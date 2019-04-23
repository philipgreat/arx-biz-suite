
package com.doublechaintech.arx.targetobject;

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









public class TargetObjectManagerImpl extends CustomArxCheckerManager implements TargetObjectManager {
	
	private static final String SERVICE_TYPE = "TargetObject";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws TargetObjectManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new TargetObjectManagerException(message);

	}
	
	

 	protected TargetObject saveTargetObject(ArxUserContext userContext, TargetObject targetObject, String [] tokensExpr) throws Exception{	
 		//return getTargetObjectDAO().save(targetObject, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveTargetObject(userContext, targetObject, tokens);
 	}
 	
 	protected TargetObject saveTargetObjectDetail(ArxUserContext userContext, TargetObject targetObject) throws Exception{	

 		
 		return saveTargetObject(userContext, targetObject, allTokens());
 	}
 	
 	public TargetObject loadTargetObject(ArxUserContext userContext, String targetObjectId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTargetObject(targetObjectId);
		userContext.getChecker().throwExceptionIfHasErrors( TargetObjectManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		TargetObject targetObject = loadTargetObject( userContext, targetObjectId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,targetObject, tokens);
 	}
 	
 	
 	 public TargetObject searchTargetObject(ArxUserContext userContext, String targetObjectId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTargetObject(targetObjectId);
		userContext.getChecker().throwExceptionIfHasErrors( TargetObjectManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		TargetObject targetObject = loadTargetObject( userContext, targetObjectId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,targetObject, tokens);
 	}
 	
 	

 	protected TargetObject present(ArxUserContext userContext, TargetObject targetObject, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,targetObject,tokens);
		
		
		TargetObject  targetObjectToPresent = userContext.getDAOGroup().getTargetObjectDAO().present(targetObject, tokens);
		
		List<BaseEntity> entityListToNaming = targetObjectToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getTargetObjectDAO().alias(entityListToNaming);
		
		return  targetObjectToPresent;
		
		
	}
 
 	
 	
 	public TargetObject loadTargetObjectDetail(ArxUserContext userContext, String targetObjectId) throws Exception{	
 		TargetObject targetObject = loadTargetObject( userContext, targetObjectId, allTokens());
 		return present(userContext,targetObject, allTokens());
		
 	}
 	
 	public Object view(ArxUserContext userContext, String targetObjectId) throws Exception{	
 		TargetObject targetObject = loadTargetObject( userContext, targetObjectId, viewTokens());
 		return present(userContext,targetObject, allTokens());
		
 	}
 	protected TargetObject saveTargetObject(ArxUserContext userContext, TargetObject targetObject, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getTargetObjectDAO().save(targetObject, tokens);
 	}
 	protected TargetObject loadTargetObject(ArxUserContext userContext, String targetObjectId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfTargetObject(targetObjectId);
		userContext.getChecker().throwExceptionIfHasErrors( TargetObjectManagerException.class);

 
 		return userContext.getDAOGroup().getTargetObjectDAO().load(targetObjectId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(ArxUserContext userContext, TargetObject targetObject, Map<String, Object> tokens){
		super.addActions(userContext, targetObject, tokens);
		
		addAction(userContext, targetObject, tokens,"@create","createTargetObject","createTargetObject/","main","primary");
		addAction(userContext, targetObject, tokens,"@update","updateTargetObject","updateTargetObject/"+targetObject.getId()+"/","main","primary");
		addAction(userContext, targetObject, tokens,"@copy","cloneTargetObject","cloneTargetObject/"+targetObject.getId()+"/","main","primary");
		
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(ArxUserContext userContext, TargetObject targetObject, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public TargetObject createTargetObject(ArxUserContext userContext,String name, BigDecimal longitude, BigDecimal latitude, int height, String textContent, String imagePath) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfTargetObject(name);
		userContext.getChecker().checkLongitudeOfTargetObject(longitude);
		userContext.getChecker().checkLatitudeOfTargetObject(latitude);
		userContext.getChecker().checkHeightOfTargetObject(height);
		userContext.getChecker().checkTextContentOfTargetObject(textContent);
		userContext.getChecker().checkImagePathOfTargetObject(imagePath);
	
		userContext.getChecker().throwExceptionIfHasErrors(TargetObjectManagerException.class);


		TargetObject targetObject=createNewTargetObject();	

		targetObject.setName(name);
		targetObject.setLongitude(longitude);
		targetObject.setLatitude(latitude);
		targetObject.setHeight(height);
		targetObject.setTextContent(textContent);
		targetObject.setImagePath(imagePath);

		targetObject = saveTargetObject(userContext, targetObject, emptyOptions());
		
		onNewInstanceCreated(userContext, targetObject);
		return targetObject;

		
	}
	protected TargetObject createNewTargetObject() 
	{
		
		return new TargetObject();		
	}
	
	protected void checkParamsForUpdatingTargetObject(ArxUserContext userContext,String targetObjectId, int targetObjectVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfTargetObject(targetObjectId);
		userContext.getChecker().checkVersionOfTargetObject( targetObjectVersion);
		

		if(TargetObject.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTargetObject(parseString(newValueExpr));
		}
		if(TargetObject.LONGITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLongitudeOfTargetObject(parseBigDecimal(newValueExpr));
		}
		if(TargetObject.LATITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLatitudeOfTargetObject(parseBigDecimal(newValueExpr));
		}
		if(TargetObject.HEIGHT_PROPERTY.equals(property)){
			userContext.getChecker().checkHeightOfTargetObject(parseInt(newValueExpr));
		}
		if(TargetObject.TEXT_CONTENT_PROPERTY.equals(property)){
			userContext.getChecker().checkTextContentOfTargetObject(parseString(newValueExpr));
		}
		if(TargetObject.IMAGE_PATH_PROPERTY.equals(property)){
			userContext.getChecker().checkImagePathOfTargetObject(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(TargetObjectManagerException.class);
	
		
	}
	
	
	
	public TargetObject clone(ArxUserContext userContext, String fromTargetObjectId) throws Exception{
		
		return userContext.getDAOGroup().getTargetObjectDAO().clone(fromTargetObjectId, this.allTokens());
	}
	
	public TargetObject internalSaveTargetObject(ArxUserContext userContext, TargetObject targetObject) throws Exception 
	{
		return internalSaveTargetObject(userContext, targetObject, allTokens());

	}
	public TargetObject internalSaveTargetObject(ArxUserContext userContext, TargetObject targetObject, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingTargetObject(userContext, targetObjectId, targetObjectVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(targetObject){ 
			//will be good when the targetObject loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TargetObject.
			
			
			targetObject = saveTargetObject(userContext, targetObject, options);
			return targetObject;
			
		}

	}
	
	public TargetObject updateTargetObject(ArxUserContext userContext,String targetObjectId, int targetObjectVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTargetObject(userContext, targetObjectId, targetObjectVersion, property, newValueExpr, tokensExpr);
		
		
		
		TargetObject targetObject = loadTargetObject(userContext, targetObjectId, allTokens());
		if(targetObject.getVersion() != targetObjectVersion){
			String message = "The target version("+targetObject.getVersion()+") is not equals to version("+targetObjectVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(targetObject){ 
			//will be good when the targetObject loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TargetObject.
			
			targetObject.changeProperty(property, newValueExpr);
			targetObject = saveTargetObject(userContext, targetObject, tokens().done());
			return present(userContext,targetObject, mergedAllTokens(tokensExpr));
			//return saveTargetObject(userContext, targetObject, tokens().done());
		}

	}
	
	public TargetObject updateTargetObjectProperty(ArxUserContext userContext,String targetObjectId, int targetObjectVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTargetObject(userContext, targetObjectId, targetObjectVersion, property, newValueExpr, tokensExpr);
		
		TargetObject targetObject = loadTargetObject(userContext, targetObjectId, allTokens());
		if(targetObject.getVersion() != targetObjectVersion){
			String message = "The target version("+targetObject.getVersion()+") is not equals to version("+targetObjectVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(targetObject){ 
			//will be good when the targetObject loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TargetObject.
			
			targetObject.changeProperty(property, newValueExpr);
			
			targetObject = saveTargetObject(userContext, targetObject, tokens().done());
			return present(userContext,targetObject, mergedAllTokens(tokensExpr));
			//return saveTargetObject(userContext, targetObject, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected TargetObjectTokens tokens(){
		return TargetObjectTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TargetObjectTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TargetObjectTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(ArxUserContext userContext, String targetObjectId, int targetObjectVersion) throws Exception {
		//deleteInternal(userContext, targetObjectId, targetObjectVersion);		
	}
	protected void deleteInternal(ArxUserContext userContext,
			String targetObjectId, int targetObjectVersion) throws Exception{
			
		userContext.getDAOGroup().getTargetObjectDAO().delete(targetObjectId, targetObjectVersion);
	}
	
	public TargetObject forgetByAll(ArxUserContext userContext, String targetObjectId, int targetObjectVersion) throws Exception {
		return forgetByAllInternal(userContext, targetObjectId, targetObjectVersion);		
	}
	protected TargetObject forgetByAllInternal(ArxUserContext userContext,
			String targetObjectId, int targetObjectVersion) throws Exception{
			
		return userContext.getDAOGroup().getTargetObjectDAO().disconnectFromAll(targetObjectId, targetObjectVersion);
	}
	

	
	public int deleteAll(ArxUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TargetObjectManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(ArxUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getTargetObjectDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(ArxUserContext userContext, TargetObject newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


