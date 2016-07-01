package pkg;

/**
 *
 * 
 */
import javax.swing.*;
import java.awt.*;

public class chaosGame extends JFrame{

     chaosGame(){
    setTitle("Chaos Game");
    add(new gamePanel());
}
     class Point {
public int x;
public int y;
public Color c;
Point(int a, int b, Color c) {
x = a;
y = b;
this.c = c;
}
/* Find the distance between this point and a point p */
public double distanceTo(Point p){
return Math.sqrt( Math.pow((double)(p.x-x), 2.0) + (float) Math.pow( (double)(p.y - y), 2.0));
}
/* Find the midpoint between this point and a point p */
public Point midpointTo(Point p) {
Point m = new Point((int)((x+p.x)/2.0), (int)((y+p.y)/2.0), p.c);
return m;
}
}
     
    class gamePanel extends JPanel{
        Point one, two, three;
      protected void paintComponent(Graphics g) {
            one = new Point((int)(this.getWidth()/2), 20, Color.RED);
            two = new Point(20, this.getHeight()-20, Color.BLUE);
            three = new Point(this.getWidth()-20, this.getHeight()-20, Color.GREEN);
            g.setColor(Color.RED);
            g.fillOval(one.x-5, one.y-5, 10, 10);
            g.setColor(Color.BLUE);            
            g.fillOval(two.x-5, two.y-5, 10, 10);
            g.setColor(Color.GREEN);
            g.fillOval(three.x-5, three.y-5, 10, 10);
            Point[] array = new Point[3];
            array[0] = one;
            array[1] = two;
            array[2] = three;
            Point seed = one;
            recChaos(array, seed, g, 0);
            
        }
      void recChaos(Point[] array, Point seed, Graphics g, int count){
          if (count > 7000) {
              return;
          }
          Point dest = array[(int) (Math.random()*3)];
          Point newS = seed.midpointTo(dest);
          g.setColor(newS.c);
          g.fillOval(newS.x-5, newS.y-5, 1, 1);
          count++;
          recChaos(array, newS, g, count);
      }
    }
    public static void main(String[] args){
        JFrame frame = new chaosGame();
        frame.setSize(200, 200);
        frame.setLocationRelativeTo(null); 
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
