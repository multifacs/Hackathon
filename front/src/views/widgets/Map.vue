<template>
  <div>
    <CRow>
      <CCol>
        <h4>
          Эссо
        </h4>
      </CCol>
    </CRow>

    <div class="my-1">
      <div
        v-for="dot in $store.state.dots"
        :key="dot.id"
        class="skier"
        :class="{active: $store.state.dots.indexOf(dot)==$route.query.id}"
        :style="{
          transform:
            'translate(' + dot.latitude + 'px, ' + dot.longitude + 'px)',
        }"
      ></div>
      <img :src="mapURL" alt="map" class="map"/>
    </div>
  </div>
</template>

<script>
export default {
  name: "Map",
  data() {
    return {
      mapURL: "img/map/map2.png",
    };
  },
};
</script>

<style scoped>
.skier {
  width: 10px;
  height: 10px;
  background-color: red;
  border-radius: 50%;
  position: absolute;
  transition: all 1s ease-out;
  transform: translate(560px, 300px);
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
