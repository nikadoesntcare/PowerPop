package powerpop;

import java.util.*;

public class Catalog {
    public static final Map<Integer, ClothingItem> items = new LinkedHashMap<>();

    static {
        items.put(1, new Top("V-neck"));
        items.put(2, new Top("Sleeveless"));
        items.put(3, new Top("Wrap Top"));
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

