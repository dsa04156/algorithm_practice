package service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ssafy.test.dao.MemberDAOImpl;
import com.ssafy.test.dao.NoteDAOImpl;
import com.ssafy.test.util.DBUtil;

import dto.MemberDTO;
import dto.noteDTO;

public class MemberServiceImpl implements MemberService {
	MemberDAOImpl dao;
	private MemberServiceImpl() {
		dao = MemberDAOImpl.getInstance();
	}
	private static MemberServiceImpl instance = new MemberServiceImpl();
	public static MemberServiceImpl getInstance() {
		return instance;
	}
	public MemberDTO login(MemberDTO dto) throws Exception {
		return dao.login(dto);
	}

}
