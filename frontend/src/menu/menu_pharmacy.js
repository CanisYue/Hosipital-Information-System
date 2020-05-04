let menu_pharmacy = {};
/**
 * 字体图标
 * @type {{name: string, icon: string, children: {}}}
 */


export default menu_pharmacy;

if(process.env.NODE_ENV=='development'){

  menu_pharmacy.development_tools = {
    name: '药房',
    icon: 'fa fa-wrench',
    children: {}
  };

  let DevelopmentTools = menu_pharmacy.development_tools.children;

  DevelopmentTools.code = {
    name: '药房发药',
    path: '/pharmacy/giveaway',
  };

}
