
package com.doublechaintech.arx.platform;

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


import com.doublechaintech.arx.viewdevice.ViewDevice;

import com.doublechaintech.arx.viewdevice.ViewDeviceDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class PlatformJDBCTemplateDAO extends ArxNamingServiceDAO implements PlatformDAO{


			
		
	
  	private  ViewDeviceDAO  viewDeviceDAO;
 	public void setViewDeviceDAO(ViewDeviceDAO pViewDeviceDAO){
 	
 		if(pViewDeviceDAO == null){
 			throw new IllegalStateException("Do not try to set viewDeviceDAO to null.");
 		}
	 	this.viewDeviceDAO = pViewDeviceDAO;
 	}
 	public ViewDeviceDAO getViewDeviceDAO(){
 		if(this.viewDeviceDAO == null){
 			throw new IllegalStateException("The viewDeviceDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.viewDeviceDAO;
 	}	
 	
			
		

	
	/*
	protected Platform load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalPlatform(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Platform load(String id,Map<String,Object> options) throws Exception{
		return loadInternalPlatform(PlatformTable.withId(id), options);
	}
	
	
	
	public Platform save(Platform platform,Map<String,Object> options){
		
		String methodName="save(Platform platform,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(platform, methodName, "platform");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalPlatform(platform,options);
	}
	public Platform clone(String platformId, Map<String,Object> options) throws Exception{
	
		return clone(PlatformTable.withId(platformId),options);
	}
	
	protected Platform clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String platformId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Platform newPlatform = loadInternalPlatform(accessKey, options);
		newPlatform.setVersion(0);
		
		
 		
 		if(isSaveViewDeviceListEnabled(options)){
 			for(ViewDevice item: newPlatform.getViewDeviceList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalPlatform(newPlatform,options);
		
		return newPlatform;
	}
	
	
	
	

	protected void throwIfHasException(String platformId,int version,int count) throws Exception{
		if (count == 1) {
			throw new PlatformVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new PlatformNotFoundException(
					"The " + this.getTableName() + "(" + platformId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String platformId, int version) throws Exception{
	
		String methodName="delete(String platformId, int version)";
		assertMethodArgumentNotNull(platformId, methodName, "platformId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{platformId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(platformId,version);
		}
		
	
	}
	
	
	
	
	

	public Platform disconnectFromAll(String platformId, int version) throws Exception{
	
		
		Platform platform = loadInternalPlatform(PlatformTable.withId(platformId), emptyOptions());
		platform.clearFromAll();
		this.savePlatform(platform);
		return platform;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return PlatformTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "platform";
	}
	@Override
	protected String getBeanName() {
		
		return "platform";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return PlatformTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractViewDeviceListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.VIEW_DEVICE_LIST);
 	}
 	protected boolean isAnalyzeViewDeviceListEnabled(Map<String,Object> options){		 		
 		return PlatformTokens.of(options).analyzeViewDeviceListEnabled();
 	}
	
	protected boolean isSaveViewDeviceListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.VIEW_DEVICE_LIST);
		
 	}
 	
		

	

	protected PlatformMapper getPlatformMapper(){
		return new PlatformMapper();
	}

	
	
	protected Platform extractPlatform(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Platform platform = loadSingleObject(accessKey, getPlatformMapper());
			return platform;
		}catch(EmptyResultDataAccessException e){
			throw new PlatformNotFoundException("Platform("+accessKey+") is not found!");
		}

	}

	
	

	protected Platform loadInternalPlatform(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Platform platform = extractPlatform(accessKey, loadOptions);

		
		if(isExtractViewDeviceListEnabled(loadOptions)){
	 		extractViewDeviceList(platform, loadOptions);
 		}	
 		if(isAnalyzeViewDeviceListEnabled(loadOptions)){
	 		analyzeViewDeviceList(platform, loadOptions);
 		}
 		
		
		return platform;
		
	}

	
		
	protected void enhanceViewDeviceList(SmartList<ViewDevice> viewDeviceList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractViewDeviceList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<ViewDevice> viewDeviceList = getViewDeviceDAO().findViewDeviceByPlatform(platform.getId(),options);
		if(viewDeviceList != null){
			enhanceViewDeviceList(viewDeviceList,options);
			platform.setViewDeviceList(viewDeviceList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeViewDeviceList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<ViewDevice> viewDeviceList = platform.getViewDeviceList();
		if(viewDeviceList != null){
			getViewDeviceDAO().analyzeViewDeviceByPlatform(viewDeviceList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
		
 	
		
		
		

	

	protected Platform savePlatform(Platform  platform){
		
		if(!platform.isChanged()){
			return platform;
		}
		
		
		String SQL=this.getSavePlatformSQL(platform);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSavePlatformParameters(platform);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		platform.incVersion();
		return platform;
	
	}
	public SmartList<Platform> savePlatformList(SmartList<Platform> platformList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitPlatformList(platformList);
		
		batchPlatformCreate((List<Platform>)lists[CREATE_LIST_INDEX]);
		
		batchPlatformUpdate((List<Platform>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Platform platform:platformList){
			if(platform.isChanged()){
				platform.incVersion();
			}
			
		
		}
		
		
		return platformList;
	}

	public SmartList<Platform> removePlatformList(SmartList<Platform> platformList,Map<String,Object> options){
		
		
		super.removeList(platformList, options);
		
		return platformList;
		
		
	}
	
	protected List<Object[]> preparePlatformBatchCreateArgs(List<Platform> platformList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Platform platform:platformList ){
			Object [] parameters = preparePlatformCreateParameters(platform);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> preparePlatformBatchUpdateArgs(List<Platform> platformList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Platform platform:platformList ){
			if(!platform.isChanged()){
				continue;
			}
			Object [] parameters = preparePlatformUpdateParameters(platform);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchPlatformCreate(List<Platform> platformList){
		String SQL=getCreateSQL();
		List<Object[]> args=preparePlatformBatchCreateArgs(platformList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchPlatformUpdate(List<Platform> platformList){
		String SQL=getUpdateSQL();
		List<Object[]> args=preparePlatformBatchUpdateArgs(platformList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitPlatformList(List<Platform> platformList){
		
		List<Platform> platformCreateList=new ArrayList<Platform>();
		List<Platform> platformUpdateList=new ArrayList<Platform>();
		
		for(Platform platform: platformList){
			if(isUpdateRequest(platform)){
				platformUpdateList.add( platform);
				continue;
			}
			platformCreateList.add(platform);
		}
		
		return new Object[]{platformCreateList,platformUpdateList};
	}
	
	protected boolean isUpdateRequest(Platform platform){
 		return platform.getVersion() > 0;
 	}
 	protected String getSavePlatformSQL(Platform platform){
 		if(isUpdateRequest(platform)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSavePlatformParameters(Platform platform){
 		if(isUpdateRequest(platform) ){
 			return preparePlatformUpdateParameters(platform);
 		}
 		return preparePlatformCreateParameters(platform);
 	}
 	protected Object[] preparePlatformUpdateParameters(Platform platform){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = platform.getName();
 		parameters[1] = platform.getDescription();		
 		parameters[2] = platform.nextVersion();
 		parameters[3] = platform.getId();
 		parameters[4] = platform.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] preparePlatformCreateParameters(Platform platform){
		Object[] parameters = new Object[3];
		String newPlatformId=getNextId();
		platform.setId(newPlatformId);
		parameters[0] =  platform.getId();
 
 		parameters[1] = platform.getName();
 		parameters[2] = platform.getDescription();		
 				
 		return parameters;
 	}
 	
	protected Platform saveInternalPlatform(Platform platform, Map<String,Object> options){
		
		savePlatform(platform);

		
		if(isSaveViewDeviceListEnabled(options)){
	 		saveViewDeviceList(platform, options);
	 		//removeViewDeviceList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		return platform;
		
	}
	
	
	
	//======================================================================================
	

	
	public Platform planToRemoveViewDeviceList(Platform platform, String viewDeviceIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ViewDevice.PLATFORM_PROPERTY, platform.getId());
		key.put(ViewDevice.ID_PROPERTY, viewDeviceIds);
		
		SmartList<ViewDevice> externalViewDeviceList = getViewDeviceDAO().
				findViewDeviceWithKey(key, options);
		if(externalViewDeviceList == null){
			return platform;
		}
		if(externalViewDeviceList.isEmpty()){
			return platform;
		}
		
		for(ViewDevice viewDevice: externalViewDeviceList){

			viewDevice.clearFromAll();
		}
		
		
		SmartList<ViewDevice> viewDeviceList = platform.getViewDeviceList();		
		viewDeviceList.addAllToRemoveList(externalViewDeviceList);
		return platform;	
	
	}



		
	protected Platform saveViewDeviceList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<ViewDevice> viewDeviceList = platform.getViewDeviceList();
		if(viewDeviceList == null){
			//null list means nothing
			return platform;
		}
		SmartList<ViewDevice> mergedUpdateViewDeviceList = new SmartList<ViewDevice>();
		
		
		mergedUpdateViewDeviceList.addAll(viewDeviceList); 
		if(viewDeviceList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateViewDeviceList.addAll(viewDeviceList.getToRemoveList());
			viewDeviceList.removeAll(viewDeviceList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getViewDeviceDAO().saveViewDeviceList(mergedUpdateViewDeviceList,options);
		
		if(viewDeviceList.getToRemoveList() != null){
			viewDeviceList.removeAll(viewDeviceList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeViewDeviceList(Platform platform, Map<String,Object> options){
	
	
		SmartList<ViewDevice> viewDeviceList = platform.getViewDeviceList();
		if(viewDeviceList == null){
			return platform;
		}	
	
		SmartList<ViewDevice> toRemoveViewDeviceList = viewDeviceList.getToRemoveList();
		
		if(toRemoveViewDeviceList == null){
			return platform;
		}
		if(toRemoveViewDeviceList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getViewDeviceDAO().removeViewDeviceList(toRemoveViewDeviceList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		

	public Platform present(Platform platform,Map<String, Object> options){
	
		presentViewDeviceList(platform,options);

		return platform;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentViewDeviceList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<ViewDevice> viewDeviceList = platform.getViewDeviceList();		
				SmartList<ViewDevice> newList= presentSubList(platform.getId(),
				viewDeviceList,
				options,
				getViewDeviceDAO()::countViewDeviceByPlatform,
				getViewDeviceDAO()::findViewDeviceByPlatform
				);

		
		platform.setViewDeviceList(newList);
		

		return platform;
	}			
		

	
    public SmartList<Platform> requestCandidatePlatformForViewDevice(ArxUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		

	protected String getTableName(){
		return PlatformTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Platform> platformList) {		
		this.enhanceListInternal(platformList, this.getPlatformMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:ViewDevice的platform的ViewDeviceList
	public void loadOurViewDeviceList(ArxUserContext userContext, List<Platform> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return;
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ViewDevice.PLATFORM_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<ViewDevice> loadedObjs = userContext.getDAOGroup().getViewDeviceDAO().findViewDeviceWithKey(key, options);
		Map<String, List<ViewDevice>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getPlatform().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<ViewDevice> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<ViewDevice> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setViewDeviceList(loadedSmartList);
		});
	}
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Platform> platformList = ownerEntity.collectRefsWithType(Platform.INTERNAL_TYPE);
		this.enhanceList(platformList);
		
	}
	
	@Override
	public SmartList<Platform> findPlatformWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getPlatformMapper());

	}
	@Override
	public int countPlatformWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countPlatformWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Platform> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getPlatformMapper());
	}
}


