<template>
  <div>
    <v-container fluid grid-list-md>
      <v-layout row wrap>
        <v-flex v-for="quote in reverseQuotes" :key="quote['.key']">
          <single-quote
            :quote="quote"
            style="max-width: 400px"
          />
        </v-flex>
      </v-layout>
    </v-container>

    <new-quote-dialog ref="dialog"/>

    <v-fab-transition>
      <v-btn
        fab bottom right fixed
        v-show="currentUser"
        color="primary"
        @click.native="showDialog()"
      >
        <v-icon>add</v-icon>
      </v-btn>
    </v-fab-transition>
  </div>
</template>

<script>
  import db from '../firebase'

  import AuthMixin from '../mixins/AuthMixin'

  import SingleQuote from './SingleQuote'
  import NewQuoteDialog from './NewQuoteDialog'

  const quotesRef = db.ref('/quotes')

  export default {
    name: 'quotes-pane',
    mixins: [AuthMixin],
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
