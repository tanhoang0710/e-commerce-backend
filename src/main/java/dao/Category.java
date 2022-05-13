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
public class Category implements Serializable{
    private int id;
    private String name;
    private String desc;
    private String image;
    private String category;

    public Category() {
    }

    public Category(int id, String name, String desc, String image, String category) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.image = image;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", name=" + name + ", desc=" + desc + ", image=" + image + ", category=" + category + '}';
    }
    
    
}
