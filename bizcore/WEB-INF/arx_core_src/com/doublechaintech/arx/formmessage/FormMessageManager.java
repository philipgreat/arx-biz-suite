
package com.doublechaintech.arx.formmessage;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.arx.ArxUserContext;
import com.doublechaintech.arx.BaseEntity;
import com.doublechaintech.arx.SmartList;

public interface FormMessageManager{

		

	public FormMessage createFormMessage(ArxUserContext userContext, String title, String formId, String level) throws Exception;	
	public FormMessage updateFormMessage(ArxUserContext userContext,String formMessageId, int formMessageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FormMessage loadFormMessage(ArxUserContext userContext, String formMessageId, String [] tokensExpr) throws Exception;
	public FormMessage internalSaveFormMessage(ArxUserContext userContext, FormMessage formMessage) throws Exception;
	public FormMessage internalSaveFormMessage(ArxUserContext userContext, FormMessage formMessage,Map<String,Object>option) throws Exception;
	
	public FormMessage transferToAnotherForm(ArxUserContext userContext, String formMessageId, String anotherFormId)  throws Exception;
 

	public void delete(ArxUserContext userContext, String formMessageId, int version) throws Exception;
	public int deleteAll(ArxUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(ArxUserContext userContext, FormMessage newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


