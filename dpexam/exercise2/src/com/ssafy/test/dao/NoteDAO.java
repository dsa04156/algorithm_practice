package com.ssafy.test.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.noteDTO;

public interface NoteDAO {
	void doRegist(noteDTO dto) throws SQLException;
	ArrayList<noteDTO> viewList() throws SQLException;
	void view(noteDTO dto) throws SQLException;
	void delete(noteDTO dto) throws SQLException;
}
