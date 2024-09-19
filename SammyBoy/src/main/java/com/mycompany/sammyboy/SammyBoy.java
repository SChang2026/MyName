/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sammyboy;

/**
 *
 * @author SChang2026
 */
public class SammyBoy {

    public static void main(String[] args) {
        String name = new String("Sam Chang");
        System.out.println("My name length is " + name.length());
        System.out.println("My name in uppercase is " + name.toUpperCase());
        System.out.println("My name to lower case is " + name.toLowerCase());
        System.out.println("The first letter in my name is " + name.charAt(0));
        System.out.println("The last letter in my name is " + name.charAt(name.length() - 1));
        System.out.println("The index of the spasce between my first and last name is " + name.indexOf(" "));
        
    }
}
