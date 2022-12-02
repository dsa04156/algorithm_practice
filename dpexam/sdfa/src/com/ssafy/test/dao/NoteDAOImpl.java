package com.ssafy.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ssafy.test.dto.NoteDTO;
import com.ssafy.test.util.DBUtil;

public class NoteDAOImpl implements NoteDAO {
	DBUtil dbUtil=null;
	private NoteDAOImpl() {
		dbUtil = DBUtil.getInstance();
	}
	private static NoteDAOImpl instance = new NoteDAOImpl();
	public static NoteDAOImpl getInstance() {
		return instance;
	}
	public String doRegist(NoteDTO dto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		try {
			conn = dbUtil.getConnection();
			sql.append("insert into note(noteCode,model,price,company) \n");
			sql.append("values (?,?,?,?);");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getNoteCode());
			pstmt.setString(2, dto.getModel());
			pstmt.setInt(3, dto.getPrice());
			pstmt.setString(4, dto.getCompany());
			pstmt.executeUpdate();
		}finally {
			dbUtil.close(pstmt,conn);
		}
		
		return null;
	}
	
	public ArrayList<NoteDTO> list() throws SQLException {
		ArrayList<NoteDTO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		try {
			conn= dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * \n");
			sql.append("from note;");
			pstmt = conn.prepareStatement(sql.toString());
			rst=pstmt.executeQuery();
			while(rst.next()) {
				NoteDTO dto = new NoteDTO();
				dto.setNoteCode(rst.getString(1));
				dto.setModel(rst.getString(2));
				dto.setPrice(rst.getInt(3));
				dto.setCompany(rst.getString(4));
				
				list.add(dto);
			}
			
		}finally {
			dbUtil.close(pstmt,rst,conn);
		}
		return list;
	}
	public void detailView(NoteDTO dto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rst =null;
		try {
			conn=dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from note \n");
			sql.append("where model = ?;");
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getModel());
			rst=pstmt.executeQuery();
			while(rst.next()) {
				dto.setNoteCode(rst.getString(1));
				dto.setPrice(rst.getInt(3));
				dto.setCompany(rst.getString(4));
			}
		}finally {
			dbUtil.close(conn,pstmt,rst);
		}
	}
	public void delete(NoteDTO dto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt =null;
		try {
			conn= dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("delete from note \n");
			sql.append("where noteCode = ?;");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getNoteCode());
			pstmt.executeUpdate();
		}finally {
			dbUtil.close(conn,pstmt);
		}
	}

	
	
}
