package com.ssafy.test.service;

import java.sql.SQLException;

import com.ssafy.test.dto.MemberDTO;

public interface MemberService {
	MemberDTO login(MemberDTO dto) throws Exception;
}
