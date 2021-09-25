import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

import axios from "axios";

const state = {
  sidebarShow: 'responsive',
  warnings: [],
  dots: [],
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