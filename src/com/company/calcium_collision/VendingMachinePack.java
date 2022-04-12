package com.company.calcium_collision;

import java.util.*;

public class VendingMachinePack {

    LinkedHashMap<String, VendMachine> namedMachines = new LinkedHashMap<>();
    ArrayList<String> titlesForMachines;


    VendingMachinePack(){

        ArrayList<VendMachine> pack =
                new ArrayList<>(Arrays.asList(VendMachine.TEA_MACHINE, VendMachine.COFFEE_MACHINE, VendMachine.COFFEE_TEA_MACHINE));

        titlesForMachines = new ArrayList<>(Arrays.asList("Coffee", "Tea", "Coffee or Tea (50/50)"));

        Collections.shuffle(pack);

        for (String title : titlesForMachines){
            namedMachines.put(title, pack.get(titlesForMachines.indexOf(title)));

        }

//        System.out.println(namedMachines.equals(new HashMap<String, VendMachine>(namedMachines)));
    }

    public LinkedHashMap<String, VendMachine> getNamedMachines() {
        return namedMachines;
    }

    public ArrayList<String> getTitlesForMachines() {
        return titlesForMachines;
    }

    public String isEqualWith(HashMap<String, VendMachine> guessMap){
        if (namedMachines.equals(guessMap)) {
            return "That's right!";
        } else {
            return "Truth is " + namedMachines;
        }
    }



}
