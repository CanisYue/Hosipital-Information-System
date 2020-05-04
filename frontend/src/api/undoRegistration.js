import request from '../utils/request.js'

export function searchRecord(params){
    return request({
        url: '/searchRecord',
        method: 'post',
        data: params
      })
}

export function undo(params){
    return request({
        url: '/undoRegistration',
        method: 'post',
        data: params
    })
}