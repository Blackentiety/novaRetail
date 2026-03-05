package com.novaretail.intranet;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.util.Properties;

import static org.apache.spark.sql.functions.col;

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

        // Lecture de la table customer_transactions
        Dataset<Row> rawData = spark.read().jdbc(url, "customer_transactions", connectionProp);

        // Nettoyage des données
        Dataset<Row> cleanedData = rawData.filter(col("country").isNotNull());

        // Anonymisation des données
        Dataset<Row> anonymizedData = cleanedData.drop("customer_email");

        // Tri des données
        Dataset<Row> sortedData = anonymizedData.sort(
                col("country").asc(),
                col("purchase_amount").desc()
        );

        // Export des données
        sortedData.write()
                .mode("overwrite")
                .partitionBy("country")
                .json("output/data_lake/transactions_archive");

        System.out.println("Pipeline terminé avec succès !");
        spark.stop();
    }
}
