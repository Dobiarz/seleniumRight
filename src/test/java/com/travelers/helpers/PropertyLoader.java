package com.travelers.helpers;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class PropertyLoader {
    public static Configuration loadProperies() throws ConfigurationException {
        Configurations configs = new Configurations();
        Configuration config = configs.properties("src/main/resources/test.properties");

        return config;


    }

    public static void main(String[] args) throws ConfigurationException {
        Configuration config = loadProperies();
        // Metody do pobrania wartosci z pliku properties
//        config.getString("driver");
//        config.getString("isDev");
        System.out.println(config.getString("driver"));
        System.out.println(config.getString("isDev"));

    }
}
