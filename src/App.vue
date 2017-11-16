<template>
  <md-app>

    <md-app-toolbar class="md-primary">
      <span class="md-title">Charisms</span>
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
  export default {
  }
</script>

<style lang="scss">
  @import "~vue-material/dist/theme/engine";

  @include md-register-theme("default", (
    primary: md-get-palette-color(blue, A200),
    accent: md-get-palette-color(red, A200)
  ));

  @import "~vue-material/dist/theme/all";
</style>
