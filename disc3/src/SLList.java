public class SLList {
    private class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    public SLList(int x) {
        first = new IntNode(x, null);
    }

    private IntNode first;

    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    public void reverse() {
        if (first == null || first.next == null){
            return;
        }

        IntNode p = first.next;
        this.first.next = null;

        while (p != null){
            IntNode temp = p.next;
            p.next = first;
            first = p;
            p = temp;
        }

    }


    public void reverse_recursive() {
        recurHelper(first.next);
    }


    private void recurHelper(IntNode lst) {
        if (lst == null) {
            return;
        }
        else {
            if (first.next == lst) {
                first.next = null;
            }
            IntNode ptr = lst.next;
            //IntNode temp = ptr.next;
            lst.next = first;
            first = lst;
            recurHelper(ptr);
            return;
        }
    }





    public void reverseRecur() {
        first = reverseHelper(first);
    }

    private IntNode reverseHelper(IntNode lst) {
         if (lst == null || lst.next == null) {
             return lst;
             } else {
             IntNode endOfReversed = lst.next;
             IntNode reversed = reverseHelper(lst.next);
             endOfReversed.next = lst;
             lst.next = null;
             return reversed;
             }
         }

    public static void main(String args[]){
        SLList s1 = new SLList(8);
        for (int i=7; i>=5;i--){
            s1.addFirst(i);
        }
        s1.reverse_recursive();;
        //s1.reverseRecur();
    }

}