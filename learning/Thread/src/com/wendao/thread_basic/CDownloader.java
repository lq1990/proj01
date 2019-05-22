package com.wendao.thread_basic;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CDownloader implements Callable<Boolean> {
	private String url; // url
	private String name; // name of file
	
	public CDownloader(String url, String name) {
		super();
		this.url = url;
		this.name = name;
	}

	@Override
	public Boolean call() throws Exception {
		WebDownloader wd = new WebDownloader();
		wd.download(url, name);
		System.out.println(name);
		return true;
	}
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		String url1 = "http://n.sinaimg.cn/news/transform/579/w340h239/20190512/ccb1-hwsffzc6350819.jpg";
		String url2 = "http://n.sinaimg.cn/mil/transform/579/w340h239/20190510/556e-hwsffzc3621526.png";
		String url3 = "http://n.sinaimg.cn/news/transform/250/w160h90/20190512/6416-hwsffzc6401382.png";
		
		// start all threads
		// 1. 创建目标对象
		CDownloader cd1 = new CDownloader(url1, "news11.jpg");
		CDownloader cd2 = new CDownloader(url2, "news22.jpg");
		CDownloader cd3 = new CDownloader(url3, "news33.jpg");
		 
		// 2. 创建执行服务
		ExecutorService ser = Executors.newFixedThreadPool(3); // nThreads
		
		// 3. 提交执行
		Future<Boolean> res1 = ser.submit(cd1);
		Future<Boolean> res2 = ser.submit(cd2);
		Future<Boolean> res3 = ser.submit(cd3);
		
		// 4. 获取结果
		boolean r1 = res1.get();
		boolean r2 = res2.get();
		boolean r3 = res3.get();
		System.out.println(r1);
		
		// 5. 关闭服务
		ser.shutdownNow();
	}
}
