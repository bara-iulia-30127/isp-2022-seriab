package ro.utcluj.isp.curs.exceptii.test1;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter @ToString 
 final class Order {
    private String itemName;
    final private int quatntity;
    protected double price;

    Order(String itemName, int quatntity, double price) {
        this.itemName = itemName;
        this.quatntity = quatntity;
        this.price = price;
    }
    
    final double calculateDeliveryCOst(){
        return 10;
    }
    
    void compareOrders(final Order o){
        //do some compare
        //o = new Oredr("12",2,5.6);
        o.setPrice(99);
    }
   
    
    
    public static void main(String[] args) {
        Order o1 = new Order("HDD",2,9.8);
        System.out.println(o1);
        o1.setItemName("SSD");
        System.out.println(o1);
        
    }
}
