
package com.doublechaintech.arx.platform;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.arx.BaseEntity;
import com.doublechaintech.arx.SmartList;
import com.doublechaintech.arx.MultipleAccessKey;
import com.doublechaintech.arx.ArxUserContext;
import com.doublechaintech.arx.viewdevice.ViewDeviceDAO;
import com.doublechaintech.arx.targetobject.TargetObjectDAO;


public interface PlatformDAO{

	
	public Platform load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Platform> platformList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Platform present(Platform platform,Map<String,Object> options) throws Exception;
	public Platform clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Platform save(Platform platform,Map<String,Object> options);
	public SmartList<Platform> savePlatformList(SmartList<Platform> platformList,Map<String,Object> options);
	public SmartList<Platform> removePlatformList(SmartList<Platform> platformList,Map<String,Object> options);
	public SmartList<Platform> findPlatformWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countPlatformWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countPlatformWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String platformId, int version) throws Exception;
	public Platform disconnectFromAll(String platformId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public TargetObjectDAO getTargetObjectDAO();
		
	public ViewDeviceDAO getViewDeviceDAO();
		
	
 	public SmartList<Platform> requestCandidatePlatformForTargetObject(ArxUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForViewDevice(ArxUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Platform planToRemoveTargetObjectList(Platform platform, String targetObjectIds[], Map<String,Object> options)throws Exception;


	public Platform planToRemoveViewDeviceList(Platform platform, String viewDeviceIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<Platform> queryList(String sql, Object ... parmeters);
}


