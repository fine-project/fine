<template>
  <v-form>
    <div>&nbsp;</div>
    <v-container>
      <v-row>
        <v-col cols="12" md="6">
          <v-btn block color="#0073BD" dark :to="{ name: 'Fine-Fine-login' }"
            >Fine管理者 ログイン</v-btn
          >
        </v-col>

        <v-col cols="12" md="6">
          <v-btn block color="#0073BD" dark :to="{ name: 'user-user-login' }"
            >一般ユーザログイン</v-btn
          >
        </v-col>
      </v-row>
    </v-container>
  </v-form>
</template>

<script>
export default {
  created() {
    if (this.$route.query.admin) {
      // 管理者モード TODO
      this.$router.push({
        path: '/admin-login'
      })
    }
    this.$store.commit('setIsAdminOperation', true)
  },
  data() {
    return {}
  }
}
</script>

<style lang="scss" scoped></style>
