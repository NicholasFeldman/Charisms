<template>
  <div>
    <p v-for="quote in quotes">
      {{quote}}
    </p>

    <md-button class="md-raised md-accent">Test</md-button>
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
