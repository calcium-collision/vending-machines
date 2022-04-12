package com.company.calcium_collision;

public enum VendMachine {
    COFFEE_MACHINE(Drink.COFFEE_DRINK), TEA_MACHINE(Drink.TEA_DRINK), COFFEE_TEA_MACHINE;

    private final Drink drink;

    VendMachine(Drink drink){
        this.drink = drink;
    }

    VendMachine(){
        drink = null;
    }

    public Drink getDrink(){
         if (this == COFFEE_MACHINE || this == TEA_MACHINE) {
             return this.drink;
         } else {
             int random = (int) (100 * Math.random());
             if (random % 2 == 1){
                 return Drink.TEA_DRINK;
             } else {
                 return Drink.COFFEE_DRINK;
             }

         }
    }

    public static VendMachine fromValue(String cipher){
        switch (cipher){
            case "c":
                return VendMachine.COFFEE_MACHINE;
            case "t":
                return VendMachine.TEA_MACHINE;
            case "ct":
                return VendMachine.COFFEE_TEA_MACHINE;
        }
        return null;
    }
}
