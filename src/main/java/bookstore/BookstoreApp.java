package bookstore;

import java.util.Scanner;

public class BookstoreApp {

        public void start() {
        Bookstore store = new Bookstore();
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("=== Welcome to the Book Store Management System ===\n");

        do {
            displayMenu();
            choice = getChoice(scanner);

            switch (choice) {
                
                case 1:
                    store.createBook();
                    break;
                /* 
                case 2:
                    store.removeBook();
                    break;
                case 3:
                    store.updateBook();
                    break;
                case 4:
                    store.listAllBooks();
                    break;
                case 5:
                    store.searchBooks();
                    break;
                case 6:
                    store.sortBooksByTitle();
                    break;
                 */
                case 7:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        } while (choice != 7);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("1. Add New Book");
        System.out.println("2. Remove a Book");
        System.out.println("3. Update a Book");
        System.out.println("4. List All Books");
        System.out.println("5. Search Books");
        System.out.println("6. Sort Books by Title");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getChoice(Scanner scanner) {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                System.out.println();
                return choice;
            } catch (NumberFormatException e) {
                System.out.print("Invalid choice. Please enter a valid number: ");
            }
        }
    }
}