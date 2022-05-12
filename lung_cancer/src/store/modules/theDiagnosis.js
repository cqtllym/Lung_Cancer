import { diagnosis } from "../../api/diagnosis"
 
const theDiagnosis = {
  actions: {
    Diagnosis({ commit }, return_list) { 
        let kind1 = return_list.kind1
        let kind2 = return_list.kind2
        let dataPackage = return_list.dataPackage
      return new Promise((resolve, reject) => { //封装一个 Promise
        diagnosis(kind1, kind2, dataPackage).then(response => { 
          commit('') 
          resolve(response) //将结果封装进 Promise
        }).catch(error => {
          reject(error)
        })
      })
    },
  }
}
export default theDiagnosis