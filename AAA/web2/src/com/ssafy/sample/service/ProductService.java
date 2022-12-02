package com.ssafy.sample.service;

import java.util.ArrayList;

import com.ssafy.sample.dto.ProductDTO;

public interface ProductService {
	int	register(ProductDTO dto) throws Exception;
	ArrayList<ProductDTO> list() throws Exception;
	void view(ProductDTO dto) throws Exception;
	int	 delete(ProductDTO dto) throws Exception;
	int	 update(ProductDTO dto) throws Exception;
}

