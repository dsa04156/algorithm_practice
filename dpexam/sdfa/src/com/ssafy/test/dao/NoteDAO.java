package com.ssafy.test.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ssafy.test.dto.NoteDTO;

public interface NoteDAO {
	String doRegist(NoteDTO dto) throws SQLException;
	ArrayList<NoteDTO> list() throws SQLException;
	void detailView(NoteDTO dto) throws SQLException;
	void delete(NoteDTO dto) throws SQLException;
}
