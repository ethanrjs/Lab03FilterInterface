import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class BigRectLister {
    public static void main(String[] args) {
        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(1, 2));
        rectangles.add(new Rectangle(2, 3));
        rectangles.add(new Rectangle(4, 5));
        rectangles.add(new Rectangle(6, 7));
        rectangles.add(new Rectangle(5, 5));

        Object[] rectangleArray = rectangles.toArray();
        List<Object> bigRectangles = FilterUtils.collectAll(rectangleArray, new BigRectangleFilter());
        bigRectangles.forEach(rect -> {
            Rectangle r = (Rectangle) rect;
            System.out.println("Rectangle with width " + r.width + " and height " + r.height);
        });
    }
}
