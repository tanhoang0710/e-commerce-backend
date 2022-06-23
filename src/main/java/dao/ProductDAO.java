/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBUtil;

/**
 *
 * @author DELL
 */
public class ProductDAO implements Serializable {

    private static ProductDAO instance;

    private Connection conn = DBUtil.makeConnection();

    private ProductDAO() {

    }

    public static ProductDAO getInstance() {
        if (instance == null) {
            return new ProductDAO();
        }
        return instance;
    }

    public List<Product> getAllByType(String type) {

        PreparedStatement stm;
        ResultSet rs;

        List<Product> productList = new ArrayList<>();
        try {

            String sql = "select * from Product p inner join Category c \n"
                    + "on p.categoryId = c.id \n"
                    + "where c.category = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, type);

            rs = stm.executeQuery();
            while (rs.next()) {
                productList.add(new Product(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return productList;
    }
    
    public List<Product> getByName(String name) {

        PreparedStatement stm;
        ResultSet rs;

        List<Product> productList = new ArrayList<>();
        try {

            String sql = "select * from Product where [name] like N'%" + name + "%'";
            stm = conn.prepareStatement(sql);  

            rs = stm.executeQuery();
            while (rs.next()) {
                productList.add(new Product(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return productList;
    }

    public Product addOneProduct(Product product) {
        PreparedStatement stm;
        Product product1 = new Product();
        try {
            String sql = "insert into Product values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stm = conn.prepareStatement(sql);
            stm.setString(1, product.getId());
            stm.setInt(2, product.getSale());
            stm.setString(3, product.getImg());
            stm.setString(4, product.getLabel());
            stm.setString(5, product.getName());
            stm.setString(6, product.getOldPrice());
            stm.setString(7, product.getNewPrice());
            stm.setString(8, product.getDesc());
            stm.setString(9, product.getCategoryId());
            if (stm.executeUpdate() > 0) {
                product1.setId(product.getId());
                product1.setSale(product.getSale());
                product1.setImg(product.getImg());
                product1.setLabel(product.getLabel());
                product1.setName(product.getName());
                product1.setOldPrice(product.getOldPrice());
                product1.setNewPrice(product.getNewPrice());
                product1.setDesc(product.getDesc());
                product1.setCategoryId(product.getCategoryId());
                return product1;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public String deleteOneProduct(String id) {
        PreparedStatement stm;
        Product product = new Product();
        try {
            String sql = "DELETE FROM Product WHERE id = ?";
            stm = conn.prepareStatement(sql);

            stm.setString(1, id);
            if (stm.executeUpdate() > 0) {
                return id + "";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Product editOneProduct(Product product) {
        PreparedStatement stm;
        Product product1 = new Product();
        try {
            String sql = ""
                    + "UPDATE Product "
                    + "SET sale = ?, label = ?, name = ?, oldPrice = ?, newPrice = ?, [desc] = ? "
                    + "WHERE id = ?";
            stm = conn.prepareStatement(sql);

            stm.setInt(1, product.getSale());
            stm.setString(2, product.getLabel());
            stm.setString(3, product.getName());
            stm.setString(4, product.getOldPrice());
            stm.setString(5, product.getNewPrice());
            stm.setString(6, product.getDesc());
            stm.setString(7, product.getId());
            if (stm.executeUpdate() > 0) {
                product1.setId(product.getId());
                product1.setSale(product.getSale());
                product1.setImg(product.getImg());
                product1.setLabel(product.getLabel());
                product1.setName(product.getName());
                product1.setOldPrice(product.getOldPrice());
                product1.setNewPrice(product.getNewPrice());
                product1.setDesc(product.getDesc());
                product1.setCategoryId(product.getCategoryId());
                return product1;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("products: \n" + getInstance().getAllByType("kitchen-cabinet"));

    }
}
