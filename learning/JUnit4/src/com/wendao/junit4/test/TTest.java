package com.wendao.junit4.test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class TTest {

	@Test
	public void testAdd() {
		
		int z = 1;
		assertEquals(1, z);
		assertEquals(11, z);
//		int a = 8/0;
		
	}

}
