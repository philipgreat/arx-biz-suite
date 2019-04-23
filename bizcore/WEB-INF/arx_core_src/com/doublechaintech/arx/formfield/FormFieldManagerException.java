
package com.doublechaintech.arx.formfield;
//import com.doublechaintech.arx.EntityNotFoundException;
import com.doublechaintech.arx.ArxException;
import com.doublechaintech.arx.Message;
import java.util.List;

public class FormFieldManagerException extends ArxException {
	private static final long serialVersionUID = 1L;
	public FormFieldManagerException(String string) {
		super(string);
	}
	public FormFieldManagerException(Message message) {
		super(message);
	}
	public FormFieldManagerException(List<Message> messageList) {
		super(messageList);
	}

}


