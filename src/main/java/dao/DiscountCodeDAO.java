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
public class DiscountCodeDAO implements Serializable {

    private static DiscountCodeDAO instance;

    private Connection conn = DBUtil.makeConnection();

    private DiscountCodeDAO() {
    }

    public static DiscountCodeDAO getInstance() {
        if (instance == null) {
            return new DiscountCodeDAO();
        }
        return instance;
    }

    public List<DiscountCode> getAll() {

        PreparedStatement stm;
        ResultSet rs;

        List<DiscountCode> DiscountCodeList = new ArrayList();
        try {

            String sql = "SELECT * FROM DiscountCode";
            stm = conn.prepareStatement(sql);

            rs = stm.executeQuery();
            while (rs.next()) {
                DiscountCodeList.add(new DiscountCode(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return DiscountCodeList;
    }

    public DiscountCode getOne(String code) {

        PreparedStatement stm;
        ResultSet rs;

        DiscountCode dsCode;
        try {

            String sql = "SELECT * FROM DiscountCode\n"
                    + "WHERE code = ? ";
            stm = conn.prepareStatement(sql);
            stm.setString(1, code);
            
            rs = stm.executeQuery();
            if (rs.next()) {
                dsCode = new DiscountCode(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7));
                return dsCode;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public DiscountCode addOneDiscountCode(DiscountCode discountCode) {

        PreparedStatement stm;
        DiscountCode dsCode = new DiscountCode();
        try {
            String sql = "insert into DiscountCode values(?, ?, ?, ?, ?, ?, ?)";
            stm = conn.prepareStatement(sql);
            stm.setString(1, discountCode.getId());
            stm.setString(2, discountCode.getCode());
            stm.setInt(3, discountCode.getValue());
            stm.setString(4, discountCode.getStatus());
            stm.setInt(5, discountCode.getTime());
            stm.setString(6, discountCode.getFrom());
            stm.setString(7, discountCode.getTo());
            if (stm.executeUpdate() > 0) {
                dsCode.setId(discountCode.getId());
                dsCode.setCode(discountCode.getCode());
                dsCode.setValue(discountCode.getValue());
                dsCode.setStatus(discountCode.getStatus());
                dsCode.setTime(discountCode.getTime());
                dsCode.setFrom(discountCode.getFrom());
                dsCode.setTo(discountCode.getTo());
                return dsCode;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public DiscountCode editOneDiscountCode(DiscountCode discountCode) {
        PreparedStatement stm;
        DiscountCode dsCode = new DiscountCode();
        try {
            String sql = "UPDATE DiscountCode\n"
                    + "SET code = ?, value = ?, status = ?, time = ?, [from] = ?, [to] = ?\n"
                    + "WHERE id = ?";
            stm = conn.prepareStatement(sql);

            stm.setString(1, discountCode.getCode());
            stm.setInt(2, discountCode.getValue());
            stm.setString(3, discountCode.getStatus());
            stm.setInt(4, discountCode.getTime());
            stm.setString(5, discountCode.getFrom());
            stm.setString(6, discountCode.getTo());
            stm.setString(7, discountCode.getId());
            if (stm.executeUpdate() > 0) {
                dsCode.setId(discountCode.getId());
                dsCode.setCode(discountCode.getCode());
                dsCode.setValue(discountCode.getValue());
                dsCode.setStatus(discountCode.getStatus());
                dsCode.setTime(discountCode.getTime());
                dsCode.setFrom(discountCode.getFrom());
                dsCode.setTo(discountCode.getTo());
                return dsCode;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String deleteOneDiscountCode(String id) {
        PreparedStatement stm;
        DiscountCode dsCode = new DiscountCode();
        try {
            String sql = "DELETE FROM DiscountCode WHERE id = ?";
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

    public static void main(String[] args) {
        System.out.println("All of DiscountCodes: \n" + getInstance().getAll());

    }
}
