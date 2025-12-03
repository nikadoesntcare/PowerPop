package powerpop;

public abstract class ClothingItem {
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
            return name.contains("V-neck") || name.contains("Wrap") || name.contains("Sleeveless") || name.contains("Tube");
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
