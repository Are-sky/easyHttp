package cn.hiles.config;

/**
 * 功能描述
 *
 * @author 邱彦祥
 * 时间：2023-04-17 20:42
 */
public class Configuration {
    private int port;
    private String webRoot;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getWebRoot() {
        return webRoot;
    }

    public void setWebRoot(String webRoot) {
        this.webRoot = webRoot;
    }
}
