import { download } from "../../api/download"
 
const theresult = {
  actions: {
    GetResult({ commit },src) { 
      return new Promise((resolve, reject) => { //封装一个 Promise
        download(src).then(response => { 
          commit('') 
          resolve(response) //将结果封装进 Promise
        }).catch(error => {
          reject(error)
        })
      })
    },
  }
}
export default theresult