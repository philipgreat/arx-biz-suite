
package com.doublechaintech.arx.targetobject;
import com.doublechaintech.arx.CommonTokens;
import java.util.Map;
public class TargetObjectTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="targetObject";
	
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
	protected TargetObjectTokens(){
		//ensure not initialized outside the class
	}
	public  static  TargetObjectTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		TargetObjectTokens tokens = new TargetObjectTokens(options);
		return tokens;
		
	}
	protected TargetObjectTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public TargetObjectTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static TargetObjectTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected TargetObjectTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static TargetObjectTokens start(){
		return new TargetObjectTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static TargetObjectTokens allTokens(){
		
		return start();
	
	}
	public static TargetObjectTokens withoutListsTokens(){
		
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
	
	public TargetObjectTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	
	public  TargetObjectTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

