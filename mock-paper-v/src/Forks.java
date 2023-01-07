// Fork pool used by the students
class Forks {
    boolean[] fork = {false, false, false, false, false};
    // initialize a boolean array
    // initially false, i.e. not used

    // Try to pick up the forks with the designated numbers

    public void get(int left, int right) {
        synchronized (this) {
            try {
                while (fork[left] || fork[right])
                    wait();
                fork[left] = fork[right] = true;
            } catch (Exception ex) {
                System.err.println(ex);
            }
        }
    }

    // Lay down the forks with the designated numbers
    public void put(int left, int right) {
        synchronized (this) {
            fork[left] = fork[right] = false;
            System.err.println("Releasing forks " + left + " and " + right);
            notifyAll();
        }
    }
}