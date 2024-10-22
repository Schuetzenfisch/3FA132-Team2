package org.example.model;

public interface IDatabaseConnection {


    public default IDatabaseConnection openConnection(){
        return null;
    }

    public default void createAllTables(){}

    public default void dropAllTables(){}

    public default void removeAllTables(){}

    public default void closeConnection(){}
}
