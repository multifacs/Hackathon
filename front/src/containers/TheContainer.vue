<template>
  <div class="c-app">
    <TheSidebar />
    <CWrapper>
      <div class="c-body">
        <main class="c-main">
          <CContainer fluid>
            <transition name="fade" mode="out-in">
              <router-view :key="$route.path"></router-view>
            </transition>
          </CContainer>
        </main>
      </div>
    </CWrapper>
  </div>
</template>

<script>
  import TheSidebar from './TheSidebar'

  export default {
    name: 'TheContainer',
    components: {
      TheSidebar,
    },
    methods: {
        fetchWarns() {
            this.$store
              .dispatch("fetchWarns");
            },
        fetchDots() {
          this.$store
            .dispatch("fetchDots")
        },
        cancelAutoUpdate() {
            clearInterval(this.dotsTimer);
            clearInterval(this.warnsTimer);
        }
    },
    created() {
        this.fetchWarns();
        this.fetchDots();
        this.dotsTimer = setInterval(this.fetchDots, 3000);
        this.warnsTimer = setInterval(this.fetchWarns, 3000);
    },
  }
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
