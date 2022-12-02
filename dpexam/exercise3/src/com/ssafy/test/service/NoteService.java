package com.ssafy.test.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ssafy.test.dto.NoteDTO;

public interface NoteService {
	void regist(NoteDTO dto) throws Exception;
	ArrayList<NoteDTO> list(ArrayList<NoteDTO> list) throws Exception;
	void view(NoteDTO dto) throws Exception;
	void delete(NoteDTO dto) throws Exception;
}
