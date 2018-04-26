package com.search.exception;

/**
 * A custom exception thrown when a filter which is configured but is not
 * available at runtime or may be thrown when an exception occurred in
 * instantiating it.
 * 
 * @author Lavesh Singhal
 *
 */
public class NoSuchCustomFilterException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoSuchCustomFilterException(String message) {
		super(message);
	}

	public NoSuchCustomFilterException(Throwable e) {
		super(e);
	}

	public NoSuchCustomFilterException(String message, Throwable e) {
		super(message, e);
	}

}
