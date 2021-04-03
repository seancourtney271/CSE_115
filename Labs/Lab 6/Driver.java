package code;

public class Driver {

    
    public static void main(String[] args){
        
        // Comment in the following test code as you complete the methods. Verify that your 
        // code works here before submitting to AutoLab
        
        Recipe macNCheese = new Recipe("mac & cheese", "mac", "cheese");
        Recipe scrambledEggs = new Recipe("scrambled eggs", "egg", "milk");
        Recipe bakedPotato = new Recipe("baked potato", "potato", "salt");
        Recipe hamburger = new Recipe("hamburger", "ground beef", "hamburger bun");
        Recipe spaghetti = new Recipe("spaghetti and meatballs", "spaghetti", "meatballs");

        System.out.println(macNCheese.getName());
        System.out.println(macNCheese.getIngredientOne());
        System.out.println(macNCheese.getIngredientTwo());
        
        Kitchen kitchen = new Kitchen();
        kitchen.addIngredient("mac");
        kitchen.addIngredient("mac");
        kitchen.addIngredient("cheese");
        kitchen.addIngredient("spaghetti");
        kitchen.addIngredient("meatballs");
        kitchen.addIngredient("salt");

        System.out.println();
        System.out.println("computed: " + kitchen.containsIngredient("cheese"));
        System.out.println("expected: true\n");

        System.out.println("computed: " + kitchen.containsIngredient("sprinkles"));
        System.out.println("expected: false\n");
        
        System.out.println("computed: " + kitchen.getQuantity());
        System.out.println("expected: 6\n");
        
        kitchen.removeIngredient("salt");
        
        System.out.println("computed: " + kitchen.getQuantity());
        System.out.println("expected: 5\n");

        kitchen.removeIngredient("mac");
        
        System.out.println("computed: " + kitchen.getQuantity());
        System.out.println("expected: 4\n");
        
        //kitchen.canCook(macNCheese);

        //System.out.println("computed: " + kitchen.canCook(macNCheese));
        //System.out.println("expected: true\n");
        
        //kitchen.cook(macNCheese);
        
        //System.out.println("computed: " + kitchen.getQuantity());
        //System.out.println("expected: 2\n");

        //System.out.println("computed: " + kitchen.canCook(macNCheese));
        //System.out.println("expected: false\n");
    }
}
