import request from '../utils/request.js'

export function loadCheck(params){
    return request({
        url: '/loadCheck',
        method: 'post',
        data: params
      })
}

export function unCheck(params){
    return request({
        url: '/loadUnCheck',
        method: 'post',
        data: params
      })
}

export function add(params){
    return request({
        url: '/addDisease',
        method: 'post',
        data: params
    })
}

export function getAllDiseases(params){
    return request({
        url: '/getAllDiseases',
        method: 'post',
        data: params
    })
}

export function submitFrontpage(params){
    return request({
        url: '/submitFrontpage',
        method: 'post',
        data: params
    })
}