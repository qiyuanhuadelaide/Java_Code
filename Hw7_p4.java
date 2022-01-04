package main.im.qiyuanhu.homework;

public class Hw7_p4 {

    public static void chainingMethod(SinglyLinkedList[] T, int[] a) {
        // implement this method
        int N= T.length;
        int remainder=0;//keep the reminder for switch
        for(int i=0;i<a.length;i++){
            remainder=a[i]%N;//MOD
            switch (remainder){//switch make code clear same function as if-else
                case 0:
                    if(T[0]==null)
                    {
                        T[0]=new SinglyLinkedList();
                    }//initialize it
                    if(T[0].isEmpty())
                    {
                        T[0].addFirst(a[i]);
                    }//add head
                    else {//the head need to go through elements to see whether there's a same value; otherwise, need to insert it
                        SinglyLinkedList.Node head=T[0].getHead();
                        boolean flag=false;//use flag to mark, false means there's no same value, true means there has same value
                        while (head!=null){
                            if(head.getElement()==a[i]){
                                System.out.println("Element "+a[i]+" already exists");
                                flag=true;
                                break;//print out sentence when the element is already existed and break the while loop
                            }
                            head=head.getNext();//go to find next node
                        }//after traversing， flag is still false, which means that's not existed, so I need to insert it.
                        if(!flag){
                            T[0].addLast(a[i]);
                        }
                    }
                    break;
                case 1:
                    if(T[1]==null)
                    {
                        T[1]=new SinglyLinkedList();
                    }//initialize
                    if(T[1].isEmpty())
                    {
                        T[1].addFirst(a[i]);
                    }//add head
                    else {//the head need to go through elements to see whether there's a same value; otherwise, need to insert it
                        SinglyLinkedList.Node head1=T[1].getHead();
                        boolean flag1=false;//use flag to mark, false means there's no same value, true means there has same value
                        while (head1!=null){
                            if(head1.getElement()==a[i]){
                                System.out.println("Element "+a[i]+" already exists");
                                flag1=true;
                                break;//print out sentence when the element is already existed and break the while loop
                            }
                            head1=head1.getNext();//go to find next node
                        }//after traversing， flag is still false, which means that's not existed, so I need to insert it.
                        if(!flag1){
                            T[1].addLast(a[i]);
                        }
                    }
                    break;
                case 2:
                    if(T[2]==null)
                    {
                        T[2]=new SinglyLinkedList();
                    }//initialize
                    if(T[2].isEmpty())
                    {
                        T[2].addFirst(a[i]);
                    }//add head
                    else {//the head need to go through elements to see whether there's a same value; otherwise, need to insert it
                        SinglyLinkedList.Node head2=T[2].getHead();
                        boolean flag2=false;//use flag to mark, false means there's no same value, true means there has same value
                        while (head2!=null){
                            if(head2.getElement()==a[i]){
                                System.out.println("Element "+a[i]+" already exists");
                                flag2=true;
                                break;//print out sentence when the element is already existed and break the while loop
                            }
                            head2=head2.getNext();//go to find next node
                        }//after traversing， flag is still false, which means that's not existed, so I need to insert it.
                        if(!flag2){
                            T[2].addLast(a[i]);
                        }
                    }
                    break;
                case 3:
                    if(T[3]==null)
                    {
                        T[3]=new SinglyLinkedList();
                    }//initialize
                    if(T[3].isEmpty())
                    {
                        T[3].addFirst(a[i]);
                    }//add head
                    else {//the head need to go through elements to see whether there's a same value; otherwise, need to insert it
                        SinglyLinkedList.Node head3=T[3].getHead();
                        boolean flag3=false;//use flag to mark, false means there's no same value, true means there has same value
                        while (head3!=null){
                            if(head3.getElement()==a[i]){
                                System.out.println("Element "+a[i]+" already exists");
                                flag3=true;
                                break;//print out sentence when the element is already existed and break the while loop
                            }
                            head3=head3.getNext();//go to find next node
                        }//after traversing， flag is still false, which means that's not existed, so I need to insert it.
                        if(!flag3){
                            T[3].addLast(a[i]);
                        }
                    }
                    break;
                case 4:
                    if(T[4]==null)
                    {
                        T[4]=new SinglyLinkedList();
                    }//initialize
                    if(T[4].isEmpty())
                    {
                        T[4].addFirst(a[i]);
                    }//add head
                    else {//the head need to go through elements to see whether there's a same value; otherwise, need to insert it
                        SinglyLinkedList.Node head4=T[4].getHead();
                        boolean flag4=false;//use flag to mark, false means there's no same value, true means there has same value
                        while (head4!=null){
                            if(head4.getElement()==a[i]){
                                System.out.println("Element "+a[i]+" already exists");
                                flag4=true;
                                break;//print out sentence when the element is already existed and break the while loop
                            }
                            head4=head4.getNext();//go to find next node
                        }//after traversing， flag is still false, which means that's not existed, so I need to insert it.
                        if(!flag4){
                            T[4].addLast(a[i]);
                        }
                    }
                    break;

            }
        }


    }

    public static void main(String[] args) {
        // complete the main method

        int N = 5; // hash table size


        // create and initialize an array of SinglyLinkedList
        SinglyLinkedList[] T=new SinglyLinkedList[N];

        // array of integer keys
        int[] a = {3,5, 10, 3, 18, 54, 26, 3, 75, 9, 11, 5, 29, 34};

        // insert keys
        chainingMethod(T, a);

        // print hash table content
        System.out.println();
        System.out.println("Hash table content：");
        System.out.println();
        for(int i=0;i<5;i++){
            if(T[i]==null)
            {
                System.out.println("Hash table slot "+i+":");
            }else {
                SinglyLinkedList.Node node=T[i].getHead();
                System.out.print("Hash table slot "+i+":");
                while(node!=null){
                    System.out.print(node.getElement()+" ");
                    node=node.getNext();
                }
                System.out.println();


            }
        }



    }
}
