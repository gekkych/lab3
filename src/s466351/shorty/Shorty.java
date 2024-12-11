package s466351.shorty;

import s466351.area.Destination;

public abstract class Shorty {
    protected String name;
    protected Job job;
    protected int condition;
    protected Destination position;

    public Shorty(Destination position) {
        this.name = "noname";
        this.job = Job.WORKER;
        this.position = position;
        this.setCondition(100);
    }

    public Shorty(String name, Job job) {
        this.name = name;
        this.job = job;
        this.position = Destination.DEFAULT;
        this.setCondition(100);
    }

    public Shorty(String name, Job job, int condition) {
        this.name = name;
        this.job = job;
        this.position = Destination.DEFAULT;
        this.setCondition(condition);
    }

    public abstract void runTo(Destination d);

    public void restore() {
        if (this.condition < 80) {
            this.condition = 100;
            System.out.println(this.getName() + " восстановил силы");
        } else {
            System.out.println(this.getCondition());
        }
    }

    public void setCondition(int cond) {
        if (cond > 100) {
            this.condition = 100;
        } else if (cond < 1) {
            this.condition = 1;
        } else {
            this.condition = cond;
        }
    }

    public int getCondition() {
        if (this.condition >= 80) {
            System.out.print(this.name + " в прекрасном состоянии");
        } else if (this.condition >= 40) {
            System.out.print(this.name + " в удовлетворительном состоянии");
        } else {
            System.out.print(this.name + " в ужасном состоянии");
        }
        System.out.println(" " + this.condition + "%");
        return this.condition;
    }

    public Destination getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public void getJob() {
        System.out.println(Job.getTranslation(this.job));
    }
}
