<template>
  <v-app>

    <v-toolbar app color="primary">
      <v-toolbar-side-icon  @click.stop="drawer = !drawer"></v-toolbar-side-icon>

      <v-spacer></v-spacer>

      <v-btn
        v-if="!currentUser"
        @click="signIn()"
      >Log in</v-btn>

      <v-btn
        v-if="currentUser"
        @click="signOut()"
      >Log Out</v-btn>
    </v-toolbar>

    <v-navigation-drawer app fixed v-model="drawer">
      <v-toolbar flat>
        <v-list>
          <v-list-tile>
            <v-list-tile-title class="title">
              Charisms
            </v-list-tile-title>
          </v-list-tile>
        </v-list>
      </v-toolbar>
      <v-list>
        <v-list-tile to="/">
          <v-list-tile-action>
            <v-icon>list</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title>Quotes</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>
      </v-list>
    </v-navigation-drawer>

    <v-content>
      <router-view/>
    </v-content>

  </v-app>
</template>

<script>
  import AuthMixin from './mixins/AuthMixin'

  export default {
    mixins: [AuthMixin],
    data: () => ({
      drawer: null,
    })
  }
</script>
