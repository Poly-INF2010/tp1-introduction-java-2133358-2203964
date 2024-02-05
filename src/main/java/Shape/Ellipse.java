package Shape;

import Point.Point2d;

import java.util.Collection;

public class Ellipse extends BaseShape {
    /** TODO
     * Create a filled Ellipse that is centered on (0, 0)
     * @param widthDiameter Width of the Ellipse
     * @param heightDiameter Height of the Ellipse
     */
    public Ellipse(Double widthDiameter, Double heightDiameter) {
        double widthRadius = widthDiameter/2;
        double heightRadius = heightDiameter/2;
        double incrementFactor = 0.5;

        for(double x = -widthRadius; x < widthRadius; x += incrementFactor){
            for(double y = -heightRadius; y < heightRadius; y += incrementFactor){
                if((Math.pow(x,2)/(Math.pow(widthRadius,2))) + (Math.pow(y,2)/(Math.pow(heightRadius,2))) <= 1){
                    add(new Point2d(x,y));
                }
            }
        }
    }

    /** TODO
     * Create a filled Ellipse that is centered on (0,0)
     * @param dimensions 2D point containing the width and height of the Ellipse
     */
    public Ellipse(Point2d dimensions) {
        this(dimensions.X(), dimensions.Y());
    }

    /**
     * Create an Ellipse from a given collection of 2D points
     * @param coords Collection of 2D points
     */
    private Ellipse(Collection<Point2d> coords) {
        super(coords);
    }

    /** TODO
     * @return Deep Copy of the Ellipse
     */
    @Override
    public Ellipse clone() {
        Ellipse copyEllipse = new Ellipse(0.0,0.0);

        for(Point2d point : getCoords()){
            copyEllipse.add(new Point2d(point.X(), point.Y()));
        }
        return copyEllipse;
    }
}
