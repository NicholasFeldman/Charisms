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
      <md-button class="md-icon-button" @click="likeQuote()">
        <md-icon>favorite</md-icon>
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
    methods: {
      likeQuote () {
        quotesRef
          .child(this.quote['.key'])
          .child('likes')
          .update({
            [this.currentUser.uid]: true
          })
      },
      unlikeQuote () {
        quotesRef
          .child(this.quote['.key'])
          .child('likes')
          .update({
            [this.currentUser.uid]: false
          })
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
</style>
