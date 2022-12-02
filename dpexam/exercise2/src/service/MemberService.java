package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.MemberDTO;
import dto.noteDTO;

public interface MemberService {
	MemberDTO login(MemberDTO dto) throws Exception;
}
