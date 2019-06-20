package com.egglib.xpro.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/*
 * File: Goods.java
 * Description:
 * Author: XiaoTao
 * Create at 2019-06-20 12:42
 */
@Entity
public class Goods {

    @Id
    private long id;
    private String name;
    private double price;
    @Generated(hash = 777608482)
    public Goods(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    @Generated(hash = 1770709345)
    public Goods() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

}
