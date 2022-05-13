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
public class DiscountCode implements Serializable{
    private int id;
    private String code;
    private int value;
    private String status;
    private int time;
    private String from;
    private String to;

    public DiscountCode() {
    }

    public DiscountCode(int id, String code, int value, String status, int time, String from, String to) {
        this.id = id;
        this.code = code;
        this.value = value;
        this.status = status;
        this.time = time;
        this.from = from;
        this.to = to;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "DiscountCode{" + "id=" + id + ", code=" + code + ", value=" + value + ", status=" + status + ", time=" + time + ", from=" + from + ", to=" + to + '}';
    }
    
    
}
