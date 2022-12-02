package com.ssafy.test.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.test.dto.noteDTO;
import com.ssafy.test.service.noteServiceImpl;

/**
 * Servlet implementation class memberServlet
 */
@WebServlet("/note")
public class noteServlet extends HttpServlet {
    private noteServiceImpl service;
    public noteServlet() {
        service = noteServiceImpl.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		String root = request.getContextPath();
		String path = "";
		System.out.println(action);
		switch (action) {
		case "doRegist":
			path=doRegist(request,response);
			response.sendRedirect(root+path);
			break;
		case "list":
			path=list(request,response);
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
			break;
		case "delete":
			path=delete(request,response);
			response.sendRedirect(root+path);
			break;
		case "view":
			path=view(request,response);
			rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
			break;
				
		default:
			break;
		}
	}

	private String view(HttpServletRequest request, HttpServletResponse response) {
		noteDTO dto = new noteDTO();
		dto.setModel(request.getParameter("model"));
		System.out.println(dto.getModel());
		try {
			service.view(dto);
			request.setAttribute("dto", dto);
			System.out.println("조회성공");
		} catch (Exception e) {
			System.out.println("실패");
			return "/error/error.jsp";
		}
	
		return "/note/detailNote.jsp";
	}

	private String delete(HttpServletRequest request, HttpServletResponse response) {
		String code;
		code= request.getParameter("noteCode");
		System.out.println(code);
		try {
			service.delete(code);
			System.out.println("삭제성공");
		} catch (Exception e) {
			System.out.println("실패");
			return "/error/error.jsp";
		}
		return "/note?action=list";
	}

	private String list(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<noteDTO> list = new ArrayList<>();
		try {
			service.list(list);
			request.setAttribute("list", list);//자주까먹
			System.out.println("리스트 성공");
		} catch (Exception e) {
			System.out.println("실패");
			return "/error/error.jsp";
		}
		return "/note/listNote.jsp";
	}

	private String doRegist(HttpServletRequest request, HttpServletResponse response) {
		noteDTO dto = new noteDTO();
		System.out.println(123);
		dto.setNoteCode(request.getParameter("noteCode"));
		dto.setModel(request.getParameter("model"));
		dto.setPrice(Integer.parseInt(request.getParameter("price")));
		dto.setCompany(request.getParameter("company"));
		System.out.println(dto.toString());
		try {
			service.doRegist(dto);
			System.out.println("성공");
		} catch (Exception e) {
			System.out.println("실패");
			return "/error/error.jsp";
		}
		return "/note?action=list";
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
