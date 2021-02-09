public class hw0_ex4 {
    public static void windowPosSum(int[] a, int n) {
        /** your code here */
        for (int i = 0; i < a.length; i = i +1){
            /** If last element, do nothing*/
            if(i == a.length-1){break;}

            if (a[i] > 0) {
                int sum = a[i];
                for (int inx = 1; inx <= n; inx = inx +1){
                    /** If index outbound*/
                    if (inx + i >= a.length){
                        System.out.println("OUT");
                        break;
                    }
                    sum = sum + a[inx + i];
                    /** Otherwise, operation*/


                }
                /** forward sum to a[i]*/
                a[i] = sum;
            }


        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, -3, 4, 5, 4};
        int n = 3;
        windowPosSum(a, n);
        int[] a1 = {1, -1, -1, 10, 5, -1};
        int n1 = 2;
        windowPosSum(a1, n1);


        // Should print 4, 8, -3, 13, 9, 4
        System.out.println(java.util.Arrays.toString(a));

        // Should print -1, -1, -1, 14, 4, -1
        System.out.println(java.util.Arrays.toString(a1));
    }
}