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
public class VideoDAO implements Serializable{
    private static VideoDAO instance;
    
    private Connection conn = DBUtil.makeConnection();

    private VideoDAO() {
    }
    
    public static VideoDAO getInstance() {
        if(instance == null) 
            return new VideoDAO();
        return instance;
    }
    
    public List<Video> getAll() {

        PreparedStatement stm;
        ResultSet rs;

        List<Video> videoList = new ArrayList();
        try {

            String sql = "SELECT * FROM Video";
            stm = conn.prepareStatement(sql);
            
            rs = stm.executeQuery();
            while (rs.next()) {
                videoList.add(new Video(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return videoList;
    }
    
    public Video addOneVideo(Video video) {
        PreparedStatement stm;
        Video vid = new Video();
        try {
            String sql = "insert into Video values(?, ?)";
            stm = conn.prepareStatement(sql);
            stm.setInt(1, video.getId());
            stm.setString(2, video.getLink());
            if(stm.executeUpdate() > 0) {
                vid.setId(video.getId());
                vid.setLink(video.getLink());
                return vid;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    
    public String deleteOneVideo(String id) {
        PreparedStatement stm;
        Video vid = new Video();
        try {
            String sql = "DELETE FROM Video WHERE id = ?";
            stm = conn.prepareStatement(sql);
            
            stm.setString(1, id);
            if (stm.executeUpdate() > 0) {
                return "Xoá thành công";
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    
    public static void main(String[] args) {
        System.out.println("All of videos: \n" + getInstance().getAll());
        
    }
}
