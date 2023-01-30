import java.time.LocalDate;
import java.time.Period;

class Task {
    final String title;
    String description;
    LocalDate scheduled;
    LocalDate deadline;
    State state;

    Task(String title, State state) {
        this.title = title;
        setState(state);
    }

    Task(String title, State state, String description, LocalDate scheduled, LocalDate deadline) {
        this(title, state);
        setDescription(description);
        setScheduled(scheduled);
        setDeadline(deadline);
    }

    public String getTitle() {
        return this.title;
    }

    // NOT ALLOWED because the variable is declared with the "final" keyword at the top of the file.
    // public void setTitle(String title) {
    //     this.title = title;
    // }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getScheduled() {
        return this.scheduled;
    }

    public void setScheduled(LocalDate scheduled) {
        this.scheduled = scheduled;
    }

    public LocalDate getDeadline() {
        return this.deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public State getState() {
        return this.state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String toString() {
        String message = this.title + " (" + this.state + ")";
        if(scheduled != null) {
            message += " scheduled: " + scheduled;
        }
        if(deadline != null) {
            message += " deadline: " + deadline;
        }
        return message;
    }

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate tomorrow = LocalDate.now();

        // Task testing.
        Task t1 = new Task("T1", State.TODO);
        System.out.println(t1);
        t1.setScheduled(now);
        t1.setDeadline(tomorrow);
        System.out.println(t1.toString());

        // ReapeatedTask testing.
        Task rp1 = new RepeatedTask("RP1", State.TODO);
        System.out.println(rp1);
        rp1.setState(State.HALT);
        System.out.println("This is when the state was changed to 'HALT'\n" + rp1);
        rp1.setState(State.DONE);
        System.out.println("This is when the state was changed to 'DONE'\n" + rp1);

        // Chore testing.
        Task c1 = new Chore("C1", State.TODO, LocalDate.now(), LocalDate.now().plus(Period.ofDays(7)));
        System.out.println(c1);
        c1.setState(State.DONE);
        System.out.println(c1);
    }
}

class RepeatedTask extends Task {
    RepeatedTask(String title, State state) {
        super(title, state);
    }

    @Override
    public void setState(State state) {
        if(state == State.DONE) {
            this.state = State.TODO;
        }
        else {
            this.state = state;
        }
    }
}

class Chore extends RepeatedTask {
    LocalDate repeat;

    Chore(String title, State state, LocalDate scheduled, LocalDate repeat) {
        super(title, state);
        setScheduled(scheduled);
        setRepeat(repeat);
    }

    public LocalDate getRepeat() {
        return this.repeat;
    }

    public void setRepeat(LocalDate repeat) {
        this.repeat = repeat;
    }

    @Override
    public void setState(State state) {
        // set state from RepeatedTask
        super.setState(state);
        if(state == State.DONE) {
            // scheduled = repeat
            // but first set repeat to +7 days
            LocalDate repeat_new = repeat.plus(Period.ofDays(7));
            setScheduled(repeat);
            setRepeat(repeat_new);
        }
    }
}

enum State {
    TODO, BEGN, HALT, WAIT, DONE;
}
