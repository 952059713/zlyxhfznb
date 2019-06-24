package com.zlyznbxhf.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zlyznbxhf.mapper.ProductMapper;
import com.zlyznbxhf.mapper.ShoppingCartMapper;
import com.zlyznbxhf.po.Product;
import com.zlyznbxhf.po.ShoppingCart;
import com.zlyznbxhf.service.ShoppingCartService;
import com.zlyznbxhf.vo.ShopCartProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public JSONObject addToCart(ShoppingCart shoppingCart) {
        JSONObject jsonObject = new JSONObject();
        int i = shoppingCartMapper.insertSelective(shoppingCart);
        if (i==1){
            jsonObject.put("code",0);
            jsonObject.put("msg","添加成功");
        }
        else {
            jsonObject.put("code",1);
            jsonObject.put("msg","添加失败");
        }

        return jsonObject;
    }

    @Override
    public JSONObject getCartList(Integer id) {
        List<ShopCartProduct> shopCartProducts = shoppingCartMapper.selectCartByUser(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","用户购物车");
        jsonObject.put("data",shopCartProducts);
        return jsonObject;
    }

    @Override
    public JSONObject deleteCart(Integer[] shoppingcartid) {
        JSONObject jsonObject = new JSONObject();
        int sum = 0;
        for (int i =0; i<shoppingcartid.length;i++){
            shoppingCartMapper.deleteByPrimaryKey(shoppingcartid[i]);
            sum++;
        }
        if(sum==shoppingcartid.length){
            jsonObject.put("code",0);
            jsonObject.put("msg","删除成功");
        }else {
            jsonObject.put("code",1);
            jsonObject.put("msg","删除失败");
        }
        return jsonObject;
    }

    @Override
    public JSONObject updateCart(Integer pId, Integer productnum) {
        JSONObject jsonObject = new JSONObject();
        ShoppingCart shoppingCart = shoppingCartMapper.selectByPrimaryKey(pId);
        Product product = productMapper.selectByPrimaryKey(shoppingCart.getProductid());
        if (product.getStock()<productnum){
            jsonObject.put("code",2);
            jsonObject.put("msg","库存不足");
        }
        else{
            shoppingCart.setProductnum(productnum);
            int i = shoppingCartMapper.updateByPrimaryKeySelective(shoppingCart);
            if(i!=0){
                jsonObject.put("code",0);
                jsonObject.put("msg","数量更新成功");
            }else {
                jsonObject.put("code",1);
                jsonObject.put("msg","数量更新失败");
            }
        }
        return jsonObject;
    }

    @Override
    public JSONObject getOrderCartList(Integer[] ids) {
        List<ShopCartProduct> shopCartProducts= new ArrayList<>();
        for(int i =0 ;i < ids.length;i++){
            ShoppingCart shoppingCart1 = shoppingCartMapper.selectById(ids[i]);
            shopCartProducts.add((ShopCartProduct) shoppingCart1);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","购物车结算");
        jsonObject.put("data",shopCartProducts);
        return jsonObject;
    }


}
