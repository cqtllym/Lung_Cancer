import { getmsg } from "../../api/getmsg"
 
const themsg = {
  actions: {
    Getmsg({ commit }, patientInfo) { 
      const name = patientInfo.name.trim()
      return new Promise((resolve, reject) => { //封装一个 Promise
        getmsg(name,patientInfo.id).then(response => { 
          commit('') 
          resolve(response) //将结果封装进 Promise
        }).catch(error => {
          reject(error)
        })
      })
    },
  }
}
export default themsg