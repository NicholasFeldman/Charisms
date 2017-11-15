<template>
  <md-app>

    <md-app-toolbar class="md-primary">
      <toolbar-content/>
    </md-app-toolbar>

    <md-app-drawer md-permanent="full">
      <drawer-content/>
    </md-app-drawer>

    <md-app-content>
      <router-view/>
    </md-app-content>

  </md-app>
</template>

<script>
  import DrawerContent from './components/DrawerContent'
  import ToolbarContent from './components/ToolbarContent'

  export default {
    components: {
      ToolbarContent,
      DrawerContent
    }
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
