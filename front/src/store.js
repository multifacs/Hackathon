import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)

const state = {
  sidebarShow: 'responsive',
  sidebarMinimize: false,
  dots: [
    {
      id: 1,
      x: 560,
      y: 300
    },
    {
      id: 2,
      x: 400,
      y: 100
    },
    {
      id: 3,
      x: 780,
      y: 500
    },
  ],
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
  ]
}

const mutations = {
  toggleSidebarDesktop (state) {
    const sidebarOpened = [true, 'responsive'].includes(state.sidebarShow)
    state.sidebarShow = sidebarOpened ? false : 'responsive'
  },
  toggleSidebarMobile (state) {
    const sidebarClosed = [false, 'responsive'].includes(state.sidebarShow)
    state.sidebarShow = sidebarClosed ? true : 'responsive'
  },
  set (state, [variable, value]) {
    state[variable] = value
  },
}

export default new Vuex.Store({
  state,
  mutations,
})