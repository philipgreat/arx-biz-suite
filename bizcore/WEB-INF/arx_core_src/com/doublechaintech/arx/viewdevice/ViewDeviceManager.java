
package com.doublechaintech.arx.viewdevice;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.arx.ArxUserContext;
import com.doublechaintech.arx.BaseEntity;
import com.doublechaintech.arx.SmartList;

public interface ViewDeviceManager{

		

	public ViewDevice createViewDevice(ArxUserContext userContext, String name, BigDecimal longitude, BigDecimal latitude, int height, String platformId) throws Exception;	
	public ViewDevice updateViewDevice(ArxUserContext userContext,String viewDeviceId, int viewDeviceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ViewDevice loadViewDevice(ArxUserContext userContext, String viewDeviceId, String [] tokensExpr) throws Exception;
	public ViewDevice internalSaveViewDevice(ArxUserContext userContext, ViewDevice viewDevice) throws Exception;
	public ViewDevice internalSaveViewDevice(ArxUserContext userContext, ViewDevice viewDevice,Map<String,Object>option) throws Exception;
	
	public ViewDevice transferToAnotherPlatform(ArxUserContext userContext, String viewDeviceId, String anotherPlatformId)  throws Exception;
 

	public void delete(ArxUserContext userContext, String viewDeviceId, int version) throws Exception;
	public int deleteAll(ArxUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(ArxUserContext userContext, ViewDevice newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


