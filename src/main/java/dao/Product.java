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
public class Product implements Serializable{
    private int id;
    private int sale;
    private String img;
    private String label;
    private String name;
    private String oldPrice;
    private String newPrice;
    private String desc;
    private String categoryId;

    public Product() {
    }

    public Product(int id, int sale, String img, String label, String name, String oldPrice, String newPrice, String desc, String categoryId) {
        this.id = id;
        this.sale = sale;
        this.img = img;
        this.label = label;
        this.name = name;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.desc = desc;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", sale=" + sale + ", img=" + img + ", label=" + label + ", name=" + name + ", oldPrice=" + oldPrice + ", newPrice=" + newPrice + ", desc=" + desc + ", categoryId=" + categoryId + '}';
    }
    
    
}
