export const state = () => ({
  lastName: ''
})

export const mutations = {
  SET_USER(state, user) {
    console.log('ユーザ情報をstateに保持します')
    state.accessToken = user.accessToken
    state.firstName = user.firstName
    state.lastName = user.lastName
    state.userGroup = user.userGroup
    state.staffType = user.staffType
    state.adminRole = user.adminRole
  }
}