<template>
  <v-app>
    <v-form>
      <v-container>
        <v-row>
          <v-col cols="12" md="6">
            <v-container class="grey lighten-5">
              <v-row>
                <v-card
                  class="mx-auto"
                  style="width: 1224px; padding: 15px;"
                  outlined
                >
                  <v-card-title>アカウント管理</v-card-title>
                  <v-container class="grey lighten-5">
                    <v-row>
                      <v-col cols="12" md="12">
                        <v-btn
                          block
                          color="#0073BD"
                          dark
                          :to="{ name: 'userMaintenance' }"
                          >ユーザー管理</v-btn
                        >
                      </v-col>
                    </v-row>
                  </v-container>
                </v-card>
              </v-row>
            </v-container>
          </v-col>
          <v-col cols="12" md="6">
            <v-container class="grey lighten-5">
              <v-row>
                <v-card
                  class="mx-auto"
                  style="width: 1224px; padding: 15px;"
                  outlined
                >
                  <v-card-title>サンプル</v-card-title>
                  <v-container class="grey lighten-5">
                    <v-row>
                      <v-col cols="12" md="12">
                        <v-btn
                          block
                          color="#0073BD"
                          dark
                          @click="forwardOrderConfirm()"
                          >サンプル</v-btn
                        >
                      </v-col>
                    </v-row>
                  </v-container>
                </v-card>
              </v-row>
            </v-container>
          </v-col>
        </v-row>

        <div style="height: 10px;"></div>
        <div style="height: 10px;"></div>
        <div style="height: 10px;"></div>
      </v-container>
    </v-form>
  </v-app>
</template>

<script>
import { mapState } from 'vuex'
import moment from 'moment-timezone'
export default {
  created() {
    console.log('created')
    clearInterval(this.$store.state.adminSession.orderConfirmIntervalId)
    this.$store.commit('CLEAR_ADMIN_SESSION')
  },
  computed: {
    ...mapState({
      user: state => state.user
    })
  },
  data() {
    return {}
  },
  methods: {
    forwardOrderConfirm() {
      this.$store.commit(
        'SET_ORDER_CONFIRM_SELECTED_SHIPPING_DATE',
        moment(new Date()).format('YYYY/MM/DD')
      )
      this.$router.push({
        name: 'admin/new-order-confirm'
      })
    }
  }
}
</script>
