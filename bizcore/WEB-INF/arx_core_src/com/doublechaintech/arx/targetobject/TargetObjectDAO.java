
package com.doublechaintech.arx.targetobject;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.arx.BaseEntity;
import com.doublechaintech.arx.SmartList;
import com.doublechaintech.arx.MultipleAccessKey;
import com.doublechaintech.arx.ArxUserContext;


public interface TargetObjectDAO{

	
	public TargetObject load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<TargetObject> targetObjectList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public TargetObject present(TargetObject targetObject,Map<String,Object> options) throws Exception;
	public TargetObject clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public TargetObject save(TargetObject targetObject,Map<String,Object> options);
	public SmartList<TargetObject> saveTargetObjectList(SmartList<TargetObject> targetObjectList,Map<String,Object> options);
	public SmartList<TargetObject> removeTargetObjectList(SmartList<TargetObject> targetObjectList,Map<String,Object> options);
	public SmartList<TargetObject> findTargetObjectWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countTargetObjectWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countTargetObjectWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String targetObjectId, int version) throws Exception;
	public TargetObject disconnectFromAll(String targetObjectId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<TargetObject> queryList(String sql, Object ... parmeters);
}


