package com.study.test.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.study.test.io.IoOperateTest.HexUtil;

public class MyServlet implements Servlet {

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init······");
	}

	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String name = "I am 君山";
//		System.out.println(name.toCharArray());
//		HexUtil.toHex(name.toCharArray());
//		HexUtil.toHex(name.getBytes());
//		System.out.println("service······");
		RequestDispatcher rd=req.getRequestDispatcher("a.html");
		rd.include(req, res);
		rd=req.getRequestDispatcher("b.html");
		for(int i=0;i<100;i++){
			rd.include(req, res);
		}

	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy······");

	}

}
