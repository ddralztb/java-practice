package bookstore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bookstore {
    private List<Book> books;
    private Scanner scanner;

    public Bookstore(){
        this.books = new ArrayList();
        this.scanner = new Scanner(System.in);
    }

    // === CREATE ===
    public void createBook(){
        System.out.println("Add new book");
        System.out.println("Enter book Id");
        int id = readInt();

        //Check if this id already exists
        if(findBookById(id) != null){
            System.out.println("Book with this Id already exists! \n");
            return;
        }

        System.out.println("Enter title: ");
        String title = scanner.nextLine();

        System.out.println("Enter price: ");
        Float price = readFloat();

        Book newBook = new Book(id, title, price);
        books.add(newBook);
        System.out.println("Book added successfully \n");
    }



    // === HELPER METHODS ===
    private int readInt(){
        while(true){
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer input. Try again: ");
            }
        }
    }

    private Book findBookById(int id){
        for (Book book : books){
            if(book.getId() == id)
                return book;
        }
        return null;
    }

    private float readFloat(){
        while(true){
            String input = scanner.nextLine();
            try {
                return Float.parseFloat(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid decimal input. Try again: ");
            }
        }
    }

}
