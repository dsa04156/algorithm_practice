package com.ssafy.test.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.test.dto.MemberDTO;
import com.ssafy.test.service.MemberServiceImpl;

@WebServlet("/member")
public class memberServlet extends HttpServlet {
	MemberServiceImpl service;
    public memberServlet() {
    	service = MemberServiceImpl.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path="";
		String action = request.getParameter("action");
		String root = request.getContextPath();
		System.out.println(action);
		switch (action) {
		case "login":
			path = login(request,response);
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
			break;
		case "logout":
			path = logout(request,response);
			rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
			break;

		default:
			break;
		}
	}

	private String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "/index.jsp";
	}

	private String login(HttpServletRequest request, HttpServletResponse response) {
		MemberDTO dto = new MemberDTO();
		dto.setId(request.getParameter("id"));
		dto.setPw(request.getParameter("pw"));
		System.out.println(dto.getId());
		System.out.println(dto.getPw());
		try {
			dto = service.login(dto);
			System.out.println(dto.getId());
			System.out.println(dto.getPw());
			if(dto.getId()!=null&&dto.getPw()!=null) {
				System.out.println("로그인성공");
				HttpSession session = request.getSession();
				session.setAttribute("userInfo",dto );
			}
		} catch (Exception e) {
			System.out.println("에러");
			return "/error/error.jsp";
		}
		return "/index.jsp";
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
