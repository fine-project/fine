<template>
  <!-- <v-dialog v-model="show" max-width="500px">
    <v-card>
      <v-card-actions>
        <v-btn color="primary" flat @click.stop="show = false">Close</v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>-->
  <v-dialog max-width="300px" v-model="show">
    <!-- v-model="dialog1" -->
    <v-card>
      <v-container>
        <v-card-title>
          <span
            style="margin: 0 auto 0;"
            v-bind:class="{ 'error-text': isError }"
            >{{ message }}</span
          >
        </v-card-title>
        <v-layout row wrap style="margin-bottom:20px;">
          <v-flex xs12 sm12>
            <v-btn
              color="primary"
              text
              @click.stop="show = false"
              @click="forwardOnClose()"
              >Close</v-btn
            >
          </v-flex>
        </v-layout>
      </v-container>
    </v-card>
  </v-dialog>
</template>

<script>
export default {
  props: {
    value: Boolean,
    message: String,
    forwardNameOnClose: String,
    isError: Boolean,
    callbackAfterOnClose: Function,
    response: Object
  },
  computed: {
    show: {
      get() {
        return this.value
      },
      set(value) {
        this.$emit('input', value)
      }
    }
  },
  methods: {
    forwardOnClose() {
      console.log('forward on close')

      // 閉じるボタンクリック後、コールバックメソッドを呼び出す
      if (this.callbackAfterOnClose != null) {
        this.callbackAfterOnClose(this.response)
      }

      if (this.forwardOnClose != null) {
        this.$router.push({
          name: this.forwardNameOnClose,
          params: {}
        })
      }
    }
  }
}
</script>

<style>
.error-text {
  color: #ff0000;
}
</style>
