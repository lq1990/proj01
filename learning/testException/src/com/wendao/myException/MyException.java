package com.wendao.myException;

/**
 * my exception
 * @author china
 *
 */
public class MyException extends Exception {
	
	public MyException() {
		
	}
	
	public MyException(String message) {
		super(message);
	}
}

class TestMyException {
	void test() throws MyException {
		
	}
	
	public static void main(String[] args) {
		TestMyException tm = new TestMyException();
		
		try {
			tm.test();
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
}