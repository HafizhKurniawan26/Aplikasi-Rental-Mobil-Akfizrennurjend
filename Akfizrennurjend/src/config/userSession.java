/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

/**
 *
 * @author Hafizh Kurniawan
 */
public class userSession {
    public static int idUser, idRental;
    public static String idMobil;
    
    public static int getIdUser(){
        return idUser;
    }
    
    public static String getIdMobil(){
        return idMobil;
    }
    
    public static int getIdRental(){
        return idRental;
    }
    
    public static void setSelectedRental (int id) {
        idRental = id;
    }
    
    public static void setSelectedMobil(String id){
        idMobil = id;
    }
    
    public static void setUserSession(int id){
        idUser = id;
    }
    
    public static void clearUserSession(){
        idUser = 0;
    }
    
    public static void clearSelectedMobil(){
        idMobil = "";
    }
    
    public static void clearSelectedRental(){
        idRental = 0;
    }
}
