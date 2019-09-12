package com.wendao.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/validcode")
public class ValidCodeServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 创建一张图片
		// 单位：像素
		BufferedImage image = 
				new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB);
		
		// 创建画板，透明的玻璃
		// 向画板上画内容之前必须先设置画笔
		Graphics2D gra = image.createGraphics();
		 
		// 设置画笔颜色，产生随机数
		gra.setColor(Color.WHITE); // 首先设置画笔颜色
		gra.fillRect(0, 0, 200, 100); // 坐标原点：相对于image而言，左上角是原点，正方向为 x往右 y往下
		List<Integer> randList = new ArrayList<Integer>();
		Random rd = new Random();
		for (int i=0;i<4; i++) {
			randList.add(rd.nextInt(10)); // [0, 10)
		}
		
		// 设置字体，颜色随机，写字
		gra.setFont(new Font("宋体", Font.ITALIC|Font.BOLD, 40));
		Color[] colors = new Color[] 
				{Color.RED, Color.BLUE, Color.GREEN, Color.PINK, Color.GRAY};
		for(int i=0; i<randList.size(); i++) {
			gra.setColor(colors[rd.nextInt(colors.length)]);
			gra.drawString(randList.get(i)+"", i*40, 70+(rd.nextInt(21)-10));
		}
		
		// 画线，颜色随机，线条y轴值随机
		for(int i=0; i<2; i++) {
			gra.setColor(colors[rd.nextInt(colors.length)]);
			gra.drawLine(0, 30+rd.nextInt(41), 200, 30+rd.nextInt(41));
		}
		
		ServletOutputStream os = resp.getOutputStream();
		// 工具类
		ImageIO.write(image, "jpg", os);
		
		
		// 把验证码放到 session 中
		HttpSession ss = req.getSession();
		String code = "";
		for(int i=0; i<randList.size(); i++) {
			code += randList.get(i);
		}
		ss.setAttribute("code", code);
		
		
	}

}



















