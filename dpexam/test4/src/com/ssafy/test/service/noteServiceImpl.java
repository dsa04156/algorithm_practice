package com.ssafy.test.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ssafy.test.dao.noteDAOImpl;
import com.ssafy.test.dto.noteDTO;
import com.ssafy.test.util.DBUtil;

public class noteServiceImpl implements noteService {
	noteDAOImpl dao;
	private noteServiceImpl() {
		dao = noteDAOImpl.getInstance();
	}
	private static noteServiceImpl instance = new noteServiceImpl();
	public static noteServiceImpl getInstance() {
		return instance;
	}
	public void doRegist(noteDTO dto) throws Exception {
		dao.doRegist(dto);
	}
	public void list(ArrayList<noteDTO> list) throws Exception {
		dao.list(list);
	}
	public void delete(String code) throws Exception {
		dao.delete(code);
	}
	public void view(noteDTO dto) throws Exception {
		dao.view(dto);
	}
}
