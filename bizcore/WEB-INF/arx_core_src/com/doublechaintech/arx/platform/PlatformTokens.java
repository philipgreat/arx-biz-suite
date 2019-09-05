
package com.doublechaintech.arx.platform;
import com.doublechaintech.arx.CommonTokens;
import java.util.Map;
public class PlatformTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="platform";
	
	public static boolean checkOptions(Map<String,Object> options, String optionToCheck){
		
		if(options==null){
 			return false; //completely no option here
 		}
 		if(options.containsKey(ALL)){
 			//danger, debug only, might load the entire database!, really terrible
 			return true;
 		}
		String ownerKey = getOwnerObjectKey();
		Object ownerObject =(String) options.get(ownerKey);
		if(ownerObject ==  null){
			return false;
		}
		if(!ownerObject.equals(OWNER_OBJECT_NAME)){ //is the owner? 
			return false; 
		}
		
 		if(options.containsKey(optionToCheck)){
 			//options.remove(optionToCheck);
 			//consume the key, can not use any more to extract the data with the same token.			
 			return true;
 		}
 		
 		return false;
	
	}
	protected PlatformTokens(){
		//ensure not initialized outside the class
	}
	public  static  PlatformTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		PlatformTokens tokens = new PlatformTokens(options);
		return tokens;
		
	}
	protected PlatformTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public PlatformTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static PlatformTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected PlatformTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static PlatformTokens start(){
		return new PlatformTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static PlatformTokens allTokens(){
		
		return start()
			.withTargetObjectList()
			.withViewDeviceList();
	
	}
	public static PlatformTokens withoutListsTokens(){
		
		return start();
	
	}
	
	public static Map <String,Object> all(){
		return allTokens().done();
	}
	public static Map <String,Object> withoutLists(){
		return withoutListsTokens().done();
	}
	public static Map <String,Object> empty(){
		return start().done();
	}
	
	public PlatformTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String TARGET_OBJECT_LIST = "targetObjectList";
	public String getTargetObjectList(){
		return TARGET_OBJECT_LIST;
	}
	public PlatformTokens withTargetObjectList(){		
		addSimpleOptions(TARGET_OBJECT_LIST);
		return this;
	}
	public PlatformTokens analyzeTargetObjectList(){		
		addSimpleOptions(TARGET_OBJECT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeTargetObjectListEnabled(){		
		
		if(checkOptions(this.options(), TARGET_OBJECT_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public PlatformTokens extractMoreFromTargetObjectList(String idsSeperatedWithComma){		
		addSimpleOptions(TARGET_OBJECT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int targetObjectListSortCounter = 0;
	public PlatformTokens sortTargetObjectListWith(String field, String descOrAsc){		
		addSortMoreOptions(TARGET_OBJECT_LIST,targetObjectListSortCounter++, field, descOrAsc);
		return this;
	}
	private int targetObjectListSearchCounter = 0;
	public PlatformTokens searchTargetObjectListWith(String field, String verb, String value){		
		addSearchMoreOptions(TARGET_OBJECT_LIST,targetObjectListSearchCounter++, field, verb, value);
		return this;
	}
	
	public PlatformTokens searchAllTextOfTargetObjectList(String verb, String value){	
		String field = "id|name|textContent";
		addSearchMoreOptions(TARGET_OBJECT_LIST,targetObjectListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfTargetObjectList(int rowsPerPage){		
		addSimpleOptions(TARGET_OBJECT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfTargetObjectList(int currentPageNumber){		
		addSimpleOptions(TARGET_OBJECT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfTargetObjectList(String[] columns){		
		addSimpleOptions(TARGET_OBJECT_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfTargetObjectList(String[] columns){		
		addSimpleOptions(TARGET_OBJECT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String VIEW_DEVICE_LIST = "viewDeviceList";
	public String getViewDeviceList(){
		return VIEW_DEVICE_LIST;
	}
	public PlatformTokens withViewDeviceList(){		
		addSimpleOptions(VIEW_DEVICE_LIST);
		return this;
	}
	public PlatformTokens analyzeViewDeviceList(){		
		addSimpleOptions(VIEW_DEVICE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeViewDeviceListEnabled(){		
		
		if(checkOptions(this.options(), VIEW_DEVICE_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public PlatformTokens extractMoreFromViewDeviceList(String idsSeperatedWithComma){		
		addSimpleOptions(VIEW_DEVICE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int viewDeviceListSortCounter = 0;
	public PlatformTokens sortViewDeviceListWith(String field, String descOrAsc){		
		addSortMoreOptions(VIEW_DEVICE_LIST,viewDeviceListSortCounter++, field, descOrAsc);
		return this;
	}
	private int viewDeviceListSearchCounter = 0;
	public PlatformTokens searchViewDeviceListWith(String field, String verb, String value){		
		addSearchMoreOptions(VIEW_DEVICE_LIST,viewDeviceListSearchCounter++, field, verb, value);
		return this;
	}
	
	public PlatformTokens searchAllTextOfViewDeviceList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(VIEW_DEVICE_LIST,viewDeviceListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfViewDeviceList(int rowsPerPage){		
		addSimpleOptions(VIEW_DEVICE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfViewDeviceList(int currentPageNumber){		
		addSimpleOptions(VIEW_DEVICE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfViewDeviceList(String[] columns){		
		addSimpleOptions(VIEW_DEVICE_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfViewDeviceList(String[] columns){		
		addSimpleOptions(VIEW_DEVICE_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  PlatformTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfTargetObjectList(verb, value);	
		searchAllTextOfViewDeviceList(verb, value);	
		return this;
	}
}

