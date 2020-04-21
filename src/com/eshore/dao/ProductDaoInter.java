package com.eshore.dao;

import com.eshore.pojo.Product;
import java.util.*;

public interface ProductDaoInter {
    
    // 新增数据Product
    public boolean addProduct(Product product) throws Exception;
    
    // 查询所有的数据，如果参数name不为空，就返回name字段中含有等于"name字串"的数据
    public List<Product> findAll(String name) throws Exception;
    
    // 根据产品编号id来查询产品
    public Product findByID(String id) throws Exception;
    
    
}
