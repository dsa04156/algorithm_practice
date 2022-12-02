package com.ssafy.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.member.model.service.MemberService;
import com.ssafy.member.model.service.MemberServiceImpl;

@WebServlet("/user")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MemberService memberService ;
	
	public void init() {
		memberService = MemberServiceImpl.getMemberService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		System.out.println("act : " + act);
		String path = "/index.jsp";
		if("mvjoin".equals(act)) {
		}else if("mvjoin".equals(act)) {
			//forward입니다.
			path = "/user/join.jsp";
			redirect(request,response,path);
		}else if("idcheck".equals(act)) {
			int cnt  = idCheck(request,response);
			response.setContentType("text/plain");
			PrintWriter out = response.getWriter();
			out.println(cnt);
		}else if("join".equals(act)) {
			path = join(request, response);
			forward(request, response,path);
			
		}else if("mvlogin".equals(act)) {
			path="/user/login.jsp";
			redirect(request, response, path);
		}else if("mvjoin".equals(act)) {
			
		}else {
			redirect(request,response,path);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request,response);
	}
	private void forward(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
	
	private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		response.sendRedirect(request.getContextPath() + path);
	}
	private int idCheck(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getParameter("userid");
		try {
			int count = memberService.idCheck(userId);
			return count;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 500;
	}



}
