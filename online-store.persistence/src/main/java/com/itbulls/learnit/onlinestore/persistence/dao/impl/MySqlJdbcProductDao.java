package com.itbulls.learnit.onlinestore.persistence.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itbulls.learnit.onlinestore.persistence.dao.CategoryDao;
import com.itbulls.learnit.onlinestore.persistence.dao.ProductDao;
import com.itbulls.learnit.onlinestore.persistence.dto.ProductDto;
import com.itbulls.learnit.onlinestore.persistence.utils.db.DBUtils;

public class MySqlJdbcProductDao implements ProductDao {

	private CategoryDao categoryDao;

	{
		categoryDao = new MySqlJdbcCategoryDao();
	}

	private ProductDto populateProductDto(ResultSet rs) throws SQLException {
		ProductDto product = new ProductDto();
		product.setId(rs.getInt("id"));
		product.setProductName(rs.getString("product_name"));
		product.setPrice(rs.getBigDecimal("price"));
		product.setCategoryDto(categoryDao.getCategoryByCategoryId(rs.getInt("category_id")));
		product.setProducType(rs.getString("product_type"));
		product.setDescription(rs.getString("description"));
		product.setImgName(rs.getString("img_name"));
		product.setGuid(rs.getString("guid"));
		return product;
	}

	@Override
	public List<ProductDto> getProducts() {
		try (var conn = DBUtils.getConnection();
				var ps = conn.prepareStatement("SELECT * FROM product");
				var rs = ps.executeQuery()) {
			List<ProductDto> products = new ArrayList<>();

			while (rs.next()) {
				ProductDto product = populateProductDto(rs);
				products.add(product);
			}

			return products;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ProductDto getProductById(int productId) {
		try (var conn = DBUtils.getConnection();
				var ps = conn.prepareStatement("SELECT * FROM product WHERE id = ?")) {

			ps.setInt(1, productId);
			try (var rs = ps.executeQuery()) {

				if (rs.next()) {
					ProductDto product = new ProductDto();
					product.setId(rs.getInt("id"));
					product.setProductName(rs.getString("product_name"));
					product.setPrice(rs.getBigDecimal("price"));
					product.setCategoryDto(categoryDao.getCategoryByCategoryId(rs.getInt("category_id")));
					product.setProducType(rs.getString("product_type"));
					product.setDescription(rs.getString("description"));
					product.setImgName(rs.getString("img_name"));
					return product;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ProductDto> getProductsLikeName(String searchQuery) {

		String lowercaseString = searchQuery.toLowerCase();
		// TODO Auto-generated method stub
		try (var conn = DBUtils.getConnection();
				var ps = conn.prepareStatement("SELECT * FROM product WHERE product_type LIKE ?")) {
			ps.setString(1, "%" + lowercaseString + "%");
			List<ProductDto> products = new ArrayList<>();
			try (var rs = ps.executeQuery()) {
				while (rs.next()) {
					ProductDto product = populateProductDto(rs);
					products.add(product);
				}
			}
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ProductDto> getProductsByCategoryId(Integer categoryId) {
		// TODO Auto-generated method stub
		try (var conn = DBUtils.getConnection();
				var ps = conn.prepareStatement("SELECT * FROM product WHERE category_id = ?")) {

			ps.setInt(1, categoryId);
			List<ProductDto> products = new ArrayList<>();
			try (var rs = ps.executeQuery()) {
				while (rs.next()) {
					ProductDto product = populateProductDto(rs);
					products.add(product);
				}
			}
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ProductDto> getProductsByCategoryIdPaginationLimit(Integer categoryId, Integer page,
			Integer paginationLimit) {
		try (var conn = DBUtils.getConnection();
				var ps = conn.prepareStatement("SELECT * FROM product WHERE category_id = ? LIMIT ? OFFSET ?")) {

			ps.setInt(1, categoryId);
			ps.setInt(2, paginationLimit);
			ps.setInt(3, (page - 1) * paginationLimit);

			List<ProductDto> products = new ArrayList<>();
			try (var rs = ps.executeQuery()) {
				while (rs.next()) {
					ProductDto product = populateProductDto(rs);
					products.add(product);
				}
			}
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer getProductCountForCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		try (var conn = DBUtils.getConnection();
				var ps = conn.prepareStatement("SELECT COUNT(*) FROM product WHERE category_id = ?")) {
			ps.setInt(1,categoryId);
			try (var rs = ps.executeQuery()) {
				if (rs.next()) {
					return rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Integer getProductCountForSearch(String searchQuery) {
		// TODO Auto-generated method stub
		String lowercaseString = searchQuery.toLowerCase();

		try (var conn = DBUtils.getConnection();
				var ps = conn.prepareStatement("SELECT COUNT(*) FROM product WHERE product_type LIKE ?")) {
			ps.setString(1, "%" + lowercaseString + "%");
			try (var rs = ps.executeQuery()) {
				if (rs.next()) {
					return rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<ProductDto> getProductsLikeNameForPageWithLimit(String searchQuery, Integer page,
			Integer paginationLimit) {
		// TODO Auto-generated method stub
		try (var conn = DBUtils.getConnection();
				var ps = conn.prepareStatement("SELECT * FROM product WHERE product_type LIKE ? LIMIT ? OFFSET ?")) {

			ps.setString(1, searchQuery);
			ps.setInt(2, paginationLimit);
			ps.setInt(3, (page - 1) * paginationLimit);

			List<ProductDto> products = new ArrayList<>();
			try (var rs = ps.executeQuery()) {
				while (rs.next()) {
					ProductDto product = populateProductDto(rs);
					products.add(product);
				}
			}
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ProductDto getProductByGuid(String guid) {
		try (var conn = DBUtils.getConnection();
				var ps = conn.prepareStatement("SELECT * FROM product WHERE guid = ?")) {

			ps.setString(1, guid);
			try (var rs = ps.executeQuery()) {

				if (rs.next()) {
					ProductDto product = populateProductDto(rs);
					return product;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
