import Vue from 'vue'
import Vuex from 'vuex'
import * as user from '@/store/modules/user.js'
import * as salesSession from '@/store/modules/salesSession.js'
import * as adminSession from '@/store/modules/adminSession.js'
// vuex設定用js
import createPersistedState from 'vuex-persistedstate'

Vue.use(Vuex)

// vuex configuration
// const initialState = {
//   username: '',
//   loggedIn: false
// }

export default new Vuex.Store({
  plugins: [createPersistedState()], // この行でvuexに「vuex-persistedstate」を追加
  modules: {
    user,
    salesSession,
    adminSession
  },
  state: {
    selectedLang: '',
    isAdminOperation: false,
    categories: [
      'sustainability',
      'nature',
      'animal welfare',
      'housing',
      'education',
      'food',
      'community'
    ]
  },
  mutations: {
    setIsAdminOperation(state, bool) {
      console.log('set is admin operation to state')
      console.log(bool)
      // 状態を変更する
      this.state.isAdminOperation = bool
    },
    setSelectedLang(state, lang) {
      console.log('set selected lang to state. lang=[' + lang + ']')
      // 状態を変更する
      this.state.selectedLang = lang
    },
    clearAllState(state) {
      console.log('clear root state')
      // 言語はクリアしない
      //      this.state.selectedLang = ''
    }
  }
})
