<template>
  <div class="c-app">
    <TheSidebar />
    <CWrapper>
<<<<<<< Updated upstream
=======
      <TheHeader />
>>>>>>> Stashed changes
      <div class="c-body">
        <main class="c-main">
          <CContainer fluid>
            <transition name="fade" mode="out-in">
              <router-view :key="$route.path"></router-view>
            </transition>
          </CContainer>
        </main>
      </div>
<<<<<<< Updated upstream
=======
      <TheFooter />
>>>>>>> Stashed changes
    </CWrapper>
  </div>
</template>

<script>
<<<<<<< Updated upstream
  import TheSidebar from './TheSidebar'

  export default {
    name: 'TheContainer',
    components: {
      TheSidebar,
    },
  }
=======
import TheSidebar from "./TheSidebar";
import TheHeader from "./TheHeader";
import TheFooter from "./TheFooter";


export default {
  name: "TheContainer",
  components: {
    TheSidebar,
    TheHeader,
    TheFooter,
  },
};
>>>>>>> Stashed changes
</script>

<style scoped>
.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.3s;
}
.fade-enter,
.fade-leave-to {
  opacity: 0;
}
</style>
