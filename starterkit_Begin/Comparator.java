/*
 * Interface : C o m p a r a t o r
 * 
 * @Name : student name
 * @StdID: 20XXXXXXX
 * @Class: IT114105/1X
 * @2021-02-19
 */
public interface Comparator {
    public abstract boolean isEqualTo (Object item1, Object item2);
    //public abstract boolean isLessThan (Object item1, Object item2);
    public abstract boolean isLessThanOrEqualTo (Object item1, Object item2);
    public abstract boolean isGreaterThan (Object item1, Object item2);
    public abstract boolean isGreaterThanOrEqualTo (Object item1, Object item2);
}

