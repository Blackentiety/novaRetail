package com.novaretail.intranet;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.util.Properties;

public class NovaRetailPipeline {
    public static void main(String[] args){
        SparkSession spark = SparkSession.builder()
                .appName("NovaRetail")
                .config("spark.master", "local[*]")
                .getOrCreate();

        String url = "jdbc:mysql://localhost:3306/novaretail_legacy";
        String user = "admin";
        String password = "Adm1n!";

        Properties connectionProp = new Properties();
        connectionProp.put("user", user);
        connectionProp.put("password", password);
        connectionProp.put("driver", "com.mysql.cj.jdbc.Driver");

        System.out.println("============================================");
        System.out.println("CONNEXION DB NOVARETAIL_LEGACY");
        System.out.println("============================================");
    }
}
