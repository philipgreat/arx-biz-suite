
package com.doublechaintech.arx.targetobject;

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






import org.springframework.dao.EmptyResultDataAccessException;

public class TargetObjectJDBCTemplateDAO extends ArxNamingServiceDAO implements TargetObjectDAO{


			
		

	
	/*
	protected TargetObject load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalTargetObject(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public TargetObject load(String id,Map<String,Object> options) throws Exception{
		return loadInternalTargetObject(TargetObjectTable.withId(id), options);
	}
	
	
	
	public TargetObject save(TargetObject targetObject,Map<String,Object> options){
		
		String methodName="save(TargetObject targetObject,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(targetObject, methodName, "targetObject");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalTargetObject(targetObject,options);
	}
	public TargetObject clone(String targetObjectId, Map<String,Object> options) throws Exception{
	
		return clone(TargetObjectTable.withId(targetObjectId),options);
	}
	
	protected TargetObject clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String targetObjectId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		TargetObject newTargetObject = loadInternalTargetObject(accessKey, options);
		newTargetObject.setVersion(0);
		
		

		
		saveInternalTargetObject(newTargetObject,options);
		
		return newTargetObject;
	}
	
	
	
	

	protected void throwIfHasException(String targetObjectId,int version,int count) throws Exception{
		if (count == 1) {
			throw new TargetObjectVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new TargetObjectNotFoundException(
					"The " + this.getTableName() + "(" + targetObjectId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String targetObjectId, int version) throws Exception{
	
		String methodName="delete(String targetObjectId, int version)";
		assertMethodArgumentNotNull(targetObjectId, methodName, "targetObjectId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{targetObjectId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(targetObjectId,version);
		}
		
	
	}
	
	
	
	
	

	public TargetObject disconnectFromAll(String targetObjectId, int version) throws Exception{
	
		
		TargetObject targetObject = loadInternalTargetObject(TargetObjectTable.withId(targetObjectId), emptyOptions());
		targetObject.clearFromAll();
		this.saveTargetObject(targetObject);
		return targetObject;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return TargetObjectTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "target_object";
	}
	@Override
	protected String getBeanName() {
		
		return "targetObject";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return TargetObjectTokens.checkOptions(options, optionToCheck);
	
	}


		

	

	protected TargetObjectMapper getTargetObjectMapper(){
		return new TargetObjectMapper();
	}

	
	
	protected TargetObject extractTargetObject(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			TargetObject targetObject = loadSingleObject(accessKey, getTargetObjectMapper());
			return targetObject;
		}catch(EmptyResultDataAccessException e){
			throw new TargetObjectNotFoundException("TargetObject("+accessKey+") is not found!");
		}

	}

	
	

	protected TargetObject loadInternalTargetObject(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		TargetObject targetObject = extractTargetObject(accessKey, loadOptions);

		
		return targetObject;
		
	}

	
		
		
 	
		
		
		

	

	protected TargetObject saveTargetObject(TargetObject  targetObject){
		
		if(!targetObject.isChanged()){
			return targetObject;
		}
		
		
		String SQL=this.getSaveTargetObjectSQL(targetObject);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveTargetObjectParameters(targetObject);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		targetObject.incVersion();
		return targetObject;
	
	}
	public SmartList<TargetObject> saveTargetObjectList(SmartList<TargetObject> targetObjectList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitTargetObjectList(targetObjectList);
		
		batchTargetObjectCreate((List<TargetObject>)lists[CREATE_LIST_INDEX]);
		
		batchTargetObjectUpdate((List<TargetObject>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(TargetObject targetObject:targetObjectList){
			if(targetObject.isChanged()){
				targetObject.incVersion();
			}
			
		
		}
		
		
		return targetObjectList;
	}

	public SmartList<TargetObject> removeTargetObjectList(SmartList<TargetObject> targetObjectList,Map<String,Object> options){
		
		
		super.removeList(targetObjectList, options);
		
		return targetObjectList;
		
		
	}
	
	protected List<Object[]> prepareTargetObjectBatchCreateArgs(List<TargetObject> targetObjectList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TargetObject targetObject:targetObjectList ){
			Object [] parameters = prepareTargetObjectCreateParameters(targetObject);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareTargetObjectBatchUpdateArgs(List<TargetObject> targetObjectList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TargetObject targetObject:targetObjectList ){
			if(!targetObject.isChanged()){
				continue;
			}
			Object [] parameters = prepareTargetObjectUpdateParameters(targetObject);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchTargetObjectCreate(List<TargetObject> targetObjectList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareTargetObjectBatchCreateArgs(targetObjectList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchTargetObjectUpdate(List<TargetObject> targetObjectList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareTargetObjectBatchUpdateArgs(targetObjectList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitTargetObjectList(List<TargetObject> targetObjectList){
		
		List<TargetObject> targetObjectCreateList=new ArrayList<TargetObject>();
		List<TargetObject> targetObjectUpdateList=new ArrayList<TargetObject>();
		
		for(TargetObject targetObject: targetObjectList){
			if(isUpdateRequest(targetObject)){
				targetObjectUpdateList.add( targetObject);
				continue;
			}
			targetObjectCreateList.add(targetObject);
		}
		
		return new Object[]{targetObjectCreateList,targetObjectUpdateList};
	}
	
	protected boolean isUpdateRequest(TargetObject targetObject){
 		return targetObject.getVersion() > 0;
 	}
 	protected String getSaveTargetObjectSQL(TargetObject targetObject){
 		if(isUpdateRequest(targetObject)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveTargetObjectParameters(TargetObject targetObject){
 		if(isUpdateRequest(targetObject) ){
 			return prepareTargetObjectUpdateParameters(targetObject);
 		}
 		return prepareTargetObjectCreateParameters(targetObject);
 	}
 	protected Object[] prepareTargetObjectUpdateParameters(TargetObject targetObject){
 		Object[] parameters = new Object[9];
 
 		parameters[0] = targetObject.getName();
 		parameters[1] = targetObject.getLongitude();
 		parameters[2] = targetObject.getLatitude();
 		parameters[3] = targetObject.getHeight();
 		parameters[4] = targetObject.getTextContent();
 		parameters[5] = targetObject.getImagePath();		
 		parameters[6] = targetObject.nextVersion();
 		parameters[7] = targetObject.getId();
 		parameters[8] = targetObject.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareTargetObjectCreateParameters(TargetObject targetObject){
		Object[] parameters = new Object[7];
		String newTargetObjectId=getNextId();
		targetObject.setId(newTargetObjectId);
		parameters[0] =  targetObject.getId();
 
 		parameters[1] = targetObject.getName();
 		parameters[2] = targetObject.getLongitude();
 		parameters[3] = targetObject.getLatitude();
 		parameters[4] = targetObject.getHeight();
 		parameters[5] = targetObject.getTextContent();
 		parameters[6] = targetObject.getImagePath();		
 				
 		return parameters;
 	}
 	
	protected TargetObject saveInternalTargetObject(TargetObject targetObject, Map<String,Object> options){
		
		saveTargetObject(targetObject);

		
		return targetObject;
		
	}
	
	
	
	//======================================================================================
	

	

		

	public TargetObject present(TargetObject targetObject,Map<String, Object> options){
	

		return targetObject;
	
	}
		

	

	protected String getTableName(){
		return TargetObjectTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<TargetObject> targetObjectList) {		
		this.enhanceListInternal(targetObjectList, this.getTargetObjectMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<TargetObject> targetObjectList = ownerEntity.collectRefsWithType(TargetObject.INTERNAL_TYPE);
		this.enhanceList(targetObjectList);
		
	}
	
	@Override
	public SmartList<TargetObject> findTargetObjectWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getTargetObjectMapper());

	}
	@Override
	public int countTargetObjectWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countTargetObjectWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<TargetObject> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getTargetObjectMapper());
	}
}


