/*
 * Class : L i n k e d L i s t
 * 
 * @Name : YUEN Yiu Yeung
 * @StdID: 200171873
 * @Class: IT114105/1C
 * @2021-03-24
 */
public class LinkedList {
    private ListNode head;
    private ListNode tail;
    private Comparator comparator;
    private int largeLength;

    public LinkedList() {
        this(new StringComparator());
    }

    public LinkedList(Comparator comparator) {
        head = tail = null;
        this.comparator = comparator;
        largeLength = 0;
    }

    public boolean isEmpty() {
        return (head==null);
    }

    public void addToHead(Object item) {
        if (isEmpty()) {
            head = tail = new ListNode(item);
        } else {
            head = new ListNode(item, head);
        }
    }

    public void addToTail(Object item) {
        if (isEmpty()) {
            head = tail = new ListNode(item);
        } else {
            tail.next = new ListNode(item);
            tail =  tail.next;
        }
    }

    public Object removeFromHead() throws EmptyListException {
        Object item = null;
        if (isEmpty()) {
            throw new EmptyListException();
        } 
        item = head.data;
        if (head == tail)      // there's only one single node
            head = tail = null;
        else
            head = head.next;
        return item;

    }

    public Object removeFromTail() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException();
        } 
        Object item = tail.data;
        if (head == tail) {   // there is only one node
            head = tail = null;
            return item;
        }
        ListNode current = head;
        while (current.next != tail)
            current = current.next;
        tail = current;
        tail.next = null;
        return item;
    }

    public String toString() {
        String s = "";
        ListNode current = head;
        while (current != null) {
            s += current.data + " ";
            if(current.move != null)
                s += ": [ " + current.move.toString() + "]\n";
            current = current.next;
        }
        return s;
    }

    public void insertInOrder (Object item,int lineNum) {
        String input = (String)item;                     // count the largest size of length
        if(input.length() > largeLength)
            largeLength = input.length();
            
        LinkedList newList = new LinkedList(new StringComparator());
        ListNode curr = head;
        if (isEmpty()){
            head = tail = new ListNode (item);
            head.move = newList;
            head.move.addToTail(lineNum);               // add count line
        }else if(comparator.isEqualTo(curr.data, item)){
                curr.move.addToTail(lineNum);
        }else if(comparator.isGreaterThan(head.data, item)){    // compare to head
            addToHead(item);
            head.move = newList;
            head.move.addToTail(lineNum);
        }else if(comparator.isLessThan(tail.data, item)){      // compare to tail
            addToTail(item);
            tail.move = newList;
            tail.move.addToTail(lineNum);
        }else
            while(curr.next != null){
                if(comparator.isEqualTo(curr.next.data, item)){     // find same value
                    curr = curr.next;
                    curr.move.addToTail(lineNum);
                    return;
                }
                else if(comparator.isGreaterThan(curr.next.data, item)){
                    ListNode newNode = new ListNode(item);
                    newNode.next =  curr.next;
                    curr.next = newNode;
                    newNode.move = newList;
                    newNode.move.addToTail(lineNum);
                    return;
                }
                curr = curr.next;
            }
    }

    public void removeItem (Object item) throws ItemNotFoundException {
        if (isEmpty()) {
            throw new ItemNotFoundException();
        } 
        if (comparator.isEqualTo(head.data, item)) 
            removeFromHead();
        else if (comparator.isEqualTo(tail.data, item)) 
            removeFromTail();
        else {
            // remove a node in the middle
            ListNode current = head;
            while (current.next != null) {
                if (comparator.isEqualTo(current.next.data, item)) {
                    current.next = current.next.next;
                    return;
                }
                current = current.next;
            }
            throw new ItemNotFoundException();
        }
    }	

    public ListNode search(String item){
        ListNode current = head;                              // Comparing the node data
        while (current.next != null) {
            if (comparator.isEqualTo(current.next.data, item))
                return current;
            current = current.next;
        }
        return null;
    }
    
    
}