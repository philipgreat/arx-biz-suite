
package com.doublechaintech.arx.formfieldmessage;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.arx.BaseEntity;


import com.doublechaintech.arx.Message;
import com.doublechaintech.arx.SmartList;
import com.doublechaintech.arx.MultipleAccessKey;

import com.doublechaintech.arx.ArxUserContext;
//import com.doublechaintech.arx.BaseManagerImpl;
import com.doublechaintech.arx.ArxCheckerManager;
import com.doublechaintech.arx.CustomArxCheckerManager;

import com.doublechaintech.arx.genericform.GenericForm;

import com.doublechaintech.arx.genericform.CandidateGenericForm;







public class FormFieldMessageManagerImpl extends CustomArxCheckerManager implements FormFieldMessageManager {
	
	private static final String SERVICE_TYPE = "FormFieldMessage";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws FormFieldMessageManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new FormFieldMessageManagerException(message);

	}
	
	

 	protected FormFieldMessage saveFormFieldMessage(ArxUserContext userContext, FormFieldMessage formFieldMessage, String [] tokensExpr) throws Exception{	
 		//return getFormFieldMessageDAO().save(formFieldMessage, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveFormFieldMessage(userContext, formFieldMessage, tokens);
 	}
 	
 	protected FormFieldMessage saveFormFieldMessageDetail(ArxUserContext userContext, FormFieldMessage formFieldMessage) throws Exception{	

 		
 		return saveFormFieldMessage(userContext, formFieldMessage, allTokens());
 	}
 	
 	public FormFieldMessage loadFormFieldMessage(ArxUserContext userContext, String formFieldMessageId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfFormFieldMessage(formFieldMessageId);
		userContext.getChecker().throwExceptionIfHasErrors( FormFieldMessageManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		FormFieldMessage formFieldMessage = loadFormFieldMessage( userContext, formFieldMessageId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,formFieldMessage, tokens);
 	}
 	
 	
 	 public FormFieldMessage searchFormFieldMessage(ArxUserContext userContext, String formFieldMessageId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfFormFieldMessage(formFieldMessageId);
		userContext.getChecker().throwExceptionIfHasErrors( FormFieldMessageManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		FormFieldMessage formFieldMessage = loadFormFieldMessage( userContext, formFieldMessageId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,formFieldMessage, tokens);
 	}
 	
 	

 	protected FormFieldMessage present(ArxUserContext userContext, FormFieldMessage formFieldMessage, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,formFieldMessage,tokens);
		
		
		FormFieldMessage  formFieldMessageToPresent = userContext.getDAOGroup().getFormFieldMessageDAO().present(formFieldMessage, tokens);
		
		List<BaseEntity> entityListToNaming = formFieldMessageToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getFormFieldMessageDAO().alias(entityListToNaming);
		
		return  formFieldMessageToPresent;
		
		
	}
 
 	
 	
 	public FormFieldMessage loadFormFieldMessageDetail(ArxUserContext userContext, String formFieldMessageId) throws Exception{	
 		FormFieldMessage formFieldMessage = loadFormFieldMessage( userContext, formFieldMessageId, allTokens());
 		return present(userContext,formFieldMessage, allTokens());
		
 	}
 	
 	public Object view(ArxUserContext userContext, String formFieldMessageId) throws Exception{	
 		FormFieldMessage formFieldMessage = loadFormFieldMessage( userContext, formFieldMessageId, viewTokens());
 		return present(userContext,formFieldMessage, allTokens());
		
 	}
 	protected FormFieldMessage saveFormFieldMessage(ArxUserContext userContext, FormFieldMessage formFieldMessage, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getFormFieldMessageDAO().save(formFieldMessage, tokens);
 	}
 	protected FormFieldMessage loadFormFieldMessage(ArxUserContext userContext, String formFieldMessageId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfFormFieldMessage(formFieldMessageId);
		userContext.getChecker().throwExceptionIfHasErrors( FormFieldMessageManagerException.class);

 
 		return userContext.getDAOGroup().getFormFieldMessageDAO().load(formFieldMessageId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(ArxUserContext userContext, FormFieldMessage formFieldMessage, Map<String, Object> tokens){
		super.addActions(userContext, formFieldMessage, tokens);
		
		addAction(userContext, formFieldMessage, tokens,"@create","createFormFieldMessage","createFormFieldMessage/","main","primary");
		addAction(userContext, formFieldMessage, tokens,"@update","updateFormFieldMessage","updateFormFieldMessage/"+formFieldMessage.getId()+"/","main","primary");
		addAction(userContext, formFieldMessage, tokens,"@copy","cloneFormFieldMessage","cloneFormFieldMessage/"+formFieldMessage.getId()+"/","main","primary");
		
		addAction(userContext, formFieldMessage, tokens,"form_field_message.transfer_to_form","transferToAnotherForm","transferToAnotherForm/"+formFieldMessage.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(ArxUserContext userContext, FormFieldMessage formFieldMessage, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public FormFieldMessage createFormFieldMessage(ArxUserContext userContext,String title, String parameterName, String formId, String level) throws Exception
	{
		
		

		

		userContext.getChecker().checkTitleOfFormFieldMessage(title);
		userContext.getChecker().checkParameterNameOfFormFieldMessage(parameterName);
		userContext.getChecker().checkLevelOfFormFieldMessage(level);
	
		userContext.getChecker().throwExceptionIfHasErrors(FormFieldMessageManagerException.class);


		FormFieldMessage formFieldMessage=createNewFormFieldMessage();	

		formFieldMessage.setTitle(title);
		formFieldMessage.setParameterName(parameterName);
			
		GenericForm form = loadGenericForm(userContext, formId,emptyOptions());
		formFieldMessage.setForm(form);
		
		
		formFieldMessage.setLevel(level);

		formFieldMessage = saveFormFieldMessage(userContext, formFieldMessage, emptyOptions());
		
		onNewInstanceCreated(userContext, formFieldMessage);
		return formFieldMessage;

		
	}
	protected FormFieldMessage createNewFormFieldMessage() 
	{
		
		return new FormFieldMessage();		
	}
	
	protected void checkParamsForUpdatingFormFieldMessage(ArxUserContext userContext,String formFieldMessageId, int formFieldMessageVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfFormFieldMessage(formFieldMessageId);
		userContext.getChecker().checkVersionOfFormFieldMessage( formFieldMessageVersion);
		

		if(FormFieldMessage.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfFormFieldMessage(parseString(newValueExpr));
		}
		if(FormFieldMessage.PARAMETER_NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkParameterNameOfFormFieldMessage(parseString(newValueExpr));
		}		

		
		if(FormFieldMessage.LEVEL_PROPERTY.equals(property)){
			userContext.getChecker().checkLevelOfFormFieldMessage(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(FormFieldMessageManagerException.class);
	
		
	}
	
	
	
	public FormFieldMessage clone(ArxUserContext userContext, String fromFormFieldMessageId) throws Exception{
		
		return userContext.getDAOGroup().getFormFieldMessageDAO().clone(fromFormFieldMessageId, this.allTokens());
	}
	
	public FormFieldMessage internalSaveFormFieldMessage(ArxUserContext userContext, FormFieldMessage formFieldMessage) throws Exception 
	{
		return internalSaveFormFieldMessage(userContext, formFieldMessage, allTokens());

	}
	public FormFieldMessage internalSaveFormFieldMessage(ArxUserContext userContext, FormFieldMessage formFieldMessage, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingFormFieldMessage(userContext, formFieldMessageId, formFieldMessageVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(formFieldMessage){ 
			//will be good when the formFieldMessage loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FormFieldMessage.
			
			
			formFieldMessage = saveFormFieldMessage(userContext, formFieldMessage, options);
			return formFieldMessage;
			
		}

	}
	
	public FormFieldMessage updateFormFieldMessage(ArxUserContext userContext,String formFieldMessageId, int formFieldMessageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingFormFieldMessage(userContext, formFieldMessageId, formFieldMessageVersion, property, newValueExpr, tokensExpr);
		
		
		
		FormFieldMessage formFieldMessage = loadFormFieldMessage(userContext, formFieldMessageId, allTokens());
		if(formFieldMessage.getVersion() != formFieldMessageVersion){
			String message = "The target version("+formFieldMessage.getVersion()+") is not equals to version("+formFieldMessageVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(formFieldMessage){ 
			//will be good when the formFieldMessage loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FormFieldMessage.
			
			formFieldMessage.changeProperty(property, newValueExpr);
			formFieldMessage = saveFormFieldMessage(userContext, formFieldMessage, tokens().done());
			return present(userContext,formFieldMessage, mergedAllTokens(tokensExpr));
			//return saveFormFieldMessage(userContext, formFieldMessage, tokens().done());
		}

	}
	
	public FormFieldMessage updateFormFieldMessageProperty(ArxUserContext userContext,String formFieldMessageId, int formFieldMessageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingFormFieldMessage(userContext, formFieldMessageId, formFieldMessageVersion, property, newValueExpr, tokensExpr);
		
		FormFieldMessage formFieldMessage = loadFormFieldMessage(userContext, formFieldMessageId, allTokens());
		if(formFieldMessage.getVersion() != formFieldMessageVersion){
			String message = "The target version("+formFieldMessage.getVersion()+") is not equals to version("+formFieldMessageVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(formFieldMessage){ 
			//will be good when the formFieldMessage loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FormFieldMessage.
			
			formFieldMessage.changeProperty(property, newValueExpr);
			
			formFieldMessage = saveFormFieldMessage(userContext, formFieldMessage, tokens().done());
			return present(userContext,formFieldMessage, mergedAllTokens(tokensExpr));
			//return saveFormFieldMessage(userContext, formFieldMessage, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected FormFieldMessageTokens tokens(){
		return FormFieldMessageTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return FormFieldMessageTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return FormFieldMessageTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherForm(ArxUserContext userContext, String formFieldMessageId, String anotherFormId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfFormFieldMessage(formFieldMessageId);
 		userContext.getChecker().checkIdOfGenericForm(anotherFormId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(FormFieldMessageManagerException.class);
 		
 	}
 	public FormFieldMessage transferToAnotherForm(ArxUserContext userContext, String formFieldMessageId, String anotherFormId) throws Exception
 	{
 		checkParamsForTransferingAnotherForm(userContext, formFieldMessageId,anotherFormId);
 
		FormFieldMessage formFieldMessage = loadFormFieldMessage(userContext, formFieldMessageId, allTokens());	
		synchronized(formFieldMessage){
			//will be good when the formFieldMessage loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			GenericForm form = loadGenericForm(userContext, anotherFormId, emptyOptions());		
			formFieldMessage.updateForm(form);		
			formFieldMessage = saveFormFieldMessage(userContext, formFieldMessage, emptyOptions());
			
			return present(userContext,formFieldMessage, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateGenericForm requestCandidateForm(ArxUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateGenericForm result = new CandidateGenericForm();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("title");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<GenericForm> candidateList = userContext.getDAOGroup().getGenericFormDAO().requestCandidateGenericFormForFormFieldMessage(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected GenericForm loadGenericForm(ArxUserContext userContext, String newFormId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getGenericFormDAO().load(newFormId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(ArxUserContext userContext, String formFieldMessageId, int formFieldMessageVersion) throws Exception {
		//deleteInternal(userContext, formFieldMessageId, formFieldMessageVersion);		
	}
	protected void deleteInternal(ArxUserContext userContext,
			String formFieldMessageId, int formFieldMessageVersion) throws Exception{
			
		userContext.getDAOGroup().getFormFieldMessageDAO().delete(formFieldMessageId, formFieldMessageVersion);
	}
	
	public FormFieldMessage forgetByAll(ArxUserContext userContext, String formFieldMessageId, int formFieldMessageVersion) throws Exception {
		return forgetByAllInternal(userContext, formFieldMessageId, formFieldMessageVersion);		
	}
	protected FormFieldMessage forgetByAllInternal(ArxUserContext userContext,
			String formFieldMessageId, int formFieldMessageVersion) throws Exception{
			
		return userContext.getDAOGroup().getFormFieldMessageDAO().disconnectFromAll(formFieldMessageId, formFieldMessageVersion);
	}
	

	
	public int deleteAll(ArxUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new FormFieldMessageManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(ArxUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getFormFieldMessageDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(ArxUserContext userContext, FormFieldMessage newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


