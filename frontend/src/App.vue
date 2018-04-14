<template>
  <v-app>

    <v-toolbar app color="primary">
      <v-toolbar-side-icon dark @click.stop="drawer = !drawer"/>

      <v-spacer/>

      <template v-if="currentUser">
        <v-menu>
          <v-btn dark icon slot="activator">
            <v-icon>more_vert</v-icon>
          </v-btn>
          <v-list>
            <v-list-tile @click="signOut()">
              <v-list-tile-title>Log Out</v-list-tile-title>
            </v-list-tile>
          </v-list>
        </v-menu>
      </template>
      <template v-else>
        <v-btn color="primary" depressed @click="signIn()">Log In</v-btn>
      </template>
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
