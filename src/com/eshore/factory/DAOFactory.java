package com.eshore.factory;

import com.eshore.dao.ProductDaoInter;
import com.eshore.service.ProductService;

public class DAOFactory {
    public static ProductDaoInter getDAOInstance() throws Exception {
        return new ProductService();
    }
}
