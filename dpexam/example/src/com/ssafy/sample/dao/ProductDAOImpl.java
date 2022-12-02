package com.ssafy.sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ssafy.sample.dto.ProductDTO;
import com.ssafy.sample.util.DBUtil;

public class ProductDAOImpl implements ProductDAO {

	private DBUtil dbUtil = null;
	private ProductDAOImpl() {
		dbUtil = DBUtil.getInstance();
	}
	
	private static ProductDAOImpl instance = new ProductDAOImpl();
	public static ProductDAOImpl getIntance() {
		return instance;
	}
	
	@Override
	public int update(ProductDTO dto) throws SQLException {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("update product \n");
			sql.append("set model = ?, price = ? \n");
			sql.append("where code = ?; \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getModel());
			pstmt.setInt(2, dto.getPrice());
			pstmt.setString(3, dto.getCode());
			cnt = pstmt.executeUpdate();
			System.out.println("cnt : " + cnt);
		}finally {
			dbUtil.close(pstmt, conn);
		}
		
		return cnt;
	}
	@Override
	public int register(ProductDTO dto) throws SQLException {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into product(code, model, price) \n");
			sql.append("values( ?, ?, ? )");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getCode());
			pstmt.setString(2, dto.getModel());
			pstmt.setInt(3, dto.getPrice());
			
			cnt = pstmt.executeUpdate();
			System.out.println("cnt : " + cnt);
		}finally {
			dbUtil.close(pstmt, conn);
		}
		
		return cnt;
	}

	@Override
	public ArrayList<ProductDTO> list() throws SQLException {
		ArrayList<ProductDTO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from product \n");
			sql.append("order by code desc");
			pstmt = conn.prepareStatement(sql.toString());
			rst = pstmt.executeQuery();
			while(rst.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setCode(rst.getString(1));
				dto.setModel(rst.getString(2));
				dto.setPrice(rst.getInt(3));
				
				list.add(dto);
			}

		}finally {
			dbUtil.close(pstmt, conn, rst);
		}
		
		
		return list;
	}

	@Override
	public void view(ProductDTO dto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from product \n");
			sql.append("where code = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getCode());
			rst = pstmt.executeQuery();
			if(rst.next()) {
				
				dto.setCode(rst.getString(1));
				dto.setModel(rst.getString(2));
				dto.setPrice(rst.getInt(3));
				
			}

		}finally {
			dbUtil.close(pstmt, conn, rst);
		}
		
	}

	@Override
	public int delete(ProductDTO dto) throws SQLException {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("delete from product \n");
			sql.append("where code = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getCode());
			
			cnt = pstmt.executeUpdate();
			System.out.println("삭제 cnt : " + cnt);
		}finally {
			dbUtil.close(pstmt, conn);
		}
		
		return cnt;
	}

}










