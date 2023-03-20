enum BookMedium {
    PhysicalBook, EBook, AudioBook;
}

enum BookGenre {
    Fiction, NonFiction;
}

enum BookRating {
    Rating1, Rating2, Rating3, Rating4, Rating5;
}

public class Book {
    private String title;
    private String author;
    private int publishedDate;
    private int readDate;
    private BookMedium bookMedium;
    private BookGenre bookGenre;
    private BookRating bookRating;

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getPublishedDate() {
        return this.publishedDate;
    }

    public int getReadDate() {
        return this.readDate;
    }

    public BookMedium getMedium() {
        return this.bookMedium;
    }

    public BookGenre getGenre() {
        return this.bookGenre;
    }

    public BookRating getRating() {
        return this.bookRating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublishedDate(int publishedDate) {
        this.publishedDate = publishedDate;
    }

    public void setReadDate(int readDate) {
        this.readDate = readDate;
    }

    public void setBookMedium(BookMedium bookMedium) {
        this.bookMedium = bookMedium;
    }

    public void setBookGenre(BookGenre bookGenre) {
        this.bookGenre = bookGenre;
    }

    public void setBookRating(BookRating bookRating) {
        this.bookRating = bookRating;
    }

    Book(String title, String author, BookGenre bookGenre) {
        setTitle(title);
        setAuthor(author);
        setBookGenre(bookGenre);
    }

    Book(String title, String author, BookGenre bookGenre, int publishedDate) {
        setTitle(title);
        setAuthor(author);
        setBookGenre(bookGenre);
        setPublishedDate(publishedDate);
    }

    Book(String title, String author, BookGenre bookGenre, int publishedDate, int readDate, BookMedium bookMedium, BookRating bookRating) {
        setTitle(title);
        setAuthor(author);
        setPublishedDate(publishedDate);
        setReadDate(readDate);
        setBookMedium(bookMedium);
        setBookGenre(bookGenre);
        setBookRating(bookRating);
    }

    public String toString() {
        String output = "";

        // title
        if (getTitle() != null) {
            output += getTitle();
        }

        // author
        if (getAuthor() != null) {
            output += " by " + getAuthor();
        }

        // publication date
        if (getPublishedDate() != 0) {
            output += " ("+getPublishedDate()+")";
        }

        // read date
        if (getReadDate() != 0) {
            output += " - read in " + getReadDate();
        }

        // rating
        if (getRating() != null) {
            int rate = 0;
            if (getRating() == BookRating.Rating1) {rate = 1;}
            else if (getRating() == BookRating.Rating1) {rate = 1;}
            else if (getRating() == BookRating.Rating2) {rate = 2;}
            else if (getRating() == BookRating.Rating3) {rate = 3;}
            else if (getRating() == BookRating.Rating4) {rate = 4;}
            else if (getRating() == BookRating.Rating5) {rate = 5;}

            output += ", rated "+rate+"/5";
        }

        return output;
    }

    public static void main(String[] args) {
        Book b1 = new Book("Children of Time", "Adrian Tchaikovsky", BookGenre.Fiction);
        System.out.println(b1);
        Book b2 = new Book("The Fifth Season", "N. K. Jemesin", BookGenre.Fiction, 2015);
        System.out.println(b2);
        Book b3 = new Book("Perdido Street Station", "China Mieville", BookGenre.Fiction, 2000, 2020, BookMedium.EBook, BookRating.Rating5);
        System.out.println(b3);

        System.out.println(b1.getTitle());
        System.out.println(b1.getAuthor());
        System.out.println(b1.getGenre());
        System.out.println(b2.getPublishedDate());
        System.out.println(b3.getReadDate());
        System.out.println(b3.getMedium());
        System.out.println(b3.getRating());
    }
}

class PublishedBook extends Book {
    public PublishedBook(int publishedDate, BookMedium bookMedium) {
        setPublishedDate(publishedDate);
        setBookMedium(bookMedium);
    }
}
