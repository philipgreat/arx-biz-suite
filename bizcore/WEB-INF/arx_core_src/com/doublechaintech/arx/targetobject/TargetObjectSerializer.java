package com.doublechaintech.arx.targetobject;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.arx.ArxObjectPlainCustomSerializer;
public class TargetObjectSerializer extends ArxObjectPlainCustomSerializer<TargetObject>{

	@Override
	public void serialize(TargetObject targetObject, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, targetObject, provider);
		
	}
}


