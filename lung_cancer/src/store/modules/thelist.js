import { getlist } from "../../api/getlist"
 
const thelist = {
  actions: {
    Getlist({ commit }) { 
      return new Promise((resolve, reject) => { //封装一个 Promise
        getlist().then(response => { 
          commit('') 
          resolve(response) //将结果封装进 Promise
        }).catch(error => {
          reject(error)
        })
      })
    },
  }
}
export default thelist