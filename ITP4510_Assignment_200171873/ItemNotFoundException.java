/*
 * Class : I t e m N o t F o u n d E x c e p t i o n
 * 
 * @Name : YUEN Yiu Yeung
 * @StdID: 200171873
 * @Class: IT114105/1C
 * @2021-03-24
 */
public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException() {
        super("Item is not found!");
    }
}
