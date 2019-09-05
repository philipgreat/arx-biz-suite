
package com.doublechaintech.arx.targetobject;
import com.doublechaintech.arx.AccessKey;


public class TargetObjectTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="target_object_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_LONGITUDE = "longitude";
	static final String COLUMN_LATITUDE = "latitude";
	static final String COLUMN_HEIGHT = "height";
	static final String COLUMN_TEXT_CONTENT = "text_content";
	static final String COLUMN_IMAGE_PATH = "image_path";
	static final String COLUMN_PLATFORM = "platform";
	static final String COLUMN_CREATE_TIME = "create_time";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_NAME, COLUMN_LONGITUDE, COLUMN_LATITUDE, COLUMN_HEIGHT, COLUMN_TEXT_CONTENT, COLUMN_IMAGE_PATH, COLUMN_PLATFORM, COLUMN_CREATE_TIME, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_NAME, COLUMN_LONGITUDE, COLUMN_LATITUDE, COLUMN_HEIGHT, COLUMN_TEXT_CONTENT, COLUMN_IMAGE_PATH, COLUMN_PLATFORM, COLUMN_CREATE_TIME
		};
	
	
}


