package com.ssafy.sample.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.sample.dto.ProductDTO;
import com.ssafy.sample.service.ProductService;
import com.ssafy.sample.service.ProductServiceImpl;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	
	private ProductService service;

	@Override
	public void init() throws ServletException {
		service = ProductServiceImpl.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println("action :" + action);
		
		System.out.println("a : " + request.getParameter("a"));
		System.out.println("b : " + request.getParameter("b"));
		String path = "";
		
		String root = request.getContextPath();
		
		if("regist".equals(action)) {
			path = doRegsit(request,response);
			//이동redirect
			response.sendRedirect(root + path);
			return;
		}else if("list".equals(action)) {
			path = doList(request,response);
			//이동 forwoard
			if(!path.contains("error")) {
				RequestDispatcher dispatcher
					= request.getRequestDispatcher(path);
				dispatcher.forward(request, response);
			}else {
				response.sendRedirect(root + path);
			}
			return;
					
		}else if("view".equals(action)) {
			path = doView(request,response);
			//이동 forwoard
			if(!path.contains("error")) {
				RequestDispatcher dispatcher
					= request.getRequestDispatcher(path);
				dispatcher.forward(request, response);
			}else {
				response.sendRedirect(root + path);
			}
			return;
					
		}else if("mvUpdate".equals(action)) {
			path = doMvUpdate(request,response);
			//이동 forwoard
			if(!path.contains("error")) {
				RequestDispatcher dispatcher
					= request.getRequestDispatcher(path);
				dispatcher.forward(request, response);
			}else {
				response.sendRedirect(root + path);
			}
			return;
					
		}else if("delete".equals(action)) {
			path = deleteProduct(request,response);
			response.sendRedirect(root + path);
			return;
					
		}else if("update".equals(action)) {
			path = doUpate(request,response);
			response.sendRedirect(root + path);
			return;
					
		}
	}
	private String doUpate(HttpServletRequest request, HttpServletResponse response) {
		String path = "";
		//클라이언트에 온 정보 읽기
		ProductDTO dto = new ProductDTO();
		dto.setCode(request.getParameter("productCode"));
		dto.setModel(request.getParameter("model") );
		dto.setPrice(Integer.parseInt(request.getParameter("price")));
		
		System.out.println("받은 정보 : "  +dto);
		
		//서비스 실행
		int cnt = 0;
		try {
			cnt = service.update(dto);
		}catch(Exception e) {
			System.out.println(" 수정 오류 : " + e);
			return "/error/error.jsp";
 		}
		//반환 주소 리턴
		return "/product?action=list";
	}
	private String doMvUpdate(HttpServletRequest request, HttpServletResponse response) {
		String path = "";
		ProductDTO dto = new ProductDTO();
		dto.setCode(request.getParameter("code"));
		try {
			service.view(dto);
			request.setAttribute("dto", dto);
		}catch(Exception e) {
			return "/error/error.jsp";
		}
		return "/product/update.jsp";
	}
	private String doView(HttpServletRequest request, HttpServletResponse response) {
		String path = "";
		ProductDTO dto = new ProductDTO();
		dto.setCode(request.getParameter("code"));
		try {
			service.view(dto);
			request.setAttribute("dto", dto);
		}catch(Exception e) {
			return "/error/error.jsp";
		}
		return "/product/view.jsp";
	}

	private String doList(HttpServletRequest request, HttpServletResponse response) {
		String path = "";
		ArrayList<ProductDTO> list = null;
		try {
			list = service.list();
			request.setAttribute("list", list);
		}catch(Exception e) {
			return "/error/error.jsp";
		}
		return "/product/list.jsp";
	}

	private String deleteProduct(HttpServletRequest request, HttpServletResponse response) {
		String path = "";
		//클라이언트에 온 정보 읽기
		ProductDTO dto = new ProductDTO();
		dto.setCode(request.getParameter("code"));
		
		System.out.println("받은 정보 : "  +dto);
		
		//서비스 실행
		int cnt = 0;
		try {
			cnt = service.delete(dto);
		}catch(Exception e) {
			System.out.println(" 삭제 오류 : " + e);
			return "/error/error.jsp";
 		}
		//반환 주소 리턴
		return "/product?action=list";
	}
	private String doRegsit(HttpServletRequest request, HttpServletResponse response) {
		String path = "";
		//클라이언트에 온 정보 읽기
		ProductDTO dto = new ProductDTO();
		dto.setCode(request.getParameter("productCode"));
		dto.setModel(request.getParameter("model") );
		dto.setPrice(Integer.parseInt(request.getParameter("price")));
		
		System.out.println("받은 정보 : "  +dto);
		
		//서비스 실행
		int cnt = 0;
		try {
			cnt = service.register(dto);
		}catch(Exception e) {
			System.out.println(" 등록 오류 : " + e);
			return "/error/error.jsp";
 		}
		//반환 주소 리턴
		return "/product?action=list";
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
