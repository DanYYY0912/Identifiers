
/**
 * Abstract Class Food - Object-oriented Programming(abstract class and methods)
 *
 * @YUEN Yiu Yeung 
 * @2021-01-31 
 */
public abstract class Food {
    protected String name;
    protected int price;

    public Food() {
        name = null;
        price = 0;
    }

    public Food(String name, int price) {
        this.name = name;
        setPrice(price);
    }

    public String toString() {
        return "name=" + name + ", price=" + price;
    }
    
    public abstract void setPrice(int price);
}

