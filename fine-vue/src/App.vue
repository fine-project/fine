<template>
  <v-app>
    <v-navigation-drawer app permanent clipped fixed>
      <v-card height="400" width="256" class="mx-auto">
        <v-list-item>
          <v-list-item-content>
            <v-list-item-title class="title">Menu</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-divider></v-divider>

        <v-list dense nav>
          <v-list-group prepend-icon="account_circle">
            <template v-slot:activator>
              <v-list-item-title style="text-align: left;"
                >管理機能</v-list-item-title
              >
            </template>
            <v-list-item v-for="item in items" :key="item.title" link>
              <v-list-item-content>
                <v-list-item-title style="text-align: left;">
                  {{ item.title }}
                </v-list-item-title>
              </v-list-item-content>
            </v-list-item>
          </v-list-group>
          <v-list-group prepend-icon="account_circle">
            <template v-slot:activator>
              <v-list-item-title style="text-align: left;"
                >サンプル</v-list-item-title
              >
            </template>
            <v-list-item v-for="item in items" :key="item.title" link>
              <v-list-item-content>
                <v-list-item-title style="text-align: left;">
                  {{ item.title }}
                </v-list-item-title>
              </v-list-item-content>
            </v-list-item>
          </v-list-group>
        </v-list>
      </v-card>
    </v-navigation-drawer>

    <v-app-bar
      app
      color="#0073BD"
      dark
      clipped-left
      fixed
      style="box-shadow: none;"
      height="50px"
    >
      <div
        class="d-flex align-center"
        style="height: 100%; margin: 0 0 0 15px;"
      >
        <!-- <v-img
          alt="Vuetify Logo"
          class="shrink mr-2"
          contain
          src="https://cdn.vuetifyjs.com/images/logos/vuetify-logo-dark.png"
          transition="scale-transition"
          width="40"
        /> 

        <v-img
          alt="Vuetify Name"
          class="shrink mt-1 hidden-sm-and-down"
          contain
          min-width="100"
          src="https://cdn.vuetifyjs.com/images/logos/vuetify-name-dark.png"
          width="100"
        />-->
        <div style="    font-size: 24px;">
          <a
            href="/"
            style="color: #fff;
    text-decoration: none;"
            >Fineシステム</a
          >
        </div>
      </div>
      <!--
      <v-spacer></v-spacer>

      <v-btn
        href="https://github.com/vuetifyjs/vuetify/releases/latest"
        target="_blank"
        text
      >
        <span class="mr-2">Latest Release</span>
        <v-icon>mdi-open-in-new</v-icon>
      </v-btn>-->
    </v-app-bar>

    <ResultDialog
      v-model="showResultDialogFlg"
      :message="resultDialogMessage"
      :forwardNameOnClose="resultDialogForwardNameOnClose"
      :isError="isError"
      :callbackAfterOnClose="callbackAfterOnClose"
      :response="response"
    />
    <v-dialog v-model="showSimpleDialog" max-width="300px">
      <v-card>
        <v-container>
          <v-card-title>
            <span
              style="margin: 0 auto 0;"
              v-bind:class="{ 'font-error': isErrorSimpleDialog }"
              >{{ simpleDialogMessage }}</span
            >
          </v-card-title>
          <v-layout row wrap style="margin-bottom:20px;">
            <v-flex xs12 sm12>
              <v-btn
                color="primary"
                text
                @click="showSimpleDialog = !showSimpleDialog"
                >Close</v-btn
              >
            </v-flex>
          </v-layout>
        </v-container>
      </v-card>
    </v-dialog>

    <v-content grid-list-md text-xs-center fluid>
      <!-- <v-card height="400" width="256" class="mx-auto"> -->
      <div
        class
        v-bind:class="{ 'display-none': nonDispHeader }"
        style="box-shadow: none;"
      >
        <div id="page-title" class="v-card__text px-0">
          non title{{ titleCache }}
        </div>
      </div>
      <!-- </v-card> -->
      <router-view style="margin: 0 auto;"></router-view>
    </v-content>
  </v-app>
</template>

<style>
* :not(.v-icon) {
  font-family: 'Avenir', 'Helvetica Neue', 'Helvetica', 'Arial', 'Hiragino Sans',
    'ヒラギノ角ゴシック', YuGothic, 'Yu Gothic', 'メイリオ', Meiryo,
    'ＭＳ Ｐゴシック', 'MS PGothic';
}
.v-list__tile__title {
  color: #2c3e50 !important;
}
.v-list__tile--link:hover {
  background: #ebeff3 !important;
}
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
#nav {
  padding: 30px;
}
button.hidden-md-and-up {
  display: block !important;
}
#page-title {
  font-size: 16px !important;
  font-weight: 500;
  line-height: 1 !important;
  letter-spacing: 0.02em !important;
  font-family: Roboto, sans-serif !important;
  color: #2c3e50;
  /* background-color: #0073bd70; */
  padding: 10px 0;

  margin: 10px 0 0 15px;
  text-align: left;
}
div.v-card__title {
  font-size: 18px;
  font-weight: bold;
  /*padding: 0 0 30px;*/
}
.v-btn__content .v-icon--left {
  margin-right: 8px;
}
.display-none {
  display: none !important;
}
.font-error {
  color: red;
}
</style>

<script>
import ResultDialog from '@/components/ResultDialog.vue'

import { Validator } from 'vee-validate'

export default {
  name: 'App',
  data() {
    return {
      // langs: ['en', 'ja', 'zhHans', 'zhHant'],
      nonDispHeader: false,
      showResultDialogFlg: false,
      resultDialogMessage: '',
      resultDialogForwardNameOnClose: '',
      isError: false,
      callbackAfterOnClose: null,
      response: null,
      drawer: null,
      showSimpleDialog: false,
      isErrorSimpleDialog: false,
      simpleDialogMessage: 'none error message',
      titleCache: '',
      admins: [['Management', 'people_outline'], ['Settings', 'settings']],
      cruds: [
        ['Create', 'add'],
        ['Read', 'insert_drive_file'],
        ['Update', 'update'],
        ['Delete', 'delete']
      ],
      isAdminOperation: true,
      items: [
        { title: 'Fine管理者メニュー', icon: 'mdi-view-dashboard' },
        { title: 'Photos', icon: 'mdi-image' },
        { title: 'About', icon: 'mdi-help-box' }
      ],
      right: null
    }
  },
  components: {
    ResultDialog
  },
  methods: {
    // $t: function(translate) {
    //   if (typeof translate === 'string') {
    //     return this.$i18n.t(translate)
    //   } else if (translate === void 0) {
    //     return this.$i18n.t('loading')
    //   }
    //   return translate[this.$i18n.locale]
    // },
    onClickMenuLogout() {
      console.log('logout')
      window.localStorage.removeItem('accessToken')
      if (this.$store.state.isAdminOperation === true) {
        this.$router.push({
          name: 'admin/new-admin-login'
        })
      } else if (this.$store.state.isAdminOperation === false) {
        this.$router.push({
          name: 'sales/new-user-login'
        })
      }
      // stateをクリア
      // this.$store.commit('clearAllState')
      this.$store.commit('CLEAR_SALES_SESSION')
      this.$store.commit('CLEAR_ADMIN_SESSION')
    },
    onClickJobkan() {
      this.drawer = !this.drawer
      window.open(
        'https://id.jobcan.jp/users/sign_in?app_key=atd&redirect_to=https://ssl.jobcan.jp/jbcoauth/callback'
      )
    },
    onClickFukutsu() {
      this.drawer = !this.drawer
      window.open('https://corp.fukutsu.co.jp/situation/tracking_no')
    },
    onClickYamato() {
      this.drawer = !this.drawer
      window.open('https://toi.kuronekoyamato.co.jp/cgi-bin/tneko')
    },
    onClickMenuHome() {
      this.drawer = !this.drawer
      this.onClickHome()
    },
    onClickHome() {
      if (this.$store.state.isAdminOperation === true) {
        this.$router.push({
          name: 'admin/new-admin-menu'
        })
      } else if (this.$store.state.isAdminOperation === false) {
        this.$router.push({
          name: 'sales/new-user-menu'
        })
      }
    },
    changeLanguage: function(item) {
      console.log('change language')
      this.$i18n.locale = item.lang
      Validator.localize(item.lang)
      // set lang for state
      this.$store.commit('setSelectedLang', item.lang)
      // title change
      let title = this.$t(this.titleCache)
      document.title = title
      var pageTitleObj = document.getElementById('page-title')
      pageTitleObj.textContent = document.title
    },
    showDialog: function(message) {
      this.showSimpleDialog = true
      this.isErrorSimpleDialog = false
      this.simpleDialogMessage = message
    },
    showErrorDialog: function(message) {
      this.showSimpleDialog = true
      this.isErrorSimpleDialog = true
      this.simpleDialogMessage = message
    },
    showResultDialog: function(
      message,
      forwardNameOnClose,
      isError,
      callbackAfterOnClose,
      response
    ) {
      console.log('call showResultDialog')
      this.showResultDialogFlg = true
      this.resultDialogMessage = message
      this.resultDialogForwardNameOnClose = forwardNameOnClose
      this.isError = isError
      this.callbackAfterOnClose = callbackAfterOnClose
      this.response = response
    },
    createPageTitle: function(to) {
      console.log('title')
      // タイトルを設定a
      if (to.name) {
        this.titleCache = 'page-title.' + to.name
        let title = this.$t('page-title.' + to.name)
        document.title = title
        // var setTitle = to.meta.title
        // document.title = setTitle
        //        document.title = this.$t('sales-user-login')
      } else {
        document.title = 'non title'
      }
      var pageTitleObj = document.getElementById('page-title')
      pageTitleObj.textContent = document.title
      // メタタグdescription設定
      // if (to.meta.desc) {
      //   var setDesc = to.meta.desc + ' | SourceAcademy'
      //   document
      //     .querySelector("meta[name='description']")
      //     .setAttribute('content', setDesc)
      // } else {
      //   document
      //     .querySelector("meta[name='description']")
      //     .setAttribute('content', 'SourceAcademy')
      // }
    }
  },
  mounted: function() {
    var to = this.$route
    this.createPageTitle(to)
  },
  watch: {
    // $route(to, from) {
    $route(to) {
      if (to.meta.nonDispHeader) {
        this.nonDispHeader = true
      } else {
        this.nonDispHeader = false
      }
      this.createPageTitle(to)
      this.isAdminOperation = this.$store.state.isAdminOperation
    }
  }
}
</script>
