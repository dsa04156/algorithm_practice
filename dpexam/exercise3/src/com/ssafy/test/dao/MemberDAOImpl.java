package com.ssafy.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.test.dto.MemberDTO;
import com.ssafy.test.service.MemberServiceImpl;
import com.ssafy.test.util.DBUtil;

public class MemberDAOImpl implements MemberDAO {
	DBUtil dbUtil;
	private MemberDAOImpl() {
		dbUtil= DBUtil.getInstance();
	}
	private static MemberDAOImpl instance = new MemberDAOImpl();
	public static MemberDAOImpl getInstance() {
		return instance;
	}
	public MemberDTO login(MemberDTO dto) throws SQLException {
		PreparedStatement pstmt=null;
		Connection conn= null;
		ResultSet rst = null;
		StringBuilder sql = new StringBuilder();
		try {
			conn=dbUtil.getConnection();
			sql.append("select * from user \n");
			sql.append("where id=? and pw =?;");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			rst = pstmt.executeQuery();
			dto = new MemberDTO();
			while(rst.next()) {
				dto.setId(rst.getString(1));
				dto.setPw(rst.getString(2));
			}
		}finally {
			dbUtil.close(conn,rst,pstmt);
		}
		return dto;
		
	}
}
