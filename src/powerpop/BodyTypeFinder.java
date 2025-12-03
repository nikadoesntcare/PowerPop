package powerpop;

public class BodyTypeFinder {
    public static String find(double bust, double waist, double hips) {
        if (bust > hips && bust > waist) return "Inverted Triangle";
        if (hips > bust && hips > waist) return "Pear";
        if (Math.abs(bust - hips) <= 2 && waist < bust && waist < hips) return "Hourglass";
        return "Rectangle";
    }
}

