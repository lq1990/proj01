package com.wendao.thread_basic;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

/**
 * download imgs
 * @author china
 *
 */
public class WebDownloader {
	
	/**
	 * 
	 * @param url
	 * @param name
	 */
	public void download(String url, String name) {
		try {
			FileUtils.copyURLToFile(new URL(url), new File(name));
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println("not valid url");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("failed to download imgs");
		}
		
	}
}
