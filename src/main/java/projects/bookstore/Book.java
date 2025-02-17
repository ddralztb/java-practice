package projects.bookstore;

public class Book {

    private int id;
    private String title;
    private double price;

    public Book(int id, String title, double price){
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public int getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public double getPrice(){
        return price;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setPrice(float price){
        this.price = price;
    }

    public void displayBook(){
        System.out.println("Id " + id + " \n");
        System.out.println("Title " + title + " \n");
        System.out.println("Price " + price + " \n");
    }
}
