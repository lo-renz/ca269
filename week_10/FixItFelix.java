/**
 * FixItFelix.java - Week 10 Assignment
 * @author guilalr2
 */

/**
 * enum class to hold the different book mediums
 */
enum BookMedium {
    HardBack, PaperBack, AudioBook, EBook;
}

/**
 * enum class to hold the different book genres
 */
enum BookGenre {
    Fiction, NonFiction;
}

/**
 * enum class to hold the five different book ratings
 */
enum BookRating {
    Rating1, Rating2, Rating3, Rating4, Rating5;
}

/**
 * class Book is the parent class, has title, author and a genre
 */
class Book {
    /**
     * Variable for the book title
     */
    public String title;

    /**
     * Variable for the book author
     */
    public String author;

    /**
     * Variable for the book genre
     */
    public BookGenre bookGenre;

    /**
     * Getter method for the title
     * @return Returns the title of the book
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Getter method for the author
     * @return Returns the author of the book
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * Getter method for the genre
     * @return Returns the genre of the book
     */
    public BookGenre getGenre() {
        return this.bookGenre;
    }

    /**
     * Setter method for the title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Setter method for the author
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Setter method for the genre
     * @param bookGenre
     */
    public void setGenre(BookGenre bookGenre) {
        this.bookGenre = bookGenre;
    }

    /**
     * Default constructor for the Book class
     *
     * @param title      The title of the book
     * @param author     The author of the book
     * @param bookGenre  The genre of the book
     */
    public Book(String title, String author, BookGenre bookGenre) {
        setTitle(title);
        setAuthor(author);
        setGenre(bookGenre);
    }

    /**
     * Additional constructor for the super() method to work for subclasses
     */
    public Book() {
    }

    /**
     * toString method
     * Reflects the information available
     *      [Title] by [Author]
     *      Genre: [Genre]
     *
     * @return Returns a string of the information available
     */
    public String toString() {
        String output = "";
        output += getTitle();
        output += " by " + getAuthor();
        output += "\nGenre: " + getGenre();
        return output;
    }
}

/**
 * class PublishedBook is a subclass of Book, has a publication date and a medium
 */
class PublishedBook extends Book {
    /**
     * Variable for the book publish date
     */
    int publishedDate;

    /**
     * Variable for the book medium
     */
    BookMedium bookMedium;

    /**
     * Getter method for the publish date
     * @return Returns the year the book was published
     */
    public int getPublishedDate() {
        return this.publishedDate;
    }

    /**
     * Getter method for the medium
     * @return Returns the medium the book is viewed through
     */
    public BookMedium getBookMedium() {
        return this.bookMedium;
    }

    /**
     * Setter method for the publish date
     * @param publishedDate
     */
    public void setPublishedDate(int publishedDate) {
        this.publishedDate = publishedDate;
    }

    /**
     * Setter method for the medium
     * @param bookMedium
     */
    public void setBookMedium(BookMedium bookMedium) {
        this.bookMedium = bookMedium;
    }

    /**
     * Default constructor for the PublishedBook class
     * Includes the title, author, genre, publish date and book medium
     *
     * @param title          The title of the book
     * @param author         The author of the book
     * @param bookGenre      The genre of the book
     * @param publishedDate  The publish date of the book
     * @param bookMedium     The medium of the book
     */
    public PublishedBook(String title, String author, BookGenre bookGenre, int publishedDate, BookMedium bookMedium) {
        super(title, author, bookGenre);
        setPublishedDate(publishedDate);
        setBookMedium(bookMedium);
    }

    /**
     * Additinal constructor for the PublishBook class
     * Includes only the publish date and the book medium
     *
     * @param publishedDate  The publish date of the book
     * @param bookMedium     The medium of the book
     */
    public PublishedBook(int publishedDate, BookMedium bookMedium) {
        super();
        setPublishedDate(publishedDate);
        setBookMedium(bookMedium);
    }

    /**
     * toString method
     * Reflects the information available or added to the class
     * If a title, author, genre, publish date and book medium are given:
     *      [Title]
     *      Author: [Author]
     *      Genre: [Genre]
     *      Published: [Publish date]
     *      Medium: [Medium]
     *
     * If only a publish date and book medium are given:
     *      Published: [Publish date]
     *      Medium: [Medium]
     *
     * @return Returns a string of the information available
     */
    public String toString() {
        String output = "";

        if(getTitle() != null) {
            output += getTitle() + "\n";
        }

        if(getAuthor() != null) {
            output += "Author: " + getAuthor() + "\n";
        }

        if(getGenre() != null) {
            output += "Genre: " + getGenre() + "\n";
        }

        if(getPublishedDate() != 0) {
            output += "Published: " + getPublishedDate() + "\n";
        }

        if(getBookMedium() != null) {
            output += "Medium: " + getBookMedium() + "\n";
        }

        return output;
    }
}

/**
 * class ReadBook is a subclass of Book, has a date for completion and a rating
 */
class ReadBook extends Book {
    /**
     * Variable for the the completion date of reading the book
     */
    int completionDate;

    /**
     * Variable for the book rating
     */
    BookRating bookRating;

    /**
     * Getter method for the completion date
     * @return Returns the year the person completed reading the book
     */
    public int getCompletionDate() {
        return this.completionDate;
    }

    /**
     * Getter method for the rating
     * @return Returns the rating of the book
     */
    public BookRating getBookRating() {
        return this.bookRating;
    }

    /**
     * Setter method for the completion date
     * @param completionDate
     */
    public void setCompletionDate(int completionDate) {
         this.completionDate = completionDate;
    }

    /**
     * Setter method for the rating
     * @param bookRating
     */
    public void setBookRating(BookRating bookRating) {
        this.bookRating = bookRating;
    }

    /**
     * Default constructor for the ReadBook class
     * Includes the title, author, genre, completion date, book rating
     *
     * @param title           The title of the book
     * @param author          The author of the book
     * @param bookGenre       The genre of the book
     * @param completionDate  The completion date of reading the book
     * @param bookRating      The rating of the book
     */
    ReadBook(String title, String author, BookGenre bookGenre, int completionDate, BookRating bookRating) {
        super(title, author, bookGenre);
        setCompletionDate(completionDate);
        setBookRating(bookRating);
    }

    /**
     * Additional constructor for the ReadBook class
     * Includes only the completion date and the book rating
     *
     * @param completionDate
     * @param bookRating
     */
    ReadBook(int completionDate, BookRating bookRating) {
        super();
        setCompletionDate(completionDate);
        setBookRating(bookRating);
    }

    /**
     * toString method
     * Reflects the information available or added to the class
     * If a title, author, genre, completion date and book rating are given:
     *      [Title]
     *      Author: [Author]
     *      Genre: [Genre]
     *      Completed: [Completion date]
     *      Rating: [Book rating]
     *
     * If only a completion date and book rating are given:
     *      Completed: [Completion date]
     *      Rating: [Book rating]
     *
     * @return Returns a string of the information available
     */
    public String toString() {
        String output = "";
        if(getTitle() != null) {
            output += getTitle() + "\n";
        }

        if(getAuthor() != null) {
            output += "Author: " + getAuthor() + "\n";
        }

        if(getGenre() != null) {
            output += "Genre: " + getGenre() + "\n";
        }

        if(getCompletionDate() != 0) {
            output += "Completed: " + getCompletionDate() + "\n";
        }

        switch(bookRating) {
            case Rating1:
                output += "Rating: " + 1;
                break;
            case Rating2:
                output += "Rating: " + 2;
                break;
            case Rating3:
                output += "Rating: " + 3;
                break;
            case Rating4:
                output += "Rating: " + 4;
                break;
            case Rating5:
                output += "Rating: " + 5;
                break;
        }

         return output;
    }
}

/**
 * class FixItFelix
 * I only use to run tests
 */
public class FixItFelix {
    public static void main(String[] args) {
        Book x = new Book("The First Book", "RG", BookGenre.Fiction);
        System.out.println(x);

        System.out.println("----------");

        PublishedBook y = new PublishedBook("The Second Book", "RG", BookGenre.NonFiction, 2000, BookMedium.HardBack);
        System.out.println(y);
        System.out.println("----------");
        PublishedBook z = new PublishedBook(2001, BookMedium.PaperBack);
        System.out.println(z);

        System.out.println("----------");

        ReadBook a = new ReadBook("The Third Book", "RG", BookGenre.Fiction, 2002, BookRating.Rating5);
        System.out.println(a);
        System.out.println("----------");
        ReadBook b = new ReadBook(2003, BookRating.Rating4);
        System.out.println(b);
    }
}