
package ar.com.eduit.curso.java.connector;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectorMySql {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String vendor = "mysql";
    private static String server = "localhost";
    private static String port="3306";
    private static String bd = "colegio";
    private static String params="";
    private static String user="root";
    private static String pass="";
    private static String url="jdbc:"+server+":"+port+"/"+bd+params;
    private static Connection conn = null;
    
    private ConnectorMySql(){}
    private static ConnectorMySql connector = new ConnectorMySql();
        
    public static Connection getConnection(){
        synchronized(connector){
        if(conn==null){
            try{
                Class.forName(driver);
                conn = DriverManager.getConnection(url, user, pass);
            }catch(Exception e){e.printStackTrace();} 
        } 
    }
        return conn;
    }
     
}
