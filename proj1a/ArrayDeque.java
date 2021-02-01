public class ArrayDeque<Sometype> {
    private Sometype[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int resize_factor = 2;
    private int capacity;

    /** nextFirst tells you which index addFirst function would use to add number*
     *  nextLast = which index addLast function would use to add
     */

    public ArrayDeque(int capacity) {
        items = (Sometype[]) new Object[capacity];
        size = 0;
        nextFirst = 0;
        nextLast = 3;
        this.capacity = capacity;

    }

    private void resize(int capacity) {
        Sometype [] a = (Sometype[]) new Object [capacity];
        if (capacity >= items.length){
            System.arraycopy(items, 0, a, 0, size);}
        else{
            System.arraycopy(items, nextLast-size, a, 0, capacity);}
        items = a;
        nextFirst = capacity - 1;
        nextLast = size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    private boolean isFull() {
        return size == capacity;
    }

    public void addFirst(Sometype x) {
        if (isFull()) {
            resize(size * resize_factor);
            capacity *= resize_factor;
        }


        items[nextFirst] = x;
        size ++;

        /** In the special case that add first goes to the back of the array*/
        if (nextFirst == 0){
            nextFirst = items.length - 1;
        }

        else if(isFull()){
            /** if last item of array is filled, Nextlast is the length + 1*/
            nextLast = items.length;
            nextFirst --;
        }

        else{
            nextFirst --;
        }

    }

    public void addLast(Sometype x) {
        if (isFull()) {
            resize(size * resize_factor);
            capacity *= resize_factor;
        }
        if (nextLast >= capacity && size < capacity){
            nextLast -= capacity;
        }
        items[nextLast] = x;
        size ++;
        nextLast ++;
    }


    public Sometype removeFirst() {
        Sometype first_item = null;

        for(int first = 0; first < capacity; first++){
            if(get(first) != null){
                first_item = get(first);
                items[first] = null;
                break;
            }
            else{
                continue;
            }
        }
        nextFirst = 0;
        size --;



        if (items.length > 35 && 100 * size / items.length < 25){
            resize(items.length / resize_factor);
            capacity /= resize_factor;
        }
        return first_item;
    }

    public Sometype get(int index) {
        return items[index];
    }

    public Sometype removeLast() {
        Sometype last_item = null;
        for(int last = items.length - 1; last >= 0; last--){
            if(get(last) != null){
                last_item = get(last);
                items[last] = null;

                /** in the case of [1 2 3 0 0 0 12 13], keep nextLast as is when looping through 12 13, otherwise nextlast = last*/
                if (last <= nextLast){
                    nextLast = last;}

                nextFirst = items.length - 1;
                break;
            }
            else{
                continue;
            }
        }
        size --;

        /** shirnk array if necessary*/
        if (items.length > 35 && size * 100/ items.length < 25){
            resize(items.length / resize_factor);
            capacity /= resize_factor;
        }
        return last_item;
    }



    public void printDeque(){
        for (int i = 0; i < this.size();i+=1){
            System.out.println(this.get(i));
            System.out.println(" ");
        }
    }

    public int size() {
        return size;
    }






}
