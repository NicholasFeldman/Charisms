<template>
  <md-dialog
    :md-active.sync="showDialog"
    :md-close-on-esc="false"
    :md-click-outside-to-close="false"
  >

    <md-dialog-title>Submit a Quote</md-dialog-title>

    <md-dialog-content>
      <form novalidate class="md-layout-row md-gutter" @submit.prevent="submitQuote()">

        <md-field>
          <label>Sayer</label>
          <md-input v-model="form.sayer"></md-input>
        </md-field>

        <md-field>
          <label>Title</label>
          <md-input v-model="form.title"></md-input>
        </md-field>

        <md-field>
          <label>Quote</label>
          <md-input v-model="form.quote"></md-input>
        </md-field>

      </form>
    </md-dialog-content>

    <md-dialog-actions>
      <md-button class="md-primary" @click="cancel()">Cancel</md-button>
      <md-button class="md-primary" @click="submit()">Submit</md-button>
    </md-dialog-actions>
  </md-dialog>
</template>

<script>
  export default {
    name: 'new-quote-dialog',
    data: () => ({
      showDialog: false,
      form: {
        sayer: null,
        title: null,
        quote: null
      }
    }),
    methods: {
      show () {
        this.showDialog = true
      },
      cancel () {
        this.form.sayer = null
        this.form.title = null
        this.form.quote = null
        this.showDialog = false
      },
      submit () { // TODO
        console.log(this.form.sayer)
        console.log(this.form.title)
        console.log(this.form.quote)
      }
    }
  }
</script>
