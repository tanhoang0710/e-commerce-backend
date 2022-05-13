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
public class CategoryDAO implements Serializable{
    private static CategoryDAO instance;
    
    private Connection conn = DBUtil.makeConnection();

    private CategoryDAO() {
    }
    
    public static CategoryDAO getInstance() {
        if(instance == null) 
            return new CategoryDAO();
        return instance;
    }
    
    public List<Category> getAll() {

        PreparedStatement stm;
        ResultSet rs;

        List<Category> categoryList = new ArrayList();
        try {

            String sql = "SELECT * FROM Category";
            stm = conn.prepareStatement(sql);
            
            rs = stm.executeQuery();
            while (rs.next()) {
                categoryList.add(new Category(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return categoryList;
    }
    
    

    
    public static void main(String[] args) {
        System.out.println("All of categories: \n" + getInstance().getAll());
        
    }
}
