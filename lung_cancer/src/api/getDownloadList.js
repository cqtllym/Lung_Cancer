import request from '@/utils/request' //引入封装好的 axios 请求
 
export function getDownloadList() { //信息列表获取接口
  return request({ //使用封装好的 axios 进行网络请求
    url: '/getD',
    method: 'post',
    data: { //提交的数据

    }
  })
}