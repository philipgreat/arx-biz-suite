
package com.doublechaintech.arx.formaction;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.arx.ArxUserContext;
import com.doublechaintech.arx.BaseEntity;
import com.doublechaintech.arx.SmartList;

public interface FormActionManager{

		

	public FormAction createFormAction(ArxUserContext userContext, String label, String localeKey, String actionKey, String level, String url, String formId) throws Exception;	
	public FormAction updateFormAction(ArxUserContext userContext,String formActionId, int formActionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FormAction loadFormAction(ArxUserContext userContext, String formActionId, String [] tokensExpr) throws Exception;
	public FormAction internalSaveFormAction(ArxUserContext userContext, FormAction formAction) throws Exception;
	public FormAction internalSaveFormAction(ArxUserContext userContext, FormAction formAction,Map<String,Object>option) throws Exception;
	
	public FormAction transferToAnotherForm(ArxUserContext userContext, String formActionId, String anotherFormId)  throws Exception;
 

	public void delete(ArxUserContext userContext, String formActionId, int version) throws Exception;
	public int deleteAll(ArxUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(ArxUserContext userContext, FormAction newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}














