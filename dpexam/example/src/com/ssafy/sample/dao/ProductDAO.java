package com.ssafy.sample.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ssafy.sample.dto.ProductDTO;

public interface ProductDAO {
	int	register(ProductDTO dto) throws SQLException;
	ArrayList<ProductDTO> list() throws SQLException;
	void view(ProductDTO dto) throws SQLException;
	
	int	delete(ProductDTO dto) throws SQLException;
	int	update(ProductDTO dto) throws SQLException;
}
