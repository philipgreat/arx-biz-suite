package com.doublechaintech.arx.platform;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.arx.ArxObjectPlainCustomSerializer;
public class PlatformSerializer extends ArxObjectPlainCustomSerializer<Platform>{

	@Override
	public void serialize(Platform platform, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, platform, provider);
		
	}
}


