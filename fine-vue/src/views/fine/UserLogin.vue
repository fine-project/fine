<template>
  <v-app>
    <v-card width="96%" class="mx-auto mt-5">
      <!-- <v-card-title class="pb-0">
        <h1>Login</h1>
      </v-card-title>-->
      <v-card-text>
        <v-form>
          <v-text-field
            v-model="userId"
            prepend-icon="account_circle"
            :counter="15"
            :label="$t('userId')"
            v-validate="'required|max:15|min:5|alpha_num'"
            data-vv-name="userId"
            :error-messages="errors.collect('userId')"
            required
          />
          <v-text-field
            v-model="password"
            prepend-icon="lock"
            :append-icon="showPassword ? 'visibility' : 'visibility_off'"
            :counter="15"
            :type="showPassword ? 'text' : 'password'"
            :label="$t('password')"
            v-validate="{
              required: true,
              regex: /[0-9a-zA-Z!\-\[\]\_\+\/\(\)\?\@]{4,15}$/
            }"
            data-vv-name="password"
            :error-messages="errors.collect('password')"
            @click:append="showPassword = !showPassword"
          />
        </v-form>
      </v-card-text>
      <v-divider></v-divider>
      <v-card-actions>
        <v-btn block color="#0073BD" dark v-on:click="login()">{{
          $t('login.btn')
        }}</v-btn>
      </v-card-actions>
    </v-card>
  </v-app>
</template>

<script>
import ServerApiCallService from '@/services/ServerApiCallService.js'
import { Validator } from 'vee-validate'

export default {
  created() {
    console.log('created')
    ServerApiCallService.setAppJs(this.$parent.$parent.$parent)
    // admin state initialize
    // this.$store.commit('setIsAdminOperation', true)
  },
  mounted() {
    let selectedLang = this.$store.state.selectedLang
    if (selectedLang == '' || selectedLang == null) {
      // デフォルトは日本語
      selectedLang = 'ja'
    }
    this.$parent.$parent.$parent.changeLanguage({ lang: selectedLang })
  },
  $_veeValidate: {
    validator: 'new'
  },
  components: {},
  data() {
    return {
      userId: '',
      password: '',
      showPassword: false
    }
  },

  methods: {
    login() {
      console.log('do login')

      this.$validator.validateAll().then(result => {
        if (!result) {
          this.$parent.$parent.$parent.showErrorDialog(this.$t('hasInputError'))
          return
        }

        // init access token
        window.localStorage.removeItem('accessToken')

        let request = { userId: this.userId, password: this.password }
        let sendContext = {
          nonDispDialog: true
        }

        ServerApiCallService.loginForAdmin(request, sendContext)
          .then(response => {
            let loginResult = response.data

            // loginResult.user.accessToken = loginResult.accessToken // TODOおそらく今この処理は必要ないので削除予定
            this.$store.commit('SET_USER', loginResult.user)
            window.localStorage.setItem('accessToken', loginResult.accessToken)

            // admin state
            this.$store.commit('setIsAdminOperation', true)

            // 国際化
            this.$i18n.locale = 'ja'
            Validator.localize('ja')

            if (loginResult.showPasswordChange) {
              // パスワード変更
              this.$router.push({
                name: 'admin/password-change',
                params: { fromAdminLogin: true }
              })
            } else {
              // メニュー画面
              this.$router.push({
                name: 'Fine-Fine-menu'
              })
            }
          })
          .catch(error => {
            console.log('There was an error:', error.response)
          })
      })
    }
  }
  // mounted() {
  //   this.$validator.localize('en', this.dictionary)
  // }
}
</script>
