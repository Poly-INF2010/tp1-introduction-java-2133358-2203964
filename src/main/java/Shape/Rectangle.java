package Shape;

import Point.Point2d;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Rectangle extends BaseShape {
    /** TODO
     * Create a filled rectangle centered on (0, 0)
     * @param width Width of the rectangle
     * @param height Height of the rectangle
     */
    public Rectangle(Double width, Double height) {
        double halfWidth = width/2;
        double halfHeight = height/2;
        double incrementFactor = 0.5;

        for(double x = -halfWidth; x <= halfWidth; x += incrementFactor){
            for(double y = -halfHeight; y <= halfHeight; y += incrementFactor){
                add(new Point2d(x,y));
            }
        }
    }

    /** TODO
     * Create a filled rectangle centered on (0, 0)
     * @param dimensions 2D point containing the width and height of the rectangle
     */
    public Rectangle(Point2d dimensions) {
        double halfWidth = dimensions.X()/2;
        double halfHeight = dimensions.Y()/2;
        double incrementFactor = 0.5;

        for(double x = -halfWidth; x <= halfWidth; x += incrementFactor){
            for(double y = -halfHeight; y <= halfHeight; y += incrementFactor){
                add(new Point2d(x,y));
            }
        }

    }

    /**
     * Create a rectangle from a given collection of Points
     * @param coords The collection of 2D points
     */
    private Rectangle(Collection<Point2d> coords) {
        super(coords);
    }

    /** TODO
     * @return Deep copy of the rectangle
     */
    @Override
    public Rectangle clone() {
      /* Rectangle copyRectangle = new Rectangle(0.0,0.0);

       for(Point2d point : getCoords()){
           copyRectangle.add(new Point2d(point.X(), point.Y()));
       }
       return copyRectangle;*/

       return new Rectangle(getCoords());
    }
}
