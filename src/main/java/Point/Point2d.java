package Point;

public class Point2d extends AbstractPoint {
    private final Integer X = 0;
    private final Integer Y = 1;

    /** TODO
     * 2D Point Constructor from coordinates
     * @param x X coordinate
     * @param y Y coordinate
     */
    public Point2d(Double x, Double y) {
        super(new double[] {x, y});
    }

    /** TODO
     * 2D Point Constructor from vector
     * @param vector Vector containing X and Y coordinates
     */
    public Point2d(Double[] vector) {
        this(vector[0], vector[1]);
    }

    /**
     * @return X coordinate
     */
    public double X() { return vector[X];}

    /**
     * @return Y coordinate
     */
    public double Y() { return vector[Y];}

    /** TODO
     * Translate the point by the given vector
     * @param translateVector The vector by which to translate
     * @return Translated point
     */
    @Override
    public Point2d translate(Double[] translateVector) {
        vector[X] += translateVector[X];
        vector[Y] += translateVector[Y];
        return this;
    }

    /** TODO
     * Translate the point by the given 2D Point
     * @param translateVector The 2D Point by which to translate
     * @return Translated point
     */
    public Point2d translate(Point2d translateVector) {
        return translate(new Double[]{translateVector.X(), translateVector.Y()});
    }

    /** TODO
     * Rotate the point by the given rotation Matrix
     * @param rotationMatrix Matrix by which to rotate
     * @return Rotated point
     */
    @Override
    public Point2d rotate(Double[][] rotationMatrix) {
        Double[] newPoint = {0.0, 0.0};
        for(int i=0; i < vector.length;i++) {
            double result = 0.0;
            for(int j=0; j < vector.length;j++) {
                result += rotationMatrix[i][j] * vector[j];
            }
            newPoint[i] = result;
        }
        vector[X] = newPoint[0];
        vector[Y] = newPoint[1];
        return this;
    }
/*
        double newX = rotationMatrix[0][0] * vector[X] + rotationMatrix[0][1] * vector[Y];
        double newY = rotationMatrix[1][0] * vector[X] + rotationMatrix[1][1] * vector[Y];

        vector[X] = newX;
        vector[Y] = newY;
        return this;

    }*/

    /** TODO
     * Rotate the point by the given angle
     * @param angle Angle in radians
     * @return Rotated point
     */
    public Point2d rotate(Double angle) {
        Double[][] rotationMatrix = {
                {Math.cos(angle), -Math.sin(angle)},
                {Math.sin(angle), Math.cos(angle)}
        };
        return rotate(rotationMatrix);
    }

    /** TODO
     * Divide the X and Y coordinates of a 2D point by a scalar
     * @param divider Scalar used to divide
     * @return Divided point
     */
    @Override
    public Point2d divide(Double divider) {
        vector[X] /= divider;
        vector[Y] /= divider;
        return this;
    }

    /** TODO
     * Multiply the X and Y coordinates of a 2D point by a scalar
     * @param multiplier Scalar used to multiply
     * @return Multiplied point
     */
    @Override
    public Point2d multiply(Double multiplier) {
        vector[X] *= multiplier;
        vector[Y] *= multiplier;
        return this;
    }

    /** TODO
     * Add a scalar to the X and Y coordinates of a 2D point
     * @param adder Scalar to add
     * @return Added point
     */
    @Override
    public Point2d add(Double adder) {
        vector[X] += adder;
        vector[Y] += adder;
        return this;
    }

    /** TODO
     * @return Deep copy of the 2D point
     */
    @Override
    public Point2d clone() {
        return new Point2d(X(), Y());
    }
}
