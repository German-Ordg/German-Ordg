/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicahiccpmp.ohonebook;
import java.sql.Connection;
import java.util.ArrayList;
import packete.phonebook.PhoneBookEntry;
import packete.phonebook.conn;
/**
 *
 * @author david
 */
public class Main {
    public static void main(String args[]) {
        
        
        conn db = new conn();
        db.getConnection();
        System.out.println("Iniciando proyecto");
        System.out.println("-----------------------");
        System.out.println("------------------------");
        ArrayList<PhoneBookEntry> myEntries = db.getAllPhoneBookEntry();
        System.out.println(myEntries.size());
    }
}
