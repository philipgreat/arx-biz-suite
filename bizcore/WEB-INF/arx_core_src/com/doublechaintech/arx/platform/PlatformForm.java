package com.doublechaintech.arx.platform;
import com.doublechaintech.arx.BaseForm;
import com.doublechaintech.arx.genericform.GenericForm;
import com.doublechaintech.arx.formfield.FormField;
import com.doublechaintech.arx.formaction.FormAction;
import com.doublechaintech.arx.formmessage.FormMessage;
import com.doublechaintech.arx.formfieldmessage.FormFieldMessage;



public class PlatformForm extends BaseForm {
	
	
	public PlatformForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public PlatformForm platformIdField(String parameterName, String initValue){
		FormField field = idFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public PlatformForm platformIdField(){
		return platformIdField("platformId","");
	}


	public PlatformForm nameField(String parameterName, String initValue){
		FormField field = nameFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public PlatformForm nameField(){
		return nameField("name","");
	}


	public PlatformForm descriptionField(String parameterName, String initValue){
		FormField field = descriptionFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm descriptionField(String initValue){
		return descriptionField("description",initValue);
	}
	public PlatformForm descriptionField(){
		return descriptionField("description","");
	}

	
	

	



	public PlatformForm targetObjectIdFieldForTargetObject(String parameterName, String initValue){
		FormField field =  idFromTargetObject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm targetObjectIdFieldForTargetObject(String initValue){
		return targetObjectIdFieldForTargetObject("targetObjectId",initValue);
	}
	public PlatformForm targetObjectIdFieldForTargetObject(){
		return targetObjectIdFieldForTargetObject("targetObjectId","");
	}


	public PlatformForm nameFieldForTargetObject(String parameterName, String initValue){
		FormField field =  nameFromTargetObject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForTargetObject(String initValue){
		return nameFieldForTargetObject("name",initValue);
	}
	public PlatformForm nameFieldForTargetObject(){
		return nameFieldForTargetObject("name","");
	}


	public PlatformForm longitudeFieldForTargetObject(String parameterName, String initValue){
		FormField field =  longitudeFromTargetObject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm longitudeFieldForTargetObject(String initValue){
		return longitudeFieldForTargetObject("longitude",initValue);
	}
	public PlatformForm longitudeFieldForTargetObject(){
		return longitudeFieldForTargetObject("longitude","");
	}


	public PlatformForm latitudeFieldForTargetObject(String parameterName, String initValue){
		FormField field =  latitudeFromTargetObject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm latitudeFieldForTargetObject(String initValue){
		return latitudeFieldForTargetObject("latitude",initValue);
	}
	public PlatformForm latitudeFieldForTargetObject(){
		return latitudeFieldForTargetObject("latitude","");
	}


	public PlatformForm heightFieldForTargetObject(String parameterName, String initValue){
		FormField field =  heightFromTargetObject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm heightFieldForTargetObject(String initValue){
		return heightFieldForTargetObject("height",initValue);
	}
	public PlatformForm heightFieldForTargetObject(){
		return heightFieldForTargetObject("height","");
	}


	public PlatformForm textContentFieldForTargetObject(String parameterName, String initValue){
		FormField field =  textContentFromTargetObject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm textContentFieldForTargetObject(String initValue){
		return textContentFieldForTargetObject("textContent",initValue);
	}
	public PlatformForm textContentFieldForTargetObject(){
		return textContentFieldForTargetObject("textContent","");
	}


	public PlatformForm imagePathFieldForTargetObject(String parameterName, String initValue){
		FormField field =  imagePathFromTargetObject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm imagePathFieldForTargetObject(String initValue){
		return imagePathFieldForTargetObject("imagePath",initValue);
	}
	public PlatformForm imagePathFieldForTargetObject(){
		return imagePathFieldForTargetObject("imagePath","");
	}


	public PlatformForm platformIdFieldForTargetObject(String parameterName, String initValue){
		FormField field =  platformIdFromTargetObject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForTargetObject(String initValue){
		return platformIdFieldForTargetObject("platformId",initValue);
	}
	public PlatformForm platformIdFieldForTargetObject(){
		return platformIdFieldForTargetObject("platformId","");
	}


	public PlatformForm createTimeFieldForTargetObject(String parameterName, String initValue){
		FormField field =  createTimeFromTargetObject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm createTimeFieldForTargetObject(String initValue){
		return createTimeFieldForTargetObject("createTime",initValue);
	}
	public PlatformForm createTimeFieldForTargetObject(){
		return createTimeFieldForTargetObject("createTime","");
	}


	public PlatformForm viewDeviceIdFieldForViewDevice(String parameterName, String initValue){
		FormField field =  idFromViewDevice(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm viewDeviceIdFieldForViewDevice(String initValue){
		return viewDeviceIdFieldForViewDevice("viewDeviceId",initValue);
	}
	public PlatformForm viewDeviceIdFieldForViewDevice(){
		return viewDeviceIdFieldForViewDevice("viewDeviceId","");
	}


	public PlatformForm nameFieldForViewDevice(String parameterName, String initValue){
		FormField field =  nameFromViewDevice(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForViewDevice(String initValue){
		return nameFieldForViewDevice("name",initValue);
	}
	public PlatformForm nameFieldForViewDevice(){
		return nameFieldForViewDevice("name","");
	}


	public PlatformForm longitudeFieldForViewDevice(String parameterName, String initValue){
		FormField field =  longitudeFromViewDevice(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm longitudeFieldForViewDevice(String initValue){
		return longitudeFieldForViewDevice("longitude",initValue);
	}
	public PlatformForm longitudeFieldForViewDevice(){
		return longitudeFieldForViewDevice("longitude","");
	}


	public PlatformForm latitudeFieldForViewDevice(String parameterName, String initValue){
		FormField field =  latitudeFromViewDevice(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm latitudeFieldForViewDevice(String initValue){
		return latitudeFieldForViewDevice("latitude",initValue);
	}
	public PlatformForm latitudeFieldForViewDevice(){
		return latitudeFieldForViewDevice("latitude","");
	}


	public PlatformForm heightFieldForViewDevice(String parameterName, String initValue){
		FormField field =  heightFromViewDevice(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm heightFieldForViewDevice(String initValue){
		return heightFieldForViewDevice("height",initValue);
	}
	public PlatformForm heightFieldForViewDevice(){
		return heightFieldForViewDevice("height","");
	}


	public PlatformForm platformIdFieldForViewDevice(String parameterName, String initValue){
		FormField field =  platformIdFromViewDevice(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForViewDevice(String initValue){
		return platformIdFieldForViewDevice("platformId",initValue);
	}
	public PlatformForm platformIdFieldForViewDevice(){
		return platformIdFieldForViewDevice("platformId","");
	}


	public PlatformForm createTimeFieldForViewDevice(String parameterName, String initValue){
		FormField field =  createTimeFromViewDevice(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm createTimeFieldForViewDevice(String initValue){
		return createTimeFieldForViewDevice("createTime",initValue);
	}
	public PlatformForm createTimeFieldForViewDevice(){
		return createTimeFieldForViewDevice("createTime","");
	}

	



	public PlatformForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


