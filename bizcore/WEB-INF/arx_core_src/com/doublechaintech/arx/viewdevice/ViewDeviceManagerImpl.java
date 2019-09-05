
package com.doublechaintech.arx.viewdevice;

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

import com.doublechaintech.arx.platform.Platform;

import com.doublechaintech.arx.platform.CandidatePlatform;







public class ViewDeviceManagerImpl extends CustomArxCheckerManager implements ViewDeviceManager {
	
	private static final String SERVICE_TYPE = "ViewDevice";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ViewDeviceManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ViewDeviceManagerException(message);

	}
	
	

 	protected ViewDevice saveViewDevice(ArxUserContext userContext, ViewDevice viewDevice, String [] tokensExpr) throws Exception{	
 		//return getViewDeviceDAO().save(viewDevice, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveViewDevice(userContext, viewDevice, tokens);
 	}
 	
 	protected ViewDevice saveViewDeviceDetail(ArxUserContext userContext, ViewDevice viewDevice) throws Exception{	

 		
 		return saveViewDevice(userContext, viewDevice, allTokens());
 	}
 	
 	public ViewDevice loadViewDevice(ArxUserContext userContext, String viewDeviceId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfViewDevice(viewDeviceId);
		userContext.getChecker().throwExceptionIfHasErrors( ViewDeviceManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ViewDevice viewDevice = loadViewDevice( userContext, viewDeviceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,viewDevice, tokens);
 	}
 	
 	
 	 public ViewDevice searchViewDevice(ArxUserContext userContext, String viewDeviceId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfViewDevice(viewDeviceId);
		userContext.getChecker().throwExceptionIfHasErrors( ViewDeviceManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ViewDevice viewDevice = loadViewDevice( userContext, viewDeviceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,viewDevice, tokens);
 	}
 	
 	

 	protected ViewDevice present(ArxUserContext userContext, ViewDevice viewDevice, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,viewDevice,tokens);
		
		
		ViewDevice  viewDeviceToPresent = userContext.getDAOGroup().getViewDeviceDAO().present(viewDevice, tokens);
		
		List<BaseEntity> entityListToNaming = viewDeviceToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getViewDeviceDAO().alias(entityListToNaming);
		
		return  viewDeviceToPresent;
		
		
	}
 
 	
 	
 	public ViewDevice loadViewDeviceDetail(ArxUserContext userContext, String viewDeviceId) throws Exception{	
 		ViewDevice viewDevice = loadViewDevice( userContext, viewDeviceId, allTokens());
 		return present(userContext,viewDevice, allTokens());
		
 	}
 	
 	public Object view(ArxUserContext userContext, String viewDeviceId) throws Exception{	
 		ViewDevice viewDevice = loadViewDevice( userContext, viewDeviceId, viewTokens());
 		return present(userContext,viewDevice, allTokens());
		
 	}
 	protected ViewDevice saveViewDevice(ArxUserContext userContext, ViewDevice viewDevice, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getViewDeviceDAO().save(viewDevice, tokens);
 	}
 	protected ViewDevice loadViewDevice(ArxUserContext userContext, String viewDeviceId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfViewDevice(viewDeviceId);
		userContext.getChecker().throwExceptionIfHasErrors( ViewDeviceManagerException.class);

 
 		return userContext.getDAOGroup().getViewDeviceDAO().load(viewDeviceId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(ArxUserContext userContext, ViewDevice viewDevice, Map<String, Object> tokens){
		super.addActions(userContext, viewDevice, tokens);
		
		addAction(userContext, viewDevice, tokens,"@create","createViewDevice","createViewDevice/","main","primary");
		addAction(userContext, viewDevice, tokens,"@update","updateViewDevice","updateViewDevice/"+viewDevice.getId()+"/","main","primary");
		addAction(userContext, viewDevice, tokens,"@copy","cloneViewDevice","cloneViewDevice/"+viewDevice.getId()+"/","main","primary");
		
		addAction(userContext, viewDevice, tokens,"view_device.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+viewDevice.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(ArxUserContext userContext, ViewDevice viewDevice, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ViewDevice createViewDevice(ArxUserContext userContext,String name, BigDecimal longitude, BigDecimal latitude, int height, String platformId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfViewDevice(name);
		userContext.getChecker().checkLongitudeOfViewDevice(longitude);
		userContext.getChecker().checkLatitudeOfViewDevice(latitude);
		userContext.getChecker().checkHeightOfViewDevice(height);
	
		userContext.getChecker().throwExceptionIfHasErrors(ViewDeviceManagerException.class);


		ViewDevice viewDevice=createNewViewDevice();	

		viewDevice.setName(name);
		viewDevice.setLongitude(longitude);
		viewDevice.setLatitude(latitude);
		viewDevice.setHeight(height);
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		viewDevice.setPlatform(platform);
		
		
		viewDevice.setCreateTime(userContext.now());

		viewDevice = saveViewDevice(userContext, viewDevice, emptyOptions());
		
		onNewInstanceCreated(userContext, viewDevice);
		return viewDevice;

		
	}
	protected ViewDevice createNewViewDevice() 
	{
		
		return new ViewDevice();		
	}
	
	protected void checkParamsForUpdatingViewDevice(ArxUserContext userContext,String viewDeviceId, int viewDeviceVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfViewDevice(viewDeviceId);
		userContext.getChecker().checkVersionOfViewDevice( viewDeviceVersion);
		

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

		
	
		userContext.getChecker().throwExceptionIfHasErrors(ViewDeviceManagerException.class);
	
		
	}
	
	
	
	public ViewDevice clone(ArxUserContext userContext, String fromViewDeviceId) throws Exception{
		
		return userContext.getDAOGroup().getViewDeviceDAO().clone(fromViewDeviceId, this.allTokens());
	}
	
	public ViewDevice internalSaveViewDevice(ArxUserContext userContext, ViewDevice viewDevice) throws Exception 
	{
		return internalSaveViewDevice(userContext, viewDevice, allTokens());

	}
	public ViewDevice internalSaveViewDevice(ArxUserContext userContext, ViewDevice viewDevice, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingViewDevice(userContext, viewDeviceId, viewDeviceVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(viewDevice){ 
			//will be good when the viewDevice loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ViewDevice.
			
			
			viewDevice = saveViewDevice(userContext, viewDevice, options);
			return viewDevice;
			
		}

	}
	
	public ViewDevice updateViewDevice(ArxUserContext userContext,String viewDeviceId, int viewDeviceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingViewDevice(userContext, viewDeviceId, viewDeviceVersion, property, newValueExpr, tokensExpr);
		
		
		
		ViewDevice viewDevice = loadViewDevice(userContext, viewDeviceId, allTokens());
		if(viewDevice.getVersion() != viewDeviceVersion){
			String message = "The target version("+viewDevice.getVersion()+") is not equals to version("+viewDeviceVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(viewDevice){ 
			//will be good when the viewDevice loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ViewDevice.
			
			viewDevice.changeProperty(property, newValueExpr);
			viewDevice = saveViewDevice(userContext, viewDevice, tokens().done());
			return present(userContext,viewDevice, mergedAllTokens(tokensExpr));
			//return saveViewDevice(userContext, viewDevice, tokens().done());
		}

	}
	
	public ViewDevice updateViewDeviceProperty(ArxUserContext userContext,String viewDeviceId, int viewDeviceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingViewDevice(userContext, viewDeviceId, viewDeviceVersion, property, newValueExpr, tokensExpr);
		
		ViewDevice viewDevice = loadViewDevice(userContext, viewDeviceId, allTokens());
		if(viewDevice.getVersion() != viewDeviceVersion){
			String message = "The target version("+viewDevice.getVersion()+") is not equals to version("+viewDeviceVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(viewDevice){ 
			//will be good when the viewDevice loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ViewDevice.
			
			viewDevice.changeProperty(property, newValueExpr);
			
			viewDevice = saveViewDevice(userContext, viewDevice, tokens().done());
			return present(userContext,viewDevice, mergedAllTokens(tokensExpr));
			//return saveViewDevice(userContext, viewDevice, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ViewDeviceTokens tokens(){
		return ViewDeviceTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ViewDeviceTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ViewDeviceTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherPlatform(ArxUserContext userContext, String viewDeviceId, String anotherPlatformId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfViewDevice(viewDeviceId);
 		userContext.getChecker().checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ViewDeviceManagerException.class);
 		
 	}
 	public ViewDevice transferToAnotherPlatform(ArxUserContext userContext, String viewDeviceId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, viewDeviceId,anotherPlatformId);
 
		ViewDevice viewDevice = loadViewDevice(userContext, viewDeviceId, allTokens());	
		synchronized(viewDevice){
			//will be good when the viewDevice loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			viewDevice.updatePlatform(platform);		
			viewDevice = saveViewDevice(userContext, viewDevice, emptyOptions());
			
			return present(userContext,viewDevice, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidatePlatform requestCandidatePlatform(ArxUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidatePlatform result = new CandidatePlatform();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Platform> candidateList = userContext.getDAOGroup().getPlatformDAO().requestCandidatePlatformForViewDevice(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Platform loadPlatform(ArxUserContext userContext, String newPlatformId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getPlatformDAO().load(newPlatformId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(ArxUserContext userContext, String viewDeviceId, int viewDeviceVersion) throws Exception {
		//deleteInternal(userContext, viewDeviceId, viewDeviceVersion);		
	}
	protected void deleteInternal(ArxUserContext userContext,
			String viewDeviceId, int viewDeviceVersion) throws Exception{
			
		userContext.getDAOGroup().getViewDeviceDAO().delete(viewDeviceId, viewDeviceVersion);
	}
	
	public ViewDevice forgetByAll(ArxUserContext userContext, String viewDeviceId, int viewDeviceVersion) throws Exception {
		return forgetByAllInternal(userContext, viewDeviceId, viewDeviceVersion);		
	}
	protected ViewDevice forgetByAllInternal(ArxUserContext userContext,
			String viewDeviceId, int viewDeviceVersion) throws Exception{
			
		return userContext.getDAOGroup().getViewDeviceDAO().disconnectFromAll(viewDeviceId, viewDeviceVersion);
	}
	

	
	public int deleteAll(ArxUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ViewDeviceManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(ArxUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getViewDeviceDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(ArxUserContext userContext, ViewDevice newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


