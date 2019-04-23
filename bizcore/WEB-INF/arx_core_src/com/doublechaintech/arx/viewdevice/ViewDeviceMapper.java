
package com.doublechaintech.arx.viewdevice;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.arx.BaseRowMapper;
import com.doublechaintech.arx.platform.Platform;

public class ViewDeviceMapper extends BaseRowMapper<ViewDevice>{
	
	protected ViewDevice internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		ViewDevice viewDevice = getViewDevice();		
		 		
 		setId(viewDevice, rs, rowNumber); 		
 		setName(viewDevice, rs, rowNumber); 		
 		setLongitude(viewDevice, rs, rowNumber); 		
 		setLatitude(viewDevice, rs, rowNumber); 		
 		setHeight(viewDevice, rs, rowNumber); 		
 		setPlatform(viewDevice, rs, rowNumber); 		
 		setVersion(viewDevice, rs, rowNumber);

		return viewDevice;
	}
	
	protected ViewDevice getViewDevice(){
		return new ViewDevice();
	}		
		
	protected void setId(ViewDevice viewDevice, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(ViewDeviceTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		viewDevice.setId(id);
	}
		
	protected void setName(ViewDevice viewDevice, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(ViewDeviceTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		viewDevice.setName(name);
	}
		
	protected void setLongitude(ViewDevice viewDevice, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		BigDecimal longitude = rs.getBigDecimal(ViewDeviceTable.COLUMN_LONGITUDE);
		if(longitude == null){
			//do nothing when nothing found in database
			return;
		}
		
		viewDevice.setLongitude(longitude);
	}
		
	protected void setLatitude(ViewDevice viewDevice, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		BigDecimal latitude = rs.getBigDecimal(ViewDeviceTable.COLUMN_LATITUDE);
		if(latitude == null){
			//do nothing when nothing found in database
			return;
		}
		
		viewDevice.setLatitude(latitude);
	}
		
	protected void setHeight(ViewDevice viewDevice, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer height = rs.getInt(ViewDeviceTable.COLUMN_HEIGHT);
		if(height == null){
			//do nothing when nothing found in database
			return;
		}
		
		viewDevice.setHeight(height);
	}
		 		
 	protected void setPlatform(ViewDevice viewDevice, ResultSet rs, int rowNumber) throws SQLException{
 		String platformId = rs.getString(ViewDeviceTable.COLUMN_PLATFORM);
 		if( platformId == null){
 			return;
 		}
 		if( platformId.isEmpty()){
 			return;
 		}
 		Platform platform = viewDevice.getPlatform();
 		if( platform != null ){
 			//if the root object 'viewDevice' already have the property, just set the id for it;
 			platform.setId(platformId);
 			
 			return;
 		}
 		viewDevice.setPlatform(createEmptyPlatform(platformId));
 	}
 	
	protected void setVersion(ViewDevice viewDevice, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(ViewDeviceTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		viewDevice.setVersion(version);
	}
		
		

 	protected Platform  createEmptyPlatform(String platformId){
 		Platform platform = new Platform();
 		platform.setId(platformId);
 		platform.setVersion(Integer.MAX_VALUE);
 		return platform;
 	}
 	
}


