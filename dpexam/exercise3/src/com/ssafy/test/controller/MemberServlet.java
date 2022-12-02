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
public class MemberServlet extends HttpServlet {
	MemberServiceImpl service;
    public MemberServlet() {
    	service= MemberServiceImpl.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "";
		String root=request.getContextPath();
		String action=request.getParameter("action");
		System.out.println(action);
		switch (action) {
		case "login":
			path= login(request,response);
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
			break;
		case "logout":
			path= logout(request,response);
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
		
		try {
			dto = service.login(dto);
			if(dto.getId()!=null&&dto.getPw()!=null) {
				System.out.println("로그인성공");
				HttpSession session = request.getSession();
				session.setAttribute("userInfo", dto);
				return "/index.jsp";
			}
		} catch (Exception e) {
			System.out.println("로그인에러");
			return "/error/error.jsp";
		}
		return "/index.jsp";
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
