
package com.doublechaintech.arx.secuser;
//import com.doublechaintech.arx.EntityNotFoundException;
import com.doublechaintech.arx.ArxException;
import com.doublechaintech.arx.Message;
import java.util.List;

public class SecUserManagerException extends ArxException {
	private static final long serialVersionUID = 1L;
	public SecUserManagerException(String string) {
		super(string);
	}
	public SecUserManagerException(Message message) {
		super(message);
	}
	public SecUserManagerException(List<Message> messageList) {
		super(messageList);
	}

}


