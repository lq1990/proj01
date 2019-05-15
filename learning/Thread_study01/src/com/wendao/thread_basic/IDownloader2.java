package com.wendao.thread_basic;


public class IDownloader2 implements Runnable {
	private String url; // url
	private String name; // name of file
	
	public IDownloader2(String url, String name) {
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
		IDownloader2 td1 = new IDownloader2(url1, "news1.jpg");
		IDownloader2 td2 = new IDownloader2(url2, "news2.jpg");
		IDownloader2 td3 = new IDownloader2(url3, "news3.jpg");
		
		// start all threads
		new Thread(td1).start(); // td1 may not be the first one to be executed
		new Thread(td2).start();
		new Thread(td3).start();
		
	}
}
