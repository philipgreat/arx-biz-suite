
package com.doublechaintech.arx.platform;

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

import com.doublechaintech.arx.viewdevice.ViewDevice;
import com.doublechaintech.arx.targetobject.TargetObject;


import com.doublechaintech.arx.platform.Platform;






public class PlatformManagerImpl extends CustomArxCheckerManager implements PlatformManager {
	
	private static final String SERVICE_TYPE = "Platform";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws PlatformManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new PlatformManagerException(message);

	}
	
	

 	protected Platform savePlatform(ArxUserContext userContext, Platform platform, String [] tokensExpr) throws Exception{	
 		//return getPlatformDAO().save(platform, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return savePlatform(userContext, platform, tokens);
 	}
 	
 	protected Platform savePlatformDetail(ArxUserContext userContext, Platform platform) throws Exception{	

 		
 		return savePlatform(userContext, platform, allTokens());
 	}
 	
 	public Platform loadPlatform(ArxUserContext userContext, String platformId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().throwExceptionIfHasErrors( PlatformManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Platform platform = loadPlatform( userContext, platformId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,platform, tokens);
 	}
 	
 	
 	 public Platform searchPlatform(ArxUserContext userContext, String platformId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().throwExceptionIfHasErrors( PlatformManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Platform platform = loadPlatform( userContext, platformId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,platform, tokens);
 	}
 	
 	

 	protected Platform present(ArxUserContext userContext, Platform platform, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,platform,tokens);
		
		
		Platform  platformToPresent = userContext.getDAOGroup().getPlatformDAO().present(platform, tokens);
		
		List<BaseEntity> entityListToNaming = platformToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getPlatformDAO().alias(entityListToNaming);
		
		return  platformToPresent;
		
		
	}
 
 	
 	
 	public Platform loadPlatformDetail(ArxUserContext userContext, String platformId) throws Exception{	
 		Platform platform = loadPlatform( userContext, platformId, allTokens());
 		return present(userContext,platform, allTokens());
		
 	}
 	
 	public Object view(ArxUserContext userContext, String platformId) throws Exception{	
 		Platform platform = loadPlatform( userContext, platformId, viewTokens());
 		return present(userContext,platform, allTokens());
		
 	}
 	protected Platform savePlatform(ArxUserContext userContext, Platform platform, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getPlatformDAO().save(platform, tokens);
 	}
 	protected Platform loadPlatform(ArxUserContext userContext, String platformId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().throwExceptionIfHasErrors( PlatformManagerException.class);

 
 		return userContext.getDAOGroup().getPlatformDAO().load(platformId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(ArxUserContext userContext, Platform platform, Map<String, Object> tokens){
		super.addActions(userContext, platform, tokens);
		
		addAction(userContext, platform, tokens,"@create","createPlatform","createPlatform/","main","primary");
		addAction(userContext, platform, tokens,"@update","updatePlatform","updatePlatform/"+platform.getId()+"/","main","primary");
		addAction(userContext, platform, tokens,"@copy","clonePlatform","clonePlatform/"+platform.getId()+"/","main","primary");
		
		addAction(userContext, platform, tokens,"platform.addTargetObject","addTargetObject","addTargetObject/"+platform.getId()+"/","targetObjectList","primary");
		addAction(userContext, platform, tokens,"platform.removeTargetObject","removeTargetObject","removeTargetObject/"+platform.getId()+"/","targetObjectList","primary");
		addAction(userContext, platform, tokens,"platform.updateTargetObject","updateTargetObject","updateTargetObject/"+platform.getId()+"/","targetObjectList","primary");
		addAction(userContext, platform, tokens,"platform.copyTargetObjectFrom","copyTargetObjectFrom","copyTargetObjectFrom/"+platform.getId()+"/","targetObjectList","primary");
		addAction(userContext, platform, tokens,"platform.addViewDevice","addViewDevice","addViewDevice/"+platform.getId()+"/","viewDeviceList","primary");
		addAction(userContext, platform, tokens,"platform.removeViewDevice","removeViewDevice","removeViewDevice/"+platform.getId()+"/","viewDeviceList","primary");
		addAction(userContext, platform, tokens,"platform.updateViewDevice","updateViewDevice","updateViewDevice/"+platform.getId()+"/","viewDeviceList","primary");
		addAction(userContext, platform, tokens,"platform.copyViewDeviceFrom","copyViewDeviceFrom","copyViewDeviceFrom/"+platform.getId()+"/","viewDeviceList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(ArxUserContext userContext, Platform platform, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Platform createPlatform(ArxUserContext userContext,String name, String description) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfPlatform(name);
		userContext.getChecker().checkDescriptionOfPlatform(description);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);


		Platform platform=createNewPlatform();	

		platform.setName(name);
		platform.setDescription(description);

		platform = savePlatform(userContext, platform, emptyOptions());
		
		onNewInstanceCreated(userContext, platform);
		return platform;

		
	}
	protected Platform createNewPlatform() 
	{
		
		return new Platform();		
	}
	
	protected void checkParamsForUpdatingPlatform(ArxUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkVersionOfPlatform( platformVersion);
		

		if(Platform.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfPlatform(parseString(newValueExpr));
		}
		if(Platform.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfPlatform(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
		
	}
	
	
	
	public Platform clone(ArxUserContext userContext, String fromPlatformId) throws Exception{
		
		return userContext.getDAOGroup().getPlatformDAO().clone(fromPlatformId, this.allTokens());
	}
	
	public Platform internalSavePlatform(ArxUserContext userContext, Platform platform) throws Exception 
	{
		return internalSavePlatform(userContext, platform, allTokens());

	}
	public Platform internalSavePlatform(ArxUserContext userContext, Platform platform, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingPlatform(userContext, platformId, platformVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(platform){ 
			//will be good when the platform loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Platform.
			
			
			platform = savePlatform(userContext, platform, options);
			return platform;
			
		}

	}
	
	public Platform updatePlatform(ArxUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingPlatform(userContext, platformId, platformVersion, property, newValueExpr, tokensExpr);
		
		
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		if(platform.getVersion() != platformVersion){
			String message = "The target version("+platform.getVersion()+") is not equals to version("+platformVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(platform){ 
			//will be good when the platform loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Platform.
			
			platform.changeProperty(property, newValueExpr);
			platform = savePlatform(userContext, platform, tokens().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
			//return savePlatform(userContext, platform, tokens().done());
		}

	}
	
	public Platform updatePlatformProperty(ArxUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingPlatform(userContext, platformId, platformVersion, property, newValueExpr, tokensExpr);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		if(platform.getVersion() != platformVersion){
			String message = "The target version("+platform.getVersion()+") is not equals to version("+platformVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(platform){ 
			//will be good when the platform loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Platform.
			
			platform.changeProperty(property, newValueExpr);
			
			platform = savePlatform(userContext, platform, tokens().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
			//return savePlatform(userContext, platform, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected PlatformTokens tokens(){
		return PlatformTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return PlatformTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortTargetObjectListWith("id","desc")
		.sortViewDeviceListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return PlatformTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(ArxUserContext userContext, String platformId, int platformVersion) throws Exception {
		//deleteInternal(userContext, platformId, platformVersion);		
	}
	protected void deleteInternal(ArxUserContext userContext,
			String platformId, int platformVersion) throws Exception{
			
		userContext.getDAOGroup().getPlatformDAO().delete(platformId, platformVersion);
	}
	
	public Platform forgetByAll(ArxUserContext userContext, String platformId, int platformVersion) throws Exception {
		return forgetByAllInternal(userContext, platformId, platformVersion);		
	}
	protected Platform forgetByAllInternal(ArxUserContext userContext,
			String platformId, int platformVersion) throws Exception{
			
		return userContext.getDAOGroup().getPlatformDAO().disconnectFromAll(platformId, platformVersion);
	}
	

	
	public int deleteAll(ArxUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new PlatformManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(ArxUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getPlatformDAO().deleteAll();
	}


	
	
	
	
	

	protected void checkParamsForAddingTargetObject(ArxUserContext userContext, String platformId, String name, BigDecimal longitude, BigDecimal latitude, int height, String textContent, String imagePath,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);

		
		userContext.getChecker().checkNameOfTargetObject(name);
		
		userContext.getChecker().checkLongitudeOfTargetObject(longitude);
		
		userContext.getChecker().checkLatitudeOfTargetObject(latitude);
		
		userContext.getChecker().checkHeightOfTargetObject(height);
		
		userContext.getChecker().checkTextContentOfTargetObject(textContent);
		
		userContext.getChecker().checkImagePathOfTargetObject(imagePath);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addTargetObject(ArxUserContext userContext, String platformId, String name, BigDecimal longitude, BigDecimal latitude, int height, String textContent, String imagePath, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTargetObject(userContext,platformId,name, longitude, latitude, height, textContent, imagePath,tokensExpr);
		
		TargetObject targetObject = createTargetObject(userContext,name, longitude, latitude, height, textContent, imagePath);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addTargetObject( targetObject );		
			platform = savePlatform(userContext, platform, tokens().withTargetObjectList().done());
			
			userContext.getManagerGroup().getTargetObjectManager().onNewInstanceCreated(userContext, targetObject);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTargetObjectProperties(ArxUserContext userContext, String platformId,String id,String name,BigDecimal longitude,BigDecimal latitude,int height,String textContent,String imagePath,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfTargetObject(id);
		
		userContext.getChecker().checkNameOfTargetObject( name);
		userContext.getChecker().checkLongitudeOfTargetObject( longitude);
		userContext.getChecker().checkLatitudeOfTargetObject( latitude);
		userContext.getChecker().checkHeightOfTargetObject( height);
		userContext.getChecker().checkTextContentOfTargetObject( textContent);
		userContext.getChecker().checkImagePathOfTargetObject( imagePath);

		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateTargetObjectProperties(ArxUserContext userContext, String platformId, String id,String name,BigDecimal longitude,BigDecimal latitude,int height,String textContent,String imagePath, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingTargetObjectProperties(userContext,platformId,id,name,longitude,latitude,height,textContent,imagePath,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTargetObjectListList()
				.searchTargetObjectListWith(TargetObject.ID_PROPERTY, "is", id).done();
		
		Platform platformToUpdate = loadPlatform(userContext, platformId, options);
		
		if(platformToUpdate.getTargetObjectList().isEmpty()){
			throw new PlatformManagerException("TargetObject is NOT FOUND with id: '"+id+"'");
		}
		
		TargetObject item = platformToUpdate.getTargetObjectList().first();
		
		item.updateName( name );
		item.updateLongitude( longitude );
		item.updateLatitude( latitude );
		item.updateHeight( height );
		item.updateTextContent( textContent );
		item.updateImagePath( imagePath );

		
		//checkParamsForAddingTargetObject(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withTargetObjectList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected TargetObject createTargetObject(ArxUserContext userContext, String name, BigDecimal longitude, BigDecimal latitude, int height, String textContent, String imagePath) throws Exception{

		TargetObject targetObject = new TargetObject();
		
		
		targetObject.setName(name);		
		targetObject.setLongitude(longitude);		
		targetObject.setLatitude(latitude);		
		targetObject.setHeight(height);		
		targetObject.setTextContent(textContent);		
		targetObject.setImagePath(imagePath);		
		targetObject.setCreateTime(userContext.now());
	
		
		return targetObject;
	
		
	}
	
	protected TargetObject createIndexedTargetObject(String id, int version){

		TargetObject targetObject = new TargetObject();
		targetObject.setId(id);
		targetObject.setVersion(version);
		return targetObject;			
		
	}
	
	protected void checkParamsForRemovingTargetObjectList(ArxUserContext userContext, String platformId, 
			String targetObjectIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		for(String targetObjectId: targetObjectIds){
			userContext.getChecker().checkIdOfTargetObject(targetObjectId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform removeTargetObjectList(ArxUserContext userContext, String platformId, 
			String targetObjectIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingTargetObjectList(userContext, platformId,  targetObjectIds, tokensExpr);
			
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){ 
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getPlatformDAO().planToRemoveTargetObjectList(platform, targetObjectIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withTargetObjectList().done());
				deleteRelationListInGraph(userContext, platform.getTargetObjectList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingTargetObject(ArxUserContext userContext, String platformId, 
		String targetObjectId, int targetObjectVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfTargetObject(targetObjectId);
		userContext.getChecker().checkVersionOfTargetObject(targetObjectVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform removeTargetObject(ArxUserContext userContext, String platformId, 
		String targetObjectId, int targetObjectVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTargetObject(userContext,platformId, targetObjectId, targetObjectVersion,tokensExpr);
		
		TargetObject targetObject = createIndexedTargetObject(targetObjectId, targetObjectVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeTargetObject( targetObject );		
			platform = savePlatform(userContext, platform, tokens().withTargetObjectList().done());
			deleteRelationInGraph(userContext, targetObject);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingTargetObject(ArxUserContext userContext, String platformId, 
		String targetObjectId, int targetObjectVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfTargetObject(targetObjectId);
		userContext.getChecker().checkVersionOfTargetObject(targetObjectVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform copyTargetObjectFrom(ArxUserContext userContext, String platformId, 
		String targetObjectId, int targetObjectVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTargetObject(userContext,platformId, targetObjectId, targetObjectVersion,tokensExpr);
		
		TargetObject targetObject = createIndexedTargetObject(targetObjectId, targetObjectVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			platform.copyTargetObjectFrom( targetObject );		
			platform = savePlatform(userContext, platform, tokens().withTargetObjectList().done());
			
			userContext.getManagerGroup().getTargetObjectManager().onNewInstanceCreated(userContext, (TargetObject)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingTargetObject(ArxUserContext userContext, String platformId, String targetObjectId, int targetObjectVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfTargetObject(targetObjectId);
		userContext.getChecker().checkVersionOfTargetObject(targetObjectVersion);
		

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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	
	public  Platform updateTargetObject(ArxUserContext userContext, String platformId, String targetObjectId, int targetObjectVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTargetObject(userContext, platformId, targetObjectId, targetObjectVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withTargetObjectList().searchTargetObjectListWith(TargetObject.ID_PROPERTY, "eq", targetObjectId).done();
		
		
		
		Platform platform = loadPlatform(userContext, platformId, loadTokens);
		
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeTargetObject( targetObject );	
			//make changes to AcceleraterAccount.
			TargetObject targetObjectIndex = createIndexedTargetObject(targetObjectId, targetObjectVersion);
		
			TargetObject targetObject = platform.findTheTargetObject(targetObjectIndex);
			if(targetObject == null){
				throw new PlatformManagerException(targetObject+" is NOT FOUND" );
			}
			
			targetObject.changeProperty(property, newValueExpr);
			
			platform = savePlatform(userContext, platform, tokens().withTargetObjectList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingViewDevice(ArxUserContext userContext, String platformId, String name, BigDecimal longitude, BigDecimal latitude, int height,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfPlatform(platformId);

		
		userContext.getChecker().checkNameOfViewDevice(name);
		
		userContext.getChecker().checkLongitudeOfViewDevice(longitude);
		
		userContext.getChecker().checkLatitudeOfViewDevice(latitude);
		
		userContext.getChecker().checkHeightOfViewDevice(height);
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addViewDevice(ArxUserContext userContext, String platformId, String name, BigDecimal longitude, BigDecimal latitude, int height, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingViewDevice(userContext,platformId,name, longitude, latitude, height,tokensExpr);
		
		ViewDevice viewDevice = createViewDevice(userContext,name, longitude, latitude, height);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addViewDevice( viewDevice );		
			platform = savePlatform(userContext, platform, tokens().withViewDeviceList().done());
			
			userContext.getManagerGroup().getViewDeviceManager().onNewInstanceCreated(userContext, viewDevice);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingViewDeviceProperties(ArxUserContext userContext, String platformId,String id,String name,BigDecimal longitude,BigDecimal latitude,int height,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfViewDevice(id);
		
		userContext.getChecker().checkNameOfViewDevice( name);
		userContext.getChecker().checkLongitudeOfViewDevice( longitude);
		userContext.getChecker().checkLatitudeOfViewDevice( latitude);
		userContext.getChecker().checkHeightOfViewDevice( height);

		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateViewDeviceProperties(ArxUserContext userContext, String platformId, String id,String name,BigDecimal longitude,BigDecimal latitude,int height, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingViewDeviceProperties(userContext,platformId,id,name,longitude,latitude,height,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withViewDeviceListList()
				.searchViewDeviceListWith(ViewDevice.ID_PROPERTY, "is", id).done();
		
		Platform platformToUpdate = loadPlatform(userContext, platformId, options);
		
		if(platformToUpdate.getViewDeviceList().isEmpty()){
			throw new PlatformManagerException("ViewDevice is NOT FOUND with id: '"+id+"'");
		}
		
		ViewDevice item = platformToUpdate.getViewDeviceList().first();
		
		item.updateName( name );
		item.updateLongitude( longitude );
		item.updateLatitude( latitude );
		item.updateHeight( height );

		
		//checkParamsForAddingViewDevice(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withViewDeviceList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ViewDevice createViewDevice(ArxUserContext userContext, String name, BigDecimal longitude, BigDecimal latitude, int height) throws Exception{

		ViewDevice viewDevice = new ViewDevice();
		
		
		viewDevice.setName(name);		
		viewDevice.setLongitude(longitude);		
		viewDevice.setLatitude(latitude);		
		viewDevice.setHeight(height);		
		viewDevice.setCreateTime(userContext.now());
	
		
		return viewDevice;
	
		
	}
	
	protected ViewDevice createIndexedViewDevice(String id, int version){

		ViewDevice viewDevice = new ViewDevice();
		viewDevice.setId(id);
		viewDevice.setVersion(version);
		return viewDevice;			
		
	}
	
	protected void checkParamsForRemovingViewDeviceList(ArxUserContext userContext, String platformId, 
			String viewDeviceIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPlatform(platformId);
		for(String viewDeviceId: viewDeviceIds){
			userContext.getChecker().checkIdOfViewDevice(viewDeviceId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform removeViewDeviceList(ArxUserContext userContext, String platformId, 
			String viewDeviceIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingViewDeviceList(userContext, platformId,  viewDeviceIds, tokensExpr);
			
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){ 
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getPlatformDAO().planToRemoveViewDeviceList(platform, viewDeviceIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withViewDeviceList().done());
				deleteRelationListInGraph(userContext, platform.getViewDeviceList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingViewDevice(ArxUserContext userContext, String platformId, 
		String viewDeviceId, int viewDeviceVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfViewDevice(viewDeviceId);
		userContext.getChecker().checkVersionOfViewDevice(viewDeviceVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform removeViewDevice(ArxUserContext userContext, String platformId, 
		String viewDeviceId, int viewDeviceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingViewDevice(userContext,platformId, viewDeviceId, viewDeviceVersion,tokensExpr);
		
		ViewDevice viewDevice = createIndexedViewDevice(viewDeviceId, viewDeviceVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeViewDevice( viewDevice );		
			platform = savePlatform(userContext, platform, tokens().withViewDeviceList().done());
			deleteRelationInGraph(userContext, viewDevice);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingViewDevice(ArxUserContext userContext, String platformId, 
		String viewDeviceId, int viewDeviceVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPlatform( platformId);
		userContext.getChecker().checkIdOfViewDevice(viewDeviceId);
		userContext.getChecker().checkVersionOfViewDevice(viewDeviceVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform copyViewDeviceFrom(ArxUserContext userContext, String platformId, 
		String viewDeviceId, int viewDeviceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingViewDevice(userContext,platformId, viewDeviceId, viewDeviceVersion,tokensExpr);
		
		ViewDevice viewDevice = createIndexedViewDevice(viewDeviceId, viewDeviceVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			platform.copyViewDeviceFrom( viewDevice );		
			platform = savePlatform(userContext, platform, tokens().withViewDeviceList().done());
			
			userContext.getManagerGroup().getViewDeviceManager().onNewInstanceCreated(userContext, (ViewDevice)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingViewDevice(ArxUserContext userContext, String platformId, String viewDeviceId, int viewDeviceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfPlatform(platformId);
		userContext.getChecker().checkIdOfViewDevice(viewDeviceId);
		userContext.getChecker().checkVersionOfViewDevice(viewDeviceVersion);
		

		if(ViewDevice.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfViewDevice(parseString(newValueExpr));
		}
		
		if(ViewDevice.LONGITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLongitudeOfViewDevice(parseBigDecimal(newValueExpr));
		}
		
		if(ViewDevice.LATITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLatitudeOfViewDevice(parseBigDecimal(newValueExpr));
		}
		
		if(ViewDevice.HEIGHT_PROPERTY.equals(property)){
			userContext.getChecker().checkHeightOfViewDevice(parseInt(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	
	public  Platform updateViewDevice(ArxUserContext userContext, String platformId, String viewDeviceId, int viewDeviceVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingViewDevice(userContext, platformId, viewDeviceId, viewDeviceVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withViewDeviceList().searchViewDeviceListWith(ViewDevice.ID_PROPERTY, "eq", viewDeviceId).done();
		
		
		
		Platform platform = loadPlatform(userContext, platformId, loadTokens);
		
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeViewDevice( viewDevice );	
			//make changes to AcceleraterAccount.
			ViewDevice viewDeviceIndex = createIndexedViewDevice(viewDeviceId, viewDeviceVersion);
		
			ViewDevice viewDevice = platform.findTheViewDevice(viewDeviceIndex);
			if(viewDevice == null){
				throw new PlatformManagerException(viewDevice+" is NOT FOUND" );
			}
			
			viewDevice.changeProperty(property, newValueExpr);
			
			platform = savePlatform(userContext, platform, tokens().withViewDeviceList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(ArxUserContext userContext, Platform newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


