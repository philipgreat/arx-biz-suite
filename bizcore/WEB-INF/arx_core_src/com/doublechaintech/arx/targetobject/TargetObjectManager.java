
package com.doublechaintech.arx.targetobject;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.arx.ArxUserContext;
import com.doublechaintech.arx.BaseEntity;
import com.doublechaintech.arx.SmartList;

public interface TargetObjectManager{

		

	public TargetObject createTargetObject(ArxUserContext userContext, String name, BigDecimal longitude, BigDecimal latitude, int height, String textContent, String imagePath, String platformId) throws Exception;	
	public TargetObject updateTargetObject(ArxUserContext userContext,String targetObjectId, int targetObjectVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public TargetObject loadTargetObject(ArxUserContext userContext, String targetObjectId, String [] tokensExpr) throws Exception;
	public TargetObject internalSaveTargetObject(ArxUserContext userContext, TargetObject targetObject) throws Exception;
	public TargetObject internalSaveTargetObject(ArxUserContext userContext, TargetObject targetObject,Map<String,Object>option) throws Exception;
	
	public TargetObject transferToAnotherPlatform(ArxUserContext userContext, String targetObjectId, String anotherPlatformId)  throws Exception;
 

	public void delete(ArxUserContext userContext, String targetObjectId, int version) throws Exception;
	public int deleteAll(ArxUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(ArxUserContext userContext, TargetObject newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


