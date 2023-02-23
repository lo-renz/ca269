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

        System.out.println("----------");

        // Test for Chore class
        Chore c1 = new Chore("Chore Test", State.TODO, LocalDate.now(), LocalDate.now().plus(Period.ofDays(7)));
        System.out.println(c1);
        c1.setState(State.TODO);
        System.out.println(c1);

        System.out.println("----------");

        // Test for RepeatedTask class
        RepeatedTask r1 = new RepeatedTask("RepeatedTask Test", State.WAIT);
        System.out.println(r1);
        r1.setState(State.DONE);
        System.out.println(r1);

        // Test for SharedTask class
        SharedTask s1 = new SharedTask("SharedTask Test", "Bob");
        System.out.println(s1);
    }
}

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

class RepeatedTask extends Task {
    RepeatedTask(String title, State state) {
        super(title, state);
    }

    public void setState(State state) {
        super.setState(state);

        if (state == State.DONE) {
           setState(State.TODO); 
        }
    }
}

class SharedTask extends RepeatedTask {
    String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    SharedTask(String title, String name) {
        super(title, State.WAIT);
        setName(name);
    }

    public void setState(State state) {
        this.state = State.WAIT;
    }

    public String toString() {
        return title + " (" + state + ") shared with: " + name;
    }
}