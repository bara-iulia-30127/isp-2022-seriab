/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.utcluj.isp.curs2.test1;

/**
 *
 * @author mihai.hulea
 */
public class Robot2 {
    static int x;

    public static int getX() {
        return x;
    }

    public static void main(String[] args) {
        
        Robot2.x = 100;
        
        Robot2 r1 = new Robot2();
        Robot2 r2 = new Robot2();
        r1.x = 10;
        r2.x = 20;
        System.out.println(r1.x);
        System.out.println(r2.x);
        
        r1.x = 99;
        System.out.println(r2.x);
        
      
    }
    
}
