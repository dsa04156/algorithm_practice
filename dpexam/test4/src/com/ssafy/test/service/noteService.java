package com.ssafy.test.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ssafy.test.dto.noteDTO;

public interface noteService {
	void doRegist(noteDTO dto) throws Exception;
	void list(ArrayList<noteDTO> list) throws Exception;
	void delete(String code) throws Exception;
	void view(noteDTO dto) throws Exception;
}
