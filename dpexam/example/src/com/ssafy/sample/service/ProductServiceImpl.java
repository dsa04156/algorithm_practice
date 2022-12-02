package com.ssafy.sample.service;

import java.util.ArrayList;

import com.ssafy.sample.dao.ProductDAO;
import com.ssafy.sample.dao.ProductDAOImpl;
import com.ssafy.sample.dto.ProductDTO;

public class ProductServiceImpl implements ProductService {
	
	private ProductDAO dao = null;
	
	private ProductServiceImpl() {
		dao = ProductDAOImpl.getIntance();
	}
	private static ProductServiceImpl instance = new ProductServiceImpl();
	
	public static ProductServiceImpl getInstance() {
		return instance;
	}

	@Override
	public int register(ProductDTO dto) throws Exception {
		// TODO Auto-generated method stub

		return dao.register(dto);
	}

	@Override
	public ArrayList<ProductDTO> list() throws Exception {
		// TODO Auto-generated method stub
		return dao.list();
	}

	@Override
	public void view(ProductDTO dto) throws Exception {
		dao.view(dto);
		
	}

	@Override
	public int delete(ProductDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return dao.delete(dto);
	}

	@Override
	public int update(ProductDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return dao.update(dto);
	}

}
