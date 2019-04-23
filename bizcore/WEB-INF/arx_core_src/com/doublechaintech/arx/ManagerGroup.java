package com.doublechaintech.arx;


import com.doublechaintech.arx.platform.PlatformManager;

import com.doublechaintech.arx.targetobject.TargetObjectManager;

import com.doublechaintech.arx.viewdevice.ViewDeviceManager;

import com.doublechaintech.arx.userdomain.UserDomainManager;

import com.doublechaintech.arx.userwhitelist.UserWhiteListManager;

import com.doublechaintech.arx.secuser.SecUserManager;

import com.doublechaintech.arx.secuserblocking.SecUserBlockingManager;

import com.doublechaintech.arx.userapp.UserAppManager;

import com.doublechaintech.arx.listaccess.ListAccessManager;

import com.doublechaintech.arx.objectaccess.ObjectAccessManager;

import com.doublechaintech.arx.loginhistory.LoginHistoryManager;

import com.doublechaintech.arx.genericform.GenericFormManager;

import com.doublechaintech.arx.formmessage.FormMessageManager;

import com.doublechaintech.arx.formfieldmessage.FormFieldMessageManager;

import com.doublechaintech.arx.formfield.FormFieldManager;

import com.doublechaintech.arx.formaction.FormActionManager;


public class ManagerGroup {

	protected PlatformManager platformManager;

	protected TargetObjectManager targetObjectManager;

	protected ViewDeviceManager viewDeviceManager;

	protected UserDomainManager userDomainManager;

	protected UserWhiteListManager userWhiteListManager;

	protected SecUserManager secUserManager;

	protected SecUserBlockingManager secUserBlockingManager;

	protected UserAppManager userAppManager;

	protected ListAccessManager listAccessManager;

	protected ObjectAccessManager objectAccessManager;

	protected LoginHistoryManager loginHistoryManager;

	protected GenericFormManager genericFormManager;

	protected FormMessageManager formMessageManager;

	protected FormFieldMessageManager formFieldMessageManager;

	protected FormFieldManager formFieldManager;

	protected FormActionManager formActionManager;

	

	public PlatformManager getPlatformManager(){
		return this.platformManager;
	}
	public void setPlatformManager(PlatformManager manager){
		this.platformManager = manager;
	}


	public TargetObjectManager getTargetObjectManager(){
		return this.targetObjectManager;
	}
	public void setTargetObjectManager(TargetObjectManager manager){
		this.targetObjectManager = manager;
	}


	public ViewDeviceManager getViewDeviceManager(){
		return this.viewDeviceManager;
	}
	public void setViewDeviceManager(ViewDeviceManager manager){
		this.viewDeviceManager = manager;
	}


	public UserDomainManager getUserDomainManager(){
		return this.userDomainManager;
	}
	public void setUserDomainManager(UserDomainManager manager){
		this.userDomainManager = manager;
	}


	public UserWhiteListManager getUserWhiteListManager(){
		return this.userWhiteListManager;
	}
	public void setUserWhiteListManager(UserWhiteListManager manager){
		this.userWhiteListManager = manager;
	}


	public SecUserManager getSecUserManager(){
		return this.secUserManager;
	}
	public void setSecUserManager(SecUserManager manager){
		this.secUserManager = manager;
	}


	public SecUserBlockingManager getSecUserBlockingManager(){
		return this.secUserBlockingManager;
	}
	public void setSecUserBlockingManager(SecUserBlockingManager manager){
		this.secUserBlockingManager = manager;
	}


	public UserAppManager getUserAppManager(){
		return this.userAppManager;
	}
	public void setUserAppManager(UserAppManager manager){
		this.userAppManager = manager;
	}


	public ListAccessManager getListAccessManager(){
		return this.listAccessManager;
	}
	public void setListAccessManager(ListAccessManager manager){
		this.listAccessManager = manager;
	}


	public ObjectAccessManager getObjectAccessManager(){
		return this.objectAccessManager;
	}
	public void setObjectAccessManager(ObjectAccessManager manager){
		this.objectAccessManager = manager;
	}


	public LoginHistoryManager getLoginHistoryManager(){
		return this.loginHistoryManager;
	}
	public void setLoginHistoryManager(LoginHistoryManager manager){
		this.loginHistoryManager = manager;
	}


	public GenericFormManager getGenericFormManager(){
		return this.genericFormManager;
	}
	public void setGenericFormManager(GenericFormManager manager){
		this.genericFormManager = manager;
	}


	public FormMessageManager getFormMessageManager(){
		return this.formMessageManager;
	}
	public void setFormMessageManager(FormMessageManager manager){
		this.formMessageManager = manager;
	}


	public FormFieldMessageManager getFormFieldMessageManager(){
		return this.formFieldMessageManager;
	}
	public void setFormFieldMessageManager(FormFieldMessageManager manager){
		this.formFieldMessageManager = manager;
	}


	public FormFieldManager getFormFieldManager(){
		return this.formFieldManager;
	}
	public void setFormFieldManager(FormFieldManager manager){
		this.formFieldManager = manager;
	}


	public FormActionManager getFormActionManager(){
		return this.formActionManager;
	}
	public void setFormActionManager(FormActionManager manager){
		this.formActionManager = manager;
	}


}









