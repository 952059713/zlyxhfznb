package com.zlyznbxhf.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zlyznbxhf.mapper.*;
import com.zlyznbxhf.po.OrderDetail;
import com.zlyznbxhf.po.Orders;
import com.zlyznbxhf.po.Product;
import com.zlyznbxhf.po.ShoppingCart;
import com.zlyznbxhf.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private OrderDetailMapper orderDetialMapper;

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Autowired
    private ProductMapper productMapper;

    /**
     * 处理订单
     * @param ids
     * @param address_id
     * @param customer_id
     * @return
     */
    @Override
    public JSONObject handlerGenerationOrder(Integer[] ids, Integer address_id,Integer customer_id) {
        Object[] par = getPar(ids,address_id,customer_id);
        JSONObject jsonObject = new JSONObject();
        Orders order = generationOrder(par);
        for(int i = 0; i< ids.length;i++){
            ShoppingCart shoppingCart = shoppingCartMapper.selectByPrimaryKey(ids[i]);
            generationOrderDetial(order,shoppingCart);
        }
        jsonObject.put("code",0);
        jsonObject.put("msg","订单生成");
        jsonObject.put("data",order.getOrderid());
        return jsonObject;
    }


    /**
     * 生成订单
     * @param par
     * @return
     */
    public  Orders generationOrder(Object[] par){
        Orders order = new Orders();
        order.setUserid((Integer) par[0]);
        order.setTotalnum((Integer) par[1]);
        order.setTotalprice((Double) par[2]);
        order.setAddressid((Integer) par[3]);
        order.setStatus(1);
        ordersMapper.insert(order);
        return order;
    }

    /**
     * 获取用户信息，产品信息,订单金额信息
     * @param ids
     * @param address_id
     * @param customer_id
     * @return
     */
    public Object[] getPar(Integer[] ids, Integer address_id,Integer customer_id){
        int sum = 0;
        double total_money=0;
        for(int i = 0; i< ids.length;i++){
            ShoppingCart shoppingCart = shoppingCartMapper.selectByPrimaryKey(ids[i]);
            Product product = productMapper.selectByPrimaryKey(shoppingCart.getProductid());
            sum += shoppingCart.getProductnum();
            total_money +=shoppingCart.getProductnum()*product.getPrice();
            product.setStock(product.getStock()-shoppingCart.getProductnum());
            product.setSales(product.getSales()+shoppingCart.getProductnum());
            productMapper.updateByPrimaryKeySelective(product);
        }
        Object[] par = {customer_id,sum,total_money,address_id};
        return par;
    }

    /**
     * 生成订单详情,并处理购物车
     * @param order
     * @param shoppingCart
     */
    public void  generationOrderDetial (Orders order,ShoppingCart shoppingCart){
        try {
            OrderDetail orderDetial= new OrderDetail();
            orderDetial.setOrderid(order.getOrderid());
            orderDetial.setProductid(shoppingCart.getProductid());
            orderDetial.setProductnum(shoppingCart.getProductnum());
            orderDetialMapper.insertSelective(orderDetial);
            shoppingCartMapper.deleteByPrimaryKey(shoppingCart.getShoppingcartid());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
