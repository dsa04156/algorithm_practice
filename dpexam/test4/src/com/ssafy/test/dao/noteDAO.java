package com.ssafy.test.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ssafy.test.dto.noteDTO;

public interface noteDAO {
	void doRegist(noteDTO dto) throws SQLException;
	void list(ArrayList<noteDTO> list) throws SQLException;
	void delete(String code) throws SQLException;
	void view(noteDTO dto) throws SQLException;
}
