/*
 * Class : E m p t y L i s t E x c e p t i o n
 * 
 * @Name : student name
 * @StdID: 20XXXXXXX
 * @Class: IT114105/1X
 * @2021-02-19
 */
public class EmptyListException extends RuntimeException {
    public EmptyListException() {
        super("List is empty.");
    }
}
