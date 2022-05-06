import axios from "axios"
import baseUrl from '../api/baseUrl'
 
// 创建 axios 实例
const service = axios.create({
    baseURL: baseUrl, // api 的 base_url
    timeout: 10*60*1000, // 请求超时时间
})

export default service


