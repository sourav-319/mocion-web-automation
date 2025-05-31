package com.mocion.web.config;

import com.mocion.web.utils.Constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static final Properties prop = new Properties();

    public static Properties init() {
        try (FileInputStream fis = new FileInputStream(Constants.CONFIG_PATH)) {
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Config file loading failed!", e);
        }
        return prop;
    }
}
