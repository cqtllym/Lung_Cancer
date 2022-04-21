import request from '@/utils/request' //引入封装好的 axios 请求
 
export function upload(fd) { //登录接口
  return request({ //使用封装好的 axios 进行网络请求
    url: '/upload',
    method: 'post',
    headers:{
      'content-type':'multipart/form-data;boundary=----WebKitFormBoundaryXUIhYHlAmsiYAKUG'
    },
    data: fd
  })
}


