package com.eshore.test;


import com.eshore.factory.DAOFactory;
import com.eshore.pojo.Product;
import java.util.*;

public class DaoInsertTest {
    public static void main(String[] args) throws Exception{
        //Product p = null;
        List<Product> list= DAOFactory.getDAOInstance().findAll("");
        if(list == null) {
            System.out.println("null");
        } else{
            for(Product p : list) {
                System.out.println("产品编号：" + p.getId());
                System.out.println("产品名称：" + p.getName());
                System.out.println("产品的价格：" + p.getPrice());
                System.out.println("产品的信息:" + p.getInfo());
                System.out.println();
            }
            
        }
       
//        Product p = null;
//        try{
//            for(int i=0; i<5; i++) {
//                p = new Product();
//                p.setId("2456588" + i);
//                p.setName("杯子");
//                p.setPrice(100 + i);
//                p.setInfo("精品杯子");
//                System.out.println(DAOFactory.getDAOInstance().addProduct(p));
//            }
//        }catch(Exception e) {
//            e.printStackTrace();
//        }

        
        
    }
}
