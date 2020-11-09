package com.company;
/*
    Written by Oliver Juul Reder on the 09.11.2020.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class User {
	public User(){
	}

	public String takeInput(){
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}

	public Order newOrder(){
		boolean finished = false;
		ArrayList<Pizza> pizzasInOrder = new ArrayList<>();
		int pickupTime = -1;

		System.out.println("Enter the new order.");
		while(!finished){
			String input = takeInput();

					// Add pizza to order
			if(input.startsWith("add ")){
				try {
					int id = Integer.parseInt(input.substring(4));
					for(Pizza p : Reader.pizzaList){
						if(id == p.id){
							pizzasInOrder.add(p);
						}
					}
				} catch (Exception e){
					System.out.println("ID = \""+ input +"\" was not recognized. Please try again.");
				}
			}

					// Remove pizza from order
			if(input.startsWith("remove ")){
				try{
					int id = Integer.parseInt(input.substring(7));
					for(Pizza p : Reader.pizzaList){
						if(id == p.id){
							pizzasInOrder.remove(p);
						}
					}
				} catch(Exception e){
					System.out.println("ID = \""+ input +"\" was not recognized. Please try again.");
				}
			}

					// End order selection
			if(input.equals("end")){
				try{
					System.out.println("Enter the pickup time :");
					pickupTime = Integer.parseInt(takeInput());
					finished = true;
				} catch (Exception e){
					System.out.println("Pickup time was not recognized. Please try again.");
				}
			}
		}

		return new Order(pizzasInOrder,pickupTime);
	}
}
