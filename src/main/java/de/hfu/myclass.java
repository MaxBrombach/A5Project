package de.hfu;

import java.util.Scanner;

public class myclass {

	public static void main(String[] args) {
		try (// TODO Auto-generated method stub
			Scanner keyboard = new Scanner(System.in)) {
			System.out.println("String eingeben");
			String my = keyboard.next();
			System.out.println(my.toUpperCase());
		}
	}

}
