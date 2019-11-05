package de.plgberlin.info.utils;

public class MongoConfig {

    private final String databaseHost;
    private final int databasePort;
    private final String databaseUser;
    private final String databasePassword;
    private final String databaseName;

    public MongoConfig(String databaseHost, int databasePort, String databaseUser, String databasePassword, String databaseName) {
        this.databaseHost = databaseHost;
        this.databasePort = databasePort;
        this.databaseUser = databaseUser;
        this.databasePassword = databasePassword;
        this.databaseName = databaseName;
    }

    public MongoConfig(MongoConfig mongoConfig) {
    }

    public String getDatabaseHost() {
        return databaseHost;
    }

    public int getDatabasePort() {
        return databasePort;
    }

    public String getDatabaseUser() {
        return databaseUser;
    }

    public String getDatabasePassword() {
        return databasePassword;
    }

    public String getDatabaseName() {
        return databaseName;
    }
}
