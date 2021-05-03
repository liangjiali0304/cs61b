public class prep06 {
    public int count = 0;
    public int function(int N, int M) {
         if (N < 10) return 0 ;
         for (int i = 0; i <= N % 10; i++) {
             function(N / 10, M / 10);
             //System.out.println(M);
             count++;
             }
         return count;
          }
    public static void main(String[] args) {
        prep06 X = new prep06();
        for (int i = 19; i < 1e5; i *= 10){
            int count = X.function(i,101);
            System.out.println(i);
            System.out.println(count);
    }
}
}
