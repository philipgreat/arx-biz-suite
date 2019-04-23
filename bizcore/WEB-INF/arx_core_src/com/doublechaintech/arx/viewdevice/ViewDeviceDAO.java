
package com.doublechaintech.arx.viewdevice;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.arx.BaseEntity;
import com.doublechaintech.arx.SmartList;
import com.doublechaintech.arx.MultipleAccessKey;
import com.doublechaintech.arx.ArxUserContext;
import com.doublechaintech.arx.platform.PlatformDAO;


public interface ViewDeviceDAO{

	
	public ViewDevice load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ViewDevice> viewDeviceList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ViewDevice present(ViewDevice viewDevice,Map<String,Object> options) throws Exception;
	public ViewDevice clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ViewDevice save(ViewDevice viewDevice,Map<String,Object> options);
	public SmartList<ViewDevice> saveViewDeviceList(SmartList<ViewDevice> viewDeviceList,Map<String,Object> options);
	public SmartList<ViewDevice> removeViewDeviceList(SmartList<ViewDevice> viewDeviceList,Map<String,Object> options);
	public SmartList<ViewDevice> findViewDeviceWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countViewDeviceWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countViewDeviceWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String viewDeviceId, int version) throws Exception;
	public ViewDevice disconnectFromAll(String viewDeviceId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<ViewDevice> queryList(String sql, Object ... parmeters);
 
 	public SmartList<ViewDevice> findViewDeviceByPlatform(String platformId, Map<String,Object> options);
 	public int countViewDeviceByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countViewDeviceByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<ViewDevice> findViewDeviceByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeViewDeviceByPlatform(SmartList<ViewDevice> resultList, String platformId, Map<String,Object> options);

 
 }


