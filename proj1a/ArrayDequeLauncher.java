public class ArrayDequeLauncher {
    public static void main(String[] args) {
        ArrayDeque <Integer> s1 = new ArrayDeque(8);

        for (int i = 1; i < 20; i++) {
            s1.addLast(i);
        }

        System.out.println(s1.get(9));


        for (int i = 1; i < 20; i++) {
            s1.removeFirst();
        }
    }
}
