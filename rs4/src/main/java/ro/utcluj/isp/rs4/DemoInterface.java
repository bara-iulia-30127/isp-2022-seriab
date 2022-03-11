/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.utcluj.isp.rs4;

interface I1{
    void m1();
}

interface I2{
    void m2();
}

/**
 *
 * @author mihai.hulea
 */
public class DemoInterface implements I1,I2{

    @Override
    public void m1() {
        System.out.println("Execut m1");
    }

    @Override
    public void m2() {
        System.out.println("Eecute m2");
    }
    
    public void execute(I1 i){
        i.m1();
    }

    public static void main(String[] args) {
        DemoInterface di = new DemoInterface();
        di.m1();
        di.m2();
        
        I1 x1 = new DemoInterface();
        x1.m1();
        //x1.m2();
        ((I2)x1).m2(); //--->cast conversie de tip 
        ((DemoInterface)x1).m1();
        
        
        String s2="abc";
        if(s2 instanceof I2){
            ((I2)x1).m2();
        }else{
            System.out.println("ERROR");
        }
        
        
        di.execute(di);
        
        //I2 x2 = new I2(); //invalid
    }
    
}
