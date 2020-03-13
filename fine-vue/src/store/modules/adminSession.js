export const state = () => ({
  orderConfiFineelectedShippingDate: '',
  orderAcceptSelectedStoreName: '',
  orderAcceptOrderManagementId: '',
  orderSelectedOrderAcceptItems: [],
  orderConfirmIntervalId: '',
  selectCategory: {
    itemCategoryId: '#',
    itemCategoryName: '全て'
  }
})

export const mutations = {
  CLEAR_ADMIN_SESSION(state) {
    console.log('clear admin session ')
    state.orderConfiFineelectedShippingDate = ''
    state.orderAcceptSelectedStoreName = ''
    state.orderAcceptOrderManagementId = ''
    state.orderSelectedOrderAcceptItems = []
    state.orderConfirmIntervalId = ''
    state.selectCategory = {
      itemCategoryId: '#',
      itemCategoryName: '全て'
    }
  },
  SET_ORDER_CONFIRM_SELECTED_SHIPPING_DATE(state, shippingDate) {
    console.log('mutations set admin shippingDate')
    state.orderConfiFineelectedShippingDate = shippingDate
  },
  SET_ORDER_ACCEPT_SELECTED_STORE_NAME(state, storeName) {
    console.log('mutations set admin storeName')
    state.orderAcceptSelectedStoreName = storeName
  },
  SET_ORDER_ACCEPT_ORDER_MANAGEMENT_ID(state, orderAcceptOrderManagementId) {
    console.log('mutations set orderAcceptOrderManagementId')
    state.orderAcceptOrderManagementId = orderAcceptOrderManagementId
  },
  SET_ORDER_ACCEPT_ITEMS(state, orderSelectedOrderAcceptItems) {
    console.log('mutations set orderSelectedOrderAcceptItems')
    state.orderSelectedOrderAcceptItems = orderSelectedOrderAcceptItems
  },
  SET_ORDER_CONFIRM_INTERVAL_ID(state, orderConfirmIntervalId) {
    console.log('mutations set orderConfirmIntervalId')
    state.orderConfirmIntervalId = orderConfirmIntervalId
  },
  SET_SELECTED_ITEM_CATEGORY(state, selectCategory) {
    console.log('mutations set selectCategory')
    state.selectCategory = selectCategory
  }
}
