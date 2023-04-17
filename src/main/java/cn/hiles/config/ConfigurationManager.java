package cn.hiles.config;

/**
 * 功能描述
 *
 * @author Helios
 * Time：2023-04-17 20:42
 */
public class ConfigurationManager {
    private static ConfigurationManager myConfigurationManager;

    private static Configuration myCurrentConfiguration;

    private ConfigurationManager() {
    }

    public static ConfigurationManager getInstance() {
        if (myConfigurationManager == null) {
            myConfigurationManager = new ConfigurationManager();
        }
        return myConfigurationManager;
    }

    /**
     * Load configuration from file
     * @param path path of configuration file
     */
    public void loadConfiguration(String path) {


    }

    /**
     * Return the current loaded configuration
     */
    public void getCurrenConfiguration(){

    }
}
