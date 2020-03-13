import axios from 'axios'

// 0:画面モックモード（ローカルサーバ実行モード）(json-server)
// 1:テストサーバ実行モード(Spring)
// 2: 特定リクエストのみテストサーバ実行モード(Spring)
// 7: AWS実行モード(Spring)
let env = '0'

// 特定のリクエストのみテストサーバ(Spring)に向けたいときは以下に追加
let realConnectServerUrls = ['/admin/supplier-brands-delete']

// URL
let urlForServer = 'http://localhost:5000'
let urlForAWS = 'https://ap1s.hirosophy.tokyo/'
// 'http://spring-boot.gjikmnapac.ap-northeast-1.elasticbeanstalk.com/'

let appJs = ''

export default {
  setAppJs(appJsObj) {
    appJs = appJsObj
  },
  getApiClientForLocal() {
    let headers = {
      Accept: 'application/json',
      'Content-Type': 'application/json'
    }
    if (window.localStorage.getItem('accessToken') != null) {
      headers.accessToken = window.localStorage.getItem('accessToken')
    }
    return axios.create({
      baseURL: 'http://localhost:3000',
      withCredentials: false, // This is the default
      headers: headers
    })
  },
  getApiClientForServer() {
    return axios.create({
      baseURL: `http://localhost:5000`,
      withCredentials: false, // This is the default
      headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
        accessToken: window.localStorage.getItem('accessToken')
      }
    })
  },
  getApiClientForAWS() {
    return axios.create({
      baseURL: urlForAWS,
      withCredentials: false, // This is the default
      headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
        accessToken: window.localStorage.getItem('accessToken')
      }
    })
  },
  getApiClientForMultipart() {
    let url
    if (env === '7') {
      url = urlForAWS
    } else {
      url = urlForServer
    }

    return axios.create({
      baseURL: url,
      withCredentials: false, // This is the default
      headers: {
        'content-type': 'multipart/form-data',
        accessToken: window.localStorage.getItem('accessToken')
      }
    })
  },
  loginForUser(request, sendContext) {
    let response = this.sendPost('/sales/login', request, sendContext)
    return response
  },
  loginForAdmin(request, sendContext) {
    let response = this.sendPost('/admin/login', request, sendContext)
    return response
  },
  menu() {
    let response = this.sendGet('/sales/menu')
    return response
  },
  items() {
    let response = this.sendGet('/admin/items')
    return response
  },
  orderItems(request) {
    let response = this.sendGet(
      '/sales/orderItems?shippingDate=' +
      request.shippingDate +
      '&storeCode=' +
      request.storeCode
    )
    return response
  },
  item(request) {
    let response = this.sendGet('/admin/items/' + request.itemCode)
    return response
  },
  itemsPost(request, sendContext) {
    let response = this.sendPost('/admin/items/post', request, sendContext)
    return response
  },
  itemsPut(request, sendContext) {
    let response = this.sendPut('/admin/items/put', request, sendContext)
    return response
  },
  itemsUpdateStock(formData, sendContext) {
    let response = this.sendPost(
      '/admin/items/updateStock',
      formData,
      sendContext
    )
    return response
  },
  suppliers() {
    let response = this.sendGet('/admin/suppliers')
    return response
  },
  suppliersByStatus() {
    let response = this.sendGet('/admin/suppliers-status-on')
    return response
  },
  supplier(request) {
    let response = this.sendGet('/admin/suppliers/' + request.supplierCode)
    return response
  },
  suppliersPost(request, sendContext) {
    let response = this.sendPost('/admin/suppliers-post', request, sendContext)
    return response
  },
  suppliersPut(request, sendContext) {
    let response = this.sendPut('/admin/suppliers-put', request, sendContext)
    return response
  },
  stores() {
    let response = this.sendGet('/admin/stores')
    return response
  },
  store(request) {
    let response = this.sendGet('/admin/stores/' + request.storeCode)
    return response
  },
  storesPost(formData, sendContext) {
    let response = this.sendPost('/admin/stores-post', formData, sendContext)
    return response
  },
  storesPut(formData, sendContext) {
    let response = this.sendPost('/admin/stores-put', formData, sendContext)
    return response
  },
  storesItems(request) {
    let response = this.sendGet('/admin/stores-items/' + request.storeCode)
    return response
  },
  copyStoresItems(request) {
    let response = this.sendGet('/admin/stores-items-copy/' + request.storeCode)
    return response
  },
  storesItemsUpdate(request, sendContext) {
    let response = this.sendPost(
      '/admin/stores-items-update',
      request,
      sendContext
    )
    return response
  },
  itemCategories() {
    let response = this.sendGet('/admin/itemCategories')
    return response
  },
  itemCategoriesByStatus() {
    let response = this.sendGet('/admin/itemCategories-status-on')
    return response
  },
  itemCategoriesPost(request, sendContext) {
    let response = this.sendPost(
      '/admin/itemCategories/post',
      request,
      sendContext
    )
    return response
  },
  itemCategoriesPut(formData) {
    let response = this.sendPut('/admin/itemCategories/put', formData)
    return response
  },
  itemsByCategory(request) {
    let response = this.sendGet(
      '/sales/itemCategories/' + request.itemCategoryId + '/items'
    )
    return response
  },
  sendOrder(request, sendContext) {
    let response = this.sendPost('/sales/send-order', request, sendContext)
    return response
  },
  sendOrderImage(formData, sendContext) {
    let response = this.sendMultipart(
      '/sales/order/uploadImg',
      formData,
      sendContext
    )
    return response
  },
  sendUsersFile(formData, sendContext) {
    let response = this.sendMultipart(
      '/admin/users-upload-file',
      formData,
      sendContext
    )
    return response
  },
  existsOrdersByShippingDate(request, sendContext) {
    let response = this.sendGet(
      '/admin/existsOrders/' + request.shippingDate,
      sendContext
    )
    return response
  },
  ordersByDay(request, sendContext) {
    let response = this.sendGet(
      '/admin/orders-by-day/' + request.shippingDate,
      sendContext
    )
    return response
  },
  orderDetailsByDay(request, sendContext) {
    let response = this.sendGet(
      '/admin/order-details-by-day/' + request.orderManagementId,
      sendContext
    )
    return response
  },
  orderLockRegion1(request, sendContext) {
    let response = this.sendPost(
      '/admin/order-lock-region1',
      request,
      sendContext
    )
    return response
  },
  orderLockRegion2(request, sendContext) {
    let response = this.sendPost(
      '/admin/order-lock-region2',
      request,
      sendContext
    )
    return response
  },
  fixOrder(request, sendContext) {
    let response = this.sendPost('/admin/fix-order', request, sendContext)
    return response
  },
  clearOrderDetail(request, sendContext) {
    let response = this.sendPost(
      '/admin/order-detail-delete',
      request,
      sendContext
    )
    return response
  },
  orderRegistSlipNumber(request) {
    let response = this.sendPost('/admin/order-regist-slip-number', request)
    return response
  },
  changeShippingDate(request) {
    let response = this.sendPost('/admin/order-update-shipping-date', request)
    return response
  },
  deleteOrder(request, sendContext) {
    let response = this.sendGet(
      '/admin/delete-order/' + request.orderManagementId,
      sendContext
    )
    return response
  },
  users() {
    let response = this.sendGet('/admin/users')
    return response
  },
  usersAuthPut(request, sendContext) {
    let response = this.sendPut('/admin/users-auth/put', request, sendContext)
    return response
  },
  usersInitializePassword(request, sendContext) {
    let response = this.sendPut(
      '/admin/users-initialize-password',
      request,
      sendContext
    )
    return response
  },
  usersPasswordChange(request, sendContext) {
    let response = this.sendPut(
      '/admin/users-password-change',
      request,
      sendContext
    )
    return response
  },
  deliveryslip(request) {
    let response = this.sendGet(
      '/admin/print-delivery-slip/' + request.orderManagementId
    )
    return response
  },
  brands() {
    let response = this.sendGet('/admin/brands')
    return response
  },
  brandsPost(request, sendContext) {
    let response = this.sendPost('/admin/brands-post', request, sendContext)
    return response
  },
  brandsStatusPut(request, sendContext) {
    let response = this.sendPut(
      '/admin/brands-status-put',
      request,
      sendContext
    )
    return response
  },
  brandsBySupplierCode(request) {
    let response = this.sendGet(
      '/admin/brands-by-supplier/' + request.supplierCode
    )
    return response
  },
  businessContacts() {
    let response = this.sendGet('/admin/businessContacts')
    return response
  },
  businessContactsPost(request, sendContext) {
    let response = this.sendPost(
      '/admin/businessContacts-post',
      request,
      sendContext
    )
    return response
  },
  businessContactsDelete(request, sendContext) {
    let response = this.sendPost(
      '/admin/businessContacts-delete',
      request,
      sendContext
    )
    return response
  },
  businessContactsImportantPut(request, sendContext) {
    let response = this.sendPost(
      '/admin/businessContacts-important-put',
      request,
      sendContext
    )
    return response
  },
  sampleDownload(request) {
    let response = this.sendGet('/download/csv', null, true)
    return response
  },
  supplierBrandPost(request, sendContext) {
    let response = this.sendPost(
      '/admin/supplier-brand-post',
      request,
      sendContext
    )
    return response
  },
  supplierBrands(request, sendContext) {
    let response = this.sendGet('/admin/supplier-brands', request, sendContext)
    return response
  },
  supplierBrandsDelete(request, sendContext) {
    let response = this.sendPost(
      '/admin/supplier-brands-delete',
      request,
      sendContext
    )
    return response
  },
  getAxios(url) {
    if (env === '7') {
      console.log('AWSへ電文を投げます')
      return this.getApiClientForAWS()
    } else if (env === '0') {
      console.log('json-serverへ電文を投げます')
      return this.getApiClientForLocal()
    } else if (env === '1') {
      console.log('実際のサーバへ電文を投げます')
      return this.getApiClientForServer()
    } else if (env === '2') {
      if (realConnectServerUrls.indexOf(url) >= 0) {
        console.log('実際のサーバへ電文を投げます')
        return this.getApiClientForServer()
      } else {
        console.log('json-serverへ電文を投げます')
        return this.getApiClientForLocal()
      }
    } else {
      console.log('envが不正')
    }
  },
  sendGet(url, sendContext, isDownload) {
    console.log('send GET request. url: ' + url)
    let response = this.getAxios(url).get(url, hasDialogComponent)

    let hasDialogComponent
    let forwardNameOnClose
    if (sendContext != null) {
      hasDialogComponent = sendContext.hasDialogComponent
      forwardNameOnClose = sendContext.forwardNameOnClose
    }

    response
      .then(response => {
        console.log('HTTP Status: ' + response.status)
        console.log('response body: ' + JSON.stringify(response.data))
        if (isDownload) {
          this.downloadFile(response, 'customFilename')
          return
        }
        if (hasDialogComponent != null) {
          let result = response.data.result
          let errors = response.data.errors
          if (result == '1') {
            hasDialogComponent.showResultDialog(
              errors[0].errorDescription,
              null,
              true
            )
          } else {
            hasDialogComponent.showResultDialog(
              'データ送信が完了しました',
              forwardNameOnClose,
              false
            )
          }
        }
      })
      .catch(error => {
        console.log('HTTP Status: ' + response.status)
        console.log('response body: ' + JSON.stringify(response.data))
        console.log('There was an error:', error.response)
        if (error.response.status === 401) {
          console.log('session expired')
          let forward = 'sales/new-user-login'
          if (appJs.$store.state.isAdminOperation) {
            forward = 'admin/new-admin-login'
          }
          appJs.showResultDialog(
            'セッションが切れました。ログイン画面から操作をやり直してください',
            forward,
            true
          )
        } else {
          appJs.showResultDialog('データ送信が失敗しました', null, true)
        }
      })

    return response
  },
  sendPut(url, formData, sendContext) {
    return this.sendPost(url, formData, sendContext)
  },
  sendPost(url, requestBody, sendContext) {
    console.log('send POST request. url: ' + url)
    console.log('request body: ' + JSON.stringify(requestBody))

    let forwardNameOnClose
    let callbackAfterOnClose
    let dialogMessage
    let nonDispDialog
    if (sendContext != null) {
      dialogMessage = sendContext.dialogMessage
      forwardNameOnClose = sendContext.forwardNameOnClose
      callbackAfterOnClose = sendContext.callbackAfterOnClose
      nonDispDialog = sendContext.nonDispDialog
    }

    let response

    if (env === '0') {
      response = this.getAxios(url).get(url, requestBody)
    } else if (env === '1' || env === '7') {
      response = this.getAxios(url).post(url, requestBody)
    } else if (env === '2') {
      if (realConnectServerUrls.indexOf(url) >= 0) {
        response = this.getAxios(url).post(url, requestBody)
      } else {
        response = this.getAxios(url).get(url, requestBody)
      }
    } else {
      console.log('envが不正！')
    }

    response
      .then(response => {
        console.log('HTTP Status: ' + response.status)
        console.log('response body: ' + JSON.stringify(response.data))
        let result = response.data.result
        let errors = response.data.errors
        // result=1の場合は、サーバから返却されたエラー内容を表示
        if (result == '1') {
          appJs.showResultDialog(errors[0].errorDescription, null, true)
          // let e = new Error('処理結果=1が返却されました')
          // e.result = 1
          // throw e
        } else {
          // 正常時、ダイアログが設定されている場合は、その内容を表示
          if (!nonDispDialog) {
            appJs.showResultDialog(
              dialogMessage != null ?
              dialogMessage :
              'データ送信が完了しました',
              forwardNameOnClose,
              false,
              callbackAfterOnClose,
              response
            )
          }
        }
      })
      .catch(error => {
        console.log('HTTP Status: ' + response.status)
        console.log('response body: ' + JSON.stringify(response.data))
        console.log('There was an error:', error.response)
        if (response.status === 401) {
          console.log('session expired')
          let forward = 'sales/new-user-login'
          if (appJs.$store.state.isAdminOperation) {
            forward = 'admin/new-admin-login'
          }
          appJs.showResultDialog(
            'セッションが切れました。ログイン画面から操作をやり直してください',
            forward,
            true
          )
        } else {
          appJs.showResultDialog('データ送信が失敗しました', null, true)
        }
      })

    return response
  },
  sendMultipart(url, formData, sendContext) {
    console.log('send ' + url)

    let hasDialogComponent
    let forwardNameOnClose
    if (sendContext != null) {
      hasDialogComponent = sendContext.hasDialogComponent
      forwardNameOnClose = sendContext.forwardNameOnClose
    }

    let config = {
      'content-type': 'multipart/form-data'
      //      accept: '*/*'
    }

    let response = this.getApiClientForMultipart().post(url, formData, config)
    // let response = axios.post(`http://localhost:9090` + url, formData, config)

    response
      .then(response => {
        console.log('HTTP Status: ' + response.status)
        console.log('response body: ' + JSON.stringify(response.data))
        let result = response.data.result
        let errors = response.data.errors
        if (result == '1') {
          hasDialogComponent.showResultDialog(
            errors[0].errorDescription,
            null,
            true
          )
        } else {
          hasDialogComponent.showResultDialog(
            '画像送信が完了しました',
            forwardNameOnClose,
            false
          )
        }
      })
      .catch(error => {
        console.log('HTTP Status: ' + response.status)
        console.log('response body: ' + JSON.stringify(response.data))
        console.log('There was an error:', error.response)
        hasDialogComponent.showResultDialog(
          'ファイル送信中にエラーが発生しました',
          null,
          true
        )
      })

    return response
  },
  downloadFile(response, filename) {
    // It is necessary to create a new blob object with mime-type explicitly set
    // otherwise only Chrome works like it should
    var newBlob = new Blob([response.body], {
      type: 'application/pdf'
    })

    // IE doesn't allow using a blob object directly as link href
    // instead it is necessary to use msSaveOrOpenBlob
    if (window.navigator && window.navigator.msSaveOrOpenBlob) {
      window.navigator.msSaveOrOpenBlob(newBlob)
      return
    }

    // For other browsers:
    // Create a link pointing to the ObjectURL containing the blob.
    const data = window.URL.createObjectURL(newBlob)
    var link = document.createElement('a')
    link.href = data
    link.download = filename + '.pdf'
    link.click()
    setTimeout(function () {
      // For Firefox it is necessary to delay revoking the ObjectURL
      window.URL.revokeObjectURL(data)
    }, 100)
  }
}