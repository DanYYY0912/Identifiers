/*
 * Class : L i s t N o d e
 * 
 * @Name : YUEN Yiu Yeung
 * @StdID: 200171873
 * @Class: IT114105/1C
 * @2021-03-24
 */
public class ListNode {
    public Object data;   
    public ListNode next;
    public LinkedList move;
    public ListNode(Object data) {
        this(data,null);
    }

    public ListNode(Object data, ListNode next) {
        this.data = data;
        this.next = next;
        move = null;
    }
}
