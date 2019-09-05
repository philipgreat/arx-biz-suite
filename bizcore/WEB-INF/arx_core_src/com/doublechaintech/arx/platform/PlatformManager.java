
package com.doublechaintech.arx.platform;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.arx.ArxUserContext;
import com.doublechaintech.arx.BaseEntity;
import com.doublechaintech.arx.SmartList;

public interface PlatformManager{

		

	public Platform createPlatform(ArxUserContext userContext, String name, String description) throws Exception;	
	public Platform updatePlatform(ArxUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Platform loadPlatform(ArxUserContext userContext, String platformId, String [] tokensExpr) throws Exception;
	public Platform internalSavePlatform(ArxUserContext userContext, Platform platform) throws Exception;
	public Platform internalSavePlatform(ArxUserContext userContext, Platform platform,Map<String,Object>option) throws Exception;
	


	public void delete(ArxUserContext userContext, String platformId, int version) throws Exception;
	public int deleteAll(ArxUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(ArxUserContext userContext, Platform newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  TargetObjectManager getTargetObjectManager(ArxUserContext userContext, String platformId, String name, BigDecimal longitude, BigDecimal latitude, int height, String textContent, String imagePath ,String [] tokensExpr)  throws Exception;
	
	public  Platform addTargetObject(ArxUserContext userContext, String platformId, String name, BigDecimal longitude, BigDecimal latitude, int height, String textContent, String imagePath , String [] tokensExpr)  throws Exception;
	public  Platform removeTargetObject(ArxUserContext userContext, String platformId, String targetObjectId, int targetObjectVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateTargetObject(ArxUserContext userContext, String platformId, String targetObjectId, int targetObjectVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ViewDeviceManager getViewDeviceManager(ArxUserContext userContext, String platformId, String name, BigDecimal longitude, BigDecimal latitude, int height ,String [] tokensExpr)  throws Exception;
	
	public  Platform addViewDevice(ArxUserContext userContext, String platformId, String name, BigDecimal longitude, BigDecimal latitude, int height , String [] tokensExpr)  throws Exception;
	public  Platform removeViewDevice(ArxUserContext userContext, String platformId, String viewDeviceId, int viewDeviceVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateViewDevice(ArxUserContext userContext, String platformId, String viewDeviceId, int viewDeviceVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


