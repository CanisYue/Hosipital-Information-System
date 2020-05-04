import localKey from './localKey'

const devApiUrl = 'http://127.0.0.1:8081';

const proApiUrl = 'http://api.youUrl.com';
//const proApiUrl = 'http://192.168.49.196:10003';

const nodeDevEnv = process.env.NODE_ENV == 'development' ? true : false;

export default {
  nodeDevEnv: nodeDevEnv,
  apiUrl: nodeDevEnv ? devApiUrl : proApiUrl,
  siteName: 'HIS',
  minSiteMame: 'HTA',
  apiPrefix: "",
  timeout: 2000,
  cookiesExpires: 7,
  requestRetry: 4,
  requestRetryDelay: 800,
  tokenKey: 'ACCESS_TOKEN',
  userInfoKey: 'USER_INFO',
  permissionsKey: 'PERMISSION_ARRAY',

}