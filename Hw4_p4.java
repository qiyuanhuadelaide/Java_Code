package main.im.qiyuanhu.homework;

public class Hw4_p4 {

    /**
     * the two methods named rearrange are different in parameter
     * @param head the head of linked list
     * @param x which value need to be counted
     * @return the numbers of times x occurs in the linked list
     */
    public static int numOccurrences(MyLinkedList.Node<Integer> head,int x){
        // to check if it went through the whole linked list
        if (head==null){
            return 0;
        }
        // check the current head value is x or not
        if (head.getElement()==x){
            // Count with the next node of the current node as the head, add one to the value, and return to the next level
            return 1+numOccurrences(head.getNext(),x);
        }
        else {
            // Since the value of the current head node is not equal to x, we simply return the number that the next node starts counting to
            return numOccurrences(head.getNext(),x);
        }
    }

    /**
     *
     * @param list the whole linked list
     * @param x which value need to be counted
     * @return he numbers of times x occurs in the linked list
     */
    public static int numOccurrences(MyLinkedList<Integer> list, int x) {
        // implement this method
        // consider writing a separate method with additional parameters
        return numOccurrences(list.head,x);//using recursive method
    }

    public static void main(String[] args) {

        MyLinkedList<Integer> intLinkedList = new MyLinkedList<>();
        int[] intArray = {3, 8, 7, 3, 5, 1, 7, 4, 7, 5, 5, 9, 5, 3, 2, 2, 7};
        for (int i=0; i<intArray.length; i++) {
            intLinkedList.addLast(intArray[i]);
        }

        System.out.println("Print linked list: ");
        System.out.print("[");
        MyLinkedList.Node<Integer> cur = intLinkedList.head;
        while (cur.getNext() != null) {
            System.out.print(cur.getElement() + ", ");
            cur = cur.getNext();
        }
        System.out.println(cur.getElement() + "]");
        System.out.println();

        int x = 3;
        System.out.println("Search linked list: ");
        int count = numOccurrences(intLinkedList, x);// call numOccurrences method
        System.out.println(x + " occurs in the linked list " + count + " times.");

    }
}
