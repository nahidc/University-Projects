/* Author: Nahid Chowdhury
   Program description: a program that creates a virtual dinosaur that the user looks after  */

import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class MPv9 {     
	public static void main(String[] param) throws IOException {	
		try {
		Dinosaur[][] save = new Dinosaur[3][5];
		Dinosaur[] dino = new Dinosaur[3];
		BufferedReader inputStream = new BufferedReader(new FileReader("dino.txt"));	
		
		for(int i=0; i<dino.length; i++) {
			dino[i] = new Dinosaur();
			setName(dino[i], inputStream.readLine());
			setSpecies(dino[i], inputStream.readLine());
			setThirst(dino[i], Integer.parseInt(inputStream.readLine()));
			setHunger(dino[i], Integer.parseInt(inputStream.readLine()));
			setIrritable(dino[i], Integer.parseInt(inputStream.readLine()));
		}
		inputStream.close();
		chooseDino(save, dino);	
		
		} catch(IOException e) {
		String response;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("No save file found. Would you like to restart progress? Y/N");
		response = scan.nextLine();
		if(response.equals("Y")) {
			start();
		}
		System.exit(0);
		}
	}

	/* ------------------------------------ Gameplay methods ------------------------------------ */
	
	//
	public static void start() {
		Dinosaur[][] save = new Dinosaur[3][5];
		Dinosaur[] dino = new Dinosaur[3];
		
		introduction();
		
		for(int i=0; i<dino.length; i++) { 
			dino[i] = new Dinosaur();
			setDinosaur(save[i], dino[i], i);
		}
		
		chooseDino(save, dino);
	}
	
	//message to the user introducing the program purpose
	public static void introduction() {
		System.out.println("Hey there! This game allows you to create and nurture your own pet dinosaur.");
		System.out.println("Let's begin by creating your first dinosaur!");
	}
	
	//setting up the default dinosaur
	public static void setDinosaur(Dinosaur[] s, Dinosaur d, int num) {	
		setDefaultName(d, num);
		setDefaultSpecies(d);
		setDefaultThirst(d);
		setDefaultHunger(d);
		setDefaultIrritable(d);
		printStatuses(s, d);
	}
	
	//allows user to choose the dinosaur they wish to interact with
	public static void chooseDino(Dinosaur[][] s, Dinosaur[] d) {
		int dinoChosen;
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			sortAnger(d);
			System.out.println("\nWhich dinosaur would you like to interactive with?");
			System.out.println("1. " +getName(d[0])+ "\n2. " +getName(d[1])+ "\n3. " +getName(d[2]));
			System.out.println("4. END");
			dinoChosen = Integer.parseInt(scan.nextLine()) ;
			
			if(dinoChosen == 1) 
				actions(s[0], d[0]);
			else if(dinoChosen == 2) 
				actions(s[1], d[1]);
			else if(dinoChosen == 3) 
				actions(s[2], d[2]);
			else if(dinoChosen == 4) {
				saveState(d);
				System.exit(0);
			}
			else 
				System.out.println("That is not a valid option.");
		}
	}
	
	
	//allows user to perform actions to nurture their pet dinosaur
	public static void actions(Dinosaur[] s, Dinosaur d) {
		int action;
		int chooseDino;
		Random dice = new Random();
		Scanner scan = new Scanner(System.in);
		
		while(true) {	
			printStatuses(s, d);
			System.out.println("\nWhat action would you like to perform?");
			System.out.println("1. Give water \n2. Feed \n3. Play with \n4. Do nothing \n5. Choose another");
			System.out.println("8. Save \n9. Load");
			action = Integer.parseInt(scan.nextLine());
			
			if(action == 1) {
				setThirst(d, getThirst(d) - dice.nextInt(6));
				setHunger(d, getHunger(d) + 1);
				setIrritable(d, getIrritable(d) + 1);	
			}
			else if(action == 2) {
				setHunger(d, getHunger(d) - dice.nextInt(6));
				setThirst(d, getThirst(d) + 1);
				setIrritable(d, getIrritable(d) + 1);
			}
			else if(action == 3) {
				setIrritable(d, getIrritable(d) - dice.nextInt(6));
				setThirst(d, getThirst(d) + 1);
				setHunger(d, getHunger(d) + 1);
			}
			else if(action == 4) {
				setThirst(d, getThirst(d) + 1);
				setHunger(d, getHunger(d) + 1);
				setIrritable(d, getIrritable(d) + 1);
			}
			else if(action == 5) {
				break;
			}
			else if(action == 8) {
				save(s, d);
			}
			else if(action == 9) {
				load(s, d);
			}
			else 
				System.out.println("\nThat option is invalid. Please choose one of the numbered options");
		}
	}
	
	//allows user to save a profile that they can use later on 
	public static void save(Dinosaur[] s, Dinosaur d) {
		final int slot;
		Scanner scan = new Scanner(System.in);
			
		System.out.println("\nWhich slot would you like to save your progress (between 1-5)?");
		slot = Integer.parseInt(scan.nextLine()) - 1;
			
		if(slot > 4) 
			System.out.println("That is not a valid slot to save...");
		else {	
			s[slot] = new Dinosaur();
			setName(s[slot], getName(d));
			setSpecies(s[slot], getSpecies(d));
			setThirst(s[slot], getThirst(d));
			setHunger(s[slot], getHunger(d));
			setIrritable(s[slot], getIrritable(d));
		}
	}
	
	//allows user to load up a previous save that they have created
	public static void load(Dinosaur[] s, Dinosaur d) {
		final int slot;
		Scanner scan = new Scanner(System.in);
			
		System.out.println("\nWhich slot would you like to load your progress (between 1-5)?");
		slot = Integer.parseInt(scan.nextLine()) -1 ;
			
		if(slot > 4) 
			System.out.println("That is not a valid slot to load...");
		else {	
			setName(d, getName(s[slot]));
			setSpecies(d, getSpecies(s[slot]));
			setThirst(d, getThirst(s[slot]));
			setHunger(d, getHunger(s[slot]));
			setIrritable(d, getIrritable(s[slot]));
			
			printStatuses(s, d);
		}
	
	}
	
	//bubblesort method to sort out the most to least angered dinosaur pet
	public static void sortAnger(Dinosaur[] d) {
		int p = 1;
		boolean sorted = false;
		
		while(!sorted) {
			sorted = true;
			
			for(int i=0; i<d.length-p; i++) {
				if(getAnger(d[i+1]) > getAnger(d[i])) {
					Dinosaur temp = new Dinosaur();
					temp = d[i];
					d[i] = d[i+1];
					d[i+1] = temp;
					sorted = false;
				}
			}
			p++;
		}	
	}
	
	//calculates the anger level based on thirst and hunger and inputs value into Dinosaur record
	public static void setAnger(Dinosaur d) {
		d.anger = getThirst(d) + getHunger(d) + getIrritable(d);
	}
	
	//prints out an appropriate response depending on the level of anger of the dinosaur
	public static void angerResponse(Dinosaur[] s, Dinosaur d) {
		String end;
		Scanner scan = new Scanner(System.in);
		
		if(getAnger(d) > 25) {
			System.out.println("\nThe dinosaur has gone into a frenzy and has killed you.");
			System.out.println("- Game over -");
			System.out.println("Would you like to load a previous save slot? Y/N");
			end = scan.nextLine();
			if(end.equals("Y"))
				load(s, d);
			else 
				System.exit(0);
		}
		else if(getAnger(d) > 15) 
			System.out.println("\nThe dinosaur is angry, perhaps you should nurture it.");
		else 
			System.out.println("\nThe dinosaur is really happy!");
	}	
	
	//saves the current progress of the game to be reloaded later
	public static void saveState(Dinosaur[] d) {
		try {
		PrintWriter outputStream = new PrintWriter(new FileWriter("dino.txt"));
		
		for(int i=0; i<d.length; i++) {
			outputStream.println(getName(d[i]));
			outputStream.println(getSpecies(d[i]));
			outputStream.println(getThirst(d[i]));
			outputStream.println(getHunger(d[i]));
			outputStream.println(getIrritable(d[i]));
		}
		outputStream.close();
		
		} catch(IOException e) {
		System.out.println("An error has occurred while saving...");
		}
	}
	
	/* ------------------------------ Setting default stats ------------------------------ */
	
	//allows user to name their dinosaur and inputs value into Dinosaur record
	public static void setDefaultName(Dinosaur d, int num) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\nSelect the name for dinosaur " +(num+1)+ ":");
		d.name = scan.nextLine();
	}
	
	//allows user to select the species of their dinosaur and inputs value into Dinosaur record
	public static void setDefaultSpecies(Dinosaur d) {
		int choice;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\nType the respective number to choose your dinosaur species... ");
		System.out.println("1. T-rex \n2. Velociraptor \n3. Diplodocus ");
		choice = Integer.parseInt(scan.nextLine());
		
		if(choice == 1) 
			d.species = "T-rex";
		else if(choice == 2)
			d.species = "Velociraptor";
		else if(choice == 3) 
			d.species = "Diplodocus";
		else {
			System.out.println("That is an invalid choice.");
			System.exit(0);
		}			
	}
	
	//randomly selects a number between 1-10 to be the thirst level and inputs value into Dinosaur record
	public static void setDefaultThirst(Dinosaur d) {
		Random dice = new Random();
		d.thirst = dice.nextInt(8) + 1;
	}
	
	//randomly selects a number between 1-10 to be the hunger level and inputs value into Dinosaur record
	public static void setDefaultHunger(Dinosaur d) {
		Random dice = new Random();
		d.hunger = dice.nextInt(8) + 1;
	}
	
	//randomly selects a number between 1-10 to be the irritable level and inputs value into Dinosaur record
	public static void setDefaultIrritable(Dinosaur d) {
		Random dice = new Random();
		d.irritable = dice.nextInt(8) + 1;
	}
		
	/* ---------------------------------- Printing stats ---------------------------------- */
	
	//print dinosaur statuses
	public static void printStatuses(Dinosaur[] s, Dinosaur d) {
		System.out.println("");
		printName(d);
		printSpecies(d);
		printThirst(d);
		printHunger(d);
		printIrritable(d);
		setAnger(d);
		printAnger(d);
		angerResponse(s, d);
	}
	
	//prints out the name of the dinosaur 
	public static void printName(Dinosaur d) {
		System.out.println("Dinosaur name: " +getName(d));
	}	
	
	//prints out the species of the dinosaur
	public static void printSpecies(Dinosaur d) {
		System.out.println("Species: \t\t" +getSpecies(d));
	}
	
	//prints out the thirst level of the dinosaur
	public static void printThirst(Dinosaur d) {
		System.out.println("Thirst level: \t\t" +getThirst(d)+ "/10");
	}
	
	//prints out the hunger level of the dinosaur
	public static void printHunger(Dinosaur d) {
		System.out.println("Hunger level: \t\t" +getHunger(d)+ "/10");
	}
	
	//prints out the irritable level of the dinosaur
	public static void printIrritable(Dinosaur d) {
		System.out.println("Irritable level: \t" +getIrritable(d)+ "/10");
	}
	
	//prints out the anger level of the dinosaur
	public static void printAnger(Dinosaur d) {
		System.out.println("Anger level: \t\t" +getAnger(d)+ "/30");
	}
	
	/* ------------------------------------- Setter methods ------------------------------------- */
	
	public static void setName(Dinosaur d, String n) {
		d.name = n;
	}
	
	public static void setSpecies(Dinosaur d, String s) {
		d.species = s;
	}
	
	public static void setThirst(Dinosaur d, int t) {
		d.thirst = t;
		
		if(d.thirst > 10) 
			d.thirst = 10;
		else if(d.thirst < 0) 
			d.thirst = 0;
	}
	
	public static void setHunger(Dinosaur d, int h) {
		d.hunger = h;
		
		if(d.hunger > 10) 
			d.hunger = 10;
		else if(d.hunger < 0) 
			d.hunger = 0;
	}
	
	public static void setIrritable(Dinosaur d, int i) {
		d.irritable = i;
		
		if(d.irritable > 10) 
			d.irritable = 10;
		else if(d.irritable < 0) 
			d.irritable = 0;
	}
	
	public static void setAnger(Dinosaur d, int a) {
		d.anger = a;
	}
	
	/* ------------------------------------- Getter methods ------------------------------------- */ 
	
	public static String getName(Dinosaur d) {
		return d.name;
	}

	public static String getSpecies(Dinosaur d) {
		return d.species;
	}
	
	public static int getThirst(Dinosaur d) {
		return d.thirst;
	}
	
	public static int getHunger(Dinosaur d) {
		return d.hunger;
	}
	
	public static int getIrritable(Dinosaur d) {
		return d.irritable;
	}
	
	public static int getAnger(Dinosaur d) {
		return d.anger;
	}
}

class Dinosaur {
	String name;
	String species;
	int thirst;
	int hunger;
	int irritable;
	int anger;
} 