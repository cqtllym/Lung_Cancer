import { getDownloadList } from "../../api/getDownloadList"
 
const theDownloadList = {
  actions: {
    GetDownloadList({ commit }) { 
      return new Promise((resolve, reject) => { //封装一个 Promise
        getDownloadList().then(response => { 
          commit('') 
          resolve(response) //将结果封装进 Promise
        }).catch(error => {
          reject(error)
        })
      })
    },
  }
}
export default theDownloadList