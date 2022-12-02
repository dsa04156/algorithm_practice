package com.ssafy.test.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ssafy.test.dto.NoteDTO;

public interface NoteService {
	String doRegist(NoteDTO dto) throws Exception;
	ArrayList<NoteDTO> list() throws Exception;
	void detailView(NoteDTO dto) throws Exception;
	void delete(NoteDTO dto) throws Exception;
}
