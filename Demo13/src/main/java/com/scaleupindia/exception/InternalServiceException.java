package com.scaleupindia.exception;

/**
 * @author abhishekvermaa10
 *
 */
public class InternalServiceException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InternalServiceException(String message) {
		super(message);
	}
}
