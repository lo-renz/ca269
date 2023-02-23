import java.time.LocalDate;
import java.time.Period;

enum State {
    TODO, BEGN, HALT, WAIT, DONE;
}

public class Task {
    public final String title;
    public String description;
    public LocalDate scheduled;
    public LocalDate deadline;
    public State state;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getScheduled() {
        return scheduled;
    }

    public void setScheduled(LocalDate scheduled) {
        this.scheduled = scheduled;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    Task(String title, State state) {
        this.title = title;
        this.state = state;
    }

    Task(String title, String description, LocalDate scheduled, LocalDate deadline, State state) {
        this(title, state);
        setDescription(description);
        setScheduled(scheduled);
        setDeadline(deadline);
    }

    public String toString() {
        String message = this.title + " (" + this.state + ")";

        if (scheduled != null) {
            message += " scheduled: " + scheduled;
        }
        if (deadline != null) {
            message += " deadline: " + deadline;
        }
        return message;
        }

    public static void main(String[] args) {
        // Test for Task class
        Task t1 = new Task("Task Test", State.TODO);
        LocalDate now = LocalDate.now();
        t1.setScheduled(now);
        System.out.println(t1);

        // Test for Chore class
        Chore c1 = new Chore("Chore Test", State.TODO, LocalDate.now(), LocalDate.now().plus(Period.ofDays(7)));
        System.out.println(c1);
        c1.setState(State.TODO);
        System.out.println(c1);

        // Test for Repeating class
        Repeating r1 = new Repeating("Repeating Test", State.WAIT);
        System.out.println(r1);
        r1.setState(State.DONE);
        System.out.println(r1);
    }
}

// Need to write the Chore, ReapeatingTask, SharedTask, Dependency classes.
class Chore extends Task {
    LocalDate repeat;

    public LocalDate getRepeat() {
        return repeat;
    }

    public void setRepeat(LocalDate repeat) {
        this.repeat = repeat;
    }

    Chore(String title, State state, LocalDate scheduled, LocalDate repeat) {
        super(title, state);
        setScheduled(scheduled);
        setRepeat(repeat);
    }

    public void setState(State state) {
        super.setState(state);

        if (state == State.DONE) {
            LocalDate newRepeatDate = repeat.plus(Period.ofDays(7));
            setScheduled(repeat);
            setRepeat(newRepeatDate);
            state = State.TODO;
        }
    }
}

class Repeating extends Task {
    Repeating(String title, State state) {
        super(title, state);
    }

    public void setState(State state) {
        super.setState(state);

        if (state == State.DONE) {
           setState(State.TODO); 
        }
    }
}