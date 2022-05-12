import { dynamic } from "../../api/dynamic"
 
const theDynamic = {
  actions: {
    Dynamic({ commit }, the_list) { 
      return new Promise((resolve, reject) => { //封装一个 Promise
        dynamic(the_list).then(response => { 
          commit('') 
          resolve(response) //将结果封装进 Promise
        }).catch(error => {
          reject(error)
        })
      })
    },
  }
}
export default theDynamic