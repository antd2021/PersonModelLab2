public class Worker extends Person{

   private double hourlyPayRate;

   //Constructor
   public Worker (String id, String firstName, String lastName, String title, int dateOfBirth , double hourlyPayRate){
        super(id , firstName , lastName , title , dateOfBirth);
        this.hourlyPayRate = hourlyPayRate;
    }

    //Getter and setters
    public double getHourlyPayRate() {
        return hourlyPayRate;
    }
    public void setHourlyPayRate(double hourlyPayRate) {
        this.hourlyPayRate = hourlyPayRate;
    }

    //To string method


    @Override
    public String toString() {
        return "Worker{" +
                "id='" + this.getId() + '\'' +
                ", firstName='" + this.getFirstName() + '\'' +
                ", lastName='" + this.getLastName() + '\'' +
                ", title='" + this.getTitle() + '\'' +
                ", dateOfBirth=" + this.getDateOfBirth() +
                "hourlyPayRate=" + hourlyPayRate +
                '}';
    }

    public double calculateWeeklyPay (double totalWeeklyHours){
       double normalWage;
       double overTimeWage;

       if (totalWeeklyHours <= 40){
           normalWage = hourlyPayRate * totalWeeklyHours;
           overTimeWage = 0;
       }

       else{
           normalWage = hourlyPayRate * 40;
           overTimeWage = (totalWeeklyHours - 40) * 1.5;
       }

       return normalWage + overTimeWage;
   }

   public String displayWeeklyPay(double totalWeeklyHours){
       double normalWage;
       double overTimeWage;

       if (totalWeeklyHours <= 40){
           normalWage = hourlyPayRate * totalWeeklyHours;
           overTimeWage = 0;
       }

       else{
           normalWage = hourlyPayRate * 40;
           overTimeWage = (totalWeeklyHours - 40) * 1.5;
       }

       double totalPay = normalWage + overTimeWage;

       String payDetails = "Weekly Pay Details:\n";
       payDetails += "Regular Hours (40 hours) at $" + hourlyPayRate + "/hour: $" + normalWage + "\n";
       payDetails += "Overtime Hours (" + (totalWeeklyHours - 40) + " hours) at $" + (hourlyPayRate * 1.5) + "/hour: $" + overTimeWage + "\n";
       payDetails += "Total Pay: $" + totalPay;

       return payDetails;
   }

}
