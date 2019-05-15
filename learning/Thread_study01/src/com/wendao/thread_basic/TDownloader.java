package com.wendao.thread_basic;


public class TDownloader extends Thread {
	private String url; // url
	private String name; // name of file
	
	public TDownloader(String url, String name) {
		super();
		this.url = url;
		this.name = name;
	}

	@Override
	public void run() {
		WebDownloader wd = new WebDownloader();
		wd.download(url, name);
		System.out.println(name);
	}
	
	
	public static void main(String[] args) {
		String url1 = "http://n.sinaimg.cn/news/transform/579/w340h239/20190512/ccb1-hwsffzc6350819.jpg";
		String url2 = "http://n.sinaimg.cn/mil/transform/579/w340h239/20190510/556e-hwsffzc3621526.png";
		String url3 = "http://n.sinaimg.cn/news/transform/250/w160h90/20190512/6416-hwsffzc6401382.png";
		TDownloader td1 = new TDownloader(url1, "news1.jpg");
		TDownloader td2 = new TDownloader(url2, "news2.jpg");
		TDownloader td3 = new TDownloader(url3, "news3.jpg");
		
		// start all threads
		td1.start(); // td1 may not be the first one to be executed
		td2.start();
		td3.start();
		
	}
}
