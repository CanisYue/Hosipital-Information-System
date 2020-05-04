import request from '../utils/request.js'

export function getBasicInfo(params) {
    return request({
      url: '/basicInfo',
      method: 'post',
      data: params
    })
}

export function getDepartmentList(params){
    return request({
        url: '/getDepartmentList',
        method: 'post',
        data: params
    })
}

export function submit(params){
    return request({
        url: '/submitRegistration',
        method: 'post',
        data: params
    })
}

export function getDoctor(params){
    return request({
        url: '/getDoctor',
        method: 'post',
        data: params
    })
}