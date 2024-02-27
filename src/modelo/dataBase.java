
package modelo;


public class dataBase {
    String url;
    String driver;
    
    public dataBase(){
        this.driver = "jdbc:sqlite";
        this.url = "data.db";
        
    }
}
