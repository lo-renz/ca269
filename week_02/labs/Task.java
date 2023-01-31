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

        System.out.println("----------");

        // ReapeatedTask testing.
        Task rp1 = new RepeatedTask("RP1", State.TODO);
        System.out.println(rp1);
        rp1.setState(State.HALT);
        System.out.println("This is when the state was changed to 'HALT'\n" + rp1);
        rp1.setState(State.DONE);
        System.out.println("This is when the state was changed to 'DONE'\n" + rp1);

        System.out.println("----------");

        // Chore testing.
        Task c1 = new Chore("C1", State.TODO, LocalDate.now(), LocalDate.now().plus(Period.ofDays(7)));
        System.out.println(c1);
        c1.setState(State.DONE);
        System.out.println(c1);

        System.out.println("----------");

        // SharedTask testing.
        Task st1 = new SharedTask("ST1", "Renso");
        System.out.println(st1);

        System.out.println("----------");
        Task d1 = new Dependency("D1", State.TODO, t1);
        System.out.println(d1);
        d1.setState(State.DONE);
        System.out.println(d1 + " This will not change the task's state to DONE because the dependent task is not labelled as DONE.");
        t1.setState(State.DONE);
        d1.setState(State.DONE);
        System.out.println(d1);
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

class SharedTask extends Task {
    String name;

    SharedTask(String title, String name) {
        super(title, State.WAIT);
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString() + " shared with: " + name;
    }
}

class Dependency extends Task {
    Task task_dependency;

    Dependency(String title, State state, Task task_dependency) {
        super(title, state);
        this.task_dependency = task_dependency;
    }

    @Override
    public String toString() {
        return super.toString() + " dependent on: " + task_dependency.toString();
    }

    @Override
    public void setState(State state) {
        // For the current Task to be labelled as DONE, both the dependent task and current task must be labelled as DONE.
        if(state == State.DONE && task_dependency.state != State.DONE) {
            return;
        }
        else {
            this.state = state;
        }
    }
}

enum State {
    TODO, BEGN, HALT, WAIT, DONE;
}
