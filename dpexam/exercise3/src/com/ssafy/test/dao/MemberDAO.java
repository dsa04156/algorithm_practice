package com.ssafy.test.dao;

import java.sql.SQLException;

import com.ssafy.test.dto.MemberDTO;

public interface MemberDAO {
	MemberDTO login(MemberDTO dto) throws SQLException;
}
