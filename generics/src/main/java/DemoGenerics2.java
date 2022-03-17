import java.util.ArrayList;
import java.util.List;

interface Drawable{
    public void draw();
}

class Circle implements Drawable{
    public void draw() {
        System.out.println("Drawe a circle.");
    }
}

class Rectangle implements Drawable{
    public void draw() {
        System.out.println("Drawe a rectangle.");
    }
}

class DrawingBoard{
    public static void drawShape(List<? extends Drawable> list){
        for(Drawable s:list)
            s.draw();
    }
}

public class DemoGenerics2 {
    public static void main(String[] args) {
        ArrayList<Drawable> shapes = new ArrayList<Drawable>();
        shapes.add(new Circle());
        shapes.add(new Rectangle());
        DrawingBoard.drawShape(shapes);
    }
}
