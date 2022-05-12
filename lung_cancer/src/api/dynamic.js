import request from '@/utils/request' //引入封装好的 axios 请求
 
export function dynamic(the_list) { //登录接口
  return request({ //使用封装好的 axios 进行网络请求
    url: '/dynamic',
    method: 'post',
    params: {
      the_list
    }
  })
}


