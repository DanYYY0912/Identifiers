
/**
 * Class TestStaff - Object-oriented Programming(Interface)
 *
 * @YUEN Yiu Yeung 
 * @2021-01-31
 */
public abstract class Staff{
    protected String name;
    protected int id;
    protected char grade;

    public Staff(String name, int id, char grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }
    public abstract void display();

}
