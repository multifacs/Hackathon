import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

import axios from "axios";

const state = {
  sidebarShow: 'responsive',
  warnings: [],
  dots: [],
  users: [
    {
      id: 'b13878e4-77da-4287-9c91-fcf4c9ead5a7',
      name: 'Yiorgos Avraamu',
      battery: 93,
      avatar: "img/avatars/1.jpg",
      login: "16:05:12",
    },
    {
      id: '1ebb20b2-69a9-4db0-b97b-e2449e2193fc',
      name: 'Avram Tarasios',
      battery: 91,
      avatar: "img/avatars/2.jpg",
      login: "18:37:23",
    }
  ]
}

const mutations = {
  updateDots(state, dots) {
    state.dots = dots;
  },
  updateWarns(state, warns) {
    state.warnings = warns;
  }
}

const actions = {
  fetchDots({ commit }) {  
    axios
    .get("/api/tourists/points")
    .then((response) => (commit('updateDots', response.data)))
    .catch((error) => {
      console.log(error.statusText)
    });
  },
  fetchWarns({ commit }) {  
    axios
    .get("/api/warnings")
    .then((response) => (commit('updateWarns', response.data)))
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