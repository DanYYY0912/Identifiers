    
/**
 * Class TestStaff - Object-oriented Programming(Interface)
 *
 * @YUEN Yiu Yeung 
 * @2021-01-31
 */
public class PartTimeStaff extends Staff implements Salary {
    private int workingHour;

    public PartTimeStaff(String name, int id, char grade, int workingHour) {
        super(name, id, grade);
        this.workingHour = workingHour;
    }

    public void display() {
        System.out.println("Name: " + this.name + "; ID: " + this.id + "; Grade: " + this.grade + "; Working Hour: " +
               this.workingHour + "; Salary: " + computeSalary());
    }

    public int computeSalary() {
        switch (grade) {
            case 'A': return SALARY_A;
            case 'B': return SALARY_B;
            case 'C': return SALARY_C;
            default: return SALARY_OTHER;
        }
    }
}

