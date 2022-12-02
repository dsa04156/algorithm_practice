package com.ssafy.sample.service;

import com.ssafy.sample.dto.MemberDTO;

public interface MemberService {
	MemberDTO login(String id, String pw) throws Exception;
}
