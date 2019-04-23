package com.doublechaintech.arx.listaccess;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.arx.ArxObjectPlainCustomSerializer;
public class ListAccessSerializer extends ArxObjectPlainCustomSerializer<ListAccess>{

	@Override
	public void serialize(ListAccess listAccess, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, listAccess, provider);
		
	}
}


