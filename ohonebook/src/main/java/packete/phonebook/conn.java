
//-40s espacios blancos a la izquierda
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packete.phonebook;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author david
 */
public class conn {
    
    java.sql.Connection c = null;
    public  java.sql.Connection getConnection(){
        
    if (c!= null){
        return c;
    }
    try{
    
    Class.forName("org.sqlite.JDBC");
    c = DriverManager.getConnection("jdbc:sqlite:phonebook.db");
    String SQLVerifyTable = "CREATE TABLE IF NOT EXISTS phones"
            + " (ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
            + "NAME TEXT NOT NULL,"
            + "PHONE1 TEXT NOT NULL,"
            + "PHONE2 TEXT NOT NULL,"
            + "EMAIL TEXT NOT NULL"
            + ")";
    Statement stmt = c.createStatement();
    stmt.executeUpdate(SQLVerifyTable);
    stmt.close();
    return c;
    
    }catch(Exception e) {
            System.err.println("Error" + e.getMessage());
            return null;
        }
    
    }
    
    public ArrayList<PhoneBookEntry> getAllPhoneBookEntry(){
        try{
            
            if(c==null){
                getConnection();
            }
            Statement stmt= c.createStatement();
            ResultSet rs=stmt.executeQuery("Select * FROM phones;");
            ArrayList<PhoneBookEntry> allMyEntries = new ArrayList<PhoneBookEntry>();
            while(rs.next()){
                PhoneBookEntry currentEntry = new PhoneBookEntry();
                currentEntry.setID(rs.getInt("ID"));
                currentEntry.setNAME(rs.getString("Name"));
                currentEntry.setPHONE1(rs.getString("PHONE1"));
                currentEntry.setPHONE2(rs.getString("PHONE2"));
                currentEntry.setEMAIL(rs.getString("EMAIL"));
                
                
                allMyEntries.add(currentEntry);
                
            }
            stmt.close();
            return allMyEntries;
        }catch(Exception e){
            System.err.println("Error" + e.getMessage());
            System.exit(0);
            return null;
        }
        
    }
    //crear datos es exucuteupdate
    public void addNewPhoneBookEntry(PhoneBookEntry newEntry){
        try{
        String sqlstr= "INSERT INTO PHONES 8NAME, PHONE1, PHONE2, EMAIL) VALUE('%s','%s','%s','%s')";
        Statement stmt = c.createStatement();
        stmt.executeUpdate(
        String.format(
        sqlstr,
        newEntry.getNAME(),
        newEntry.getPHONE1(),
        newEntry.getPHONE2(),
        newEntry.getEMAIL()
        
        )
        );
        stmt.close();
        }catch(Exception e){
            System.err.println("Error"+ e.getMessage());
            System.exit(0);
        }
    }
    
    
}
