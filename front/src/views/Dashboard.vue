<template>
  <div>
    <CCard>
      <CCardBody>
        <Map />
      </CCardBody>
    </CCard>
    <CRow>
      <CCol md="12">
        <CCard>
          <CCardBody>
            <CDataTable
              class="mb-0 table-outline"
              hover
              :items="users"
              :fields="tableFields"
              head-color="light"
              no-sorting
            >
              <td slot="photo" slot-scope="{ item }">
                <div class="c-avatar">
                  <img :src="item.avatar" class="c-avatar-img" alt="" />
                </div>
              </td>
              <td slot="user" slot-scope="{ item }">
                <div>{{ item.name }}</div>
              </td>
              <td slot="usage" slot-scope="{ item }">
                <div class="clearfix">
                  <div class="float-left">
                    <strong>{{ item.battery }}%</strong>
                  </div>
                </div>
                <CProgress
                  class="progress-xs"
                  v-model="item.battery"
                  :color="color(item.battery)"
                />
              </td>
              <td slot="activity" slot-scope="{ item }">
                <div class="small text-muted">Started at</div>
                <strong>{{ item.login }}</strong>
              </td>
            </CDataTable>
          </CCardBody>
        </CCard>
      </CCol>
    </CRow>
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
