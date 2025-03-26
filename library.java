import java.util.*;


public class library{

    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, BookSystem> book = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nDigital Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addBook(); 
                break;
                case 2: viewBooks(); 
                break;
                case 3: searchBook(); 
                break;
                case 4: updateBook(); 
                break;
                case 5: deleteBook(); 
                break;
                case 6: System.out.println("Exiting"); 
                return;
                default: System.out.println("Invalid option. Try again.");
            }
        }
    }

    public static void addBook(){
        System.out.print("Enter BookID:");
        String bookid = scanner.nextLine();
        if(book.containsKey(bookid)){
            System.out.println("Book ID already exists");
        }

        System.out.print("Enter Title:");
        String title = scanner.nextLine();
        System.out.print("Enter Author:");
        String author = scanner.nextLine();
        System.out.print("Enter Genre:");
        String genre = scanner.nextLine();
        System.out.print("Enter Availability(Available/CheckedOut):");
        String availability = scanner.nextLine();

        if(title.isEmpty()||author.isEmpty()|| (!availability.equalsIgnoreCase("Available")&& !availability.equalsIgnoreCase("CheckedOut"))){
            System.out.println("Invalid Input! Title and author cannot be empty and Availability should be 'available' or 'checkedout'. ");
        }


        book.put(bookid, new BookSystem(bookid,title,author,genre,availability));
        System.out.println("Book added");




    }

    public static void viewBooks(){
        if(book.isEmpty()){
            System.out.println("No books in the library");

        }

        book.values().forEach(System.out::println);

    }


    public static void searchBook(){

        System.out.print("Enter ID or Title:");
        String search = scanner.nextLine();

        for(BookSystem books : book.values()){
            if(books.getID().equalsIgnoreCase(search)|| books.getTitle().equalsIgnoreCase(search)){
                System.out.println(books);
                return;
            }
        }

        System.out.println("Book not found.");
       


    }


 private static void updateBook() {
        System.out.print("Enter Book ID to update: ");
        String bookID = scanner.nextLine();
        
        if (!book.containsKey(bookID)) {
            System.out.println("Book ID not found.");
            return;
        }
        
        BookSystem books = book.get(bookID);
        System.out.print("Enter new Title (leave blank to keep unchanged): ");
        String newTitle = scanner.nextLine();
        if (!newTitle.isEmpty()) books.setTitle(newTitle);
        
        System.out.print("Enter new Author (leave blank to keep unchanged): ");
        String newAuthor = scanner.nextLine();
        if (!newAuthor.isEmpty()) books.setAuthor(newAuthor);
        
        System.out.print("Enter new Genre (leave blank to keep unchanged): ");
        String newGenre = scanner.nextLine();
        if (!newGenre.isEmpty()) books.setGenre(newGenre);
        
        System.out.print("Enter new Availability (Available/Checked Out): ");
        String newAvailability = scanner.nextLine();
        if (!newAvailability.isEmpty() && (newAvailability.equalsIgnoreCase("Available") || newAvailability.equalsIgnoreCase("Checked Out"))) {
            books.setAvailability(newAvailability);
        } else {
            System.out.println("Invalid availability status. Keeping previous status.");
        }
        
        System.out.println("Book updated successfully!");
    }


  private static void deleteBook() {
        System.out.print("Enter Book ID to delete: ");
        String bookID = scanner.nextLine();
        
        if (book.remove(bookID) != null) {
            System.out.println("Book deleted successfully!");
        } else {
            System.out.println("Book ID not found.");
        }
    }



}