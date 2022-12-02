package com.ssafy.test.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.noteDTO;
import service.NoteServiceImpl;

@WebServlet("/note")
public class NoteServlet extends HttpServlet {
	NoteServiceImpl service;
    public NoteServlet() {
    	service = NoteServiceImpl.getInstance();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path="";
		String root=request.getContextPath();
		String action=request.getParameter("action");
		System.out.println(action);
		switch (action) {
		case "regist":
			path=doRegist(request,response);
			response.sendRedirect(root+path);
			break;
		case "list":
			path=list(request,response);
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
			break;
		case "view":
			path=view(request,response);
			rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
			break;	
		case "delete":
			path=delete(request,response);
			response.sendRedirect(root+path);
			break;
		default:
			break;
		}
	}

	private String delete(HttpServletRequest request, HttpServletResponse response) {
		noteDTO dto = new noteDTO();
		dto.setNoteCode(request.getParameter("noteCode"));
		try {
			service.delete(dto);
		} catch (Exception e) {
			System.out.println("삭제에러");
			return "/error/error.jsp";

		}
		return "/note?action=list";
	}
	private String view(HttpServletRequest request, HttpServletResponse response) {
		noteDTO dto= new noteDTO();
		dto.setModel(request.getParameter("model"));
		System.out.println(dto.getModel());
		try {
			service.view(dto);
			request.setAttribute("dto", dto);
			System.out.println(dto.getCompany());
			System.out.println(dto.getModel());
		} catch (Exception e) {
			System.out.println("view 실패");
			return "/error/error.jsp";
		}
		
		return "/note/detailNote.jsp";
	}
	private String list(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<noteDTO> list = new ArrayList<>();
		try {
			System.out.println(1);
			list=service.viewList();
			System.out.println(2);
			request.setAttribute("list",list);
			System.out.println(3);
		} catch (Exception e) {
			System.out.println("리스트 실패");
			return "/error/error.jsp";
		}
		return "/note/listNote.jsp";
	}
	private String doRegist(HttpServletRequest request, HttpServletResponse response) {
		noteDTO dto = new noteDTO();
		dto.setNoteCode(request.getParameter("noteCode"));
		dto.setModel(request.getParameter("model"));
		dto.setPrice(Integer.parseInt(request.getParameter("price")));
		dto.setCompany(request.getParameter("company"));
		try {
			service.doRegist(dto);
		} catch (Exception e) {
			System.out.println("등록실패");
			return "error/error.jsp";
		}
		return "/index.jsp";
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
