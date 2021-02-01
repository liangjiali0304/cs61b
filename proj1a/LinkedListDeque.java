public class LinkedListDeque<Sometype> {

    /** in this code IntList is no longer an integer list
     * I keep it there just because of the tradition*/

    private IntNode sentinel;
    private int size;

    /* the first item (if exist) is at sentinel.next*
       the last item (if exist) is at sentinel.prev*
     */

    public class IntNode {
        public IntNode prev;
        public Sometype item;
        public IntNode next;

        public IntNode(Sometype i, IntNode p, IntNode n){
            item = i;
            next = n;
            prev = p;
        }

    }


    public LinkedListDeque() {
        sentinel = new IntNode(null,null,null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /** there are 2 situations, if size = 0, and the rest */
    public void addFirst(Sometype x) {
        sentinel.next = new IntNode(x,sentinel,sentinel.next);
        if (size == 0 ){
            sentinel.prev = sentinel.next;
        }
        else{
            sentinel.next.next.prev = sentinel.next;
        }
        size += 1;
    }

    public void addLast(Sometype x) {
        sentinel.prev = new IntNode(x,sentinel.prev,sentinel);
        if (size == 0 ){
            sentinel.next = sentinel.prev;
        }
        else{
            sentinel.prev.prev.next = sentinel.prev;
        }

        size += 1;
    }

    /** if size = 0 return */
    public boolean isEmpty(){
        return size()==0;
    }

    public int size() {
        return size;
    }

    public Sometype getRecursive(int inx) {
        if(inx == 0){
            return sentinel.next.item;
        }
        LinkedListDeque <Sometype> test = new LinkedListDeque();

        test.sentinel.next = this.sentinel.next.next;
        //IntNode test = new IntNode(sentinel.next.item,sentinel,sentinel.next.next);
        return test.getRecursive(inx - 1);
    }

    /** Create a new IntNode to deal with the iteration. */
    public Sometype get(int inx) {

        if(inx == 0){
            return sentinel.next.item;
        }
        IntNode test = new IntNode(sentinel.next.item,sentinel,sentinel.next.next);
        while (inx != 1) {
            test.next = test.next.next;
            inx -= 1;
        }
        return test.next.item;
    }


    public void printDeque(){
        for (int i = 0; i < this.size();i+=1){
            System.out.println(this.get(i));
            System.out.println(" ");
        }
    }


    public Sometype removeFirst() {
        //sentinel.next = new IntNode(sentinel.next.next.item,sentinel,sentinel.next.next.next);
        sentinel.next = sentinel.next.next;
        sentinel.next.next.prev = sentinel;
        size -= 1;
        if(size == 0){return null;}
        else {
            return sentinel.next.item;
        }
    }


    public Sometype removeLast() {
        //sentinel.next = new IntNode(sentinel.next.next.item,sentinel,sentinel.next.next.next);
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.prev.next = sentinel;
        size -= 1;
        if(size == 0){return null;}
        else {
            return sentinel.prev.item;
        }
    }


}
