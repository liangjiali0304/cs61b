public class LinkedListDequeLauncher {
    public static void main(String[] args){
        LinkedListDeque <Integer> s1 = new LinkedListDeque();
        /**s1.addFirst(29);*/

        s1.addLast(10);
        s1.addLast(5);
        s1.addLast(19);
        /**System.out.println(s1.getFirst());
        System.out.println(s1.getLast());
        System.out.println(s1.isEmpty());
        s1.printDeque();
        System.out.println("###############");
        /**s1.removeFirst();
        s1.printDeque();
        System.out.println("###############");
        s1.removeFirst();
        s1.printDeque();*/

        System.out.println(s1.getRecursive(2));
        System.out.println(s1.get(0));
    }

}
