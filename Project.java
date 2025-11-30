import java.util.*;

class UserInfo {
    private String name;
    private int age;

    public void setUserInfo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
}

class UndertoneDetector {
    public static String detect(String vein, String jewelry, String paper) {
        int warm = 0, cool = 0;

        if (vein.equalsIgnoreCase("green")) warm++; else cool++;
        if (jewelry.equalsIgnoreCase("gold")) warm++; else cool++;
        if (paper.equalsIgnoreCase("yellowish")) warm++; else cool++;

        return warm > cool ? "Warm" : cool > warm ? "Cool" : "Neutral";
    }
}

class SeasonalColor {
    public static String determineSeason(String undertone, String hair, String eyes, String skin) {

        boolean light = hair.equals("light") || eyes.equals("light") || skin.equals("light");
        boolean dark = hair.equals("dark") || eyes.equals("dark") || skin.equals("deep");

        switch (undertone) {
            case "Cool":
                if (dark) return "Winter";
                return "Summer";

            case "Warm":
                if (dark) return "Autumn";
                return "Spring";

            case "Neutral":
                if (dark) return "Soft Autumn";
                return "Soft Summer";
        }
        return "Unknown";
    }
}

class BodyTypeFinder {
    public static String find(double bust, double waist, double hips) {
        if (bust > hips && bust > waist) return "Inverted Triangle";
        if (hips > bust && hips > waist) return "Pear";
        if (Math.abs(bust - hips) <= 2 && waist < bust && waist < hips)
            return "Hourglass";
        return "Rectangle";
    }
}

abstract class ClothingItem {
    protected String name;
    protected String type;

    ClothingItem(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() { return name; }
    public abstract boolean isRecommendedFor(String bodyType);
}

class Top extends ClothingItem {
    Top(String name) { super(name, "Top"); }

    @Override
    public boolean isRecommendedFor(String bodyType) {
        if (bodyType.equals("Inverted Triangle"))
            return name.contains("V-neck") || name.contains("Wrap") ||
                   name.contains("Sleeveless") || name.contains("Tube");
        if (bodyType.equals("Pear"))
            return name.contains("Crop") || name.contains("Off-Shoulder");
        if (bodyType.equals("Hourglass"))
            return name.contains("Peplum") || name.contains("Wrap");
        return name.contains("Button");
    }
}

class Bottom extends ClothingItem {
    Bottom(String name) { super(name, "Bottom"); }

    @Override
    public boolean isRecommendedFor(String bodyType) {
        if (bodyType.equals("Pear"))
            return name.contains("A-line") || name.contains("Wide");
        if (bodyType.equals("Hourglass"))
            return name.contains("Skinny");
        return name.contains("Straight") || name.contains("Pleated");
    }
}

class Accessory extends ClothingItem {
    Accessory(String name) { super(name, "Accessory"); }

    @Override
    public boolean isRecommendedFor(String bodyType) {
        return name.contains("Belt") || name.contains("Long") || name.contains("Stud");
    }
}

class Catalog {
    public static final Map<Integer, ClothingItem> items = new LinkedHashMap<>();

    static {
        items.put(1, new Top("V-neck"));
        items.put(2, new Top("Wrap Top"));
        items.put(3, new Top("Sleeveless"));
        items.put(4, new Top("Tube Top"));
        items.put(5, new Top("Crop Top"));
        items.put(6, new Top("Peplum Top"));
        items.put(7, new Top("Off-Shoulder"));
        items.put(8, new Top("Button-down Shirt"));

        items.put(9, new Bottom("Straight Jeans"));
        items.put(10, new Bottom("Wide-leg Jeans"));
        items.put(11, new Bottom("Skinny Jeans"));
        items.put(12, new Bottom("A-line Skirt"));
        items.put(13, new Bottom("Pencil Skirt"));
        items.put(14, new Bottom("Pleated Skirt"));

        items.put(15, new Accessory("Stud Earrings"));
        items.put(16, new Accessory("Hoop Earrings"));
        items.put(17, new Accessory("Long Necklace"));
        items.put(18, new Accessory("Short Necklace"));
        items.put(19, new Accessory("Belt"));
        items.put(20, new Accessory("Scarf"));
    }

    public static void showTable() {
        System.out.println("\n============================= CATALOG TABLE =============================");
        System.out.printf("%-30s %-30s %-30s%n", "👕 TOPS", "👖 BOTTOMS", "👓 ACCESSORIES");
        System.out.println("--------------------------------------------------------------------------");

        String[] top = items.entrySet().stream()
                .filter(e -> e.getKey() >= 1 && e.getKey() <= 8)
                .map(e -> e.getKey() + ". " + e.getValue().getName())
                .toArray(String[]::new);

        String[] bottom = items.entrySet().stream()
                .filter(e -> e.getKey() >= 9 && e.getKey() <= 14)
                .map(e -> e.getKey() + ". " + e.getValue().getName())
                .toArray(String[]::new);

        String[] acc = items.entrySet().stream()
                .filter(e -> e.getKey() >= 15)
                .map(e -> e.getKey() + ". " + e.getValue().getName())
                .toArray(String[]::new);

        int max = Math.max(top.length, Math.max(bottom.length, acc.length));
        for (int i = 0; i < max; i++) {
            System.out.printf("%-30s %-30s %-30s%n",
                    i < top.length ? top[i] : "",
                    i < bottom.length ? bottom[i] : "",
                    i < acc.length ? acc[i] : "");
        }
    }
}

public class Project {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("======== 👗 WELCOME TO COLOR & FIT POP 👠 ========");
            System.out.println("");
            System.out.println("Please enter your Personal Information here:");
            System.out.print("Enter name: ");
            String name = sc.nextLine();

            int age = 0;
            while (true) {
                try {
                    System.out.print("Enter age: ");
                    age = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid age! Please enter a number.");
                }
            }

            UserInfo user = new UserInfo();
            user.setUserInfo(name, age);

            System.out.println("\n==== 🔲 LET US KNOW YOUR UNDERTONE 🔲 ====");
            System.out.print("\nWhat is your Vein color (green/blue)?: ");
            String vein = sc.nextLine();
            System.out.print("What is your Preferred jewelry (gold/silver)?: ");
            String jewelry = sc.nextLine();
            System.out.print("What is your Paper reflection (yellowish/white)?: ");
            String paper = sc.nextLine();

            String undertone = UndertoneDetector.detect(vein, jewelry, paper);
            System.out.println("Good! Your undertone is: " + undertone);

            // ⭐⭐⭐ SEASONAL COLOR ANALYSIS ADDED HERE ⭐⭐⭐
            System.out.println("\n==== 🍂 LET US KNOW YOUR SEASONAL COLOR 🍁 ====");
            System.out.print("Is your natural hair color light or dark? (light/dark): ");
            String hair = sc.nextLine().toLowerCase();

            System.out.print("Are your eyes light or dark? (light/dark): ");
            String eyes = sc.nextLine().toLowerCase();

            System.out.print("Is your skin depth light, medium, or deep? (light/medium/deep): ");
            String skin = sc.nextLine().toLowerCase();

            String season = SeasonalColor.determineSeason(undertone, hair, eyes, skin);
            System.out.println("\n🍀 Your Seasonal Color Type is: " + season);

            System.out.println("\n==== ✂️ LET US KNOW YOUR BODY MEASUREMENT ✂️ ====");
            double bust = readDouble(sc, "\nBust Measurement (inch): ");
            double waist = readDouble(sc, "Waist Measurement (inch): ");
            double hips = readDouble(sc, "Hips Measurement (inch): ");

            String bodyType = BodyTypeFinder.find(bust, waist, hips);
            System.out.println("\nGotchu! Your body type is: " + bodyType);

            ClothingItem selectedTop = null, selectedBottom = null, acc1 = null, acc2 = null;
            String outfitColor = "";

            boolean done = false;
            while (!done) {

                System.out.println("\n======== 👗 WELCOME TO COLOR & FIT POP 👠 ========");
                System.out.println("");
                System.out.println("\n===== MENU =====");
                System.out.println("A - Show Catalog Table");
                System.out.println("B - Choose Outfit");
                System.out.println("C - Result");
                System.out.print("Pick your choice: ");

                String choice = sc.nextLine().toUpperCase();

                switch (choice) {
                    case "A" -> Catalog.showTable();

                    case "B" -> {
                        System.out.println("======== 👒 PICK YOUR OUTFIT 👗 ========");
                        selectedTop = getItem(sc, "\nEnter TOP number: ");
                        selectedBottom = getItem(sc, "Enter BOTTOM number: ");
                        acc1 = getItem(sc, "Enter Accessory (1) number: ");

                        System.out.print("Second accessory? (yes/no): ");
                        if (sc.nextLine().equalsIgnoreCase("yes")) {
                            acc2 = getItem(sc, "Enter Accessory 2 number: ");
                        }

                        System.out.print("\n🎨 What outfit color are you planning to wear?: ");
                        outfitColor = sc.nextLine().toLowerCase();
                    }

                    case "C" -> done = true;

                    default -> System.out.println("Invalid choice! Try again.");
                }
            }

            int score = 0;

            if (selectedTop != null && selectedTop.isRecommendedFor(bodyType)) score++;
            if (selectedBottom != null && selectedBottom.isRecommendedFor(bodyType)) score++;
            if (acc1 != null && acc1.isRecommendedFor(bodyType)) score++;
            if (acc2 != null && acc2.isRecommendedFor(bodyType)) score++;

            if (isColorGoodForUndertone(outfitColor, undertone)) score++;

            System.out.println("\n============ 👗 FINAL RESULT 👠 ============");
            System.out.println("");

            if (score >= 5) System.out.println("🔥 Your outfit looks AMAZING and perfectly matches your undertone!");
            else if (score >= 3) System.out.println("✨ Your outfit is good — a few improvements can make it better!");
            else System.out.println("‼️ Try different outfit choices next time for a better fit!");

            System.out.println("\nThanks for styling with us, " + user.getName() + "! 💖");

        } catch (Exception e) {
            System.out.println("Unexpected error occurred: " + e.getMessage());
        }

        sc.close();
    }

    public static boolean isColorGoodForUndertone(String color, String undertone) {
        List<String> warmColors = Arrays.asList("yellow", "orange", "red", "brown", "olive", "gold");
        List<String> coolColors = Arrays.asList("blue", "violet", "green", "silver", "rose", "black");

        switch (undertone) {
            case "Warm" -> { return warmColors.contains(color); }
            case "Cool" -> { return coolColors.contains(color); }
            case "Neutral" -> { return true; }
        }
        return false;
    }

    public static double readDouble(Scanner sc, String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }

    public static ClothingItem getItem(Scanner sc, String msg) {
        while (true) {
            try {
                System.out.print(msg);
                int id = Integer.parseInt(sc.nextLine());

                if (!Catalog.items.containsKey(id)) {
                    System.out.println("Invalid ID! Try again.");
                    continue;
                }
                return Catalog.items.get(id);

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
