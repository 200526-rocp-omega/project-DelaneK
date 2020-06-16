package com.revature.exceptions;

import javax.naming.AuthenticationException;

public class RoleNotAllowedException extends AuthenticationException {

	private static final long serialVersionUID = -6895500942556683779L;

	public RoleNotAllowedException() {
	}

	public RoleNotAllowedException(String explanation) {
		super(explanation);
	}

}
