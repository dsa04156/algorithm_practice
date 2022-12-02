package com.ssafy.test.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ssafy.test.dto.NoteDTO;

public interface NoteDAO {
	void regist(NoteDTO dto) throws SQLException;
	ArrayList<NoteDTO> list(ArrayList<NoteDTO> list) throws SQLException;
	void view(NoteDTO dto) throws SQLException;
	void delete(NoteDTO dto) throws SQLException;
}
