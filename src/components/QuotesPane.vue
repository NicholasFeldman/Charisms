<template>
  <div>
    <single-quote
      v-for="quote in quotes"
      :key="quote['.key']"
      :quote="quote"
    />

    <md-button class="md-fab md-primary md-fab-bottom-right">
      <md-icon>add</md-icon>
    </md-button>
  </div>
</template>

<script>
  import db from '../firebase'

  import SingleQuote from './SingleQuote'

  const quotesRef = db.ref('/quotes')

  export default {
    name: 'quotes-pane',
    components: { SingleQuote },
    firebase: {
      quotes: quotesRef
    }
  }
</script>
