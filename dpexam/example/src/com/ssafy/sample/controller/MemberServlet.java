package com.ssafy.sample.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.sample.dto.MemberDTO;
import com.ssafy.sample.service.MemberService;
import com.ssafy.sample.service.MemberServiceImpl;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/member")
public class MemberServlet extends HttpServlet {

	private MemberService service;
	
	@Override
	public void init() throws ServletException {
		service = MemberServiceImpl.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		System.out.println("act : " + act);
		String path = "/index.jsp";
		switch(act) {
		case "login" :
			path = login(request, response);
			if(!path.contains("error")) {
				response.sendRedirect(request.getContextPath() + path);
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(path);
				dispatcher.forward(request, response);
			}
			 break;
		case "logout" :
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			break;
		}
	}

	private String login(HttpServletRequest request, HttpServletResponse response) {
		String path = "/index.jsp";
		String id = request.getParameter("mid");
		String pw = request.getParameter("mpw");
		try {
			MemberDTO dto = service.login(id, pw);
			if(dto != null) {
				HttpSession session = request.getSession();
				session.setAttribute("userInfo", dto);
				path = "/product?action=list";
			}
		}catch(Exception e) {
			request.setAttribute("msg", "로그인 실행중 실패");
			path = "/error/error.jsp";
		}
		return path;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
