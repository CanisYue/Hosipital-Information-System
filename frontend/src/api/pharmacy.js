import request from '../utils/request.js'

export function search(params){
    return request({
        url: '/searchPharmacy',
        method: 'post',
        data: params
      })
}

export function giveaway(params){
    return request({
        url: '/giveaway',
        method: 'post',
        data: params
      })
}