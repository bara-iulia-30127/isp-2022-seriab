package ro.utcluj.isp.curs2.test1;


public class Test {
    
    static void calculateDistance(Robot r1, Robot r2){
       // System.out.println(this);
        System.out.println("Distance="+(r1.getX() - r2.getX()));
    }
    
    public static void main(String[] args) {
        Robot r1 = new Robot();
        Robot r2 = new Robot(23, "ABC");
        
        r1.moveLeft();
        r2.moveLeft();
    
        System.out.println(r1);
        System.out.println(r2);
        
        r1.displayRobot();
        r2.displayRobot();
        
        r1 = r2;
        
        System.out.println(r1);
        System.out.println(r2);
        
        r1.displayRobot();
        r2.displayRobot();
        
        Robot r3 = null;
        
        System.out.println(r3);
        r3 = new Robot(10, "XYZ");
        r3.displayRobot();
        
        calculateDistance(r1, r2);
        
        r3.setX(99);
        System.out.println(r3);
        
//        if(r1==r3){ //GRESIT DEOARECE COMPAR REFERINTELE!!!
//            System.out.println("");
//        }
        String s = "asdasdad";
        String s2 = new String("alskjdasd");

        //METODA CORECTA DE COMPARARE A OBIECTELOR ESTE CU equals
        //ATENTIE - METOD EQUALS TREBUIE SA FIE IMPLEMENTATA PENTRU A FUNCTIONA 
        if(r1.equals(r3)){
            System.out.println(".....");
        }
        
        
        
    }
    
}
