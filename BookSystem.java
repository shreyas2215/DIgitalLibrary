
public class BookSystem{
    private String bookID;
    private String title;
    private String author;
    private String genre;
    private String availability;


    public BookSystem(String bookID,  String title, String author, String genre, String availability){
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre=genre;
        this.availability= availability;

    }

    public String getID(){return bookID;}
    public String getTitle(){return title;}
    public String getAuthor(){return author;}
    public String getGenre(){return genre;}
    public String getAvailability(){return availability;}

    public void setTitle(String title){this.title =title;}
    public void setGenre(String genre){this.genre =genre;}
    public void setAuthor(String author){this.author= author;}
    public void setAvailability(String availability){this.availability = availability;}

    @Override
    public String toString(){
        return "bookID:" + bookID + ", Title:" +  title + ", Genre: "+ genre+ ", Author: "+ Author+ ", Availability: " + availability;
    }
}
