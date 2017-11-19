import Firebase from 'firebase'

// Force initialize firebase
import '../firebase'

export default {
  data () {
    return {
      currentUser: null
    }
  },
  beforeCreate () {
    Firebase.auth().onAuthStateChanged((user) => {
      this.currentUser = user
    })
  },
  methods: {
    signIn () {
      const facebookProvider = new Firebase.auth.FacebookAuthProvider()
      Firebase.auth().signInWithPopup(facebookProvider)
    },
    signOut () {
      Firebase.auth().signOut()
    }
  }
}
