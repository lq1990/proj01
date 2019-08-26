package com.wendao.servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * 问题： server关闭时，nums对网页访问次数的计数就没了。 解决： 功能： server启动时，init时：从nums.txt读取nums到
 * ServletContext server关闭时，destroy时，将ServletContext中的nums写入 nums.txt
 * 
 * 设置web.xml中 NumServlet 的 <load-on-startup>1</load-on-startup>
 * 
 * @author china
 *
 */
public class NumServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		// 获取文件中的计数器数据
		// 获取文件路径
		String path = this.getServletContext().getRealPath("/nums/nums.txt");

		// 声明流对象
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
			String nums = br.readLine(); // io流中使用String，这利于阅读txt文件
			
			System.out.println("=========\ninit, nums: " + nums);
			System.out.println("init, nums: " + nums);
			System.out.println("init, nums: " + nums);
			
			if(nums != null) {
				this.getServletContext().setAttribute("nums", Integer.parseInt(nums));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public void destroy() {

		// 获取网页计数器
		int nums = (int) this.getServletContext().getAttribute("nums");
		System.out.println("==========\ndestroy, nums: " + nums);
		System.out.println("destroy, nums: " + nums);
		System.out.println("destroy, nums: " + nums);

		// 获取文件路径
		String path = this.getServletContext().getRealPath("/nums/nums.txt");
		//
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(path));
			bw.write(nums+""); // io流中使用String
			bw.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
