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
  routes: [{
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
      path: '/Fine/masterMaintenance/customerMaintenance',
      name: 'customerMaintenance',
      component: CustomerMaintenance,
      meta: {
        title: '顧客メンテナンス',
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
      path: '/Fine/masterMaintenance/sectionMaintenance',
      name: 'sectionMaintenance',
      component: SectionMaintenance,
      meta: {
        title: '部門メンテナンス',
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

    /*
    {
      path: '/sales/report',
      name: 'sales/report',
      component: Report,
      meta: {
        title: '売上報告',
        titleKey: 'sales-report',
        desc: ''
      }
    },
    {
      path: '/sales/report-send-confirm',
      name: 'sales/report-send-confirm',
      component: ReportSendConfirm,
      meta: {
        title: '売上報告確認',
        titleKey: 'sales-report-send-confirm',
        desc: ''
      }
    },
    {
      path: '/sales/report-send-complete',
      name: 'sales/report-send-complete',
      component: ReportSendComplete,
      meta: {
        title: '売上報告完了',
        titleKey: 'sales-report-send-complete',
        desc: ''
      }
    },
    {
      path: '/admin/report-confirm',
      name: 'admin/report-confirm',
      component: ReportConfirm,
      meta: {
        title: '売上報告確認',
        titleKey: 'admin-report-confirm',
        desc: ''
      }
    },
    {
      path: '/admin/report-confirm-detail',
      name: 'admin/report-confirm-detail',
      component: ReportConfirmDetail,
      meta: {
        title: '売上内容確認 ',
        titleKey: 'admin-report-confirm-detail',
        desc: ''
      }
    },
    {
      path: '/sales/new-user-login',
      name: 'sales/new-user-login',
      component: NewUserLogin,
      alias: '/',
      meta: {
        title: '販売員ログイン',
        titleKey: 'sales-user-login',
        desc: ''
      }
    },
    {
      path: '/sales/new-user-menu',
      name: 'sales/new-user-menu',
      component: NewUserMenu,
      meta: {
        title: '販売員メニュー',
        titleKey: 'sales-user-menu',
        desc: ''
      }
    },
    {
      path: '/admin/password-change',
      name: 'admin/password-change',
      component: PasswordChange,
      meta: {
        title: '初期パスワード変更',
        titleKey: 'admin-password-change',
        desc: ''
      }
    },
    {
      path: '/admin/new-admin-login',
      name: 'admin/new-admin-login',
      component: NewAdminLogin,
      alias: '/admin-login',
      meta: {
        title: '管理者ログイン',
        titleKey: 'admin-admin-login',
        desc: ''
      }
    },
    {
      path: '/admin/new-admin-menu',
      name: 'admin/new-admin-menu',
      component: NewAdminMenu,
      meta: {
        title: '管理者メニュー',
        titleKey: 'admin-admin-menu',
        desc: ''
      }
    },
    {
      path: '/admin/new-item-category',
      name: 'admin/new-item-category',
      component: NewItemCategory,
      meta: {
        title: '商品カテゴリメンテナンス',
        titleKey: 'admin-item-category',
        desc: ''
      }
    },
    {
      path: '/admin/new-item-maintenance',
      name: 'admin/new-item-maintenance',
      component: NewItemMaintenance,
      meta: {
        title: '商品データメンテナンス',
        titleKey: 'admin-item-maintenance',
        desc: ''
      }
    },
    {
      path: '/admin/new-item-regist',
      name: 'admin/new-item-regist',
      component: NewItemRegist,
      meta: {
        title: '商品データ登録',
        titleKey: 'admin-item-regist',
        desc: ''
      }
    },
    {
      path: '/admin/items/:itemCode',
      name: 'admin_items_update',
      alias: '',
      component: NewItemRegist,
      meta: {
        title: '商品データ更新',
        titleKey: 'admin-items-itemCode',
        desc: ''
      }
    },
    {
      path: '/sales/new-order-send',
      name: 'sales/new-order-send',
      component: NewOrderSend,
      meta: {
        title: '発注依頼',
        titleKey: 'sales-order-send',
        desc: '',
        props: true
      }
    },
    {
      path: '/sales/new-order-send-confirm',
      name: 'sales/new-order-send-confirm',
      component: NewOrderSendConfirm,
      meta: {
        title: '発注依頼確認',
        titleKey: 'sales-order-send-confirm',
        desc: '',
        props: true
      }
    },
    {
      path: '/sales/new-order-send-by-image',
      name: 'sales/new-order-send-by-image',
      component: NewOrderSendByImage,
      meta: {
        title: '発注依頼送信',
        titleKey: 'sales-order-send-by-image',
        desc: '',
        props: true
      }
    },
    {
      path: '/admin/new-supplier-maintenance',
      name: 'admin/new-supplier-maintenance',
      component: NewSupplierMaintenance,
      meta: {
        title: '取引先データメンテナンス',
        titleKey: 'admin-supplier-maintenance',
        desc: ''
      }
    },
    {
      path: '/admin/suppliers/new',
      name: 'admin/suppliers/new',
      component: NewSupplierRegist,
      meta: {
        title: '取引先データ登録',
        titleKey: 'admin-suppliers-new',
        desc: ''
      }
    },
    {
      path: '/admin/suppliers/:supplierCode',
      name: 'admin_suppliers_update',
      alias: '',
      component: NewSupplierRegist,
      meta: {
        title: '取引先データ更新',
        titleKey: 'admin-suppliers-supplierCode',
        desc: ''
      }
    },
    {
      path: '/admin/new-store-maintenance',
      name: 'admin/new-store-maintenance',
      component: NewStoreMaintenance,
      meta: {
        title: '店舗データメンテナンス',
        titleKey: 'admin-store-maintenance',
        desc: ''
      }
    },
    {
      path: '/admin/stores/new',
      name: 'admin/stores/new',
      component: NewStoreRegist,
      meta: {
        title: '店舗データ登録',
        titleKey: 'admin-stores-new',
        desc: ''
      }
    },
    {
      path: '/admin/stores/:storeCode',
      name: 'admin_stores_update',
      alias: '',
      component: NewStoreRegist,
      meta: {
        title: '店舗データ更新',
        titleKey: 'admin-stores-storecode',
        desc: ''
      }
    },
    {
      path: '/admin/new-user-upload',
      name: 'admin/new-user-upload',
      component: NewUserUpload,
      meta: {
        title: '従業員データ一覧',
        titleKey: 'admin-user-upload',
        desc: ''
      }
    },
    {
      path: '/admin/new-brand-maintenance',
      name: 'admin/new-brand-maintenance',
      component: NewBrandMaintenance,
      meta: {
        title: 'ブランド名メンテナンス',
        titleKey: 'admin-brand-maintenance',
        desc: ''
      }
    },
    {
      path: '/admin/new-businessContact',
      name: 'admin/new-businessContact',
      component: NewBusinessContact,
      meta: {
        title: '業務連絡登録',
        titleKey: 'admin-businessContact',
        desc: ''
      }
    },
    {
      path: '/admin/new-order-confirm',
      name: 'admin/new-order-confirm',
      component: NewOrderConfirm,
      meta: {
        title: '発注依頼確認',
        titleKey: 'admin-order-confirm',
        desc: ''
      }
    },
    {
      path: '/admin/new-order-accept',
      name: 'admin/new-order-accept',
      component: NewOrderAccept,
      meta: {
        title: '発注依頼確認',
        titleKey: 'admin-order-accept',
        desc: ''
      }
    },
    {
      path: 'admin/supplier-brand-maintenance',
      name: 'admin/supplier-brand-maintenance',
      component: SupplierBrandMaintenance,
      meta: {
        title: '取引先・ブランド関連メンテナンス',
        titleKey: 'admin-supplier-brand-maintenance',
        desc: ''
      }
    },
    {
      path: 'admin/delivery-slip',
      name: 'admin/delivery-slip',
      component: DeliverySlip,
      meta: {
        title: '納品書出力',
        titleKey: 'admin-delivery-slip',
        desc: '',
        nonDispHeader: true
      }
    }*/
  ]
})