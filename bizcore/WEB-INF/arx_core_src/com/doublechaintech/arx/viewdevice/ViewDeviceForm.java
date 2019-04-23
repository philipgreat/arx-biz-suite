package com.doublechaintech.arx.viewdevice;
import com.doublechaintech.arx.BaseForm;
import com.doublechaintech.arx.genericform.GenericForm;
import com.doublechaintech.arx.formfield.FormField;
import com.doublechaintech.arx.formaction.FormAction;
import com.doublechaintech.arx.formmessage.FormMessage;
import com.doublechaintech.arx.formfieldmessage.FormFieldMessage;



public class ViewDeviceForm extends BaseForm {
	
	
	public ViewDeviceForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ViewDeviceForm viewDeviceIdField(String parameterName, String initValue){
		FormField field = idFromViewDevice(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ViewDeviceForm viewDeviceIdField(String initValue){
		return viewDeviceIdField("viewDeviceId",initValue);
	}
	public ViewDeviceForm viewDeviceIdField(){
		return viewDeviceIdField("viewDeviceId","");
	}


	public ViewDeviceForm nameField(String parameterName, String initValue){
		FormField field = nameFromViewDevice(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ViewDeviceForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public ViewDeviceForm nameField(){
		return nameField("name","");
	}


	public ViewDeviceForm longitudeField(String parameterName, String initValue){
		FormField field = longitudeFromViewDevice(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ViewDeviceForm longitudeField(String initValue){
		return longitudeField("longitude",initValue);
	}
	public ViewDeviceForm longitudeField(){
		return longitudeField("longitude","");
	}


	public ViewDeviceForm latitudeField(String parameterName, String initValue){
		FormField field = latitudeFromViewDevice(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ViewDeviceForm latitudeField(String initValue){
		return latitudeField("latitude",initValue);
	}
	public ViewDeviceForm latitudeField(){
		return latitudeField("latitude","");
	}


	public ViewDeviceForm heightField(String parameterName, String initValue){
		FormField field = heightFromViewDevice(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ViewDeviceForm heightField(String initValue){
		return heightField("height",initValue);
	}
	public ViewDeviceForm heightField(){
		return heightField("height","");
	}


	public ViewDeviceForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromViewDevice(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ViewDeviceForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public ViewDeviceForm platformIdField(){
		return platformIdField("platformId","");
	}

	
	


	public ViewDeviceForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ViewDeviceForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public ViewDeviceForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public ViewDeviceForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ViewDeviceForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public ViewDeviceForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}


	public ViewDeviceForm descriptionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  descriptionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ViewDeviceForm descriptionFieldOfPlatform(String initValue){
		return descriptionFieldOfPlatform("description",initValue);
	}
	public ViewDeviceForm descriptionFieldOfPlatform(){
		return descriptionFieldOfPlatform("description","");
	}

	


	

	
 	public ViewDeviceForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/viewDeviceId/");
		this.addFormAction(action);
		return this;
	}

 

	public ViewDeviceForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


