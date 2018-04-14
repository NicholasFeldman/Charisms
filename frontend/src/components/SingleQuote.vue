<template>
  <v-card>
    <v-card-title primary-title>
      <h3 class="headline mb-0">{{quote.sayer}}</h3><br>
      <h3 class="subheader mb-1">{{quote.title}}</h3>
    </v-card-title>

    <v-card-text>
      {{quote.quote}}
    </v-card-text>

    <v-card-actions>
      <v-spacer></v-spacer>
      <v-btn icon
        v-show="currentUser"
        class="md-icon-button"
        @click="toggleLike()">
        <v-icon :class="getLikedClass">favorite</v-icon>
      </v-btn>
    </v-card-actions>
  </v-card>
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
