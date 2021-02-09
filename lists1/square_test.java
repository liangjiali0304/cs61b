public class square_test {


    public static IntList square(IntList L) {
        /* Your code here. */
        if(L.rest == null){
            return new IntList(L.first * L.first,null);
        }
        return new IntList(L.first * L.first,square(L.rest));

    }

    public static IntList squareDestructive(IntList L) {
        /* Your code here. */
        if(L.rest == null){
            L.first = L.first * L.first;
            return L;

        }
        L.first = L.first * L.first;
        L.rest = square(L.rest);
        return L;

    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(7, null);
        L.rest.rest = new IntList(9, null);
        L.rest.rest.rest = new IntList(11, null);

        System.out.println(L.size());

        IntList Q = squareDestructive(L);
        System.out.println(Q.size());
        for (int i = 0; i < Q.size(); i += 1) {
            System.out.println(Q.get(i));


            // Test your answers by uncommenting. Or copy and paste the
            // code for incrList and dincrList into IntList.java and
            // run it in the visualizer.
            // System.out.println(L.get(1));
            // System.out.println(incrList(L, 3));
            // System.out.println(dincrList(L, 3));
        }
        for (int i = 0; i < L.size(); i += 1) {
            System.out.println(L.get(i));}
    }
}
