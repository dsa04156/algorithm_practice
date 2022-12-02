package com.ssafy.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ssafy.test.util.DBUtil;

import dto.MemberDTO;
import dto.noteDTO;

public class MemberDAOImpl implements MemberDAO {
	DBUtil dbUtil = null;
	private MemberDAOImpl() {
		dbUtil = DBUtil.getInstance();
	}
	private static MemberDAOImpl instance = new MemberDAOImpl();
	
	public static MemberDAOImpl getInstance() {
		return instance;
	}
	
	public MemberDTO login(MemberDTO dto) throws SQLException {
		Connection conn =null;
		ResultSet rst = null;
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		MemberDTO dto2 = new MemberDTO();
		try {
			conn = dbUtil.getConnection();
			sql.append("select * from user \n");
			sql.append("where id=? and pw=? ;");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			
			rst=pstmt.executeQuery();
			if(rst.next()) {
				dto2.setId(rst.getString(1));
				dto2.setPw(rst.getString(2));
				System.out.println(456);
			}
		}finally {
			dbUtil.close(rst,conn,pstmt);
		}
		return dto2;
	}

}
