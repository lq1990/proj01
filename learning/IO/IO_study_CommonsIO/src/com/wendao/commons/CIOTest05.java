package com.wendao.commons;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/**
 * copy
 * @author china
 *
 */
public class CIOTest05 {
	public static void main(String[] args) throws IOException {
		
		
		File file = new File("dog1.jpg");
		// copy file
		FileUtils.copyFile(file, new File("dest.jpg"));
		
		
		// copy file to dir
		FileUtils.copyFileToDirectory(file, new File("lib"));
		
		// dir 2 dir， 将lib放到 lib2目录里
		FileUtils.copyDirectoryToDirectory(new File("lib"), new File("lib2"));
		
		// copy dir
		FileUtils.copyDirectory(new File("lib"), new File("lib3"));
		
		// copy URL
		String url = "https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=images&hs=2&pn=4&spn=0&di=52170&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&ie=utf-8&oe=utf-8&cl=2&lm=-1&cs=3750504475%2C1624694856&os=525962986%2C2541150473&simid=1550652986%2C3728776205&adpicid=0&lpn=0&ln=30&fr=ala&fm=&sme=&cg=&bdtype=11&oriquery=images&objurl=http%3A%2F%2Fpix6.agoda.net%2Fagaff%2Faff.bstatic.com%2Fimages%2Fhotel%2Fmax1024x768%2F164%2F164035175.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fik_z%26e3Bqq_z%26e3Bv54AzdH3FwAzdH3Fda80a8ddAzdH3Fadcclm_z%26e3Bip4%3Fp%3D8cacb8anb8b9l&gsm=0&islist=&querylist=";
		FileUtils.copyURLToFile(new URL(url), new File("img"));
		
		
		// 
		String datas = IOUtils.toString(new URL("https://www.163.com"),"gbk");
		
		System.out.println(datas);
		
		
	}
}









