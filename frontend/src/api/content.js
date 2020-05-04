import request from '../utils/request.js'

// 文章
export function allPosts(params) {
  return request({
    url: '/posts',
    method: 'get',
    data: params
  })
}


// 半句
export function allSentences(params) {
  return request({
    url: '/sentences',
    method: 'get',
    data: params
  })
}

export function addSentence(params) {
  return request({
    url: '/sentence'+'/{'+params.sentence_content+'}',
    method: 'post',
    data: params
  })
}

export function deleteSentence(params) {
  return request({
    url: '/sentence'+'/{'+params.id+'}',
    method: 'delete',
    data: params
  })
}

// 反馈
export function allFeedback(params) {
  return request({
    url: '/feedback',
    method: 'get',
    data: params
  })
}

export function deleteFeedback(params) {
  return request({
    url: '/feedback'+'/{'+params.id+'}',
    method: 'delete',
    data: params
  })
}

// 半句主题
export function sentenceTheme(params) {
  // console.log("我现在api处：")
  // console.log(params)
  return request({
    url: '/sentenceTheme'+'/{'+params.sentence_theme+'}',
    method: 'post',
    data: params
  })
}