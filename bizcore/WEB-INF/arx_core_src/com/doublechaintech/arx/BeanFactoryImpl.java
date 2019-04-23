
package com.doublechaintech.arx;
import java.util.Map;

import com.doublechaintech.arx.platform.Platform;
import com.doublechaintech.arx.targetobject.TargetObject;
import com.doublechaintech.arx.viewdevice.ViewDevice;
import com.doublechaintech.arx.userdomain.UserDomain;
import com.doublechaintech.arx.userwhitelist.UserWhiteList;
import com.doublechaintech.arx.secuser.SecUser;
import com.doublechaintech.arx.secuserblocking.SecUserBlocking;
import com.doublechaintech.arx.userapp.UserApp;
import com.doublechaintech.arx.listaccess.ListAccess;
import com.doublechaintech.arx.objectaccess.ObjectAccess;
import com.doublechaintech.arx.loginhistory.LoginHistory;
import com.doublechaintech.arx.genericform.GenericForm;
import com.doublechaintech.arx.formmessage.FormMessage;
import com.doublechaintech.arx.formfieldmessage.FormFieldMessage;
import com.doublechaintech.arx.formfield.FormField;
import com.doublechaintech.arx.formaction.FormAction;

public class BeanFactoryImpl{


	public Platform createPlatform(Map<String,Object> options){
		return new Platform();
	}


	public TargetObject createTargetObject(Map<String,Object> options){
		return new TargetObject();
	}


	public ViewDevice createViewDevice(Map<String,Object> options){
		return new ViewDevice();
	}


	public UserDomain createUserDomain(Map<String,Object> options){
		return new UserDomain();
	}


	public UserWhiteList createUserWhiteList(Map<String,Object> options){
		return new UserWhiteList();
	}


	public SecUser createSecUser(Map<String,Object> options){
		return new SecUser();
	}


	public SecUserBlocking createSecUserBlocking(Map<String,Object> options){
		return new SecUserBlocking();
	}


	public UserApp createUserApp(Map<String,Object> options){
		return new UserApp();
	}


	public ListAccess createListAccess(Map<String,Object> options){
		return new ListAccess();
	}


	public ObjectAccess createObjectAccess(Map<String,Object> options){
		return new ObjectAccess();
	}


	public LoginHistory createLoginHistory(Map<String,Object> options){
		return new LoginHistory();
	}


	public GenericForm createGenericForm(Map<String,Object> options){
		return new GenericForm();
	}


	public FormMessage createFormMessage(Map<String,Object> options){
		return new FormMessage();
	}


	public FormFieldMessage createFormFieldMessage(Map<String,Object> options){
		return new FormFieldMessage();
	}


	public FormField createFormField(Map<String,Object> options){
		return new FormField();
	}


	public FormAction createFormAction(Map<String,Object> options){
		return new FormAction();
	}





}










