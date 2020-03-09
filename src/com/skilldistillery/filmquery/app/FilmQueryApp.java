package com.skilldistillery.filmquery.app;

import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//    app.test();
		app.launch();
	}

	private void test() {
		Film film = db.findFilmById(2);
		System.out.println(film);
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		int choice = 0;
		while (choice != 3) {
			printMenu();
			choice = input.nextInt();
			if (choice == 1) {
				System.out.println("Enter the film ID number: ");
				int filmID = input.nextInt();
				System.out.println(db.findFilmById(filmID));
			} else if (choice == 2) {
				System.out.println("Enter the keyword: ");
				String keyword = input.next();
				System.out.println(db.findFilmsByKeyword(keyword));
			} else if (choice == 3) {
				System.out.println("Goodbye");
				System.exit(0);
			} else {
				System.out.println("Invalid Choice");
			}

		}
	}

	private void printMenu() {
		System.out.println();
		System.out.println();
		System.out.println("   Welcome to the DataBase");
		System.out.println("       Access Granted     ");
		System.out.println();
		System.out.println("         User Menu");
		System.out.println("+---------------------------+");
		System.out.println("|1. Look up film by ID      |");
		System.out.println("|2. Search films by keyword |");
		System.out.println("|3. Exit Application        |");
		System.out.println("+---------------------------+");
	}

}
