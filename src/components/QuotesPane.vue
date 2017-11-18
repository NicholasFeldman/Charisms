<template>
  <div>
    <single-quote
      v-for="quote in quotes"
      :key="quote['.key']"
      :quote="quote"
    />

    <new-quote-dialog ref="dialog"/>

    <md-button class="md-fab md-primary md-fab-bottom-right" @click.native="showDialog()">
      <md-icon>add</md-icon>
    </md-button>
  </div>
</template>

<script>
  import db from '../firebase'

  import SingleQuote from './SingleQuote'
  import NewQuoteDialog from './NewQuoteDialog'

  const quotesRef = db.ref('/quotes')

  export default {
    name: 'quotes-pane',
    components: {
      SingleQuote,
      NewQuoteDialog
    },
    firebase: {
      quotes: quotesRef
    },
    methods: {
      showDialog () {
        this.$refs['dialog'].show()
      }
    }
  }
</script>
