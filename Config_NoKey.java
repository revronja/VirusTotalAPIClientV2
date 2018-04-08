
public final class Config_NoKey {
	public String virusTotalAPIKey;
	public static Config configInstance = null;
	
    public Config_NoKey() {
    // api key goes into this empty string 
    virusTotalAPIKey = "";
    }
    public static Config getConfigInstance() {
        if (configInstance == null) {
            synchronized (Config.class) {
                if (configInstance == null) {
                    configInstance = new Config();
                }
            }
        }
        return configInstance;
    }
    public String getVirusTotalAPIKey() {
        return virusTotalAPIKey;
    }

    public void setVirusTotalAPIKey(String virusTotalAPIKey) {
        this.virusTotalAPIKey = virusTotalAPIKey;
    }

   
    
}