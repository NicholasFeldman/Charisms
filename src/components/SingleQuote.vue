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
      <md-button class="md-icon-button" @click="likeQuote(quote['.key'])">
        <md-icon>favorite</md-icon>
      </md-button>
    </md-card-actions>
  </md-card>
</template>

<script>
  export default {
    props: {
      quote: Object
    },
    methods: {
      likeQuote (id) {
        alert(id)
      }
    }
  }
</script>

<style scoped>
  .md-card {
    margin: 4px;
    display: inline-block;
    min-width: 20%;
  }
</style>
