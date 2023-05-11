import java.lang.Character;

public class E23N1 {
    private String title;
    private String published;
    private int number;
    private boolean approvedForPublication;

    // getters
    public String getTitle() {
        return title;
    }

    public String getPublished() {
        return published;
    }

    public int getNumber() {
        return number;
    }

    public boolean getApproved() {
        return approvedForPublication;
    }

    // setters
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Setter that also checks for validity.
     * Checks that the length of the string passed is greater than or equal to 6 and less than or equal to 10 characters.
     * Changes the string into a char array and iterates through it to check for the amount of dashes.
     * Has a variable dashCount that checks that there for use in checking that there are exactly 2 dashes in the string passed.
     *
     * @param published, a string that represents the date the news article was published.
     */
    public void setPublished(String published) {
        int length = published.toCharArray().length;
        int dashCount = 0;
        if(length >= 6 && length <= 10) {
            for(char c: published.toCharArray()) {
                if(Character.compare(c, '-') == 0) {
                    dashCount += 1;
                }
            }
        }

        if(dashCount == 2) {
            this.published = published;
        } else {
            this.published = "not set";
        }
    }

    /**
     * A setter that allows the user to input three numbers and sets the published in the format <day>-<month>-<year>.
     *
     * @param day, the day of the year.
     * @param month, the month of the year.
     * @param year, the year.
     */
    public void setPublished(int day, int month, int year) {
        String date = "";
        date += day + "-";
        date += month + "-";
        date += year;
        this.published = date;
    }

    /**
     * A setter with validity.
     * Checks that the number is above 0.
     *
     * @param number, a number to be set to the variable number
     */
    public void setNumber(int number) {
        if(number > 0) {
            this.number = number;
        } else {
            this.number = 0;
        }
    }

    public void setApproved(boolean approved) {
        this.approvedForPublication = approved;
    }

    /**
     * A method that checks that the variables title, publised, number and approvedForPublication are not their default values.
     * If all the variables do not contain their default values then the method returns true and false otherwise.
     *
     * @return boolean value
     */
    public boolean isCameraReady() {
        if((getTitle() != "Untitled") && (getPublished() != "not set") && (getNumber() != 0) && (getApproved() == true)) {
            return true;
        }
        return false;
    }

    E23N1() {
        setTitle("Untitled");
        setPublished("not set");
        setNumber(0);
        setApproved(false);
    }

    E23N1(String title) {
        setTitle(title);
        setPublished("not set");
        setNumber(0);
        setApproved(false);
    }

    public static void main(String[] args) {
        E23N1 test1 = new E23N1();
        System.out.println(test1.getPublished());
        test1.setPublished("1-6-23");
        System.out.println(test1.getPublished());
        test1.setPublished("11-22-2023");
        System.out.println(test1.getPublished());

        test1.setPublished(24, 6, 23);
        System.out.println(test1.getPublished());

        test1.setTitle("The First Article");
        test1.setNumber(1);
        test1.setApproved(true);
        System.out.println(test1.isCameraReady());
    }
}