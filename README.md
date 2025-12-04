# <p align="center">👗 POWER POP 🧣</p>
<p align="center"><small><b>Your console based dress up & color analysis system</b></small></p>

<div align="center" style="margin:0;"><small><b>IT 2111</b></small></div>
<div align="center" style="margin:0;"><small>Dimaculangan, Annika M.</small></div>
<div align="center" style="margin:0;"><small>Maralit, Alyka Denise A.</small></div>
<div align="center" style="margin:0;"><small>Mendoza, Allana Maryse R.</small></div>


# **Overview** ‧₊˚✩彡

This console-based program assists users in discovering the seasonal color that best suits them based on their inputs, as well as identifying their body type from the measurements they provide. Additionally, the system includes a dress-up feature that offers feedback on the user’s outfit, taking into account body type, color choices, and providing a brief comment on the overall compatibility and style of the selected clothing. 

Overall, it aims to make color analysis fun, practical, and easy to understand for everyday styling.

# ᛝ‧₊˚┆ Project structure 〢

     📂 src/  
     └── 📂 powerpop/
         ├── Project.java 
         ├── UserInfo.java
         ├── UndertoneDetector.java
         ├── SeasonalColor.java
         ├── BodyTypeFinder.java
         ├── ClothingItem.java
         └── Catalog.java



# ༄.° How to Run the Program 𖦹˙—  
1. Open your terminal in the `src/` folder.  
2. Compile all Java files in the `powerpop` package:  
       `javac powerpop/*.java`

3. Run the program using:  
       `java powerpop.Project`
   
# ⤷ ゛Features ˎˊ˗
1. 👤 **Enter Personal Information.** Input name and age to create a user profile.  
2. 👩🏻 **Determine Undertone.** Identify skin undertone (Warm, Cool, Neutral) by answering questions about vein color, jewelry preference, and paper reflection.  
3. 🌸 **Discover Seasonal Color Type.** Find seasonal color category (Winter, Summer, Spring, Autumn, Soft Summer, Soft Autumn) based on undertone, hair color, eye color, and skin depth.  
4. 🧍🏻‍♀️ **Identify Body Type.** Calculate body type (Inverted Triangle, Pear, Hourglass, Rectangle) using bust, waist, and hip measurements.  
5. 📁 **Browse Catalog.** View a complete list of tops, bottoms, and accessories in a neatly organized table.  
6. 💯 **Select Outfit.** Choose tops, bottoms, and up to two accessories to create an outfit.  
7. 👗 **Input Outfit Color.** Enter the planned outfit color to check if it matches your undertone.  
8. ✨ **Receive outfit Feedback.** Get a final evaluation of your outfit’s compatibility with your body type and undertone, including a score-based recommendation.
   
# 𐔌՞. .՞𐦯 OOP - Principles
## 🔐 **Encapsulation**

Encapsulation was applied mainly in the **UserInfo class**, where the fields `name` and `age` are made private and accessed only through public setter and getter methods, ensuring the data is protected and controlled.

     
    class UserInfo {
    private String name;
    private int age;

    public void setUserInfo(String name, int age) {
        this.name = name;
        this.age = age;
    }

The `setter` was used here `setUserInfo`, this method takes the values typed by the user and stores them inside the object.

    public String getName() { return name; }
    public int getAge() { return age; }}
            
The `getters` was used here to allow other parts of the code to read the private data. But they still cannot access the variables directly — they must ask the class through these methods.

     System.out.println("Thanks for styling with us, " + user.getName() + "! 💖");

## ✨ **Abstraction**

Abstraction was applied through the abstract class `ClothingItem`, which hides common details (like name and type) and forces subclasses (`Top`, `Bottom`, `Accessory`) to implement the abstract method `isRecommendedFor()`, exposing only what is essential while hiding the internal logic of each clothing type.

abstract class ClothingItem {
    protected String name;
    protected String type;

    ClothingItem(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() { return name; }

    public abstract boolean isRecommendedFor(String bodyType);}}

## 🧬 Inheritance
Inheritance is applied in this project through the class structure. `ClothingItem` serves as the parent class for all outfit categories such as `Top`, `Bottom`, and `Accessory`.It inherited shared features (such as `name` and `type`) so, these subclasses only need to define their specific rules. 

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
         public boolean isRecommendedFor(String bodyType) { }
     }
     class Bottom extends ClothingItem { }
     class Accessory extends ClothingItem { }
 
 
## 🎭 Polymorphism
Polymorphism is demonstrated when checking whether selected clothing items fit the user’s body type. All selected items are stored under the same reference type `ClothingItem`, but they override the method `isRecommendedFor(bodyType)`.

     ClothingItem selectedTop = null, selectedBottom = null, acc1 = null;

     selectedTop = getItem(sc, "\nEnter top number: ");
     selectedBottom = getItem(sc, "Enter bottom number: ");
     acc1 = getItem(sc, "Enter Accessory 1 number: ");

     if (selectedTop != null && selectedTop.isRecommendedFor(bodyType)) score++;
     if (selectedBottom != null && selectedBottom.isRecommendedFor(bodyType)) score++;
     if (acc1 != null && acc1.isRecommendedFor(bodyType)) score++;

# ⋆.𐙚 ̊ Example output

     ======== 👗 WELCOME TO COLOR & FIT POP 👠 ========
 Please enter your Personal Information here:  
     Enter name: Allana  
     Enter age: 19  

     ==== 🔲 LET US KNOW YOUR UNDERTONE 🔲 ====  

     Vein color (green/blue/purple)?: purple  
     Preferred jewelry (gold/silver)?: gold  
     Paper reflection (yellowish/white)?: yellowish  
     Your undertone is: Cool  

     ==== 🍂 LET US KNOW YOUR SEASONAL COLOR 🍁 ====  
     Hair color (light/dark): light  
     Eyes color (light/dark): dark  
     Skin depth (light/medium/deep): light  
     Your Seasonal Color Type is: Winter  

     ==== ✂️ BODY MEASUREMENT ✂️ ====  
     Bust (inch): 31  
     Waist (inch): 30  
     Hips (inch): 26  
     Your body type is: Inverted Triangle  
     
     ===== MENU =====  
     A - Show Catalog Table  
     B - Choose Outfit  
     C - Result  
     Pick your choice: A  

     ============================== CATALOG TABLE ==============================
     👕 TOPS                    👖 BOTTOMS                 👓 ACCESSORIES
     ---------------------------------------------------------------------- 
     1.  V-neck                  9.  Straight Jeans         15. Stud Earrings  
     2.  Sleeveless              10. Wide-leg Jeans         16. Hoop Earrings  
     3.  Wrap Top                11. Skinny Jeans           17. Long Necklace  
     4.  Tube Top                12. A-line Skirt           18. Short Necklace  
     5.  Crop Top                13. Pencil Skirt           19. Belt  
     6.  Peplum Top              14. Pleated Skirt          20. Scarf  
     7.  Off-Shoulder  
     8.  Button-down Shirt  


     ===== MENU =====  
     A - Show Catalog Table  
     B - Choose Outfit  
     C - Result  
     Pick your choice: B  
     Enter top number: 4  
     Enter bottom number: 14  
     Enter Accessory 1 number: 19  
     Second accessory? (yes/no): yes  
     Enter Accessory 2 number: 20  
     Outfit color: white  

     ===== MENU =====  
     A - Show Catalog Table  
     B - Choose Outfit  
     C - Result  
     Pick your choice: C  

     ============ 👗 FINAL RESULT 👠 =============  
     ✨ Your outfit is good — a few improvements can make it better!  

     Thanks for styling with us, Allana! 💖  

 


# 𐔌 ⋮ Contributors ₊ ꒱

| Photo | Name | Role |
|-------|------|------|
| <img src="pix/nika.png" width="120"> | Annika M. Dimaculangan | Project Leader / System Architect |
| <img src="pix/alyka.png" width="120"> | Alyka Denise A. Maralit | File Handling Specialist / Output Coordinator |
| <img src="pix/allana.png" width="120"> | Allana Maryse R. Mendoza | Feature Developer / Concept Designer |

# ᯓ 𑣲 : Acknowledgement ꩜⋆˚

We would like to express our heartfelt gratitude to everyone who supported us throughout the completion of our OOP project, Power POP! Our sincerest thanks go to our instructor, **Ma'am Grace Alib**, for her invaluable guidance, encouragement, and support. We are also deeply grateful to our friends for their unwavering support from start to finish. ✧₊⁺


