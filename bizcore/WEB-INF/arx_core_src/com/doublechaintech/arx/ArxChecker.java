package com.doublechaintech.arx;
import java.text.MessageFormat;
import java.util.Date;
import java.util.ArrayList;
import com.terapico.uccaf.BaseUserContext;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
public class ArxChecker extends BaseChecker{
	
	
	protected ArxUserContext userContext;
	public ArxUserContext getUserContext() {
		return userContext;
	}
	public void setUserContext(ArxUserContext userContext) {
		this.userContext = userContext;
	}
	
	public ArxChecker() {
		this.messageList = new ArrayList<Message>();
	}

	

	public static final String  ID_OF_PLATFORM ="platform.id";
	public ArxChecker checkIdOfPlatform(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PLATFORM ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_PLATFORM ="platform.name";
	public ArxChecker checkNameOfPlatform(String name)
	{
		
	 	checkStringLengthRange(name,1, 200,NAME_OF_PLATFORM ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_PLATFORM ="platform.description";
	public ArxChecker checkDescriptionOfPlatform(String description)
	{
		
	 	checkLongtext(description,0, 1048576,DESCRIPTION_OF_PLATFORM ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_PLATFORM ="platform.version";
	public ArxChecker checkVersionOfPlatform(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PLATFORM ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_TARGET_OBJECT ="target_object.id";
	public ArxChecker checkIdOfTargetObject(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TARGET_OBJECT ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_TARGET_OBJECT ="target_object.name";
	public ArxChecker checkNameOfTargetObject(String name)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_TARGET_OBJECT ); 		
		
		return this;
	}	 			

	public static final String  LONGITUDE_OF_TARGET_OBJECT ="target_object.longitude";
	public ArxChecker checkLongitudeOfTargetObject(BigDecimal longitude)
	{
		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_TARGET_OBJECT ); 		
		
		return this;
	}	 			

	public static final String  LATITUDE_OF_TARGET_OBJECT ="target_object.latitude";
	public ArxChecker checkLatitudeOfTargetObject(BigDecimal latitude)
	{
		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_TARGET_OBJECT ); 		
		
		return this;
	}	 			

	public static final String  HEIGHT_OF_TARGET_OBJECT ="target_object.height";
	public ArxChecker checkHeightOfTargetObject(int height)
	{
		
	 	checkIntegerRange(height,0, 40000,HEIGHT_OF_TARGET_OBJECT ); 		
		
		return this;
	}	 			

	public static final String  TEXT_CONTENT_OF_TARGET_OBJECT ="target_object.text_content";
	public ArxChecker checkTextContentOfTargetObject(String textContent)
	{
		
	 	checkStringLengthRange(textContent,2, 16,TEXT_CONTENT_OF_TARGET_OBJECT ); 		
		
		return this;
	}	 			

	public static final String  IMAGE_PATH_OF_TARGET_OBJECT ="target_object.image_path";
	public ArxChecker checkImagePathOfTargetObject(String imagePath)
	{
		
	 	checkImage(imagePath,0, 512,IMAGE_PATH_OF_TARGET_OBJECT ); 		
		
		return this;
	}	 			

	public static final String  PLATFORM_OF_TARGET_OBJECT ="target_object.platform";
	public ArxChecker checkPlatformIdOfTargetObject(String platformId)
	{
		
	 	checkIdOfTargetObject(platformId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_TARGET_OBJECT ="target_object.version";
	public ArxChecker checkVersionOfTargetObject(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TARGET_OBJECT ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_VIEW_DEVICE ="view_device.id";
	public ArxChecker checkIdOfViewDevice(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_VIEW_DEVICE ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_VIEW_DEVICE ="view_device.name";
	public ArxChecker checkNameOfViewDevice(String name)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_VIEW_DEVICE ); 		
		
		return this;
	}	 			

	public static final String  LONGITUDE_OF_VIEW_DEVICE ="view_device.longitude";
	public ArxChecker checkLongitudeOfViewDevice(BigDecimal longitude)
	{
		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_VIEW_DEVICE ); 		
		
		return this;
	}	 			

	public static final String  LATITUDE_OF_VIEW_DEVICE ="view_device.latitude";
	public ArxChecker checkLatitudeOfViewDevice(BigDecimal latitude)
	{
		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_VIEW_DEVICE ); 		
		
		return this;
	}	 			

	public static final String  HEIGHT_OF_VIEW_DEVICE ="view_device.height";
	public ArxChecker checkHeightOfViewDevice(int height)
	{
		
	 	checkIntegerRange(height,0, 40000,HEIGHT_OF_VIEW_DEVICE ); 		
		
		return this;
	}	 			

	public static final String  PLATFORM_OF_VIEW_DEVICE ="view_device.platform";
	public ArxChecker checkPlatformIdOfViewDevice(String platformId)
	{
		
	 	checkIdOfViewDevice(platformId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_VIEW_DEVICE ="view_device.version";
	public ArxChecker checkVersionOfViewDevice(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_VIEW_DEVICE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_USER_DOMAIN ="user_domain.id";
	public ArxChecker checkIdOfUserDomain(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_DOMAIN ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_USER_DOMAIN ="user_domain.name";
	public ArxChecker checkNameOfUserDomain(String name)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_USER_DOMAIN ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_USER_DOMAIN ="user_domain.version";
	public ArxChecker checkVersionOfUserDomain(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_DOMAIN ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_USER_WHITE_LIST ="user_white_list.id";
	public ArxChecker checkIdOfUserWhiteList(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	 			

	public static final String  USER_IDENTITY_OF_USER_WHITE_LIST ="user_white_list.user_identity";
	public ArxChecker checkUserIdentityOfUserWhiteList(String userIdentity)
	{
		
	 	checkStringLengthRange(userIdentity,1, 40,USER_IDENTITY_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	 			

	public static final String  USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST ="user_white_list.user_special_functions";
	public ArxChecker checkUserSpecialFunctionsOfUserWhiteList(String userSpecialFunctions)
	{
		
	 	checkStringLengthRange(userSpecialFunctions,1, 200,USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	 			

	public static final String  DOMAIN_OF_USER_WHITE_LIST ="user_white_list.domain";
	public ArxChecker checkDomainIdOfUserWhiteList(String domainId)
	{
		
	 	checkIdOfUserWhiteList(domainId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_USER_WHITE_LIST ="user_white_list.version";
	public ArxChecker checkVersionOfUserWhiteList(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_SEC_USER ="sec_user.id";
	public ArxChecker checkIdOfSecUser(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  LOGIN_OF_SEC_USER ="sec_user.login";
	public ArxChecker checkLoginOfSecUser(String login)
	{
		
	 	checkStringLengthRange(login,2, 20,LOGIN_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  MOBILE_OF_SEC_USER ="sec_user.mobile";
	public ArxChecker checkMobileOfSecUser(String mobile)
	{
		
	 	checkChinaMobilePhone(mobile,0, 11,MOBILE_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  EMAIL_OF_SEC_USER ="sec_user.email";
	public ArxChecker checkEmailOfSecUser(String email)
	{
		
	 	checkStringLengthRange(email,0, 76,EMAIL_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  PWD_OF_SEC_USER ="sec_user.pwd";
	public ArxChecker checkPwdOfSecUser(String pwd)
	{
		
	 	checkPassword(pwd,3, 28,PWD_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  VERIFICATION_CODE_OF_SEC_USER ="sec_user.verification_code";
	public ArxChecker checkVerificationCodeOfSecUser(int verificationCode)
	{
		
	 	checkIntegerRange(verificationCode,0, 9999999,VERIFICATION_CODE_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  VERIFICATION_CODE_EXPIRE_OF_SEC_USER ="sec_user.verification_code_expire";
	public ArxChecker checkVerificationCodeExpireOfSecUser(DateTime verificationCodeExpire)
	{
		
	 	checkDateTime(verificationCodeExpire,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),VERIFICATION_CODE_EXPIRE_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  LAST_LOGIN_TIME_OF_SEC_USER ="sec_user.last_login_time";
	public ArxChecker checkLastLoginTimeOfSecUser(DateTime lastLoginTime)
	{
		
	 	checkDateTime(lastLoginTime,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),LAST_LOGIN_TIME_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  DOMAIN_OF_SEC_USER ="sec_user.domain";
	public ArxChecker checkDomainIdOfSecUser(String domainId)
	{
		
	 	checkIdOfSecUser(domainId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_SEC_USER ="sec_user.version";
	public ArxChecker checkVersionOfSecUser(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_SEC_USER_BLOCKING ="sec_user_blocking.id";
	public ArxChecker checkIdOfSecUserBlocking(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SEC_USER_BLOCKING ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_SEC_USER_BLOCKING ="sec_user_blocking.who";
	public ArxChecker checkWhoOfSecUserBlocking(String who)
	{
		
	 	checkStringLengthRange(who,4, 52,WHO_OF_SEC_USER_BLOCKING ); 		
		
		return this;
	}	 			

	public static final String  COMMENTS_OF_SEC_USER_BLOCKING ="sec_user_blocking.comments";
	public ArxChecker checkCommentsOfSecUserBlocking(String comments)
	{
		
	 	checkStringLengthRange(comments,7, 96,COMMENTS_OF_SEC_USER_BLOCKING ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_SEC_USER_BLOCKING ="sec_user_blocking.version";
	public ArxChecker checkVersionOfSecUserBlocking(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SEC_USER_BLOCKING ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_USER_APP ="user_app.id";
	public ArxChecker checkIdOfUserApp(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_USER_APP ="user_app.title";
	public ArxChecker checkTitleOfUserApp(String title)
	{
		
	 	checkStringLengthRange(title,1, 300,TITLE_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  SEC_USER_OF_USER_APP ="user_app.sec_user";
	public ArxChecker checkSecUserIdOfUserApp(String secUserId)
	{
		
	 	checkIdOfUserApp(secUserId ); 		
		
		return this;
	}	 			

	public static final String  APP_ICON_OF_USER_APP ="user_app.app_icon";
	public ArxChecker checkAppIconOfUserApp(String appIcon)
	{
		
	 	checkStringLengthRange(appIcon,2, 36,APP_ICON_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  FULL_ACCESS_OF_USER_APP ="user_app.full_access";
	public ArxChecker checkFullAccessOfUserApp(boolean fullAccess)
	{
		
	 	checkBooleanRange(fullAccess,0, true,FULL_ACCESS_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  PERMISSION_OF_USER_APP ="user_app.permission";
	public ArxChecker checkPermissionOfUserApp(String permission)
	{
		
	 	checkStringLengthRange(permission,2, 16,PERMISSION_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  OBJECT_TYPE_OF_USER_APP ="user_app.object_type";
	public ArxChecker checkObjectTypeOfUserApp(String objectType)
	{
		
	 	checkStringLengthRange(objectType,1, 100,OBJECT_TYPE_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  OBJECT_ID_OF_USER_APP ="user_app.object_id";
	public ArxChecker checkObjectIdOfUserApp(String objectId)
	{
		
	 	checkStringLengthRange(objectId,4, 40,OBJECT_ID_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  LOCATION_OF_USER_APP ="user_app.location";
	public ArxChecker checkLocationOfUserApp(String location)
	{
		
	 	checkStringLengthRange(location,4, 48,LOCATION_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_USER_APP ="user_app.version";
	public ArxChecker checkVersionOfUserApp(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_LIST_ACCESS ="list_access.id";
	public ArxChecker checkIdOfListAccess(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_LIST_ACCESS ="list_access.name";
	public ArxChecker checkNameOfListAccess(String name)
	{
		
	 	checkStringLengthRange(name,1, 200,NAME_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  INTERNAL_NAME_OF_LIST_ACCESS ="list_access.internal_name";
	public ArxChecker checkInternalNameOfListAccess(String internalName)
	{
		
	 	checkStringLengthRange(internalName,1, 200,INTERNAL_NAME_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  READ_PERMISSION_OF_LIST_ACCESS ="list_access.read_permission";
	public ArxChecker checkReadPermissionOfListAccess(boolean readPermission)
	{
		
	 	checkBooleanRange(readPermission,0, true,READ_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  CREATE_PERMISSION_OF_LIST_ACCESS ="list_access.create_permission";
	public ArxChecker checkCreatePermissionOfListAccess(boolean createPermission)
	{
		
	 	checkBooleanRange(createPermission,0, true,CREATE_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  DELETE_PERMISSION_OF_LIST_ACCESS ="list_access.delete_permission";
	public ArxChecker checkDeletePermissionOfListAccess(boolean deletePermission)
	{
		
	 	checkBooleanRange(deletePermission,0, true,DELETE_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  UPDATE_PERMISSION_OF_LIST_ACCESS ="list_access.update_permission";
	public ArxChecker checkUpdatePermissionOfListAccess(boolean updatePermission)
	{
		
	 	checkBooleanRange(updatePermission,0, true,UPDATE_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  EXECUTION_PERMISSION_OF_LIST_ACCESS ="list_access.execution_permission";
	public ArxChecker checkExecutionPermissionOfListAccess(boolean executionPermission)
	{
		
	 	checkBooleanRange(executionPermission,0, true,EXECUTION_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  APP_OF_LIST_ACCESS ="list_access.app";
	public ArxChecker checkAppIdOfListAccess(String appId)
	{
		
	 	checkIdOfListAccess(appId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_LIST_ACCESS ="list_access.version";
	public ArxChecker checkVersionOfListAccess(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_OBJECT_ACCESS ="object_access.id";
	public ArxChecker checkIdOfObjectAccess(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_OBJECT_ACCESS ="object_access.name";
	public ArxChecker checkNameOfObjectAccess(String name)
	{
		
	 	checkStringLengthRange(name,2, 28,NAME_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  OBJECT_TYPE_OF_OBJECT_ACCESS ="object_access.object_type";
	public ArxChecker checkObjectTypeOfObjectAccess(String objectType)
	{
		
	 	checkStringLengthRange(objectType,5, 112,OBJECT_TYPE_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST1_OF_OBJECT_ACCESS ="object_access.list1";
	public ArxChecker checkList1OfObjectAccess(String list1)
	{
		
	 	checkStringLengthRange(list1,5, 80,LIST1_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST2_OF_OBJECT_ACCESS ="object_access.list2";
	public ArxChecker checkList2OfObjectAccess(String list2)
	{
		
	 	checkStringLengthRange(list2,5, 80,LIST2_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST3_OF_OBJECT_ACCESS ="object_access.list3";
	public ArxChecker checkList3OfObjectAccess(String list3)
	{
		
	 	checkStringLengthRange(list3,5, 80,LIST3_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST4_OF_OBJECT_ACCESS ="object_access.list4";
	public ArxChecker checkList4OfObjectAccess(String list4)
	{
		
	 	checkStringLengthRange(list4,5, 80,LIST4_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST5_OF_OBJECT_ACCESS ="object_access.list5";
	public ArxChecker checkList5OfObjectAccess(String list5)
	{
		
	 	checkStringLengthRange(list5,5, 80,LIST5_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST6_OF_OBJECT_ACCESS ="object_access.list6";
	public ArxChecker checkList6OfObjectAccess(String list6)
	{
		
	 	checkStringLengthRange(list6,5, 80,LIST6_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST7_OF_OBJECT_ACCESS ="object_access.list7";
	public ArxChecker checkList7OfObjectAccess(String list7)
	{
		
	 	checkStringLengthRange(list7,5, 80,LIST7_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST8_OF_OBJECT_ACCESS ="object_access.list8";
	public ArxChecker checkList8OfObjectAccess(String list8)
	{
		
	 	checkStringLengthRange(list8,5, 80,LIST8_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST9_OF_OBJECT_ACCESS ="object_access.list9";
	public ArxChecker checkList9OfObjectAccess(String list9)
	{
		
	 	checkStringLengthRange(list9,5, 80,LIST9_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  APP_OF_OBJECT_ACCESS ="object_access.app";
	public ArxChecker checkAppIdOfObjectAccess(String appId)
	{
		
	 	checkIdOfObjectAccess(appId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_OBJECT_ACCESS ="object_access.version";
	public ArxChecker checkVersionOfObjectAccess(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_LOGIN_HISTORY ="login_history.id";
	public ArxChecker checkIdOfLoginHistory(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	 			

	public static final String  FROM_IP_OF_LOGIN_HISTORY ="login_history.from_ip";
	public ArxChecker checkFromIpOfLoginHistory(String fromIp)
	{
		
	 	checkStringLengthRange(fromIp,5, 44,FROM_IP_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_LOGIN_HISTORY ="login_history.description";
	public ArxChecker checkDescriptionOfLoginHistory(String description)
	{
		
	 	checkStringLengthRange(description,2, 16,DESCRIPTION_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	 			

	public static final String  SEC_USER_OF_LOGIN_HISTORY ="login_history.sec_user";
	public ArxChecker checkSecUserIdOfLoginHistory(String secUserId)
	{
		
	 	checkIdOfLoginHistory(secUserId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_LOGIN_HISTORY ="login_history.version";
	public ArxChecker checkVersionOfLoginHistory(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_GENERIC_FORM ="generic_form.id";
	public ArxChecker checkIdOfGenericForm(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_GENERIC_FORM ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_GENERIC_FORM ="generic_form.title";
	public ArxChecker checkTitleOfGenericForm(String title)
	{
		
	 	checkStringLengthRange(title,2, 20,TITLE_OF_GENERIC_FORM ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_GENERIC_FORM ="generic_form.description";
	public ArxChecker checkDescriptionOfGenericForm(String description)
	{
		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_GENERIC_FORM ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_GENERIC_FORM ="generic_form.version";
	public ArxChecker checkVersionOfGenericForm(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GENERIC_FORM ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_FORM_MESSAGE ="form_message.id";
	public ArxChecker checkIdOfFormMessage(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_FORM_MESSAGE ="form_message.title";
	public ArxChecker checkTitleOfFormMessage(String title)
	{
		
	 	checkStringLengthRange(title,2, 24,TITLE_OF_FORM_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  FORM_OF_FORM_MESSAGE ="form_message.form";
	public ArxChecker checkFormIdOfFormMessage(String formId)
	{
		
	 	checkIdOfFormMessage(formId ); 		
		
		return this;
	}	 			

	public static final String  LEVEL_OF_FORM_MESSAGE ="form_message.level";
	public ArxChecker checkLevelOfFormMessage(String level)
	{
		
	 	checkStringLengthRange(level,2, 28,LEVEL_OF_FORM_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_FORM_MESSAGE ="form_message.version";
	public ArxChecker checkVersionOfFormMessage(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_FORM_FIELD_MESSAGE ="form_field_message.id";
	public ArxChecker checkIdOfFormFieldMessage(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_FORM_FIELD_MESSAGE ="form_field_message.title";
	public ArxChecker checkTitleOfFormFieldMessage(String title)
	{
		
	 	checkStringLengthRange(title,2, 16,TITLE_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  PARAMETER_NAME_OF_FORM_FIELD_MESSAGE ="form_field_message.parameter_name";
	public ArxChecker checkParameterNameOfFormFieldMessage(String parameterName)
	{
		
	 	checkStringLengthRange(parameterName,2, 16,PARAMETER_NAME_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  FORM_OF_FORM_FIELD_MESSAGE ="form_field_message.form";
	public ArxChecker checkFormIdOfFormFieldMessage(String formId)
	{
		
	 	checkIdOfFormFieldMessage(formId ); 		
		
		return this;
	}	 			

	public static final String  LEVEL_OF_FORM_FIELD_MESSAGE ="form_field_message.level";
	public ArxChecker checkLevelOfFormFieldMessage(String level)
	{
		
	 	checkStringLengthRange(level,2, 28,LEVEL_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_FORM_FIELD_MESSAGE ="form_field_message.version";
	public ArxChecker checkVersionOfFormFieldMessage(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_FORM_FIELD ="form_field.id";
	public ArxChecker checkIdOfFormField(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  LABEL_OF_FORM_FIELD ="form_field.label";
	public ArxChecker checkLabelOfFormField(String label)
	{
		
	 	checkStringLengthRange(label,1, 12,LABEL_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  LOCALE_KEY_OF_FORM_FIELD ="form_field.locale_key";
	public ArxChecker checkLocaleKeyOfFormField(String localeKey)
	{
		
	 	checkStringLengthRange(localeKey,1, 44,LOCALE_KEY_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  PARAMETER_NAME_OF_FORM_FIELD ="form_field.parameter_name";
	public ArxChecker checkParameterNameOfFormField(String parameterName)
	{
		
	 	checkStringLengthRange(parameterName,2, 16,PARAMETER_NAME_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  TYPE_OF_FORM_FIELD ="form_field.type";
	public ArxChecker checkTypeOfFormField(String type)
	{
		
	 	checkStringLengthRange(type,1, 36,TYPE_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  FORM_OF_FORM_FIELD ="form_field.form";
	public ArxChecker checkFormIdOfFormField(String formId)
	{
		
	 	checkIdOfFormField(formId ); 		
		
		return this;
	}	 			

	public static final String  PLACEHOLDER_OF_FORM_FIELD ="form_field.placeholder";
	public ArxChecker checkPlaceholderOfFormField(String placeholder)
	{
		
	 	checkStringLengthRange(placeholder,4, 48,PLACEHOLDER_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  DEFAULT_VALUE_OF_FORM_FIELD ="form_field.default_value";
	public ArxChecker checkDefaultValueOfFormField(String defaultValue)
	{
		
	 	checkStringLengthRange(defaultValue,1, 12,DEFAULT_VALUE_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_FORM_FIELD ="form_field.description";
	public ArxChecker checkDescriptionOfFormField(String description)
	{
		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  FIELD_GROUP_OF_FORM_FIELD ="form_field.field_group";
	public ArxChecker checkFieldGroupOfFormField(String fieldGroup)
	{
		
	 	checkStringLengthRange(fieldGroup,2, 16,FIELD_GROUP_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  MINIMUM_VALUE_OF_FORM_FIELD ="form_field.minimum_value";
	public ArxChecker checkMinimumValueOfFormField(String minimumValue)
	{
		
	 	checkStringLengthRange(minimumValue,4, 60,MINIMUM_VALUE_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  MAXIMUM_VALUE_OF_FORM_FIELD ="form_field.maximum_value";
	public ArxChecker checkMaximumValueOfFormField(String maximumValue)
	{
		
	 	checkStringLengthRange(maximumValue,5, 72,MAXIMUM_VALUE_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  REQUIRED_OF_FORM_FIELD ="form_field.required";
	public ArxChecker checkRequiredOfFormField(boolean required)
	{
		
	 	checkBooleanRange(required,0, true|false,REQUIRED_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  DISABLED_OF_FORM_FIELD ="form_field.disabled";
	public ArxChecker checkDisabledOfFormField(boolean disabled)
	{
		
	 	checkBooleanRange(disabled,0, true|false,DISABLED_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  CUSTOM_RENDERING_OF_FORM_FIELD ="form_field.custom_rendering";
	public ArxChecker checkCustomRenderingOfFormField(boolean customRendering)
	{
		
	 	checkBooleanRange(customRendering,0, false,CUSTOM_RENDERING_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  CANDIDATE_VALUES_OF_FORM_FIELD ="form_field.candidate_values";
	public ArxChecker checkCandidateValuesOfFormField(String candidateValues)
	{
		
	 	checkStringLengthRange(candidateValues,0, 12,CANDIDATE_VALUES_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  SUGGEST_VALUES_OF_FORM_FIELD ="form_field.suggest_values";
	public ArxChecker checkSuggestValuesOfFormField(String suggestValues)
	{
		
	 	checkStringLengthRange(suggestValues,0, 12,SUGGEST_VALUES_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_FORM_FIELD ="form_field.version";
	public ArxChecker checkVersionOfFormField(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_FORM_ACTION ="form_action.id";
	public ArxChecker checkIdOfFormAction(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_ACTION ); 		
		
		return this;
	}	 			

	public static final String  LABEL_OF_FORM_ACTION ="form_action.label";
	public ArxChecker checkLabelOfFormAction(String label)
	{
		
	 	checkStringLengthRange(label,1, 8,LABEL_OF_FORM_ACTION ); 		
		
		return this;
	}	 			

	public static final String  LOCALE_KEY_OF_FORM_ACTION ="form_action.locale_key";
	public ArxChecker checkLocaleKeyOfFormAction(String localeKey)
	{
		
	 	checkStringLengthRange(localeKey,2, 16,LOCALE_KEY_OF_FORM_ACTION ); 		
		
		return this;
	}	 			

	public static final String  ACTION_KEY_OF_FORM_ACTION ="form_action.action_key";
	public ArxChecker checkActionKeyOfFormAction(String actionKey)
	{
		
	 	checkStringLengthRange(actionKey,2, 24,ACTION_KEY_OF_FORM_ACTION ); 		
		
		return this;
	}	 			

	public static final String  LEVEL_OF_FORM_ACTION ="form_action.level";
	public ArxChecker checkLevelOfFormAction(String level)
	{
		
	 	checkStringLengthRange(level,3, 28,LEVEL_OF_FORM_ACTION ); 		
		
		return this;
	}	 			

	public static final String  URL_OF_FORM_ACTION ="form_action.url";
	public ArxChecker checkUrlOfFormAction(String url)
	{
		
	 	checkStringLengthRange(url,11, 168,URL_OF_FORM_ACTION ); 		
		
		return this;
	}	 			

	public static final String  FORM_OF_FORM_ACTION ="form_action.form";
	public ArxChecker checkFormIdOfFormAction(String formId)
	{
		
	 	checkIdOfFormAction(formId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_FORM_ACTION ="form_action.version";
	public ArxChecker checkVersionOfFormAction(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_ACTION ); 		
		
		return this;
	}	 			
	public void throwExceptionIfHasErrors(Class<? extends Exception> exceptionClazz) throws Exception {
		if(messageList.isEmpty()){
			return;
		}
		
		for(Message message: messageList){
			String subject = message.getSubject();
			String template = userContext.getLocaleKey(subject);
			if(template==null){
				//not found, it is fine to use hard coded value
				userContext.log("Check Result "+message.getBody());
				continue;
			}
			MessageFormat mf = new MessageFormat(template);
			
			String labelKey = message.getFirstParam();
			String newLabel = userContext.getLocaleKey(labelKey);
			message.setFirstParam(newLabel);
			String newBody = mf.format(message.getParameters());
			message.setBody(newBody);
			userContext.log("Check Result "+message.getBody());
			
		}
		
		
		Class [] classes = {List.class};
		throw  exceptionClazz.getDeclaredConstructor(classes).newInstance(messageList);

		
	}

    
}












