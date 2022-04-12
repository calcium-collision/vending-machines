package com.company.calcium_collision;


import java.util.*;

public class Main {

    public static void main(String[] args) {

        VendingMachinePack vmp = new VendingMachinePack();

        int insertedCoins = 0;
        Scanner in = new Scanner(System.in);
        HashMap<String, VendMachine> guessMap = new HashMap<>(3);

        System.out.println(Arrays.asList("Coffee 1", "Tea 2", "Coffee or Tea (50/50) 3") + "\n" +
                "Choose machine 1, 2, or 3\n");

        boolean ready = false;

        while (!ready){
            String line = in.nextLine();
            try {
                if (line.equalsIgnoreCase("stop")){
                    ready = true;
                }

                int numMachine = Integer.parseInt(line);

                if (numMachine > 0 && numMachine < 4){
                    insertedCoins++;
                    String title = vmp.getTitlesForMachines().get(numMachine-1);
                    System.out.println( title + ": " + vmp.getNamedMachines().get(title)
                                    .getDrink());
                } else {
                    System.out.println("Choose machine 1, 2, or 3");
                }
            } catch (Exception ignored){
                if (!ready) {
                    System.out.println("Wrong input!");                }
            }


        } // Block of code "Get drink" - READY!

        System.out.println("Now assign name to machines!");
        for (String title: vmp.titlesForMachines){
            System.out.printf("Machine with title %s is - ? " +
                    "('c' for Coffee, 't' for Tea and 'ct' for Coffee/Tea)\n", title);
            ready = false;
            while (!ready){
                String typeMachine = in.nextLine();
                if ("ct".contains(typeMachine)){
                    VendMachine machine = VendMachine.fromValue(typeMachine);
                    guessMap.put(title, machine);
                    ready = true;
                } else {
                    System.out.printf("Machine with title %s is - ? " +
                            "('c' for Coffee, 't' for Tea and 'ct' for Coffee/Tea)\n", title);
                }
            }
        }

        System.out.println(vmp.isEqualWith(guessMap) + "\nCount of attempts is " + insertedCoins);

    }
}


