package org.asinfo.lib.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Classe utilitaire ; outils de configuration des APIs.
 */
public class ConfigClient {

    private static final String PROP_FILE = "config.properties";

    /**
     * Permet d'accéder aux différentes variables de configuration
     * du fichier 'config.properties'.
     *
     * @param key Clé de la variable (String)
     * @return Variable de configuration (String)
     * @throws IOException Exception
     */
    public static String getProp(String key) throws IOException {
        String p = null;
        Properties prop = new Properties();
        FileInputStream stream = new FileInputStream(PROP_FILE);
        prop.load(stream);
        p = prop.getProperty(key);
        return p;
    }
}
