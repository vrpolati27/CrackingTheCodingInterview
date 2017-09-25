package AlgorithmsForInterviews.primitivetypes.primitivetypes;

public class RectangleIntersection {
    public static void main(String[] args){

    }

    /* This method returns nonEmpty intersection (rectangle).
       T(n)=O(1), constant time.*/
    public static Rectangle intersectRectangle(Rectangle r1, Rectangle r2){
        if(!isIntersect(r1,r2)){
            return new Rectangle(0,0,-1,-1);/* no intersection.*/
        }
        return new Rectangle(Math.max(r1.x,r2.x), Math.max(r1.y,r2.y),
                Math.min(r1.x+r1.width, r2.x+r2.width)-Math.max(r1.x,r2.x)/*width*/,
                Math.min(r1.y+r1.height,r2.y+r2.height)-Math.max(r1.y,r2.y));
    }
    /* returns true if rectangle1 intersects with rectangle2.
      T(n)=O(1), constant time. */
    private static boolean isIntersect(Rectangle r1, Rectangle r2){
        boolean isIntersect = r1.x <= (r2.x+r2.width) && (r1.x+r1.width)>=r2.x
                && r1.y<=(r2.y+r2.height) && (r1.y+r1.height)>=r2.y;
        return isIntersect;
    }

}

class Rectangle{
    int x,y, width, height;

    public Rectangle(int x,int y,int width,int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}