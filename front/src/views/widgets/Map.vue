<template>
  <div>
    <CRow>
      <CCol>
        <h4>
          Станция Эссо
        </h4>
      </CCol>
    </CRow>

    <CModal title="Запрос состояния" color="warning" :show.sync="warningModal">
      Запрос отправлен
    </CModal>

    <CModal title="Помощь" color="danger" :show.sync="dangerModal">
      Запрос отправлен
    </CModal>

    <CModal title="Предупреждения" color="warning" :show.sync="primaryModal">
      Новые предупреждения
    </CModal>

    <div
      class="buttons"
      v-show="showButtons"
      :style="{
        transform:
          'translate(' +
          (parseInt($store.state.user.latitude, 10) + 20).toString(10) +
          'px, ' +
          (parseInt($store.state.user.longitude, 10) - 30).toString(10) +
          'px)',
      }"
    >
      <CButton @click="warningModal = true" color="warning" style="margin-right: 5px">
        Запрос состояния
      </CButton>
      <CButton @click="dangerModal = true" color="danger">
        Послать помощь
      </CButton>
    </div>
    <CCallout
      color="info"
      class="info"
      v-show="doShow"
      :style="{
        transform:
          'translate(' +
          (parseInt($store.state.user.latitude, 10) + 20).toString(10) +
          'px, ' +
          $store.state.user.longitude +
          'px)',
      }"
    >
      <small class="text-muted">{{ $store.state.user.id }}</small
      ><br />
      <strong class="h5">{{ $store.state.user.fullName }}</strong
      ><br />
      <strong class="h5">Level: {{ $store.state.user.level }}</strong
      ><br />
      <strong class="h6">{{ +$store.state.user.latitude.toFixed(6) }}</strong
      ><br />
      <strong class="h6">{{ +$store.state.user.longitude.toFixed(6) }}</strong>
    </CCallout>

    <div class="map-container">
      <div
        v-for="dot in $store.state.dots"
        :key="dot.id"
        class="skier"
        @click="showCall($store.state.dots.indexOf(dot))"
        @mouseover="
          updateUser(dot.id);
          doShow = true;
          showButtons = false;
        "
        @mouseleave="doShow = false"
        :class="{ active: $store.state.dots.indexOf(dot) == $route.query.id }"
        :style="{
          transform:
            'translate(' + dot.latitude + 'px, ' + dot.longitude + 'px)',
        }"
      ></div>

      <img :src="mapURL" alt="map" class="map" />
    </div>
  </div>
</template>

<script>
export default {
  name: "Map",
  data() {
    return {
      mapURL: "img/map/123.drawio.png",
      doShow: false,
      showButtons: false,
      id: 0,
    };
  },
  // created() {
  //   setTimeout(() => {
  //     this.primaryModal = true;
  //   }, 10000);
  // },
  methods: {
    removeShow(id) {
      setTimeout(() => {
        this.doShow[id] = false;
      }, 2500);
    },
    updateUser(id) {
      this.id = id;
      this.$store.dispatch("fetchUser", id);
      console.log("mouse over", this.id);
    },
    showCall() {
      console.log("123");
      this.showButtons = true;
      setTimeout(() => {
        this.showButtons = false;
      }, 5000);
    },
  },
};
</script>

<style scoped>
.map-container {
  position: relative;
  width: 840px;
  overflow: hidden;
}
.skier {
  width: 10px;
  height: 10px;
  background-color: red;
  border-radius: 50%;
  position: absolute;
  transition: transform 0s ease-out;
  transform: translate(560px, 300px);
}

.info {
  z-index: 90;
  position: absolute;
  background-color: #fff;
}

.show {
  visibility: hidden;
}

.skier:hover {
  outline: dashed red;
}

.active {
  outline: dashed red;
}

.map {
  width: 60em;
}

.buttons {
  position: absolute;
  z-index: 90;
}

@keyframes move1 {
  10% {
    transform: translate(600px, 310px);
  }
  20% {
    transform: translate(650px, 320px);
  }
  30% {
    transform: translate(750px, 400px);
  }
  40% {
    transform: translate(800px, 350px);
  }
  50% {
    transform: translate(650px, 400px);
  }
  60% {
    transform: translate(700px, 400px);
  }
  70% {
    transform: translate(700px, 500px);
  }
  80% {
    transform: translate(800px, 500px);
  }
  90% {
    transform: translate(900px, 550px);
  }
  100% {
    transform: translate(1000px, 600px);
  }
}
</style>
