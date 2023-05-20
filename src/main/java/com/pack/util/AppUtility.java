package com.pack.util;

import java.util.UUID;

public class AppUtility {
	public static String getRandomeId()
	{
		return UUID.randomUUID().toString();
	}
	
	public static final String DIRECTORY_PATH = "F://movies/";

	private AppUtility() {
		super();
	}
	
}
