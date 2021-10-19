import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

import axios from "axios";

const state = {
  sidebarShow: 'responsive',
  warnings: [],
  logged: false,
  dots: [],
  user: {
    "id": "123",
    "fullName": "User 1",
    "level": 1,
    "detectorId": "123",
    "latitude": 123,
    "longitude": 123
  },
}

const mutations = {
  updateDots(state, dots) {
    state.dots = dots;
  },
  updateWarns(state, warns) {
    state.warnings = warns;
  },
  updateUser(state, user) {
    state.user = user;
  },
  loggedIn(state) {
    state.logged = true
  },
  loggedOut(state) {
    state.logged = false
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
  },
  fetchUser({ commit }, id) {  
    axios
    .get("/api/tourists/" + id)
    .then((response) => (commit('updateUser', response.data)))
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