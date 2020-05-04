import Vue from 'vue'
import store from './store/'
import ElementUI from 'element-ui'
import './assets/css/style.scss'
import router from './router/'
import Config from './config/app'
import {
  isLogin, getToken
} from './utils/dataStorage'

import App from './App.vue'
import animated from './assets/css/animate.css'
 
Vue.prototype.$Config = Config;
Vue.use(animated)

Vue.use(ElementUI)

router.beforeEach((to, from, next) => {
  window.document.title = to.meta.title ? to.meta.title + '-' + Config.siteName : Config.siteName;
  if ((!isLogin() && to.path != '/login')){
    next({
      path: '/login'
    });
  } 
  else {
    if(isLogin()){
      var a = to.path.split("/");
      var c = getToken().split(" ");  
      var d = c[1];
      if(((a[1]=='operator'&& d!=167)&&(a[1]=='operator'&&d!=168)) 
            || (a[1]=='pharmacy'&&d!=169) || ((a[1]=='doctor'&&d!=165)&&(a[1]=='doctor'&&d!=166))||(a[1]=='')){
        console.log("huitui: "+getToken());
        next({
          path: '/login'
        });

      }
      else {
        console.log("zhengchang: "+getToken());
        next();
      }
    }
    else{
      next();
    }
  }
});
router.afterEach(transition => {

});


new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
})