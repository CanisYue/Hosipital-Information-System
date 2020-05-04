let menu_operator = {};
/**
 * 字体图标
 * @type {{name: string, icon: string, children: {}}}
 */
menu_operator.font_icon = {
  name: '挂号收费',
  icon: 'fa fa-th',
  children: {}
};
let icon = menu_operator.font_icon.children;

icon.font_awesome = {
  name: '挂号',
  path: '/operator/registration',

};
icon.element_icon = {
  name: '退号',
  path: '/operator/undo_registration',
};
icon.fund = {
  name: '收费',
  path: '/operator/fund',
};


export default menu_operator;

