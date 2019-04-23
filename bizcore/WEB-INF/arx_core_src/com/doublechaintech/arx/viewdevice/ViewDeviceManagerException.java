
package com.doublechaintech.arx.viewdevice;
//import com.doublechaintech.arx.EntityNotFoundException;
import com.doublechaintech.arx.ArxException;
import com.doublechaintech.arx.Message;
import java.util.List;

public class ViewDeviceManagerException extends ArxException {
	private static final long serialVersionUID = 1L;
	public ViewDeviceManagerException(String string) {
		super(string);
	}
	public ViewDeviceManagerException(Message message) {
		super(message);
	}
	public ViewDeviceManagerException(List<Message> messageList) {
		super(messageList);
	}

}


