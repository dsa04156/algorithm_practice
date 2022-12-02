package com.ssafy.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ssafy.test.util.DBUtil;

import dto.MemberDTO;
import dto.noteDTO;

public class NoteDAOImpl implements NoteDAO {
	DBUtil dbUtil = null;
	private NoteDAOImpl() {
		dbUtil = DBUtil.getInstance();
	}
	private static NoteDAOImpl instance = new NoteDAOImpl();
	public static NoteDAOImpl getInstance() {
		return instance;
	}
	public void doRegist(noteDTO dto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt= null;
		try {
			StringBuilder sql = new StringBuilder();
			conn = dbUtil.getConnection();
			sql.append("insert into note \n");
			sql.append("values (?,?,?,?);");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getNoteCode());
			pstmt.setString(2, dto.getModel());
			pstmt.setInt(3, dto.getPrice());
			pstmt.setString(4, dto.getCompany());
			pstmt.executeUpdate();
		}finally {
			dbUtil.close(conn,pstmt);
		}
	}
	public ArrayList<noteDTO> viewList() throws SQLException {
		ArrayList<noteDTO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rst = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * \n");
			sql.append("from note ;");
			pstmt=conn.prepareStatement(sql.toString());
			rst = pstmt.executeQuery();
			while(rst.next()) {
				noteDTO dto = new noteDTO();
				dto.setNoteCode(rst.getString(1));
				dto.setModel(rst.getString(2));
				dto.setPrice(rst.getInt(3));
				dto.setCompany(rst.getString(4));
				list.add(dto);
			}
		}finally {
			dbUtil.close(rst,conn,pstmt);
		}
		return list;
	}
	public void view(noteDTO dto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rst=null;
		try {
			StringBuilder sql = new StringBuilder();
			conn= dbUtil.getConnection();
			sql.append("select * from note \n ");
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
			dbUtil.close(conn,rst,pstmt);
		}
	}
	public void delete(noteDTO dto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		try {
			StringBuilder sql = new StringBuilder();
			conn = dbUtil.getConnection();
			sql.append("delete from note \n");
			sql.append("where noteCode=? ;");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getNoteCode());
			pstmt.executeUpdate();
		}finally {
			dbUtil.close(conn,rst,pstmt);
		}
	}

}
