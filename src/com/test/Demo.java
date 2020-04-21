package com.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Demo {
    public static void main(String[] args) throws IOException {
        ComboPooledDataSource cpd = new ComboPooledDataSource();
        Properties cfg = new Properties();
        System.out.println(cfg);
        System.out.println(cfg.size());
        System.out.println(cfg.isEmpty());
        InputStream in = Demo.class.getClassLoader()
                .getResourceAsStream("db.properties");
        cfg.load(in);
        System.out.println(cfg);
        System.out.println(cfg.size());
        String s = cfg.getProperty("jdbc.url");
        System.out.println(s);
        in.close();
    }
}
