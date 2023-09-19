public class SalaryWorker extends Worker{

    private double annualSalary;

    //Constructor
    public SalaryWorker(String id, String firstName, String lastName, String title, int dateOfBirth, double hourlyPayRate , double annualSalary) {
        super(id, firstName, lastName, title, dateOfBirth, hourlyPayRate);
        this.annualSalary = annualSalary;
    }

    //Getters and setters
    public double getAnnualSalary() {
        return annualSalary;
    }
    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    //tostring method


    @Override
    public String toString() {
        return "salaryWorker{" +
                "id='" + this.getId() + '\'' +
                ", firstName='" + this.getFirstName() + '\'' +
                ", lastName='" + this.getLastName() + '\'' +
                ", title='" + this.getTitle() + '\'' +
                ", dateOfBirth=" + this.getDateOfBirth() +
                "hourlyPayRate=" + this.getHourlyPayRate() +
                "annualSalary=" + annualSalary +
                '}';
    }

    @Override
    public double calculateWeeklyPay(double hoursWorked) {
        return annualSalary / 52;
    }

    @Override
    public String displayWeeklyPay(double hoursWorked) {
        double weeklyPay = calculateWeeklyPay(hoursWorked);
        return "Weekly Pay: $" + weeklyPay;
    }

}
