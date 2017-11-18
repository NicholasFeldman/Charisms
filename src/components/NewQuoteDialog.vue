<template>
    <md-dialog
      :md-active.sync="showDialog"
      :md-close-on-esc="false"
      :md-click-outside-to-close="false"
    >

      <md-dialog-title>Submit a Quote</md-dialog-title>

      <md-dialog-content>

          <md-field :class="getValidationClass('sayer')">
            <label>Sayer</label>
            <md-input v-model="form.sayer"></md-input>
            <span class="md-error" v-if="!$v.form.sayer.required"> This field is required</span>
            <span class="md-error" v-if="!$v.form.sayer.minLength"> This field is too short</span>
          </md-field>

          <md-field :class="getValidationClass('title')">
            <label>Title</label>
            <md-input v-model="form.title"></md-input>
            <span class="md-error" v-if="!$v.form.title.required"> This field is required</span>
            <span class="md-error" v-if="!$v.form.title.minLength"> This field is too short</span>

          </md-field>

          <md-field :class="getValidationClass('quote')">
            <label>Quote</label>
            <md-input v-model="form.quote"></md-input>
            <span class="md-error" v-if="!$v.form.quote.required"> This field is required</span>
            <span class="md-error" v-if="!$v.form.quote.minLength"> This field is too short</span>
          </md-field>

      </md-dialog-content>

      <md-dialog-actions>
        <md-button class="md-primary" @click="cancel()">Cancel</md-button>
        <md-button class="md-primary" @click="validateForm()">Submit</md-button>
      </md-dialog-actions>
    </md-dialog>
</template>

<script>
  import { required, minLength } from 'vuelidate/lib/validators'

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
    validations: {
      form: {
        sayer: {
          required,
          minLength: minLength(3)
        },
        title: {
          required,
          minLength: minLength(3)
        },
        quote: {
          required,
          minLength: minLength(5)
        }
      }
    },
    methods: {
      show () {
        this.showDialog = true
      },
      cancel () {
        this.$v.$reset()
        this.form.sayer = null
        this.form.title = null
        this.form.quote = null
        this.showDialog = false
      },
      getValidationClass (fieldName) {
        const field = this.$v.form[fieldName]
        if (field) {
          return {
            'md-invalid': field.$invalid && field.$dirty
          }
        }
      },
      validateForm () {
        this.$v.$touch()
        if (!this.$v.$invalid) {
          this.submit()
        }
      },
      submit () { // TODO
        console.log(this.form.sayer)
        console.log(this.form.title)
        console.log(this.form.quote)
      }
    }
  }
</script>
