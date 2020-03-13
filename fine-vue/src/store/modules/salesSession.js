export const state = () => ({
  menuSelectedBrand: {
    brandId: '#',
    brandName: 'error'
  },
  menuSelectedStore: {
    storeCode: '#',
    storeName: 'error'
  },
  orderSelectedShippingDate: '',
  orderSelectedOrderItems: [],
  dispAddOrderForm: false,
  remarks: ''
})

export const mutations = {
  CLEAR_SALES_SESSION(state) {
    console.log('clear sales session ')
    state.menuSelectedBrand = {
      brandId: '#',
      brandName: 'error'
    }
    state.menuSelectedStore = {
      storeCode: '#',
      storeName: 'error'
    }
    state.orderSelectedShippingDate = ''
    state.orderSelectedOrderItems = []
    state.dispAddOrderForm = false
    state.remarks = ''
  },
  SET_MENU_SELECTED_BRAND(state, selectedBrand) {
    console.log('mutations set brand ')
    state.menuSelectedBrand = selectedBrand
  },
  SET_MENU_SELECTED_STORE(state, selectedStore) {
    console.log('mutations set store ')
    state.menuSelectedStore = selectedStore
  },
  SET_ORDER_SELECTED_SHIPPING_DATE(state, selectedShippingDate) {
    console.log('mutations set shipping date ')
    state.orderSelectedShippingDate = selectedShippingDate
  },
  SET_ORDER_SELECTED_ITEMS(state, selectedOrderItems) {
    console.log('mutations set orderSelectedOrderItems ')
    state.orderSelectedOrderItems = selectedOrderItems
  },
  SET_ORDER_DISP_ADD_ORDER_FORM(state, dispAddOrderForm) {
    console.log('mutations set dispAddOrderForm ')
    state.dispAddOrderForm = dispAddOrderForm
  },
  SET_ORDER_REMARKS(state, remarks) {
    console.log('mutations set remarks ')
    state.remarks = remarks
  }
}
