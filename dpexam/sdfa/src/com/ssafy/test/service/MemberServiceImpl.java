package com.ssafy.test.service;

import java.sql.SQLException;

import com.ssafy.test.dao.MemberDAOImpl;
import com.ssafy.test.dto.MemberDTO;
import com.ssafy.test.util.DBUtil;

public class MemberServiceImpl implements MemberService {
	MemberDAOImpl dao = null;
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
