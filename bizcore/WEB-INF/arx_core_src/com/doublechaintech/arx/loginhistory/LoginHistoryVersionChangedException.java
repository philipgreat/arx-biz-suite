
package com.doublechaintech.arx.loginhistory;
import com.doublechaintech.arx.EntityNotFoundException;

public class LoginHistoryVersionChangedException extends LoginHistoryManagerException {
	private static final long serialVersionUID = 1L;
	public LoginHistoryVersionChangedException(String string) {
		super(string);
	}


}


