import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

import axios from "axios";

const state = {
  sidebarShow: 'responsive',
  warnings: [
    {
      touristName: "Иванов Иван Иванович",
      latitude: 0,
      longitude: 0,
      message: "Мне хуева!",
      touristId: "string"
    },
    {
      touristName: "Иванов Иван Иванович",
      latitude: 0,
      longitude: 0,
      message: "Мне хуева!",
      touristId: "string"
    }
  ],
  dots: [],
}

const mutations = {
}

const actions = {
  fetchDots({ commit }) {  
    axios
    .get("http://localhost:8081/api/tourists/points")
    .then((response) => (commit('set', ['dots', response.data])))
    .catch((error) => {
      console.log(error.statusText)
    });
  }
}

export default new Vuex.Store({
  state,
  mutations,
  actions
})