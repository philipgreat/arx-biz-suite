package com.doublechaintech.arx.targetobject;
import com.doublechaintech.arx.BaseForm;
import com.doublechaintech.arx.genericform.GenericForm;
import com.doublechaintech.arx.formfield.FormField;
import com.doublechaintech.arx.formaction.FormAction;
import com.doublechaintech.arx.formmessage.FormMessage;
import com.doublechaintech.arx.formfieldmessage.FormFieldMessage;



public class TargetObjectForm extends BaseForm {
	
	
	public TargetObjectForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public TargetObjectForm targetObjectIdField(String parameterName, String initValue){
		FormField field = idFromTargetObject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TargetObjectForm targetObjectIdField(String initValue){
		return targetObjectIdField("targetObjectId",initValue);
	}
	public TargetObjectForm targetObjectIdField(){
		return targetObjectIdField("targetObjectId","");
	}


	public TargetObjectForm nameField(String parameterName, String initValue){
		FormField field = nameFromTargetObject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TargetObjectForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public TargetObjectForm nameField(){
		return nameField("name","");
	}


	public TargetObjectForm longitudeField(String parameterName, String initValue){
		FormField field = longitudeFromTargetObject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TargetObjectForm longitudeField(String initValue){
		return longitudeField("longitude",initValue);
	}
	public TargetObjectForm longitudeField(){
		return longitudeField("longitude","");
	}


	public TargetObjectForm latitudeField(String parameterName, String initValue){
		FormField field = latitudeFromTargetObject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TargetObjectForm latitudeField(String initValue){
		return latitudeField("latitude",initValue);
	}
	public TargetObjectForm latitudeField(){
		return latitudeField("latitude","");
	}


	public TargetObjectForm heightField(String parameterName, String initValue){
		FormField field = heightFromTargetObject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TargetObjectForm heightField(String initValue){
		return heightField("height",initValue);
	}
	public TargetObjectForm heightField(){
		return heightField("height","");
	}


	public TargetObjectForm textContentField(String parameterName, String initValue){
		FormField field = textContentFromTargetObject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TargetObjectForm textContentField(String initValue){
		return textContentField("textContent",initValue);
	}
	public TargetObjectForm textContentField(){
		return textContentField("textContent","");
	}


	public TargetObjectForm imagePathField(String parameterName, String initValue){
		FormField field = imagePathFromTargetObject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TargetObjectForm imagePathField(String initValue){
		return imagePathField("imagePath",initValue);
	}
	public TargetObjectForm imagePathField(){
		return imagePathField("imagePath","");
	}


	public TargetObjectForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromTargetObject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TargetObjectForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public TargetObjectForm platformIdField(){
		return platformIdField("platformId","");
	}


	public TargetObjectForm createTimeField(String parameterName, String initValue){
		FormField field = createTimeFromTargetObject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TargetObjectForm createTimeField(String initValue){
		return createTimeField("createTime",initValue);
	}
	public TargetObjectForm createTimeField(){
		return createTimeField("createTime","");
	}

	
	


	public TargetObjectForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TargetObjectForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public TargetObjectForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public TargetObjectForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TargetObjectForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public TargetObjectForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}


	public TargetObjectForm descriptionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  descriptionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TargetObjectForm descriptionFieldOfPlatform(String initValue){
		return descriptionFieldOfPlatform("description",initValue);
	}
	public TargetObjectForm descriptionFieldOfPlatform(){
		return descriptionFieldOfPlatform("description","");
	}

	


	

	
 	public TargetObjectForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/targetObjectId/");
		this.addFormAction(action);
		return this;
	}

 

	public TargetObjectForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


