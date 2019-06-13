package com.wendao.regexp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 1. 网络爬虫取链接
 * 
 * wget 目前的爬虫产品
 * 
 * 
 * @author china
 *
 */
public class WebSpiderCore {

	public static void main(String[] args) {
		String url = "http://www.163.com";
		String destStr = getURLContent(url, "gbk");

//		String regexp = "<a[\\s\\S]+?</a>";
		String regexp = "href=\"([\\w\\s./:?]*?)\"";
		
		List<String> urlList = getMatcherSubstrs(destStr, regexp);
		
		for(String str : urlList) {
			System.out.println(str);
		}

	}

	/**
	 * get substrs in destStr that match regexp
	 * 
	 * @param destStr
	 * @param regexp
	 * @return
	 */
	public static List<String> getMatcherSubstrs(String destStr, String regexp) {
		Pattern p = Pattern.compile(regexp);
		Matcher m = p.matcher(destStr);

		List<String> urlList = new ArrayList<String>();

		while (m.find()) {
			urlList.add(m.group(1));
		}

		return urlList;
	}

	/**
	 * 获得源码内容
	 * 
	 * @param urlStr
	 * @return
	 */
	public static String getURLContent(String urlStr, String charset) {
		StringBuilder sb = new StringBuilder();

		try {
			URL url = new URL(urlStr);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), charset));

			String tmp = "";
			while ((tmp = br.readLine()) != null) {
//				System.out.println(tmp);
				sb.append(tmp);
				sb.append("\r\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return sb.toString();
	}

}
