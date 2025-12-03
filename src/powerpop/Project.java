package powerpop;

import java.util.*;

public class Project {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("======== 👗 WELCOME TO POWER POP 👠 ========");
            System.out.println("\nPlease enter your Personal Information here:");
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
            System.out.print("\nVein color (green/blue/purple)?: ");
            String vein = sc.nextLine();
            System.out.print("Preferred jewelry (gold/silver)?: ");
            String jewelry = sc.nextLine();
            System.out.print("Paper reflection (yellowish/white)?: ");
            String paper = sc.nextLine();

            String undertone = UndertoneDetector.detect(vein, jewelry, paper);
            System.out.println("Your undertone is: " + undertone);

            System.out.println("\n==== 🍂 LET US KNOW YOUR SEASONAL COLOR 🍁 ====");
            System.out.print("Hair color (light/dark): ");
            String hair = sc.nextLine().toLowerCase();
            System.out.print("Eyes color (light/dark): ");
            String eyes = sc.nextLine().toLowerCase();
            System.out.print("Skin depth (light/medium/deep): ");
            String skin = sc.nextLine().toLowerCase();

            String season = SeasonalColor.determineSeason(undertone, hair, eyes, skin);
            System.out.println("Your Seasonal Color Type is: " + season);

            System.out.println("\n==== ✂️ BODY MEASUREMENT ✂️ ====");
            double bust = readDouble(sc, "Bust (inch): ");
            double waist = readDouble(sc, "Waist (inch): ");
            double hips = readDouble(sc, "Hips (inch): ");

            String bodyType = BodyTypeFinder.find(bust, waist, hips);
            System.out.println("Your body type is: " + bodyType);

            ClothingItem selectedTop = null, selectedBottom = null, acc1 = null, acc2 = null;
            String outfitColor = "";
            boolean done = false;

            while (!done) {
                System.out.println("\n===== MENU =====");
                System.out.println("A - Show Catalog Table");
                System.out.println("B - Choose Outfit");
                System.out.println("C - Result");
                System.out.print("Pick your choice: ");
                String choice = sc.nextLine().toUpperCase();

                switch (choice) {
                    case "A" -> Catalog.showTable();
                    case "B" -> {
                        selectedTop = getItem(sc, "Enter top number: ");
                        selectedBottom = getItem(sc, "Enter bottom number: ");
                        acc1 = getItem(sc, "Enter Accessory 1 number: ");

                        System.out.print("Second accessory? (yes/no): ");
                        if (sc.nextLine().equalsIgnoreCase("yes"))
                            acc2 = getItem(sc, "Enter Accessory 2 number: ");

                        System.out.print("Outfit color: ");
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
                System.out.println("Invalid input! Enter a number.");
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
