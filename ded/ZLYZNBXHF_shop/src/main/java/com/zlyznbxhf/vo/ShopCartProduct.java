package com.zlyznbxhf.vo;

import com.zlyznbxhf.po.Product;
import com.zlyznbxhf.po.ShoppingCart;

public class ShopCartProduct extends ShoppingCart {
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ShopCartProduct{" +
                "product=" + product +
                '}';
    }
}
