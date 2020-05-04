import request from '../utils/request.js'

export function search(params){
    return request({
        url: '/searchFund',
        method: 'post',
        data: params
      })
}

export function fund(params){
  return request({
      url: '/fund',
      method: 'post',
      data: params
    })
}

