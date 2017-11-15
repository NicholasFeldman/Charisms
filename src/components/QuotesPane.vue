<template>
  <div>
    <p v-for="quote in quotes">
      {{quote}}
    </p>
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
