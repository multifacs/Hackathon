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
        v-for="dot in dots"
        :key="dot.id"
        class="skier"
        :class="{active: dots.indexOf(dot)==$route.query.id}"
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
function getRandomInt(max) {
  return Math.floor(Math.random() * max);
}

export default {
  name: "Map",
  data() {
    return {
      selected: "Month",
      mapURL: "img/map/map2.png",
      x: 560,
      y: 300,
      dots: null,
      timer: "",
    };
  },
  methods: {
    move1() {
      this.x = 560;
      this.y = 300;
      this.isActive = !this.isActive;
    },
    move2() {
      this.x = getRandomInt(1000);
      this.y = getRandomInt(500);
    },

    fetchDots() {
      this.$store
        .dispatch("fetchDots")
        .then(() => {
          console.log("This would be printed after dispatch!!");
        })
        .then(() => {
          this.dots = this.$store.state.dots;
          console.log(this.dots.indexOf(this.dots[0]));
        });
    },
    cancelAutoUpdate() {
      clearInterval(this.timer);
    },
  },

  created() {
    this.fetchDots();
    this.timer = setInterval(this.fetchDots, 3000);
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
