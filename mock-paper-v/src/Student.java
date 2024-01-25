// An eating student ....
public class Student implements Runnable {
    int n; // this student’s number
    int talkDelay; // how long does this student talk for?
    int eatDelay; // how long does this student eat
    int left, right; // left and right fork number
    Forks forks; // forks used by all students

    public Student(int n, int talkDelay, int eatDelay, Forks forks) {
        this.n = n;
        this.talkDelay = talkDelay;
        this.eatDelay = eatDelay;
        this.forks = forks;
        left = n == 0 ? 4 : n - 1;
        right = (n + 1) % 5;
        new Thread(this).start();
    }


    @Override
    public void run() {
        for (; ; ) {
            try {
                Thread.sleep(talkDelay);
                forks.get(left, right);
                System.out.println("Student " + n + " is eating... with forks " + left + " and " + right);
                Thread.sleep(eatDelay);
                forks.put(left, right);
            } catch (Exception ex) {
                return;
            }
        }
    }
}