package model;


// Represents a Person that is initially set to default shirt, pants, and shoes
public class Person {
    private String name;
    private Outfit outfit;


    // EFFECTS: creates a person with a default shirt, pants, shoes
    public Person(String name, Shirt shirt, Pants pants, Shoes shoes) {
        this.name = name;
        outfit = new Outfit("Default Outfit", shirt, pants, shoes);
    }


    // Setters and getters below
    public void setName(String name) {
        this.name = name;
    } 

    public void setShirt(Shirt shirt) {
        outfit.setShirt(shirt);
    }

    public void setPants(Pants pants) {
        outfit.setPants(pants);
    }

    public void setShoes(Shoes shoes) {
        outfit.setShoes(shoes);
    }


    public String getName() {
        return this.name;
    }

    public Shirt getShirt() {
        return outfit.getShirt();
    }

    public Pants getPants() {
        return outfit.getPants();
    }

    public Shoes getShoes() {
        return outfit.getShoes();
    }

    public Outfit getOutfit() {
        return outfit;
    }


}
