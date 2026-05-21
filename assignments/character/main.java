public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Bold");
        student.setAge(20);
        System.out.println("Surgaluurt: " + student.getName() + ", nas " + student.getAge());
        student.setAge(200);

        BankAccount account = new BankAccount();
        account.deposit(100);
        account.deposit(-10);
        account.withdraw(30);
        account.withdraw(200);
        System.out.println("Dans: " + account.getBalance());

        Product product = new Product("Laptop", 1500);
        product.setPrice(-50);
        System.out.println(product.getName() + " une: " + product.getPrice());

        Student s = new Student();
        s.setName("Nara");
        s.setAge(19);
        System.out.println("Zasvar: private nas deer shuud orolt hiih bolomjgui, setter ashiglana.");

        ATMAccount atm = new ATMAccount("Dorj", 5000, 1000);
        atm.withdraw(600);
        atm.withdraw(500);

        Employee emp = new Employee("Sara");
        emp.setBaseSalary(700000);
        emp.addBonus(50000);
        System.out.println("Niit tsalin: " + emp.getTotalSalary());

        Candidate a = new Candidate("A");
        Candidate b = new Candidate("B");
        a.addVote();
        a.addVote();
        b.addVote();
        System.out.println(winner(a, b));
    }

    private static String winner(Candidate x, Candidate y) {
        if (x.getVotes() > y.getVotes()) {
            return x.getName() + " ylje";
        }
        if (y.getVotes() > x.getVotes()) {
            return y.getName() + " ylje";
        }
        return "Tents";
    }
}