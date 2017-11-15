<template>
  <div>
    <md-card v-for="quote in quotes">
      <md-card-header>
        <div class="md-title">{{quote.sayer}}</div>
        <div class="md-subhead">{{quote.title}}</div>
      </md-card-header>

      <md-card-content>
        {{quote.quote}}
      </md-card-content>

      <md-card-actions>
        <md-button class="md-icon-button">
          <md-icon>favorite</md-icon>
        </md-button>
      </md-card-actions>
    </md-card>
  </div>
</template>

<script>
  import db from '../firebase'

  const quotesRef = db.ref('/quotes')

  export default {
    name: 'quotes-pane',
    firebase: {
      quotes: quotesRef
    }
  }
</script>

<style lang="scss" scoped>
  .md-card {
    margin: 4px;
    display: inline-block;
  }
</style>
