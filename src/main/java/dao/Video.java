/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class Video implements Serializable{
    private int id;
    private String link;

    public Video() {
    }

    public Video(int id, String link) {
        this.id = id;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Video{" + "id=" + id + ", link=" + link + '}';
    }
    
    
    
}
