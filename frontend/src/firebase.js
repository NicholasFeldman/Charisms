import Firebase from 'firebase'

const app = Firebase.initializeApp({
  apiKey: 'AIzaSyDyfT4_eIsV7E8D11Y2ttfEfCRL7ipVLo4',
  authDomain: 'charisms-2efd2.firebaseapp.com',
  databaseURL: 'https://charisms-2efd2.firebaseio.com',
  projectId: 'charisms-2efd2',
  storageBucket: 'charisms-2efd2.appspot.com',
  messagingSenderId: '1020618637735'
})

export default app.database()
