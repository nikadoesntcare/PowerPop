package powerpop;

public class SeasonalColor {

    public static String determineSeason(String undertone, String hair, String eyes, String skin) {
        boolean isLight = hair.equalsIgnoreCase("light") || eyes.equalsIgnoreCase("light") || skin.equalsIgnoreCase("light");
        boolean isDark = hair.equalsIgnoreCase("dark") || eyes.equalsIgnoreCase("dark") || skin.equalsIgnoreCase("deep");

        return switch (undertone) {
            case "Cool" -> isDark ? "Winter" : isLight ? "Summer" : "Neutral Cool";
            case "Warm" -> isDark ? "Autumn" : isLight ? "Spring" : "Neutral Warm";
            case "Neutral" -> isDark ? "Soft Autumn" : isLight ? "Soft Summer" : "Neutral";
            default -> "Unknown";
        };
    }
}
