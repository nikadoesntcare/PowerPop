package powerpop;

public class UndertoneDetector {
    public static String detect(String vein, String jewelry, String paper) {
        int warm = 0, cool = 0;

        if (vein.equalsIgnoreCase("green")) warm++;
        else if (vein.equalsIgnoreCase("purple")) cool++;
        else if (!vein.equalsIgnoreCase("blue"))
            System.out.println("Invalid vein color, defaulting to Neutral.");

        if (jewelry.equalsIgnoreCase("gold")) warm++; else cool++;
        if (paper.equalsIgnoreCase("yellowish")) warm++; else cool++;

        return warm > cool ? "Warm" : cool > warm ? "Cool" : "Neutral";
    }
}
