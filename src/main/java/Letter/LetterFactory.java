package Letter;

import Point.Point2d;
import Shape.*;

public final class LetterFactory {
    final static Double maxHeight = 150.0;
    final static Double maxWidth = maxHeight / 2.5;
    final static Double halfMaxHeight = maxHeight / 2;
    final static Double halfMaxWidth = maxWidth / 2;
    final static Double stripeThickness = maxHeight / 8;
    final static Double halfStripeThickness = stripeThickness / 2;

    private static final int rotateStripeA = 10;
    private static final double translateCircleB = 3.0;
    private static final int rotateStripeN = -20;
    private static final double removeTranslateStripeC = stripeThickness+3;
    private static final double translateStripeE = halfMaxHeight-4;
    private static final double ellipseHeight = maxHeight-stripeThickness;
    private static final double ellipseWidth = halfMaxWidth+stripeThickness;
    private static final double stripeHeightC =(ellipseHeight-stripeThickness);

    public static void translateShape(BaseShape shape, double x, double y){
        shape.translate(shape.getCoords(), new Point2d(x,y));
    }
    public static void rotateShape(BaseShape shape, double angle){
        shape.rotate(shape.getCoords(), Math.toRadians(angle));
    }

    /** TODO
     * Create the letter A graphically
     * @return BaseShape containing the letter A
     */
    public static BaseShape create_A()  {
        Rectangle letter = new Rectangle(halfStripeThickness,maxHeight);
        translateShape(letter, -(halfMaxWidth/2), 0.0);
        rotateShape(letter, rotateStripeA);

        Rectangle rightStripe = new Rectangle(halfStripeThickness,maxHeight);
        translateShape(rightStripe, (halfMaxWidth/2), 0.0);
        rotateShape(rightStripe, -rotateStripeA);

        Rectangle middleStripe = new Rectangle(halfMaxWidth,halfStripeThickness);

        letter.addAll(rightStripe.getCoords());
        letter.addAll(middleStripe.getCoords());
        return letter;
    }

    /** TODO
     * Create the letter B graphically
     * @return BaseShape containing the letter B
     */
    public static BaseShape create_B() {
        double smallRadius = (halfMaxHeight/2) - halfStripeThickness;

        Rectangle letter = new Rectangle(stripeThickness, maxHeight);
        Circle topCircle = new Circle(halfMaxHeight/2);
        Circle bottomCircle = new Circle(halfMaxHeight/2);
        Circle insideCircle = new Circle(smallRadius);

        translateShape(letter, -(halfMaxWidth+5), 0.0);
        topCircle.removeAll(insideCircle.getCoords());
        bottomCircle.removeAll(insideCircle.getCoords());
        translateShape(topCircle, translateCircleB, halfMaxHeight/2);
        translateShape(bottomCircle, translateCircleB, -halfMaxHeight/2);

        letter.addAll(topCircle.getCoords());
        letter.addAll(bottomCircle.getCoords());
        return letter;
    }

    /** TODO
     * Create the letter C graphically
     * @return BaseShape containing the letter C
     */
    public static BaseShape create_C() {
        Ellipse letter = new Ellipse(maxWidth, maxHeight);
        Ellipse inside = new Ellipse(ellipseWidth, ellipseHeight);
        Rectangle rightStripe = new Rectangle(stripeThickness, stripeHeightC);

        translateShape(rightStripe, removeTranslateStripeC,0.0);
        letter.removeAll(inside.getCoords());
        letter.removeAll(rightStripe.getCoords());

        return letter;
    }

    /** TODO
     * Create the letter E graphically
     * @return BaseShape containing the letter E
     */
    public static BaseShape create_E() {
        Rectangle letter = new Rectangle(halfStripeThickness,maxHeight);
        Rectangle topStripe = new Rectangle(maxWidth,halfStripeThickness);
        Rectangle middleStripe = topStripe.clone();
        Rectangle bottomStripe = topStripe.clone();

        translateShape(letter, -halfMaxWidth, 0.0);
        translateShape(topStripe,0.0, translateStripeE);
        translateShape(bottomStripe, 0.0, -translateStripeE);

        letter.addAll(topStripe.getCoords());
        letter.addAll(middleStripe.getCoords());
        letter.addAll(bottomStripe.getCoords());
        return letter;
    }

    /** TODO
     * Create the letter H graphically
     * @return BaseShape containing the letter H
     */
    public static BaseShape create_H() {
        Rectangle letter = new Rectangle(stripeThickness, maxHeight);
        Rectangle rightStripe = letter.clone();
        Rectangle middleStripe = new Rectangle(maxWidth, stripeThickness);

        translateShape(letter, -halfMaxWidth, 0.0);
        translateShape(rightStripe, halfMaxWidth, 0.0);

        letter.addAll(rightStripe.getCoords());
        letter.addAll(middleStripe.getCoords());
        return letter;
    }

    /** TODO
     * Create the letter N graphically
     * @return BaseShape containing the letter N
     */
    public static BaseShape create_N() {
        Rectangle letter = new Rectangle(halfStripeThickness,maxHeight);
        Rectangle rightStripe = letter.clone();
        Rectangle middleStripe = letter.clone();

        translateShape(letter, -(halfMaxWidth+2),0.0);
        translateShape(rightStripe, (halfMaxWidth-2),0.0 );
        rotateShape(middleStripe, rotateStripeN);

        letter.addAll(rightStripe.getCoords());
        letter.addAll(middleStripe.getCoords());
        return letter;
    }

    /** TODO
     * Create the letter O graphically
     * @return BaseShape containing the letter O
     */
    public static BaseShape create_O() {
        Ellipse letter = new Ellipse(maxWidth, maxHeight);
        Ellipse inside = new Ellipse(ellipseWidth, ellipseHeight);
        letter.removeAll(inside.getCoords());
        return letter;
    }
}
