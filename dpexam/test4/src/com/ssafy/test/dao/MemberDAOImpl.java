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
		dbUtil = DBUtil.getInstance();
	}
	private static MemberDAOImpl instance = new MemberDAOImpl();
	public static MemberDAOImpl getInstance() {
		return instance;
	}
	
	public MemberDTO login(MemberDTO dto) throws SQLException {
		Connection conn =null;
		StringBuilder sql = new StringBuilder();
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		MemberDTO dto2 = new MemberDTO();
		try {
			conn=dbUtil.getConnection();
			sql.append("select * from user \n");
			sql.append("where id=? and pw=? ;");
			
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			System.out.println(12131);
			rst=pstmt.executeQuery();
			if(rst.next()) {
				System.out.println("if문");
				dto2.setId(rst.getString(1));
				dto2.setPw(rst.getString(2));
			}
			System.out.println(2);
		}finally {
			dbUtil.close(rst,conn,pstmt);
		}
		
		return dto2;
	}
	
	

}
