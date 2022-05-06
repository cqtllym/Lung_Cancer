import Vue from "vue"
import Vuex from "vuex"
import themsg from './modules/themsg'
import thelist from './modules/thelist'
import theUpload from './modules/theUpload'
import theresult from './modules/theresult'
import theDownloadList from "./modules/theDownloadList"

Vue.use(Vuex)
import {state,getters,mutations} from "./mutations"
import {actions} from "./actions"


export default new Vuex.Store({
    state,
    getters,
    mutations,
    actions,
    modules:{
        themsg,
        thelist,
        theUpload,
        theresult,
        theDownloadList
    }
})

