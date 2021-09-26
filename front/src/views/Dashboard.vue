<template>
  <div>
    <CCard>
      <CCardBody>
        <Map />
      </CCardBody>
    </CCard>
  </div>
</template>

<script>
import Map from "./widgets/Map";

export default {
  name: "Dashboard",
  components: {
    Map,
  },
  data() {
    return {
      users: this.$store.state.users,
      mapURL: "img/map/map.png",
      tableFields: [
        { key: "photo" },
        { key: "user" },
        { key: "usage" },
        { key: "activity" },
      ],
    };
  },
  methods: {
    color(value) {
      let $color;
      if (value <= 25) {
        $color = "danger";
      } else if (value > 25 && value <= 50) {
        $color = "warning";
      } else if (value > 50 && value <= 75) {
        $color = "success";
      } else if (value > 75 && value <= 100) {
        $color = "info";
      }
      return $color;
    },
  },
};
</script>
