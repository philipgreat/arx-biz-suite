
package com.doublechaintech.arx.formfieldmessage;
//import com.doublechaintech.arx.EntityNotFoundException;
import com.doublechaintech.arx.ArxException;
import com.doublechaintech.arx.Message;
import java.util.List;

public class FormFieldMessageManagerException extends ArxException {
	private static final long serialVersionUID = 1L;
	public FormFieldMessageManagerException(String string) {
		super(string);
	}
	public FormFieldMessageManagerException(Message message) {
		super(message);
	}
	public FormFieldMessageManagerException(List<Message> messageList) {
		super(messageList);
	}

}


