import java.time.LocalDate;

enum State {
    TODO, BEGN, HALT, WAIT, DONE;
}

public class Task {
    public final String title;
    private String description;
    private LocalDate scheduled;
    private LocalDate deadline;
    private State state;

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public LocalDate getScheduled() {
        return this.scheduled;
    }

    public LocalDate getDeadline() {
        return this.deadline;
    }

    public State getState() {
        return this.state;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setScheduled(LocalDate scheduled) {
        this.scheduled = scheduled;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public void setState(State state) {
        this.state = state;
    }

    Task(String title, State state) {
        this.title = title;
        this.state = state;
    }

    Task(String title, State state, String description, LocalDate scheduled, LocalDate deadline) {
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

    public static void main(String args[]) {
        Task x = new Task("Brush your teeth", State.TODO);
        System.out.println(x);
    }
}
