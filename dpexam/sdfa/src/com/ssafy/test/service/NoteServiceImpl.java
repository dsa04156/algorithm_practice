package com.ssafy.test.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ssafy.test.dao.NoteDAOImpl;
import com.ssafy.test.dto.NoteDTO;
import com.ssafy.test.util.DBUtil;

public class NoteServiceImpl implements NoteService {
	NoteDAOImpl dao;
	private NoteServiceImpl() {
		dao = NoteDAOImpl.getInstance();
	}
	private static NoteServiceImpl instance = new NoteServiceImpl();
	
	public static NoteServiceImpl getInstance() {
		return instance;
	}
	
	@Override
	public String doRegist(NoteDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return dao.doRegist(dto);
	}

	public ArrayList<NoteDTO> list() throws Exception {
		// TODO Auto-generated method stub
		return dao.list();
	}


	public void detailView(NoteDTO dto) throws Exception{
		dao.detailView(dto);
	}

	public void delete(NoteDTO dto) throws Exception {
		dao.delete(dto);
		
	}
}
