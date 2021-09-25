<template>
  <div>
    <CCard>
      <CCardBody>
        <Map/>
      </CCardBody>
    </CCard>
  </div>
</template>

<script>
import Map from "./widgets/Map";

export default {
  name: "Dashboard",
  components: {
    Map
  },
};
</script>
