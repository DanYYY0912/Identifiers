/*
 * Class : I t e m N o t F o u n d E x c e p t i o n
 * 
 * @Name : student name
 * @StdID: 20XXXXXXX
 * @Class: IT114105/1X
 * @2021-02-19
 */
public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException() {
        super("Item is not found!");
    }
}
