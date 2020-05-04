let menu = {};

/**
 * 首页
 * @type {{name: string, path: string, icon: string}}
 */
// menu.home = {
//   name: '首页',
//   path: '/',
//   icon: 'fa fa-tachometer',
// };


/**
 * 字体图标
 * @type {{name: string, icon: string, children: {}}}
 */
menu.font_icon = {
  name: '挂号收费',
  icon: 'fa fa-th',
  children: {}
};
let icon = menu.font_icon.children;

icon.font_awesome = {
  name: '挂号',
  path: '/registration',

};
icon.element_icon = {
  name: '退号',
  path: '/undo_registration',
};
icon.fund = {
  name: '收费',
  path: '/fund',
};

/**
 * 内容管理
 * @type {{name: string, icon: string, children: {}}}
 */
menu.content_manage = {
  name: '门诊医生',
  icon: 'fa fa-file-text-o',
  children: {}
};

let ContentManage = menu.content_manage.children;

ContentManage.post = {
  name: '医生看诊',
  path: '/frontpage',
};
ContentManage.sentence = {
  name: '医生开药',
  path: '/complete',
};

export default menu;

if(process.env.NODE_ENV=='development'){

  menu.development_tools = {
    name: '药房',
    icon: 'fa fa-wrench',
    children: {}
  };

  let DevelopmentTools = menu.development_tools.children;

  DevelopmentTools.code = {
    name: '药房发药',
    path: '/giveaway',
  };

}
