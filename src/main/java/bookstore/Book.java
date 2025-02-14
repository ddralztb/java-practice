package bookstore;

public class Book {

    private int id;
    private String title;
    private float price;

    public Book(int id, String title, float price){
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

    public float getPrice(){
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
}
