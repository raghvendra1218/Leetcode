package com.raghvendra;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> myList = new LinkedList<String>();
//        myList.add("Nighasan");
//        myList.add("Palia");
//        myList.add("Lakhimpur");
//        myList.add("Tikunia");
//        myList.add("Singhai");
//        myList.add("Banglaha");
//        printList(myList);
//        myList.add(2,"Bhira");
//        printList(myList);
//        myList.remove(4);
//        printList(myList);
//        myList.add("pitampurva");
//        printList(myList);
        inOrder(myList,"Nighasan");
        inOrder(myList,"Tikunia");
        inOrder(myList,"Bhira");
        inOrder(myList,"Delhi");
        inOrder(myList,"Agra");
        inOrder(myList,"Jaipur");
        inOrder(myList,"Rewari");
        printList(myList);
        inOrder(myList,"Bhira");
        inOrder(myList,"Jammu");
        printList(myList);
        visit(myList);
    }

    private static void printList(LinkedList<String> linkedList ){
        Iterator<String> it = linkedList.iterator();
        while(it.hasNext()){
            System.out.println("Now visiting: "+ it.next());
        }
        System.out.println("==========================");
    }

    private static boolean inOrder(LinkedList<String> orderList, String newCity){
        ListIterator<String> lit = orderList.listIterator();

        while(lit.hasNext()){
            int comparison = lit.next().compareTo(newCity);
            if(comparison == 0 ){
                //equal, do not add the duplicate record.
                System.out.println(newCity+ " record already exists.");
                return false;
            } else if(comparison > 0){
                // newCity should appear before this city.
                lit.previous();
                lit.add(newCity);
                return true;
            } else if(comparison < 0){
                //move to next city
            }
        }
        lit.add(newCity);
        return true;
    }

    private static void visit(LinkedList<String> cities){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forwardDirection = true;
        ListIterator<String> lit = cities.listIterator();

        if(cities.getFirst().isEmpty()){
            System.out.println("No records in the List.");
        } else {
            System.out.println("Now visiting "+ lit.next());
            printMenu();
        }

        while(!quit) {
            System.out.println("Enter the action item from the menu below: ");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Exit from the list.");
                    quit = true;
                    break;

                case 1:
                    if(!forwardDirection){
                        if(lit.hasNext()){
                            lit.next();
                        }
                        forwardDirection = true;
                    }
                    if(lit.hasNext()){
                        System.out.println("Now visiting: "+ lit.next());
                    } else {
                        System.out.println("Reached at the end of the list.");
                        forwardDirection = false;
                    }
                    break;

                case 2:
                    if(forwardDirection){
                        if(lit.hasPrevious()){
                            lit.previous();
                        }
                        forwardDirection = false;
                    }
                    if(lit.hasPrevious()){
                        System.out.println("Now visiting: "+ lit.previous());
                    } else {
                        System.out.println("Reached at the beginning of the List.");
                        forwardDirection = true;
                    }
                    break;

                case 3:
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu(){
        System.out.println("Available Actions: \n" + "Press: ");
        System.out.println( "\n 0 - Quit\n"+
                            "\n 1 - Move forward\n"+
                            "\n 2 - Move Backward\n"+
                            "\n 3 - Print menu");
    }
}
