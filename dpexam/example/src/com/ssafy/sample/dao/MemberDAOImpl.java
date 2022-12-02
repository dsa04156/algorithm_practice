package com.ssafy.sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.sample.dto.MemberDTO;
import com.ssafy.sample.util.DBUtil;

public class MemberDAOImpl implements MemberDAO {
	
	private static MemberDAOImpl instance = new MemberDAOImpl();
	DBUtil dbUtil = null;
	private MemberDAOImpl() {
			dbUtil = DBUtil.getInstance();
	}
	public static MemberDAOImpl getInstance() {
		return instance;
	}

	@Override
	public MemberDTO login(String id, String pw) throws SQLException {
		MemberDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select *  \n");
			sql.append("from members \n");
			sql.append("where user_id = ? and user_password = ?  \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1,id);
			pstmt.setString(2,pw);
			rst = pstmt.executeQuery();
			if(rst.next()) {
				dto = new MemberDTO();
				//id성공
				dto.setUserId(rst.getString(1));
				dto.setUserName(rst.getString(2));
			}
		}finally {
			dbUtil.close(rst, pstmt, conn);
		}
		return dto;
	}

}
