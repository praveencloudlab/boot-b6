package com.cts.ecart.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cts.ecart.model.Product;

@Repository
public class ProductDaoImpl {
	
	@Autowired
	private JdbcTemplate jt;
	
	// query for map: single record
	public void f1(int productId) {
		String q1="select * from products where product_id=?";
		Map<String, Object> row = jt.queryForMap(q1,productId);
		System.out.println(row);
	}
	
	//query for list : multiple records
	public void f2() {
		String q2="select * from products";
		List<Map<String, Object>> rows = jt.queryForList(q2);
		rows.forEach(System.out::println);
	}
	
	// query for domain objects
	/*
	 *  1.RowMapper
	 *  2.ResultSetExtractor
	 *  3.RowCallbackHandler
	 *  
	 *  1.RowMapper
	 *  =================
	 *   Spring provides a RowMapper interface for mapping a single row of a ResultSet to an object
			– Can be used for both single and multiple row queries
			- single row use method jdbcTemplate.queryForObject
			- multiple rows use query method
			- must implement mapRow(ResultSet rs, int rowNum) throws SQLException
			
			
	     2.ResultSetExtractor
	     ========================
	     Spring provides a ResultSetExtractor interface for processing an entire ResultSet at once
			– You are responsible for iterating the ResultSet
			– e.g. for mapping entire ResultSet to a single object
			- must implement T extractData(ResultSet rs) throws SQLException,DataAccessException;
			- use query() method for fetching records
			
	 *  
	 *  
	 */
	
	 // query method using RowMapper interface for multiple rows
	public List<Product> f3(){
		String q3="select * from products";
		List<Product> prods= jt.query(q3, new RowMapperDemo());
		return prods;
	}
	
	// queryForObject method for single row operations
	public Product f4(int productId) {
		String q4="select * from products where product_id=?";
		Product product = jt.queryForObject(q4, new RowMapperDemo(),productId);
		return product;
	}
	
	// ResultSetExtractor interface for single record
	public Product f5(int productId) {
		String q5="select * from products where product_id=?";
		Product product = jt.query(q5, new ResultSetExtractorDemo(),productId);
		return product;
	}
	
	//ResultSetExtractor :: multiple records
	public List<Product> f6() {
		String q6="select * from products";
		List<Product> products = jt.query(q6, new ResultSetExtractorDemoV1());
		return products;
	}
	
	
}

// RowMapper
class RowMapperDemo implements RowMapper<Product>{
	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		   	Product prod=null;
			 prod=new Product();
			 prod.setProductId(rs.getInt("product_id"));
			 prod.setProductName(rs.getString("product_name"));
			 prod.setPrice(rs.getDouble("price"));
		return prod;
	}
}

//ResultSetExtractor :: single record
class ResultSetExtractorDemo implements ResultSetExtractor<Product>{
	@Override
	public Product extractData(ResultSet rs) throws SQLException, DataAccessException {
		Product prod=null;
		if(rs.next()) {
			 prod=new Product();
			 prod.setProductId(rs.getInt("product_id"));
			 prod.setProductName(rs.getString("product_name"));
			 prod.setPrice(rs.getDouble("price"));
		}
		return prod;
	}
}

//ResultSetExtractor for multiple records
class ResultSetExtractorDemoV1 implements ResultSetExtractor<List<Product>>{
	
	private List<Product> prods=new ArrayList<>();
	@Override
	public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Product prod=null;
		while(rs.next()) {
			 prod=new Product();
			 prod.setProductId(rs.getInt("product_id"));
			 prod.setProductName(rs.getString("product_name"));
			 prod.setPrice(rs.getDouble("price"));
			 
			 prods.add(prod);
			 
		}
		
		return prods;
	}
}





