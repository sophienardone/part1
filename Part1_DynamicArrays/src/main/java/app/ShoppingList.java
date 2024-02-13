package app;

import utils.DynamicArrayList;

import java.util.Scanner;

/**
 *
 * @author michelle
 */
public class ShoppingList {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //        Creates an instance of your DynamicArrayList class.
        DynamicArrayList shoppingList = new DynamicArrayList();

        //        2. Asks the user how many entries they’d like to add to their shopping list.
        System.out.println("How many entries would you like to add to shopping list?:");
        int answer = sc.nextInt();
        sc.nextLine();

       //3. Prompts the user to enter the specified number of entries for their shopping list and adds each to the list (each
              //line can contain one or more words each, or may be null)
        System.out.println("Enter the number of entries for you shopping list:");
        for(int i=0; i< answer; i++){
            System.out.println("Entry " + (i+1));
            String entry = sc.nextLine();
            shoppingList.add(entry);
        }


       // 4. Loops through the shopping list and displays the content.
        for(int i=0; i< shoppingList.size(); i++){
            System.out.println((i+1) + " . " + shoppingList.get(i));
        }



       //5. Repeatedly offers a menu of actions that can be done by the shopping list (based on the functionality you have
     //  been tasked with) and provides the logic for each.
    boolean found = false;
        while(!found){
            //menu of actions for user
            System.out.println("1. Add an entry");
            System.out.println("2. Remove an entry");
            System.out.println("3. Clone an entry");
            System.out.println("4. Exit menu");


            System.out.println("Enter your chosen action:");
            int action = sc.nextInt();
            sc.nextLine();

            if(action ==1){
                System.out.println("Enter entry to add:");
                String addedEntry = sc.nextLine();
                shoppingList.add(addedEntry);
            } else if (action == 2) {
                System.out.println("Enter entry to remove");
                String removedEntry = sc.nextLine();
                if(shoppingList.removeAll(removedEntry)){
                    System.out.println("Entry removed");
                } else {
                    System.out.println("Entry does not exist");
                }
            } else if (action == 3) {
                shoppingList.clone();
                System.out.println("Shopping list cloned");
            } else if (action == 4) {
                found = true;
            } else {
                System.out.println("Invalid integer");
            }
        }
        sc.close();



    }
}
