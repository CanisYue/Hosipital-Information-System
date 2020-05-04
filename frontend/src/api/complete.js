import request from '../utils/request.js'

export function load(params){
    return request({
        url: '/loadPatient',
        method: 'post',
        data: params
      })
}

export function addComplete(params){
  return request({
      url: '/addComplete',
      method: 'post',
      data: params
    })
}

export function getComplete(params){
  return request({
      url: '/getCompletes',
      method: 'post',
      data: params
    })
}

export function addMedicine(params){
  return request({
      url: '/addMedicine',
      method: 'post',
      data: params
    })
}

export function destroyComplete(params){
  return request({
    url: '/destroyComplete',
    method: 'post',
    data: params
  })
}

export function getCompleteDetail(params){
  return request({
    url: '/getCompleteDetail',
    method: 'post',
    data: params
  })
}

export function getMedicines(params){
  return request({
    url: '/getMedicines',
    method: 'post',
    data: params
  })
}

export function confirmComplete(params){
  return request({
    url: '/confirmComplete',
    method: 'post',
    data: params
  })
}

export function loadModel(params){
  return request({
    url: '/loadModel',
    method: 'post',
    data: params
  })
}

export function getModelDetail(params){
  return request({
    url: '/getModelDetail',
    method: 'post',
    data: params
  })
}

export function useModel(params){
  return request({
    url: '/useModel',
    method: 'post',
    data: params
  })
}

export function destroyMedicine(params){
  return request({
    url: '/destroyMedicine',
    method: 'post',
    data: params
  })
}