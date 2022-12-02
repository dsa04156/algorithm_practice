package com.ssafy.test.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ssafy.test.dao.NoteDAOImpl;
import com.ssafy.test.dto.NoteDTO;
import com.ssafy.test.util.DBUtil;

public class NoteServiceImpl implements NoteService{
	NoteDAOImpl dao;
	private NoteServiceImpl() {
		dao = NoteDAOImpl.getInstance();
	}
	private static NoteServiceImpl instance = new NoteServiceImpl();
	public static NoteServiceImpl getInstance() {
		return instance;
	}
	public void regist(NoteDTO dto) throws Exception {
		dao.regist(dto);
	}
	public ArrayList<NoteDTO> list(ArrayList<NoteDTO> list) throws Exception {
		return dao.list(list);
	}
	public void view(NoteDTO dto) throws Exception {
		dao.view(dto);
	}
	public void delete(NoteDTO dto) throws Exception {
		dao.delete(dto);
	}
}
