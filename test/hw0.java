public class hw0 {
    public static void DrawTriangle(int N) {
        int x = 1;
        while (x <= N){
            int y = 1;
            while (y<=x){
            System.out.print("*");
            y = y + 1;
            }
            System.out.println("");
            x = x + 1;
        }
    }

    public static void main(String[] args) {
        DrawTriangle(10);
    }
}