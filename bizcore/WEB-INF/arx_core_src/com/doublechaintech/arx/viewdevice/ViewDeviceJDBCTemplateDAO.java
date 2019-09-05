
package com.doublechaintech.arx.viewdevice;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import com.doublechaintech.arx.ArxNamingServiceDAO;
import com.doublechaintech.arx.BaseEntity;
import com.doublechaintech.arx.SmartList;
import com.doublechaintech.arx.AccessKey;
import com.doublechaintech.arx.DateKey;
import com.doublechaintech.arx.StatsInfo;
import com.doublechaintech.arx.StatsItem;

import com.doublechaintech.arx.MultipleAccessKey;
import com.doublechaintech.arx.ArxUserContext;


import com.doublechaintech.arx.platform.Platform;

import com.doublechaintech.arx.platform.PlatformDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class ViewDeviceJDBCTemplateDAO extends ArxNamingServiceDAO implements ViewDeviceDAO{
 
 	
 	private  PlatformDAO  platformDAO;
 	public void setPlatformDAO(PlatformDAO platformDAO){
	 	this.platformDAO = platformDAO;
 	}
 	public PlatformDAO getPlatformDAO(){
	 	return this.platformDAO;
 	}


			
		

	
	/*
	protected ViewDevice load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalViewDevice(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public ViewDevice load(String id,Map<String,Object> options) throws Exception{
		return loadInternalViewDevice(ViewDeviceTable.withId(id), options);
	}
	
	
	
	public ViewDevice save(ViewDevice viewDevice,Map<String,Object> options){
		
		String methodName="save(ViewDevice viewDevice,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(viewDevice, methodName, "viewDevice");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalViewDevice(viewDevice,options);
	}
	public ViewDevice clone(String viewDeviceId, Map<String,Object> options) throws Exception{
	
		return clone(ViewDeviceTable.withId(viewDeviceId),options);
	}
	
	protected ViewDevice clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String viewDeviceId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ViewDevice newViewDevice = loadInternalViewDevice(accessKey, options);
		newViewDevice.setVersion(0);
		
		

		
		saveInternalViewDevice(newViewDevice,options);
		
		return newViewDevice;
	}
	
	
	
	

	protected void throwIfHasException(String viewDeviceId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ViewDeviceVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ViewDeviceNotFoundException(
					"The " + this.getTableName() + "(" + viewDeviceId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String viewDeviceId, int version) throws Exception{
	
		String methodName="delete(String viewDeviceId, int version)";
		assertMethodArgumentNotNull(viewDeviceId, methodName, "viewDeviceId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{viewDeviceId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(viewDeviceId,version);
		}
		
	
	}
	
	
	
	
	

	public ViewDevice disconnectFromAll(String viewDeviceId, int version) throws Exception{
	
		
		ViewDevice viewDevice = loadInternalViewDevice(ViewDeviceTable.withId(viewDeviceId), emptyOptions());
		viewDevice.clearFromAll();
		this.saveViewDevice(viewDevice);
		return viewDevice;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return ViewDeviceTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "view_device";
	}
	@Override
	protected String getBeanName() {
		
		return "viewDevice";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ViewDeviceTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractPlatformEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ViewDeviceTokens.PLATFORM);
 	}

 	protected boolean isSavePlatformEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ViewDeviceTokens.PLATFORM);
 	}
 	

 	
 
		

	

	protected ViewDeviceMapper getViewDeviceMapper(){
		return new ViewDeviceMapper();
	}

	
	
	protected ViewDevice extractViewDevice(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			ViewDevice viewDevice = loadSingleObject(accessKey, getViewDeviceMapper());
			return viewDevice;
		}catch(EmptyResultDataAccessException e){
			throw new ViewDeviceNotFoundException("ViewDevice("+accessKey+") is not found!");
		}

	}

	
	

	protected ViewDevice loadInternalViewDevice(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ViewDevice viewDevice = extractViewDevice(accessKey, loadOptions);
 	
 		if(isExtractPlatformEnabled(loadOptions)){
	 		extractPlatform(viewDevice, loadOptions);
 		}
 
		
		return viewDevice;
		
	}

	 

 	protected ViewDevice extractPlatform(ViewDevice viewDevice, Map<String,Object> options) throws Exception{

		if(viewDevice.getPlatform() == null){
			return viewDevice;
		}
		String platformId = viewDevice.getPlatform().getId();
		if( platformId == null){
			return viewDevice;
		}
		Platform platform = getPlatformDAO().load(platformId,options);
		if(platform != null){
			viewDevice.setPlatform(platform);
		}
		
 		
 		return viewDevice;
 	}
 		
 
		
		
  	
 	public SmartList<ViewDevice> findViewDeviceByPlatform(String platformId,Map<String,Object> options){
 	
  		SmartList<ViewDevice> resultList = queryWith(ViewDeviceTable.COLUMN_PLATFORM, platformId, options, getViewDeviceMapper());
		// analyzeViewDeviceByPlatform(resultList, platformId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ViewDevice> findViewDeviceByPlatform(String platformId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ViewDevice> resultList =  queryWithRange(ViewDeviceTable.COLUMN_PLATFORM, platformId, options, getViewDeviceMapper(), start, count);
 		//analyzeViewDeviceByPlatform(resultList, platformId, options);
 		return resultList;
 		
 	}
 	public void analyzeViewDeviceByPlatform(SmartList<ViewDevice> resultList, String platformId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(ViewDevice.PLATFORM_PROPERTY, platformId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//ViewDevice.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("查看设备");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(ViewDevice.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(ViewDevice.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countViewDeviceByPlatform(String platformId,Map<String,Object> options){

 		return countWith(ViewDeviceTable.COLUMN_PLATFORM, platformId, options);
 	}
 	@Override
	public Map<String, Integer> countViewDeviceByPlatformIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ViewDeviceTable.COLUMN_PLATFORM, ids, options);
	}
 	
 	
		
		
		

	

	protected ViewDevice saveViewDevice(ViewDevice  viewDevice){
		
		if(!viewDevice.isChanged()){
			return viewDevice;
		}
		
		
		String SQL=this.getSaveViewDeviceSQL(viewDevice);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveViewDeviceParameters(viewDevice);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		viewDevice.incVersion();
		return viewDevice;
	
	}
	public SmartList<ViewDevice> saveViewDeviceList(SmartList<ViewDevice> viewDeviceList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitViewDeviceList(viewDeviceList);
		
		batchViewDeviceCreate((List<ViewDevice>)lists[CREATE_LIST_INDEX]);
		
		batchViewDeviceUpdate((List<ViewDevice>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ViewDevice viewDevice:viewDeviceList){
			if(viewDevice.isChanged()){
				viewDevice.incVersion();
			}
			
		
		}
		
		
		return viewDeviceList;
	}

	public SmartList<ViewDevice> removeViewDeviceList(SmartList<ViewDevice> viewDeviceList,Map<String,Object> options){
		
		
		super.removeList(viewDeviceList, options);
		
		return viewDeviceList;
		
		
	}
	
	protected List<Object[]> prepareViewDeviceBatchCreateArgs(List<ViewDevice> viewDeviceList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ViewDevice viewDevice:viewDeviceList ){
			Object [] parameters = prepareViewDeviceCreateParameters(viewDevice);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareViewDeviceBatchUpdateArgs(List<ViewDevice> viewDeviceList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ViewDevice viewDevice:viewDeviceList ){
			if(!viewDevice.isChanged()){
				continue;
			}
			Object [] parameters = prepareViewDeviceUpdateParameters(viewDevice);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchViewDeviceCreate(List<ViewDevice> viewDeviceList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareViewDeviceBatchCreateArgs(viewDeviceList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchViewDeviceUpdate(List<ViewDevice> viewDeviceList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareViewDeviceBatchUpdateArgs(viewDeviceList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitViewDeviceList(List<ViewDevice> viewDeviceList){
		
		List<ViewDevice> viewDeviceCreateList=new ArrayList<ViewDevice>();
		List<ViewDevice> viewDeviceUpdateList=new ArrayList<ViewDevice>();
		
		for(ViewDevice viewDevice: viewDeviceList){
			if(isUpdateRequest(viewDevice)){
				viewDeviceUpdateList.add( viewDevice);
				continue;
			}
			viewDeviceCreateList.add(viewDevice);
		}
		
		return new Object[]{viewDeviceCreateList,viewDeviceUpdateList};
	}
	
	protected boolean isUpdateRequest(ViewDevice viewDevice){
 		return viewDevice.getVersion() > 0;
 	}
 	protected String getSaveViewDeviceSQL(ViewDevice viewDevice){
 		if(isUpdateRequest(viewDevice)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveViewDeviceParameters(ViewDevice viewDevice){
 		if(isUpdateRequest(viewDevice) ){
 			return prepareViewDeviceUpdateParameters(viewDevice);
 		}
 		return prepareViewDeviceCreateParameters(viewDevice);
 	}
 	protected Object[] prepareViewDeviceUpdateParameters(ViewDevice viewDevice){
 		Object[] parameters = new Object[9];
 
 		parameters[0] = viewDevice.getName();
 		parameters[1] = viewDevice.getLongitude();
 		parameters[2] = viewDevice.getLatitude();
 		parameters[3] = viewDevice.getHeight(); 	
 		if(viewDevice.getPlatform() != null){
 			parameters[4] = viewDevice.getPlatform().getId();
 		}
 
 		parameters[5] = viewDevice.getCreateTime();		
 		parameters[6] = viewDevice.nextVersion();
 		parameters[7] = viewDevice.getId();
 		parameters[8] = viewDevice.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareViewDeviceCreateParameters(ViewDevice viewDevice){
		Object[] parameters = new Object[7];
		String newViewDeviceId=getNextId();
		viewDevice.setId(newViewDeviceId);
		parameters[0] =  viewDevice.getId();
 
 		parameters[1] = viewDevice.getName();
 		parameters[2] = viewDevice.getLongitude();
 		parameters[3] = viewDevice.getLatitude();
 		parameters[4] = viewDevice.getHeight(); 	
 		if(viewDevice.getPlatform() != null){
 			parameters[5] = viewDevice.getPlatform().getId();
 		
 		}
 		
 		parameters[6] = viewDevice.getCreateTime();		
 				
 		return parameters;
 	}
 	
	protected ViewDevice saveInternalViewDevice(ViewDevice viewDevice, Map<String,Object> options){
		
		saveViewDevice(viewDevice);
 	
 		if(isSavePlatformEnabled(options)){
	 		savePlatform(viewDevice, options);
 		}
 
		
		return viewDevice;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected ViewDevice savePlatform(ViewDevice viewDevice, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(viewDevice.getPlatform() == null){
 			return viewDevice;//do nothing when it is null
 		}
 		
 		getPlatformDAO().save(viewDevice.getPlatform(),options);
 		return viewDevice;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public ViewDevice present(ViewDevice viewDevice,Map<String, Object> options){
	

		return viewDevice;
	
	}
		

	

	protected String getTableName(){
		return ViewDeviceTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<ViewDevice> viewDeviceList) {		
		this.enhanceListInternal(viewDeviceList, this.getViewDeviceMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<ViewDevice> viewDeviceList = ownerEntity.collectRefsWithType(ViewDevice.INTERNAL_TYPE);
		this.enhanceList(viewDeviceList);
		
	}
	
	@Override
	public SmartList<ViewDevice> findViewDeviceWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getViewDeviceMapper());

	}
	@Override
	public int countViewDeviceWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countViewDeviceWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<ViewDevice> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getViewDeviceMapper());
	}
}


