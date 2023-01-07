class Main {
    public static void main(String[] args) {
        Forks forks = new Forks();
        new Student(0, 1000, 5000, forks);
        new Student(1, 2000, 4000, forks);
        new Student(2, 3000, 3000, forks);
        new Student(3, 4000, 2000, forks);
        new Student(4, 5000, 1000, forks);
    }
}