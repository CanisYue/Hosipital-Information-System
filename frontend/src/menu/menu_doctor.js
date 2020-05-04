let menu_doctor = {};
/**
 * 内容管理
 * @type {{name: string, icon: string, children: {}}}
 */
menu_doctor.content_manage = {
  name: '门诊医生',
  icon: 'fa fa-file-text-o',
  children: {}
};

let ContentManage = menu_doctor.content_manage.children;

ContentManage.post = {
  name: '医生看诊',
  path: '/doctor/frontpage',
};
ContentManage.sentence = {
  name: '医生开药',
  path: '/doctor/complete',
};

export default menu_doctor;


