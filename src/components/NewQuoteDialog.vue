<template>
    <v-dialog
      v-model="dialog"
    >
      <v-card>
        <v-card-title>
          <span class="headline">Submit a Quote</span>
        </v-card-title>

        <v-card-text>
          <v-form v-model="form.valid" ref="form" lazy-validation>
            <v-text-field
              label="Sayer"
              v-model="form.sayer"
              required
              :rules="form.rules.sayer"
            />
            <v-text-field
              label="Title"
              v-model="form.title"
              :rules="form.rules.title"
            />
            <v-text-field
              label="Quote"
              v-model="form.quote"
              required
              :rules="form.rules.quote"
            />
          </v-form>
        </v-card-text>

        <v-card-actions>
          <v-spacer/>
          <v-btn primary flat @click.native="cancel">Cancel</v-btn>
          <v-btn primary flat @click.native="submit">Submit</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
</template>

<script>
  import db from '../firebase'
  import AuthMixin from '../mixins/AuthMixin'

  const quotesRef = db.ref('/quotes')

  export default {
    name: 'new-quote-dialog',
    mixins: [AuthMixin],
    data: () => ({
      dialog: false,
      form: {
        valid: true,
        sayer: null,
        title: null,
        quote: null,
        rules: {
          sayer: [v => !!v || 'Sayer is required'],
          title: [],
          quote: [v => !!v || 'Quote is required']
        }
      }
    }),
    methods: {
      show () {
        this.dialog = true
      },
      cancel () {
        this.form.sayer = null
        this.form.title = null
        this.form.quote = null
        this.dialog = false
      },
      submit () {
        if (this.$refs.form.validate()) {
          quotesRef.push({
            sayer: this.form.sayer,
            title: this.form.title,
            quote: this.form.quote,
            submittedBy: this.currentUser.uid,
            date: new Date().getTime()
          })
          this.cancel()
        }
      }
    }
  }
</script>
