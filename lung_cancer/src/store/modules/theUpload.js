import { upload } from "../../api/upload"
 
const therna = {
  actions: {
    Upload({ commit }, fd) { 
      return new Promise((resolve, reject) => { //封装一个 Promise
        upload(fd).then(response => { 
          commit('') 
          resolve(response) //将结果封装进 Promise
        }).catch(error => {
          reject(error)
        })
      })
    },
  }
}
export default therna