



import PlatformBase from './platform/Platform.base';
import PlatformBizApp from './platform/Platform.app';
import PlatformModel from './platform/Platform.model';
import PlatformDashboard from './platform/Platform.dashboard';
import PlatformPreference from './platform/Platform.preference';
import PlatformModalTable from './platform/Platform.modaltable';
import PlatformSearch from './platform/Platform.search';
import PlatformSearchForm from './platform/Platform.searchform';
import PlatformCreateForm from './platform/Platform.createform';
import PlatformAssociateForm from './platform/Platform.associateform';
import PlatformTable from './platform/Platform.table';
import PlatformPermission from './platform/Platform.permission';
import PlatformProfile from './platform/Platform.profile';
import PlatformService from './platform/Platform.service';
import PlatformUpdateForm from './platform/Platform.updateform';
import TargetObjectBase from './targetobject/TargetObject.base';
import TargetObjectBizApp from './targetobject/TargetObject.app';
import TargetObjectModel from './targetobject/TargetObject.model';
import TargetObjectDashboard from './targetobject/TargetObject.dashboard';
import TargetObjectPreference from './targetobject/TargetObject.preference';
import TargetObjectModalTable from './targetobject/TargetObject.modaltable';
import TargetObjectSearch from './targetobject/TargetObject.search';
import TargetObjectSearchForm from './targetobject/TargetObject.searchform';
import TargetObjectCreateForm from './targetobject/TargetObject.createform';
import TargetObjectAssociateForm from './targetobject/TargetObject.associateform';
import TargetObjectTable from './targetobject/TargetObject.table';
import TargetObjectPermission from './targetobject/TargetObject.permission';
import TargetObjectProfile from './targetobject/TargetObject.profile';
import TargetObjectService from './targetobject/TargetObject.service';
import TargetObjectUpdateForm from './targetobject/TargetObject.updateform';
import ViewDeviceBase from './viewdevice/ViewDevice.base';
import ViewDeviceBizApp from './viewdevice/ViewDevice.app';
import ViewDeviceModel from './viewdevice/ViewDevice.model';
import ViewDeviceDashboard from './viewdevice/ViewDevice.dashboard';
import ViewDevicePreference from './viewdevice/ViewDevice.preference';
import ViewDeviceModalTable from './viewdevice/ViewDevice.modaltable';
import ViewDeviceSearch from './viewdevice/ViewDevice.search';
import ViewDeviceSearchForm from './viewdevice/ViewDevice.searchform';
import ViewDeviceCreateForm from './viewdevice/ViewDevice.createform';
import ViewDeviceAssociateForm from './viewdevice/ViewDevice.associateform';
import ViewDeviceTable from './viewdevice/ViewDevice.table';
import ViewDevicePermission from './viewdevice/ViewDevice.permission';
import ViewDeviceProfile from './viewdevice/ViewDevice.profile';
import ViewDeviceService from './viewdevice/ViewDevice.service';
import ViewDeviceUpdateForm from './viewdevice/ViewDevice.updateform';
import UserDomainBase from './userdomain/UserDomain.base';
import UserDomainBizApp from './userdomain/UserDomain.app';
import UserDomainModel from './userdomain/UserDomain.model';
import UserDomainDashboard from './userdomain/UserDomain.dashboard';
import UserDomainPreference from './userdomain/UserDomain.preference';
import UserDomainModalTable from './userdomain/UserDomain.modaltable';
import UserDomainSearch from './userdomain/UserDomain.search';
import UserDomainSearchForm from './userdomain/UserDomain.searchform';
import UserDomainCreateForm from './userdomain/UserDomain.createform';
import UserDomainAssociateForm from './userdomain/UserDomain.associateform';
import UserDomainTable from './userdomain/UserDomain.table';
import UserDomainPermission from './userdomain/UserDomain.permission';
import UserDomainProfile from './userdomain/UserDomain.profile';
import UserDomainService from './userdomain/UserDomain.service';
import UserDomainUpdateForm from './userdomain/UserDomain.updateform';
import UserWhiteListBase from './userwhitelist/UserWhiteList.base';
import UserWhiteListBizApp from './userwhitelist/UserWhiteList.app';
import UserWhiteListModel from './userwhitelist/UserWhiteList.model';
import UserWhiteListDashboard from './userwhitelist/UserWhiteList.dashboard';
import UserWhiteListPreference from './userwhitelist/UserWhiteList.preference';
import UserWhiteListModalTable from './userwhitelist/UserWhiteList.modaltable';
import UserWhiteListSearch from './userwhitelist/UserWhiteList.search';
import UserWhiteListSearchForm from './userwhitelist/UserWhiteList.searchform';
import UserWhiteListCreateForm from './userwhitelist/UserWhiteList.createform';
import UserWhiteListAssociateForm from './userwhitelist/UserWhiteList.associateform';
import UserWhiteListTable from './userwhitelist/UserWhiteList.table';
import UserWhiteListPermission from './userwhitelist/UserWhiteList.permission';
import UserWhiteListProfile from './userwhitelist/UserWhiteList.profile';
import UserWhiteListService from './userwhitelist/UserWhiteList.service';
import UserWhiteListUpdateForm from './userwhitelist/UserWhiteList.updateform';
import SecUserBase from './secuser/SecUser.base';
import SecUserBizApp from './secuser/SecUser.app';
import SecUserModel from './secuser/SecUser.model';
import SecUserDashboard from './secuser/SecUser.dashboard';
import SecUserPreference from './secuser/SecUser.preference';
import SecUserModalTable from './secuser/SecUser.modaltable';
import SecUserSearch from './secuser/SecUser.search';
import SecUserSearchForm from './secuser/SecUser.searchform';
import SecUserCreateForm from './secuser/SecUser.createform';
import SecUserAssociateForm from './secuser/SecUser.associateform';
import SecUserTable from './secuser/SecUser.table';
import SecUserPermission from './secuser/SecUser.permission';
import SecUserProfile from './secuser/SecUser.profile';
import SecUserService from './secuser/SecUser.service';
import SecUserUpdateForm from './secuser/SecUser.updateform';
import SecUserBlockingBase from './secuserblocking/SecUserBlocking.base';
import SecUserBlockingBizApp from './secuserblocking/SecUserBlocking.app';
import SecUserBlockingModel from './secuserblocking/SecUserBlocking.model';
import SecUserBlockingDashboard from './secuserblocking/SecUserBlocking.dashboard';
import SecUserBlockingPreference from './secuserblocking/SecUserBlocking.preference';
import SecUserBlockingModalTable from './secuserblocking/SecUserBlocking.modaltable';
import SecUserBlockingSearch from './secuserblocking/SecUserBlocking.search';
import SecUserBlockingSearchForm from './secuserblocking/SecUserBlocking.searchform';
import SecUserBlockingCreateForm from './secuserblocking/SecUserBlocking.createform';
import SecUserBlockingAssociateForm from './secuserblocking/SecUserBlocking.associateform';
import SecUserBlockingTable from './secuserblocking/SecUserBlocking.table';
import SecUserBlockingPermission from './secuserblocking/SecUserBlocking.permission';
import SecUserBlockingProfile from './secuserblocking/SecUserBlocking.profile';
import SecUserBlockingService from './secuserblocking/SecUserBlocking.service';
import SecUserBlockingUpdateForm from './secuserblocking/SecUserBlocking.updateform';
import UserAppBase from './userapp/UserApp.base';
import UserAppBizApp from './userapp/UserApp.app';
import UserAppModel from './userapp/UserApp.model';
import UserAppDashboard from './userapp/UserApp.dashboard';
import UserAppPreference from './userapp/UserApp.preference';
import UserAppModalTable from './userapp/UserApp.modaltable';
import UserAppSearch from './userapp/UserApp.search';
import UserAppSearchForm from './userapp/UserApp.searchform';
import UserAppCreateForm from './userapp/UserApp.createform';
import UserAppAssociateForm from './userapp/UserApp.associateform';
import UserAppTable from './userapp/UserApp.table';
import UserAppPermission from './userapp/UserApp.permission';
import UserAppProfile from './userapp/UserApp.profile';
import UserAppService from './userapp/UserApp.service';
import UserAppUpdateForm from './userapp/UserApp.updateform';
import ListAccessBase from './listaccess/ListAccess.base';
import ListAccessBizApp from './listaccess/ListAccess.app';
import ListAccessModel from './listaccess/ListAccess.model';
import ListAccessDashboard from './listaccess/ListAccess.dashboard';
import ListAccessPreference from './listaccess/ListAccess.preference';
import ListAccessModalTable from './listaccess/ListAccess.modaltable';
import ListAccessSearch from './listaccess/ListAccess.search';
import ListAccessSearchForm from './listaccess/ListAccess.searchform';
import ListAccessCreateForm from './listaccess/ListAccess.createform';
import ListAccessAssociateForm from './listaccess/ListAccess.associateform';
import ListAccessTable from './listaccess/ListAccess.table';
import ListAccessPermission from './listaccess/ListAccess.permission';
import ListAccessProfile from './listaccess/ListAccess.profile';
import ListAccessService from './listaccess/ListAccess.service';
import ListAccessUpdateForm from './listaccess/ListAccess.updateform';
import ObjectAccessBase from './objectaccess/ObjectAccess.base';
import ObjectAccessBizApp from './objectaccess/ObjectAccess.app';
import ObjectAccessModel from './objectaccess/ObjectAccess.model';
import ObjectAccessDashboard from './objectaccess/ObjectAccess.dashboard';
import ObjectAccessPreference from './objectaccess/ObjectAccess.preference';
import ObjectAccessModalTable from './objectaccess/ObjectAccess.modaltable';
import ObjectAccessSearch from './objectaccess/ObjectAccess.search';
import ObjectAccessSearchForm from './objectaccess/ObjectAccess.searchform';
import ObjectAccessCreateForm from './objectaccess/ObjectAccess.createform';
import ObjectAccessAssociateForm from './objectaccess/ObjectAccess.associateform';
import ObjectAccessTable from './objectaccess/ObjectAccess.table';
import ObjectAccessPermission from './objectaccess/ObjectAccess.permission';
import ObjectAccessProfile from './objectaccess/ObjectAccess.profile';
import ObjectAccessService from './objectaccess/ObjectAccess.service';
import ObjectAccessUpdateForm from './objectaccess/ObjectAccess.updateform';
import LoginHistoryBase from './loginhistory/LoginHistory.base';
import LoginHistoryBizApp from './loginhistory/LoginHistory.app';
import LoginHistoryModel from './loginhistory/LoginHistory.model';
import LoginHistoryDashboard from './loginhistory/LoginHistory.dashboard';
import LoginHistoryPreference from './loginhistory/LoginHistory.preference';
import LoginHistoryModalTable from './loginhistory/LoginHistory.modaltable';
import LoginHistorySearch from './loginhistory/LoginHistory.search';
import LoginHistorySearchForm from './loginhistory/LoginHistory.searchform';
import LoginHistoryCreateForm from './loginhistory/LoginHistory.createform';
import LoginHistoryAssociateForm from './loginhistory/LoginHistory.associateform';
import LoginHistoryTable from './loginhistory/LoginHistory.table';
import LoginHistoryPermission from './loginhistory/LoginHistory.permission';
import LoginHistoryProfile from './loginhistory/LoginHistory.profile';
import LoginHistoryService from './loginhistory/LoginHistory.service';
import LoginHistoryUpdateForm from './loginhistory/LoginHistory.updateform';


const BizModels = [
	PlatformModel,
	TargetObjectModel,
	ViewDeviceModel,
	UserDomainModel,
	UserWhiteListModel,
	SecUserModel,
	SecUserBlockingModel,
	UserAppModel,
	ListAccessModel,
	ObjectAccessModel,
	LoginHistoryModel,

]


const bindBizModels = (app) =>{

	BizModels.map((model)=>app.model(model))

}
const unbindBizModels = (app) =>{

	BizModels.map((model)=>app.unmodel(model))

}

const menuLibrary = []

menuLibrary['platform'] = PlatformBase.menuData
menuLibrary['targetObject'] = TargetObjectBase.menuData
menuLibrary['viewDevice'] = ViewDeviceBase.menuData
menuLibrary['userDomain'] = UserDomainBase.menuData
menuLibrary['userWhiteList'] = UserWhiteListBase.menuData
menuLibrary['secUser'] = SecUserBase.menuData
menuLibrary['secUserBlocking'] = SecUserBlockingBase.menuData
menuLibrary['userApp'] = UserAppBase.menuData
menuLibrary['listAccess'] = ListAccessBase.menuData
menuLibrary['objectAccess'] = ObjectAccessBase.menuData
menuLibrary['loginHistory'] = LoginHistoryBase.menuData


const menuDataOf=(type)=>{
	
	const menu = menuLibrary[type]
	
	if(menu){
		return menu;
	}
	console.error(`Not able to find corresponding menu for ${type}`);

	return null;

}



const ViewMapping = {


  'com.doublechaintech.arx.platform.Platform': {name:'platform'},
  'com.doublechaintech.arx.targetobject.TargetObject': {name:'targetObject'},
  'com.doublechaintech.arx.viewdevice.ViewDevice': {name:'viewDevice'},
  'com.doublechaintech.arx.userdomain.UserDomain': {name:'userDomain'},
  'com.doublechaintech.arx.userwhitelist.UserWhiteList': {name:'userWhiteList'},
  'com.doublechaintech.arx.secuser.SecUser': {name:'secUser'},
  'com.doublechaintech.arx.secuserblocking.SecUserBlocking': {name:'secUserBlocking'},
  'com.doublechaintech.arx.userapp.UserApp': {name:'userApp'},
  'com.doublechaintech.arx.listaccess.ListAccess': {name:'listAccess'},
  'com.doublechaintech.arx.objectaccess.ObjectAccess': {name:'objectAccess'},
  'com.doublechaintech.arx.loginhistory.LoginHistory': {name:'loginHistory'},

}



// eslint-disable-next-line no-unused-vars
const presentApp = (clazz, data) => {
  // console.log(data)
}


const calcLocationPath = (clazz,id,subLocation) => {

  const location = ViewMapping[clazz]
  if(!location){
  	console.error("Not able to find an app for class: ", clazz);
  	return 'home'
  }
  const {name} = location;
  if(!name){
  	return '/home'
  }
  if (name) {
    return `${name}/${id}/${subLocation}`
  }
  return '/home'
}


const calcMenuData=(clazz) => {
  const location = ViewMapping[clazz]
  if(!location){
  	console.error("Not able to find an app for class: ", clazz);
    return {};
  }
  const {name} = location;
  //const { menuDataOf } = GlobalComponents
  return menuDataOf(name)
}

// console.log("element", )



const OOTBComponents={
    PlatformBase,
    PlatformBizApp,
    PlatformModel,
    PlatformDashboard,
    PlatformPreference,
    PlatformModalTable,
    PlatformSearch,
    PlatformSearchForm,
    PlatformCreateForm,
    PlatformAssociateForm,
    PlatformTable,
    PlatformPermission,
    PlatformProfile,
    PlatformService,
    PlatformUpdateForm,
    TargetObjectBase,
    TargetObjectBizApp,
    TargetObjectModel,
    TargetObjectDashboard,
    TargetObjectPreference,
    TargetObjectModalTable,
    TargetObjectSearch,
    TargetObjectSearchForm,
    TargetObjectCreateForm,
    TargetObjectAssociateForm,
    TargetObjectTable,
    TargetObjectPermission,
    TargetObjectProfile,
    TargetObjectService,
    TargetObjectUpdateForm,
    ViewDeviceBase,
    ViewDeviceBizApp,
    ViewDeviceModel,
    ViewDeviceDashboard,
    ViewDevicePreference,
    ViewDeviceModalTable,
    ViewDeviceSearch,
    ViewDeviceSearchForm,
    ViewDeviceCreateForm,
    ViewDeviceAssociateForm,
    ViewDeviceTable,
    ViewDevicePermission,
    ViewDeviceProfile,
    ViewDeviceService,
    ViewDeviceUpdateForm,
    UserDomainBase,
    UserDomainBizApp,
    UserDomainModel,
    UserDomainDashboard,
    UserDomainPreference,
    UserDomainModalTable,
    UserDomainSearch,
    UserDomainSearchForm,
    UserDomainCreateForm,
    UserDomainAssociateForm,
    UserDomainTable,
    UserDomainPermission,
    UserDomainProfile,
    UserDomainService,
    UserDomainUpdateForm,
    UserWhiteListBase,
    UserWhiteListBizApp,
    UserWhiteListModel,
    UserWhiteListDashboard,
    UserWhiteListPreference,
    UserWhiteListModalTable,
    UserWhiteListSearch,
    UserWhiteListSearchForm,
    UserWhiteListCreateForm,
    UserWhiteListAssociateForm,
    UserWhiteListTable,
    UserWhiteListPermission,
    UserWhiteListProfile,
    UserWhiteListService,
    UserWhiteListUpdateForm,
    SecUserBase,
    SecUserBizApp,
    SecUserModel,
    SecUserDashboard,
    SecUserPreference,
    SecUserModalTable,
    SecUserSearch,
    SecUserSearchForm,
    SecUserCreateForm,
    SecUserAssociateForm,
    SecUserTable,
    SecUserPermission,
    SecUserProfile,
    SecUserService,
    SecUserUpdateForm,
    SecUserBlockingBase,
    SecUserBlockingBizApp,
    SecUserBlockingModel,
    SecUserBlockingDashboard,
    SecUserBlockingPreference,
    SecUserBlockingModalTable,
    SecUserBlockingSearch,
    SecUserBlockingSearchForm,
    SecUserBlockingCreateForm,
    SecUserBlockingAssociateForm,
    SecUserBlockingTable,
    SecUserBlockingPermission,
    SecUserBlockingProfile,
    SecUserBlockingService,
    SecUserBlockingUpdateForm,
    UserAppBase,
    UserAppBizApp,
    UserAppModel,
    UserAppDashboard,
    UserAppPreference,
    UserAppModalTable,
    UserAppSearch,
    UserAppSearchForm,
    UserAppCreateForm,
    UserAppAssociateForm,
    UserAppTable,
    UserAppPermission,
    UserAppProfile,
    UserAppService,
    UserAppUpdateForm,
    ListAccessBase,
    ListAccessBizApp,
    ListAccessModel,
    ListAccessDashboard,
    ListAccessPreference,
    ListAccessModalTable,
    ListAccessSearch,
    ListAccessSearchForm,
    ListAccessCreateForm,
    ListAccessAssociateForm,
    ListAccessTable,
    ListAccessPermission,
    ListAccessProfile,
    ListAccessService,
    ListAccessUpdateForm,
    ObjectAccessBase,
    ObjectAccessBizApp,
    ObjectAccessModel,
    ObjectAccessDashboard,
    ObjectAccessPreference,
    ObjectAccessModalTable,
    ObjectAccessSearch,
    ObjectAccessSearchForm,
    ObjectAccessCreateForm,
    ObjectAccessAssociateForm,
    ObjectAccessTable,
    ObjectAccessPermission,
    ObjectAccessProfile,
    ObjectAccessService,
    ObjectAccessUpdateForm,
    LoginHistoryBase,
    LoginHistoryBizApp,
    LoginHistoryModel,
    LoginHistoryDashboard,
    LoginHistoryPreference,
    LoginHistoryModalTable,
    LoginHistorySearch,
    LoginHistorySearchForm,
    LoginHistoryCreateForm,
    LoginHistoryAssociateForm,
    LoginHistoryTable,
    LoginHistoryPermission,
    LoginHistoryProfile,
    LoginHistoryService,
    LoginHistoryUpdateForm,
    menuDataOf,bindBizModels,unbindBizModels,calcLocationPath,calcMenuData
};
       


export default OOTBComponents;







