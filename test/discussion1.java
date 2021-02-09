public class discussion1 {
    public static int Finb(int N) {
        int [] Fib = new int[N+1];
        Fib[0] = 0; Fib[1] = 1;
        if (N <= 1){
            return Fib[N];
        }

        for (int i = 2; i <= N; i = i + 1){
            Fib[i] = Fib[i-1] + Fib[i-2];

        }
        return Fib[N];
    }

    public static void main(String[] args) {
    System.out.println(Finb(9));
    }

}