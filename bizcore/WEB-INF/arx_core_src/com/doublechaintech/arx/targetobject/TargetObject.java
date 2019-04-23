
package com.doublechaintech.arx.targetobject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.arx.BaseEntity;
import com.doublechaintech.arx.SmartList;
import com.doublechaintech.arx.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = TargetObjectSerializer.class)
public class TargetObject extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String LONGITUDE_PROPERTY             = "longitude"         ;
	public static final String LATITUDE_PROPERTY              = "latitude"          ;
	public static final String HEIGHT_PROPERTY                = "height"            ;
	public static final String TEXT_CONTENT_PROPERTY          = "textContent"       ;
	public static final String IMAGE_PATH_PROPERTY            = "imagePath"         ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="TargetObject";
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
	protected		BigDecimal          	mLongitude          ;
	protected		BigDecimal          	mLatitude           ;
	protected		int                 	mHeight             ;
	protected		String              	mTextContent        ;
	protected		String              	mImagePath          ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	TargetObject(){
		// lazy load for all the properties
	}
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
	}
	
	public 	TargetObject(String name, BigDecimal longitude, BigDecimal latitude, int height, String textContent, String imagePath)
	{
		setName(name);
		setLongitude(longitude);
		setLatitude(latitude);
		setHeight(height);
		setTextContent(textContent);
		setImagePath(imagePath);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(LONGITUDE_PROPERTY.equals(property)){
			changeLongitudeProperty(newValueExpr);
		}
		if(LATITUDE_PROPERTY.equals(property)){
			changeLatitudeProperty(newValueExpr);
		}
		if(HEIGHT_PROPERTY.equals(property)){
			changeHeightProperty(newValueExpr);
		}
		if(TEXT_CONTENT_PROPERTY.equals(property)){
			changeTextContentProperty(newValueExpr);
		}
		if(IMAGE_PATH_PROPERTY.equals(property)){
			changeImagePathProperty(newValueExpr);
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
			
			
			
	protected void changeLongitudeProperty(String newValueExpr){
		BigDecimal oldValue = getLongitude();
		BigDecimal newValue = parseBigDecimal(newValueExpr);
		if(equalsBigDecimal(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLongitude(newValue);
		this.onChangeProperty(LONGITUDE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeLatitudeProperty(String newValueExpr){
		BigDecimal oldValue = getLatitude();
		BigDecimal newValue = parseBigDecimal(newValueExpr);
		if(equalsBigDecimal(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLatitude(newValue);
		this.onChangeProperty(LATITUDE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeHeightProperty(String newValueExpr){
		int oldValue = getHeight();
		int newValue = parseInt(newValueExpr);
		if(equalsInt(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateHeight(newValue);
		this.onChangeProperty(HEIGHT_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeTextContentProperty(String newValueExpr){
		String oldValue = getTextContent();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateTextContent(newValue);
		this.onChangeProperty(TEXT_CONTENT_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeImagePathProperty(String newValueExpr){
		String oldValue = getImagePath();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateImagePath(newValue);
		this.onChangeProperty(IMAGE_PATH_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public TargetObject updateId(String id){
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
	public TargetObject updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setLongitude(BigDecimal longitude){
		this.mLongitude = longitude;;
	}
	public BigDecimal getLongitude(){
		return this.mLongitude;
	}
	public TargetObject updateLongitude(BigDecimal longitude){
		this.mLongitude = longitude;;
		this.changed = true;
		return this;
	}
	public void mergeLongitude(BigDecimal longitude){
		setLongitude(longitude);
	}
	
	
	public void setLatitude(BigDecimal latitude){
		this.mLatitude = latitude;;
	}
	public BigDecimal getLatitude(){
		return this.mLatitude;
	}
	public TargetObject updateLatitude(BigDecimal latitude){
		this.mLatitude = latitude;;
		this.changed = true;
		return this;
	}
	public void mergeLatitude(BigDecimal latitude){
		setLatitude(latitude);
	}
	
	
	public void setHeight(int height){
		this.mHeight = height;;
	}
	public int getHeight(){
		return this.mHeight;
	}
	public TargetObject updateHeight(int height){
		this.mHeight = height;;
		this.changed = true;
		return this;
	}
	public void mergeHeight(int height){
		setHeight(height);
	}
	
	
	public void setTextContent(String textContent){
		this.mTextContent = trimString(textContent);;
	}
	public String getTextContent(){
		return this.mTextContent;
	}
	public TargetObject updateTextContent(String textContent){
		this.mTextContent = trimString(textContent);;
		this.changed = true;
		return this;
	}
	public void mergeTextContent(String textContent){
		if(textContent != null) { setTextContent(textContent);}
	}
	
	
	public void setImagePath(String imagePath){
		this.mImagePath = trimString(imagePath);;
	}
	public String getImagePath(){
		return this.mImagePath;
	}
	public TargetObject updateImagePath(String imagePath){
		this.mImagePath = trimString(imagePath);;
		this.changed = true;
		return this;
	}
	public void mergeImagePath(String imagePath){
		if(imagePath != null) { setImagePath(imagePath);}
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public TargetObject updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){


		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, LONGITUDE_PROPERTY, getLongitude());
		appendKeyValuePair(result, LATITUDE_PROPERTY, getLatitude());
		appendKeyValuePair(result, HEIGHT_PROPERTY, getHeight());
		appendKeyValuePair(result, TEXT_CONTENT_PROPERTY, getTextContent());
		appendKeyValuePair(result, IMAGE_PATH_PROPERTY, getImagePath());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof TargetObject){
		
		
			TargetObject dest =(TargetObject)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setLongitude(getLongitude());
			dest.setLatitude(getLatitude());
			dest.setHeight(getHeight());
			dest.setTextContent(getTextContent());
			dest.setImagePath(getImagePath());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof TargetObject){
		
			
			TargetObject dest =(TargetObject)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeLongitude(getLongitude());
			dest.mergeLatitude(getLatitude());
			dest.mergeHeight(getHeight());
			dest.mergeTextContent(getTextContent());
			dest.mergeImagePath(getImagePath());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("TargetObject{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tlongitude='"+getLongitude()+"';");
		stringBuilder.append("\tlatitude='"+getLatitude()+"';");
		stringBuilder.append("\theight='"+getHeight()+"';");
		stringBuilder.append("\ttextContent='"+getTextContent()+"';");
		stringBuilder.append("\timagePath='"+getImagePath()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	
	public void increaseHeight(int incHeight){
		updateHeight(this.mHeight +  incHeight);
	}
	public void decreaseHeight(int decHeight){
		updateHeight(this.mHeight - decHeight);
	}
	

}

