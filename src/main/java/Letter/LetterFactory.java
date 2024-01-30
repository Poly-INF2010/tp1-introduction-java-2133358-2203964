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

    //added variable and function for letter

    /** TODO
     * Create the letter A graphically
     * @return BaseShape containing the letter A
     */
    public static BaseShape create_A()  {
        Rectangle letter = new Rectangle(halfStripeThickness,maxHeight);
        letter.translate(letter.getCoords(), new Point2d(-(halfMaxWidth/2),0.0));
        letter.rotate(letter.getCoords(),Math.toRadians(10));

        Rectangle rightStripe = new Rectangle(halfStripeThickness,maxHeight);
        rightStripe.translate(rightStripe.getCoords(), new Point2d((halfMaxWidth/2),0.0));
        rightStripe.rotate(rightStripe.getCoords(), Math.toRadians(-10));

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
        double radius = halfMaxHeight/2;
        double smallRadius = radius - halfStripeThickness;

        Rectangle letter = new Rectangle(stripeThickness, maxHeight);
        Circle topCircle = new Circle(halfMaxHeight/2);
        Circle bottomCircle = new Circle(halfMaxHeight/2);
        Circle insideCircle = new Circle(smallRadius);

        letter.translate(letter.getCoords(), new Point2d(-halfMaxWidth+5, 0.0));
        topCircle.removeAll(insideCircle.getCoords());
        bottomCircle.removeAll(insideCircle.getCoords());
        topCircle.translate(topCircle.getCoords(), new Point2d(3.0, halfMaxHeight/2));
        bottomCircle.translate(bottomCircle.getCoords(), new Point2d(3.0, -halfMaxHeight/2));

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
        Ellipse inside = new Ellipse((halfMaxWidth+stripeThickness),(maxHeight-stripeThickness));
        Rectangle rightStripe = new Rectangle(stripeThickness,((maxHeight-stripeThickness)-stripeThickness));

        rightStripe.translate(rightStripe.getCoords(), new Point2d(stripeThickness+3,0.0));
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

        letter.translate(letter.getCoords(), new Point2d(-halfMaxWidth,0.0));
        topStripe.translate(topStripe.getCoords(), new Point2d(0.0, halfMaxHeight-4));
        bottomStripe.translate(middleStripe.getCoords(), new Point2d(0.0, -halfMaxHeight+4));

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

        letter.translate(letter.getCoords(),new Point2d(-halfMaxWidth,0.0));
        rightStripe.translate(rightStripe.getCoords(), new Point2d(halfMaxWidth, 0.0));

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

        letter.translate(letter.getCoords(), new Point2d(-halfMaxWidth+2, 0.0));
        rightStripe.translate(rightStripe.getCoords(), new Point2d(halfMaxWidth-2, 0.0));
        middleStripe.rotate(middleStripe.getCoords(), Math.toRadians(-20));

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
        Ellipse inside = new Ellipse((halfMaxWidth+stripeThickness),(maxHeight-stripeThickness));
        letter.removeAll(inside.getCoords());
        return letter;
    }
}
