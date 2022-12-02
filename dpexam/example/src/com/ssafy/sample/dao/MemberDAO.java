package com.ssafy.sample.dao;

import java.sql.SQLException;

import com.ssafy.sample.dto.MemberDTO;

public interface MemberDAO {
	MemberDTO login(String id, String pw) throws SQLException;
	
}
