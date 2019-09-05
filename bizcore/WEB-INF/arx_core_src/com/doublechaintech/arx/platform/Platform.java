
package com.doublechaintech.arx.platform;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.arx.BaseEntity;
import com.doublechaintech.arx.SmartList;
import com.doublechaintech.arx.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.arx.viewdevice.ViewDevice;
import com.doublechaintech.arx.targetobject.TargetObject;

@JsonSerialize(using = PlatformSerializer.class)
public class Platform extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String TARGET_OBJECT_LIST                       = "targetObjectList"  ;
	public static final String VIEW_DEVICE_LIST                         = "viewDeviceList"    ;

	public static final String INTERNAL_TYPE="Platform";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getName();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		String              	mDescription        ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<TargetObject>	mTargetObjectList   ;
	protected		SmartList<ViewDevice>	mViewDeviceList     ;
	
		
	public 	Platform(){
		// lazy load for all the properties
	}
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
	}
	
	public 	Platform(String name, String description)
	{
		setName(name);
		setDescription(description);

		this.mTargetObjectList = new SmartList<TargetObject>();
		this.mViewDeviceList = new SmartList<ViewDevice>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			changeDescriptionProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeNameProperty(String newValueExpr){
		String oldValue = getName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateName(newValue);
		this.onChangeProperty(NAME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeDescriptionProperty(String newValueExpr){
		String oldValue = getDescription();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateDescription(newValue);
		this.onChangeProperty(DESCRIPTION_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public Platform updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	public Platform updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setDescription(String description){
		this.mDescription = description;;
	}
	public String getDescription(){
		return this.mDescription;
	}
	public Platform updateDescription(String description){
		this.mDescription = description;;
		this.changed = true;
		return this;
	}
	public void mergeDescription(String description){
		if(description != null) { setDescription(description);}
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Platform updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<TargetObject> getTargetObjectList(){
		if(this.mTargetObjectList == null){
			this.mTargetObjectList = new SmartList<TargetObject>();
			this.mTargetObjectList.setListInternalName (TARGET_OBJECT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mTargetObjectList;	
	}
	public  void setTargetObjectList(SmartList<TargetObject> targetObjectList){
		for( TargetObject targetObject:targetObjectList){
			targetObject.setPlatform(this);
		}

		this.mTargetObjectList = targetObjectList;
		this.mTargetObjectList.setListInternalName (TARGET_OBJECT_LIST );
		
	}
	
	public  void addTargetObject(TargetObject targetObject){
		targetObject.setPlatform(this);
		getTargetObjectList().add(targetObject);
	}
	public  void addTargetObjectList(SmartList<TargetObject> targetObjectList){
		for( TargetObject targetObject:targetObjectList){
			targetObject.setPlatform(this);
		}
		getTargetObjectList().addAll(targetObjectList);
	}
	public  void mergeTargetObjectList(SmartList<TargetObject> targetObjectList){
		if(targetObjectList==null){
			return;
		}
		if(targetObjectList.isEmpty()){
			return;
		}
		addTargetObjectList( targetObjectList );
		
	}
	public  TargetObject removeTargetObject(TargetObject targetObjectIndex){
		
		int index = getTargetObjectList().indexOf(targetObjectIndex);
        if(index < 0){
        	String message = "TargetObject("+targetObjectIndex.getId()+") with version='"+targetObjectIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        TargetObject targetObject = getTargetObjectList().get(index);        
        // targetObject.clearPlatform(); //disconnect with Platform
        targetObject.clearFromAll(); //disconnect with Platform
		
		boolean result = getTargetObjectList().planToRemove(targetObject);
        if(!result){
        	String message = "TargetObject("+targetObjectIndex.getId()+") with version='"+targetObjectIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return targetObject;
        
	
	}
	//断舍离
	public  void breakWithTargetObject(TargetObject targetObject){
		
		if(targetObject == null){
			return;
		}
		targetObject.setPlatform(null);
		//getTargetObjectList().remove();
	
	}
	
	public  boolean hasTargetObject(TargetObject targetObject){
	
		return getTargetObjectList().contains(targetObject);
  
	}
	
	public void copyTargetObjectFrom(TargetObject targetObject) {

		TargetObject targetObjectInList = findTheTargetObject(targetObject);
		TargetObject newTargetObject = new TargetObject();
		targetObjectInList.copyTo(newTargetObject);
		newTargetObject.setVersion(0);//will trigger copy
		getTargetObjectList().add(newTargetObject);
		addItemToFlexiableObject(COPIED_CHILD, newTargetObject);
	}
	
	public  TargetObject findTheTargetObject(TargetObject targetObject){
		
		int index =  getTargetObjectList().indexOf(targetObject);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "TargetObject("+targetObject.getId()+") with version='"+targetObject.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getTargetObjectList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTargetObjectList(){
		getTargetObjectList().clear();
	}
	
	
	


	public  SmartList<ViewDevice> getViewDeviceList(){
		if(this.mViewDeviceList == null){
			this.mViewDeviceList = new SmartList<ViewDevice>();
			this.mViewDeviceList.setListInternalName (VIEW_DEVICE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mViewDeviceList;	
	}
	public  void setViewDeviceList(SmartList<ViewDevice> viewDeviceList){
		for( ViewDevice viewDevice:viewDeviceList){
			viewDevice.setPlatform(this);
		}

		this.mViewDeviceList = viewDeviceList;
		this.mViewDeviceList.setListInternalName (VIEW_DEVICE_LIST );
		
	}
	
	public  void addViewDevice(ViewDevice viewDevice){
		viewDevice.setPlatform(this);
		getViewDeviceList().add(viewDevice);
	}
	public  void addViewDeviceList(SmartList<ViewDevice> viewDeviceList){
		for( ViewDevice viewDevice:viewDeviceList){
			viewDevice.setPlatform(this);
		}
		getViewDeviceList().addAll(viewDeviceList);
	}
	public  void mergeViewDeviceList(SmartList<ViewDevice> viewDeviceList){
		if(viewDeviceList==null){
			return;
		}
		if(viewDeviceList.isEmpty()){
			return;
		}
		addViewDeviceList( viewDeviceList );
		
	}
	public  ViewDevice removeViewDevice(ViewDevice viewDeviceIndex){
		
		int index = getViewDeviceList().indexOf(viewDeviceIndex);
        if(index < 0){
        	String message = "ViewDevice("+viewDeviceIndex.getId()+") with version='"+viewDeviceIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        ViewDevice viewDevice = getViewDeviceList().get(index);        
        // viewDevice.clearPlatform(); //disconnect with Platform
        viewDevice.clearFromAll(); //disconnect with Platform
		
		boolean result = getViewDeviceList().planToRemove(viewDevice);
        if(!result){
        	String message = "ViewDevice("+viewDeviceIndex.getId()+") with version='"+viewDeviceIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return viewDevice;
        
	
	}
	//断舍离
	public  void breakWithViewDevice(ViewDevice viewDevice){
		
		if(viewDevice == null){
			return;
		}
		viewDevice.setPlatform(null);
		//getViewDeviceList().remove();
	
	}
	
	public  boolean hasViewDevice(ViewDevice viewDevice){
	
		return getViewDeviceList().contains(viewDevice);
  
	}
	
	public void copyViewDeviceFrom(ViewDevice viewDevice) {

		ViewDevice viewDeviceInList = findTheViewDevice(viewDevice);
		ViewDevice newViewDevice = new ViewDevice();
		viewDeviceInList.copyTo(newViewDevice);
		newViewDevice.setVersion(0);//will trigger copy
		getViewDeviceList().add(newViewDevice);
		addItemToFlexiableObject(COPIED_CHILD, newViewDevice);
	}
	
	public  ViewDevice findTheViewDevice(ViewDevice viewDevice){
		
		int index =  getViewDeviceList().indexOf(viewDevice);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "ViewDevice("+viewDevice.getId()+") with version='"+viewDevice.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getViewDeviceList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpViewDeviceList(){
		getViewDeviceList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){


		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getTargetObjectList(), internalType);
		collectFromList(this, entityList, getViewDeviceList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getTargetObjectList());
		listOfList.add( getViewDeviceList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, TARGET_OBJECT_LIST, getTargetObjectList());
		if(!getTargetObjectList().isEmpty()){
			appendKeyValuePair(result, "targetObjectCount", getTargetObjectList().getTotalCount());
			appendKeyValuePair(result, "targetObjectCurrentPageNumber", getTargetObjectList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, VIEW_DEVICE_LIST, getViewDeviceList());
		if(!getViewDeviceList().isEmpty()){
			appendKeyValuePair(result, "viewDeviceCount", getViewDeviceList().getTotalCount());
			appendKeyValuePair(result, "viewDeviceCurrentPageNumber", getViewDeviceList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Platform){
		
		
			Platform dest =(Platform)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setDescription(getDescription());
			dest.setVersion(getVersion());
			dest.setTargetObjectList(getTargetObjectList());
			dest.setViewDeviceList(getViewDeviceList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Platform){
		
			
			Platform dest =(Platform)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeDescription(getDescription());
			dest.mergeVersion(getVersion());
			dest.mergeTargetObjectList(getTargetObjectList());
			dest.mergeViewDeviceList(getViewDeviceList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Platform{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

