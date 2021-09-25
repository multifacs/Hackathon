<template>
  <div>
    <h1>
      Эссо
    </h1>
    <CButton color="primary" v-on:click="move">Button</CButton>
    <div>
      <div class="skier" v-bind:style="{ transform: 'translate('+ x +'px, '+ y +'px)' }"></div>
      <img :src="mapURL" alt="map" />
    </div>
  </div>
</template>

<script>

function getRandomInt(max) {
  return Math.floor(Math.random() * max);
}

export default {
  name: "Map",
  data() {
    return {
      selected: "Month",
      mapURL: "img/map/map.png",
      x: 700,
      y: 300,
    };
  },
  methods: {
    move() {
      this.x = getRandomInt(1000);
      this.y = getRandomInt(500);
    },
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
}

.move {
  transform: translate(10px, 20px);
}
</style>
