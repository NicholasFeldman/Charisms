<template>
  <md-app>

    <md-app-toolbar class="md-primary">
      <div class="md-toolbar-section-start">
        <span class="md-title">Charisms</span>
      </div>

      <div class="md-toolbar-section-end">
        <md-button
          v-if="!currentUser"
          class="md-primary"
          @click="signIn()"
        >Log in</md-button>

        <md-button
          v-if="currentUser"
          class="md-primary"
          @click="signOut()"
        >Log Out</md-button>
      </div>

    </md-app-toolbar>

    <md-app-drawer md-permanent="clipped">
      <md-list>
        <md-list-item to="/">
          <md-icon>list</md-icon>
          <span class="md-list-item-text">Quotes</span>
        </md-list-item>
      </md-list>
    </md-app-drawer>

    <md-app-content>
      <router-view/>
    </md-app-content>

  </md-app>
</template>

<script>
  import AuthMixin from './mixins/AuthMixin'

  export default {
    mixins: [AuthMixin]
  }
</script>
