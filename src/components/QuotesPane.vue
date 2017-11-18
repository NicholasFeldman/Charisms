<template>
  <div>
    <single-quote
      v-for="quote in reverseQuotes"
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
        .orderByChild('date')
    },
    methods: {
      showDialog () {
        this.$refs['dialog'].show()
      }
    },
    computed: {
      reverseQuotes () {
        return this.quotes.slice().reverse()
      }
    }
  }
</script>
