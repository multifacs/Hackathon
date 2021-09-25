<template>
  <CSidebar 
    fixed 
    :show="show"
  >
    <CSidebarBrand class="d-md-down-none" to="/">
      <h1>Ищейка</h1>
    </CSidebarBrand>

    <CRenderFunction flat :content-to-render="$options.nav"/>
  </CSidebar>
</template>

<script>
import nav from './_nav'

export default {
  name: 'TheSidebar',
  nav,
  computed: {
    show () {
      return this.$store.state.sidebarShow 
    }
  }
}
</script>
