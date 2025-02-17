package projects.bookstore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bookstore {
    private List<Book> books;
    private Scanner scanner;

    public Bookstore(){
        this.books = new ArrayList();
        this.books.add(new Book(0, "The host", 8.5));
        this.books.add(new Book(1, "1984", 99.5));
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

    // === UPDATE ===
    public void updateBook(){
        System.out.println("Enter book Id to update: ");
        int id = readInt();
        Book bookToUpdate = findBookById(id);
        if(bookToUpdate == null){
            System.out.println("Book not found, please enter a valid Id");
            return;
        }

        System.out.println("Enter new title");
        String newTitle = scanner.nextLine();
        bookToUpdate.setTitle(newTitle);

        System.out.println("Enter new price");
        Float newPrice = readFloat();
        bookToUpdate.setPrice(newPrice);
    }

    public void listAllBooks(){
        if(books.isEmpty()){
            System.out.println("No books in the store");
            return;
        }
        for(Book book : books){
            book.displayBook();
        }
    }

    // === DELETE ===
    public void removeBook(){
        System.out.println("Enter a book Id to remove");
        int id = readInt();
        if(findBookById(id) == null){
            System.out.println("Book not found");
            removeBook();
        }
        books.remove(findBookById(id));
        System.out.println("Book removed successuflly \n");
    }

    // == SEARCH BOOKS ===
    public void searchBooks(){
        System.out.println("Search books by Id or title: \n");
        Book book;
        String search = scanner.nextLine().trim().toLowerCase();
        try{
            int id = Integer.parseInt(search);
            book = findBookById(id);
        }catch (NumberFormatException e){
            book = findBookByTitle(search);
            
        }
        if (book != null){
            book.displayBook();
        }
        else{
            System.out.println("Book not found");
        }
    }

    // === SORT BOOKS BY TITLE ===
    public void sortBooksByTitle(){
        System.out.println("Sort books by title \n");
        if(books.isEmpty()){
            System.out.println("There are no books to sort \n");
            return;
        }
        books.sort((b1, b2) -> 
            b1.getTitle().compareToIgnoreCase(b2.getTitle()));
            
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

    private Book findBookByTitle(String title){
        for(Book book : books){
            if (book.getTitle().toLowerCase().contains(title))
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
