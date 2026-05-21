public class Employee {
    private static final double MINIMUM_WAGE = 0;

    private String name;
    private double baseSalary;
    private double bonus;

    public Employee(String name) {
        this.name = name == null ? "" : name;
        this.baseSalary = MINIMUM_WAGE;
        this.bonus = 0;
    }

    public String getName() {
        return name;
    }

    public void setBaseSalary(double salary) {
        if (salary < 0) {
            System.out.println("Sur sur bolohgui");
            return;
        }
        if (salary < MINIMUM_WAGE) {
            System.out.println("Sur bagadaa bag");
            return;
        }
        this.baseSalary = salary;
    }

    public void addBonus(double amount) {
        if (amount < 0) {
            System.out.println("Urshuulgiin dugnelt buruu");
            return;
        }
        this.bonus += amount;
    }

    public double getTotalSalary() {
        return baseSalary + bonus;
    }
}