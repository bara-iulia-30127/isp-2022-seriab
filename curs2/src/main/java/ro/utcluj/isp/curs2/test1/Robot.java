package ro.utcluj.isp.curs2.test1;

/**
 * Specificatorii de acces:
 * - public - cuv cheie public
 * - private - cuv cheie private
 * - protected - cuv cheie protected
 * - default (package access) - fara nimic in fata
 * 
 * @author mihai.hulea
 */


public class Robot {
    //declarare constante
    public static final int MIN_X = 0;
    public static final int MAX_X=100;
    
    private int x;
    private String name;

    //constructor implicit (default)
    Robot(){
        this(0,"No name robot");
    }
    
    //constructor cu argumnte
    Robot(int a, String name){
        x = a;
        this.name = name;
    }
    
    void moveLeft(){
        System.out.println("Moving robot:"+this);
        if(x>0){
            x--;
            System.out.println("Move robot to left -> position "+x);
        }else{
            System.out.println("Robot cannot be moved.");
        }
    }
    
    void moveRight(){
        if(x<50){
            x++;
            System.out.println("Move robot to right -> position "+x);
        }else{
            System.out.println("Robot cannot be moved.");
        }
    }
    
    
    void displayRobot(){
        System.out.println("Robot ["+x+","+name+"]");
    }

    public void setX(int x) {
        this.x = x;
    }
    
    public int getX() {
        return x;
    }

    public String getName() {
        return name;
    }

    

    @Override
    public String toString() {
        return "Robot{" + "x=" + x + ", name=" + name + '}';
    }

    
}
