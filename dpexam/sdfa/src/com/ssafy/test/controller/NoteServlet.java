package com.ssafy.test.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.test.dto.NoteDTO;
import com.ssafy.test.service.NoteServiceImpl;

/**
 * Servlet implementation class NoteServlet
 */
@WebServlet("/note")
public class NoteServlet extends HttpServlet {
       NoteServiceImpl service;
       
    public NoteServlet() {
    	service = NoteServiceImpl.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String path = "";
		String root = request.getContextPath();
		System.out.println(action);
		switch (action) {
		case "regist":
			path = doRegist(request,response);
			response.sendRedirect(root+path);
			break;
		case "list":
			path=list(request,response);
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
			break;
		case "detailNote":
			path=detail(request,response);
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

	private String login(HttpServletRequest request, HttpServletResponse response) {
		
		return null;
	}

	private String delete(HttpServletRequest request, HttpServletResponse response) {
		NoteDTO dto = new NoteDTO();
		dto.setNoteCode(request.getParameter("noteCode"));
		try {
			service.delete(dto);
		} catch (Exception e) {
			System.out.println("삭제실패");
			return "/error/error.jsp";
		}
		 
		return "/note?action=list";
	}

	private String detail(HttpServletRequest request, HttpServletResponse response) {
		NoteDTO dto = new NoteDTO();
		dto.setModel(request.getParameter("model"));
		try {
			service.detailView(dto);
			request.setAttribute("dto", dto);
		} catch (Exception e) {
			System.out.println("디테일뷰실패");
			return "/error/error.jsp";
		}
		return "/note/detailNote.jsp";
		
		
	}

	private String list(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<NoteDTO> list = null;
		try {
			list=service.list();
			request.setAttribute("list", list);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("리스트실패");
			e.printStackTrace();
			return "/error/error.jsp"; 
				
		}
		
		
		return "/note/listNote.jsp";
	}

	private String doRegist(HttpServletRequest request, HttpServletResponse response) {
		NoteDTO dto = new NoteDTO();
		dto.setNoteCode(request.getParameter("noteCode"));
		dto.setModel(request.getParameter("model"));
		dto.setPrice(Integer.parseInt(request.getParameter("price")));
		dto.setCompany(request.getParameter("company"));
		System.out.println(dto.getCompany());
		System.out.println(dto.getModel());
		System.out.println(dto.getPrice());
		System.out.println(dto.getNoteCode());
		
		try {
			service.doRegist(dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("회원가입 실패");
			return "/error/error.jsp";
		}
		return "/index.jsp";
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
