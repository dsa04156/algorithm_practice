package service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ssafy.test.dao.NoteDAOImpl;
import com.ssafy.test.util.DBUtil;

import dto.noteDTO;

public class NoteServiceImpl implements NoteService {
	NoteDAOImpl dao;
	private NoteServiceImpl() {
		dao = NoteDAOImpl.getInstance();
	}
	private static NoteServiceImpl instance = new NoteServiceImpl();
	public static NoteServiceImpl getInstance() {
		return instance;
	}
	public void doRegist(noteDTO dto) throws Exception {
		dao.doRegist(dto);
	}
	public ArrayList<noteDTO> viewList() throws Exception {
		System.out.println("service viewlist");
		return dao.viewList();
	}
	public void view(noteDTO dto) throws Exception {
		dao.view(dto);
	}
	public void delete(noteDTO dto) throws Exception {
		dao.delete(dto);
		
	}
}
