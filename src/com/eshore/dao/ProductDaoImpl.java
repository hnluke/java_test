package com.eshore.dao;

import com.eshore.pojo.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class ProductDaoImpl implements ProductDaoInter{

    
    private Connection conn;

    private PreparedStatement preState = null;
    
    public ProductDaoImpl() {
    }
    public ProductDaoImpl(Connection conn) {
        this.conn = conn;
    }
    @Override
    public boolean addProduct(Product product) throws Exception {
        boolean flag = false;
        String sql = "insert into product(id, name, price, info) values(?, ?, ?, ?)";
        this.preState = this.conn.prepareStatement(sql);
        this.preState.setString(1, product.getId());
        this.preState.setString(2, product.getName());
        this.preState.setDouble(3, product.getPrice());
        this.preState.setString(4, product.getInfo());

        if(this.preState.executeUpdate() > 0) {
            flag = true;
        }
        this.preState.close();

        return flag;
    }

    @Override
    public List<Product> findAll(String name) throws Exception {
        List<Product> list = new ArrayList<Product>();
        String sql = "select * from product";
        if (name != null && !"".equals(name)) {
            sql = "select * from product where name like ?";
            this.preState = this.conn.prepareStatement(sql);
            this.preState.setString(1, "%" + name + "%");
        } else {
            this.preState = this.conn.prepareStatement(sql);
        }
      
        ResultSet rs = this.preState.executeQuery();    
        Product p = null;
        while (rs.next()) {
            p = new Product();
            p.setId(rs.getString(1));
            p.setName(rs.getString(2));
            p.setPrice(rs.getDouble(3));
            p.setInfo(rs.getString(4));
            list.add(p);
        }
        this.preState.close();
        return list;
    }
        
        

    @Override
    public Product findByID (String id) throws Exception {
        Product p = null;
        String sql = "select * from product where id = ?";
        this.preState = this.conn.prepareStatement(sql);
        this.preState.setString(1, id);
        ResultSet rs = this.preState.executeQuery();
        while (rs.next()) {
            p = new Product();
            p.setId(rs.getString(1));
            p.setName(rs.getString(2));
            p.setPrice(rs.getDouble(3));
            p.setInfo(rs.getString(4));
        }
        //this.preState.close();
        this.preState.close();
        return p;
        
    }

}
    
    

    

    


        //@Override

//    public Product findByID(String id) throws Exception{
//        Product p = null;
//        String sql = "select * from product where id = ?";
//        this.preState = this.conn.prepareStatement(sql);
//        this.preState.setString(1, id);
//        ResultSet rs = this.preState.executeQuery();
//        while(rs.next()) {
//            p = new Product();
//            p.setId(rs.getString(1));
//            p.setName(rs.getString(2));
//            p.setPrice(rs.getDouble(3));
//            p.setInfo(rs.getString(4));
//        }
//        this.preState.close();
//        return p;
//    }


   

        