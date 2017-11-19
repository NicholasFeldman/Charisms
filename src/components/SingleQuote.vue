<template>
  <md-card>
    <md-card-header>
      <div class="md-title">{{quote.sayer}}</div>
      <div class="md-subhead">{{quote.title}}</div>
    </md-card-header>

    <md-card-content>
      {{quote.quote}}
    </md-card-content>

    <md-card-actions>
      <md-button class="md-icon-button" @click="toggleLike()">
        <md-icon :class="getLikedClass">favorite</md-icon>
      </md-button>
    </md-card-actions>
  </md-card>
</template>

<script>
  import db from '../firebase'

  import AuthMixin from '../mixins/AuthMixin'

  const quotesRef = db.ref('quotes')

  export default {
    mixins: [AuthMixin],
    props: {
      quote: Object
    },
    data () {
      return {
        quoteId: this.quote['.key']
      }
    },
    firebase () {
      return {
        likes: {
          source: quotesRef
            .child(this.quoteId)
            .child('likes'),
          asObject: true
        }
      }
    },
    methods: {
      likeQuote () {
        quotesRef
          .child(this.quoteId)
          .child('likes')
          .update({
            [this.currentUser.uid]: true
          })
      },
      unlikeQuote () {
        quotesRef
          .child(this.quoteId)
          .child('likes')
          .child(this.currentUser.uid)
          .remove()
      },
      toggleLike () {
        if (this.isLiked()) {
          this.unlikeQuote()
        } else {
          this.likeQuote()
        }
      },
      isLiked () {
        return this.currentUser && this.likes[this.currentUser.uid]
      }
    },
    computed: {
      getLikedClass () {
        return {
          'liked-quote': this.isLiked()
        }
      }
    }
  }
</script>

<style scoped>
  .md-card {
    margin: 4px;
    display: inline-block;
    min-width: 20%;
    max-width: 30%;
  }

  .liked-quote {
    color: red !important;
  }
</style>
