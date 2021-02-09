public class hw0_ex2 {
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
        int winner = m[1];
        for (int x = 1; x < m.length; x = x +1){
            if (winner <= m[x]){
                winner = m[x];
            }
            System.out.println(winner);
        }
        System.out.println("Final winner is :");
        System.out.println(winner);

        return 0;
    }
    public static void main(String[] args) {
        int[] numbers = new int[]{9, 2, 15, 23, 22, 10, 36, 11,99};
        max(numbers);
    }
}