package com.ssafy.test.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.MemberDTO;
import dto.noteDTO;

public interface MemberDAO {
	MemberDTO login(MemberDTO dto) throws SQLException;
}
