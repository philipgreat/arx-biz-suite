
package com.doublechaintech.arx.targetobject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.arx.BaseRowMapper;
import com.doublechaintech.arx.platform.Platform;

public class TargetObjectMapper extends BaseRowMapper<TargetObject>{
	
	protected TargetObject internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		TargetObject targetObject = getTargetObject();		
		 		
 		setId(targetObject, rs, rowNumber); 		
 		setName(targetObject, rs, rowNumber); 		
 		setLongitude(targetObject, rs, rowNumber); 		
 		setLatitude(targetObject, rs, rowNumber); 		
 		setHeight(targetObject, rs, rowNumber); 		
 		setTextContent(targetObject, rs, rowNumber); 		
 		setImagePath(targetObject, rs, rowNumber); 		
 		setPlatform(targetObject, rs, rowNumber); 		
 		setCreateTime(targetObject, rs, rowNumber); 		
 		setVersion(targetObject, rs, rowNumber);

		return targetObject;
	}
	
	protected TargetObject getTargetObject(){
		return new TargetObject();
	}		
		
	protected void setId(TargetObject targetObject, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(TargetObjectTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		targetObject.setId(id);
	}
		
	protected void setName(TargetObject targetObject, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(TargetObjectTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		targetObject.setName(name);
	}
		
	protected void setLongitude(TargetObject targetObject, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		BigDecimal longitude = rs.getBigDecimal(TargetObjectTable.COLUMN_LONGITUDE);
		if(longitude == null){
			//do nothing when nothing found in database
			return;
		}
		
		targetObject.setLongitude(longitude);
	}
		
	protected void setLatitude(TargetObject targetObject, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		BigDecimal latitude = rs.getBigDecimal(TargetObjectTable.COLUMN_LATITUDE);
		if(latitude == null){
			//do nothing when nothing found in database
			return;
		}
		
		targetObject.setLatitude(latitude);
	}
		
	protected void setHeight(TargetObject targetObject, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer height = rs.getInt(TargetObjectTable.COLUMN_HEIGHT);
		if(height == null){
			//do nothing when nothing found in database
			return;
		}
		
		targetObject.setHeight(height);
	}
		
	protected void setTextContent(TargetObject targetObject, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String textContent = rs.getString(TargetObjectTable.COLUMN_TEXT_CONTENT);
		if(textContent == null){
			//do nothing when nothing found in database
			return;
		}
		
		targetObject.setTextContent(textContent);
	}
		
	protected void setImagePath(TargetObject targetObject, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String imagePath = rs.getString(TargetObjectTable.COLUMN_IMAGE_PATH);
		if(imagePath == null){
			//do nothing when nothing found in database
			return;
		}
		
		targetObject.setImagePath(imagePath);
	}
		 		
 	protected void setPlatform(TargetObject targetObject, ResultSet rs, int rowNumber) throws SQLException{
 		String platformId = rs.getString(TargetObjectTable.COLUMN_PLATFORM);
 		if( platformId == null){
 			return;
 		}
 		if( platformId.isEmpty()){
 			return;
 		}
 		Platform platform = targetObject.getPlatform();
 		if( platform != null ){
 			//if the root object 'targetObject' already have the property, just set the id for it;
 			platform.setId(platformId);
 			
 			return;
 		}
 		targetObject.setPlatform(createEmptyPlatform(platformId));
 	}
 	
	protected void setCreateTime(TargetObject targetObject, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date createTime = rs.getTimestamp(TargetObjectTable.COLUMN_CREATE_TIME);
		if(createTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		targetObject.setCreateTime(convertToDateTime(createTime));
	}
		
	protected void setVersion(TargetObject targetObject, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(TargetObjectTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		targetObject.setVersion(version);
	}
		
		

 	protected Platform  createEmptyPlatform(String platformId){
 		Platform platform = new Platform();
 		platform.setId(platformId);
 		platform.setVersion(Integer.MAX_VALUE);
 		return platform;
 	}
 	
}


