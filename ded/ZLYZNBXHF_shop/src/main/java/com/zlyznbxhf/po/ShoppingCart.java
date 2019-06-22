package com.zlyznbxhf.po;

import org.springframework.stereotype.Repository;

@Repository
public class ShoppingCart {
    private Integer shoppingcartid;

    private Integer productid;

    private Integer productnum;

    private Integer userid;

    private Integer status;

    public Integer getShoppingcartid() {
        return shoppingcartid;
    }

    public void setShoppingcartid(Integer shoppingcartid) {
        this.shoppingcartid = shoppingcartid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getProductnum() {
        return productnum;
    }

    public void setProductnum(Integer productnum) {
        this.productnum = productnum;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "shoppingcartid=" + shoppingcartid +
                ", productid=" + productid +
                ", productnum=" + productnum +
                ", userid=" + userid +
                ", status=" + status +
                '}';
    }
}