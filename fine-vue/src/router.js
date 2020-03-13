import Vue from 'vue'
import Router from 'vue-router'

import Home from './views/Home.vue' // 画面モックの場合のTOP画面
import FineLogin from './views/fine/FineLogin.vue' // 画面モックの場合のTOP画面
import FineMenu from './views/fine/FineMenu.vue' // 画面モックの場合のTOP画面

import UserLogin from './views/fine/UserLogin.vue' // 画面モックの場合のTOP画面

// マスタメンテナンス
import UserMaintenance from './views/fine/masterMaintenance/UserMaintenance.vue' // 画面モックの場合のTOP画面

Vue.use(Router)

export default new Router({
  mode: 'history', // HTML5 history モード
  scrollBehavior() {
    // routerでの画面遷移時の座標を必ずx:0, y:0
    // see https://router.vuejs.org/ja/guide/advanced/scroll-behavior.html
    return {
      x: 0,
      y: 0
    }
  },
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        title: '画面モックTOP',
        desc: ''
      }
    },
    {
      path: '/Fine/Fine-login',
      name: 'Fine-Fine-login',
      component: FineLogin,
      meta: {
        title: 'Fine管理者ログイン',
        desc: ''
      }
    },
    {
      path: '/Fine/Fine-menu',
      name: 'Fine-Fine-menu',
      component: FineMenu,
      meta: {
        title: 'Fine管理者メニュー',
        desc: ''
      }
    },
    {
      path: '/Fine/masterMaintenance/UserMaintenance',
      name: 'userMaintenance',
      component: UserMaintenance,
      meta: {
        title: 'ユーザー管理',
        desc: ''
      }
    },
    {
      path: '/Fine/user-login',
      name: 'user-user-login',
      component: UserLogin,
      meta: {
        title: 'ログイン',
        desc: ''
      }
    }
  ]
})
