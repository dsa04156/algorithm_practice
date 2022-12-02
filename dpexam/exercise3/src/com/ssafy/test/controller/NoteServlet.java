package com.ssafy.test.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.test.dto.NoteDTO;
import com.ssafy.test.service.NoteServiceImpl;

@WebServlet("/note")
public class NoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       NoteServiceImpl service;
    public NoteServlet() {
    	service = NoteServiceImpl.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		String action = request.getParameter("action");
		String path="";
		System.out.println(action);
		switch (action) {
		case "regist":
			path=noteRegist(request,response);
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
//			rd = request.getRequestDispatcher(path);
//			rd.forward(request, response);
			break;

		default:
			break;
		}
	}

	private String delete(HttpServletRequest request, HttpServletResponse response) {
		NoteDTO dto = new NoteDTO();
		dto.setNoteCode(request.getParameter("noteCode"));
		System.out.println(dto.getNoteCode());
		try {
			service.delete(dto);
		} catch (Exception e) {
			System.out.println("삭제에러");
			return "/error/error.jsp";
		}
		
		return "/note?action=list";
	}

	private String view(HttpServletRequest request, HttpServletResponse response) {
		NoteDTO dto = new NoteDTO();
		dto.setModel(request.getParameter("model"));
		try {
			request.setAttribute("dto", dto);
			service.view(dto);
			System.out.println(dto.getCompany());
		} catch (Exception e) {
			System.out.println("뷰 에러");
			return "/error/error.jsp";
		}
		return "/note/detailNote.jsp";
	}

	private String list(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<NoteDTO> list = new ArrayList<>();
		try {
			list = service.list(list);
			request.setAttribute("list", list);
		} catch (Exception e) {
			System.out.println("리스트실패");
			return "/error/error.jsp";
		}
		return "/note/listNote.jsp";
	}

	private String noteRegist(HttpServletRequest request, HttpServletResponse response) {
		NoteDTO dto = new NoteDTO();
		dto.setNoteCode(request.getParameter("noteCode"));
		dto.setModel(request.getParameter("model"));
		dto.setPrice(Integer.parseInt(request.getParameter("price")));
		dto.setCompany(request.getParameter("company"));
		System.out.println(dto.getCompany());
		try {
			service.regist(dto);
		} catch (Exception e) {
			System.out.println("등록실패");
			return "/error/error.jsp";
		}
		
		return "/index.jsp";
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
