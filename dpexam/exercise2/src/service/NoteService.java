package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.noteDTO;

public interface NoteService {
	void doRegist(noteDTO dto) throws Exception;
	ArrayList<noteDTO> viewList() throws Exception;
	void view(noteDTO dto) throws Exception;
	void delete(noteDTO dto) throws Exception;
}
