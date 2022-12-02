package com.ssafy.sample.service;

import com.ssafy.sample.dao.MemberDAO;
import com.ssafy.sample.dao.MemberDAOImpl;
import com.ssafy.sample.dto.MemberDTO;

public class MemberServiceImpl implements MemberService {
	
	private static MemberServiceImpl instance = new MemberServiceImpl();
	private MemberDAO dao = null;
	private MemberServiceImpl() {
		dao = MemberDAOImpl.getInstance();
		
	}
	public static MemberServiceImpl getInstance() {
		return instance;
	}

	@Override
	public MemberDTO login(String id, String pw) throws Exception {
		// TODO Auto-generated method stub
		return dao.login(id, pw);
	}

}
