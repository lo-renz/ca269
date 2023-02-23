import java.time.LocalDate;

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
        Task t1 = new Task("Test", State.TODO);
        LocalDate now = LocalDate.now();
        t1.setScheduled(now);
        System.out.println(t1);
    }
}

// Need to write the Chore, ReapeatingTask, SharedTask, Dependency classes.