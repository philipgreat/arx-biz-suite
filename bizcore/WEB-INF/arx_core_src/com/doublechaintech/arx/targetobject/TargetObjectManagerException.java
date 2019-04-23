
package com.doublechaintech.arx.targetobject;
//import com.doublechaintech.arx.EntityNotFoundException;
import com.doublechaintech.arx.ArxException;
import com.doublechaintech.arx.Message;
import java.util.List;

public class TargetObjectManagerException extends ArxException {
	private static final long serialVersionUID = 1L;
	public TargetObjectManagerException(String string) {
		super(string);
	}
	public TargetObjectManagerException(Message message) {
		super(message);
	}
	public TargetObjectManagerException(List<Message> messageList) {
		super(messageList);
	}

}


