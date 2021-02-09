public class AList {
    /** Given an item, index and array, insert item at destined index in the array given */
    public static int[] insert(int[] arr, int item, int position) {
        int[] return_arr = new int[arr.length+1];
         // find the min between arr.length and position
        position = Math.min(arr.length, position);

        System.arraycopy(arr, 0, return_arr, 0, position);
        return_arr[position] = item;
        System.arraycopy(arr, position, return_arr, position+1, arr.length - position);

        return return_arr;
    }
    /** Destrutively reverse the array*/
    public static void reverse(int[] arr) {
        for(int i = 0; i < arr.length/2;i++){
            int temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }

    }


    public static int[] replicate(int[] arr) {
        int sum = 0;
        for (int i:arr){
            sum += i;
        }
        int[] replicated_arr = new int[sum];
        int size = 0;
        for (int i:arr){
            for(int j =size; j <size+i;j++){
                replicated_arr[j] = i;
            }
            size += i;
        }
        return replicated_arr;
    }

    public static void main(String args[]){
        int[] arr = {1,2,4,5,6};
        //int[] new_arr = insert(arr,10,2);
        reverse(arr);
        //System.out.println(calc_length(4));
        replicate(arr);
    }


}
