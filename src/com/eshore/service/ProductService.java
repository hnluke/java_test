package com.eshore.service;

import com.eshore.dao.ProductDaoImpl;
import com.eshore.dao.ProductDaoInter;
import com.eshore.db.DBConnection;
import com.eshore.pojo.Product;

import java.sql.Connection;
import java.util.List;

public class ProductService implements ProductDaoInter{
    
    private DBConnection dbconn = null;
    private ProductDaoImpl dao = null;
    
    public ProductService() throws Exception{
        this.dbconn = new DBConnection();
        this.dao = new ProductDaoImpl(this.dbconn.getConn());
    }
    @Override
    public boolean addProduct(Product product) throws Exception {
        boolean flag = false;
        try {
            if(this.dao.findByID(product.getId()) == null) {
                flag = this.dao.addProduct(product);
            }
        }catch(Exception e){
            throw e;
        }finally {
            this.dbconn.close();
        }
        
        return flag;
    }

    @Override
    public List<Product> findAll(String name) throws Exception {
        List<Product> all = null;
        try {
            all = this.dao.findAll(name);
        }catch(Exception e) {
            throw e;
        }finally {
            this.dbconn.close();
        }
        return all;
    }

    @Override
    public Product findByID(String id) throws Exception {
        Product p = null;
        try {
            this.dao.findByID(id);
        }catch (Exception e) {
            throw e;
        }finally {
            this.dbconn.close();
        }
        return p;
    }
    
   
}
