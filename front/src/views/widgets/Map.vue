<template>
  <div>
    <CRow>
      <CCol>
        <h4>
          Станция Эссо
        </h4>
      </CCol>
    </CRow>

    <div class="my-1">
      <div
        v-for="dot in $store.state.dots"
        :key="dot.id"
        class="skier"
        @mouseover="doShow[$store.state.dots.indexOf(dot)] = true"
        @mouseleave="removeShow($store.state.dots.indexOf(dot))"
        :class="{active: $store.state.dots.indexOf(dot)==$route.query.id}"
        :style="{
          transform:
            'translate(' + dot.latitude + 'px, ' + dot.longitude + 'px)',
        }"
      ></div>
      <CCallout color="info"
        v-for="dot in $store.state.dots"
        :key="dot.id+1"
        class="info"
        v-show="doShow[$store.state.dots.indexOf(dot)]"
        :style="{
          transform:
            'translate(' + (parseInt(dot.latitude, 10) + 20).toString(10) + 'px, ' + dot.longitude + 'px)',
        }"
      >
        <small class="text-muted">{{dot.id}}</small><br>
        <strong class="h4">{{+dot.latitude.toFixed(6)}}</strong><br>
        <strong class="h4">{{+dot.longitude.toFixed(6)}}</strong>
      </CCallout>
      <img :src="mapURL" alt="map" class="map"/>
    </div>
  </div>
</template>

<script>
export default {
  name: "Map",
  data() {
    return {
      mapURL: "img/map/map22.png",
      doShow: [false, false],
    };
  },
  methods: {
    removeShow(id) {
      setTimeout(() => {
        this.doShow[id] = false;
      }, 2500);
    }
  }
};
</script>

<style scoped>
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
  width: 70em;
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
