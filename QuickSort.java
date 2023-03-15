package code;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {7,5,5,9,6,4,3,8,2,1};
        sort(arr);
        for(int i: arr){
            System.out.println(i);
        }

        char[] arr1 = "OIGBSKDUZKWNFGJ".toCharArray();
        sort(arr1);
        for(char i: arr1){
            System.out.println(i);
        }
    }

    public static void sort(int[] arr){
        if(arr.length < 2) return;
        else sort(0, arr.length-1, arr);
    }

    public static void sort(char[] arr){
        if(arr.length < 2) return;
        else sort(0, arr.length-1, arr);
    }

    public static void sort(int left , int right, int[] arr){
        if(left >= right) return;

        int start = left, end = right;
        int pivot = arr[start];

        while(left < right){
            if(arr[right] < pivot) {
                left++;
                if(arr[left] > pivot) swap(left, right, arr);
            }
            else right--;
        }

        swap(start, right, arr);
        sort(start, right - 1, arr);
        sort(right + 1, end, arr);
    }

    private static void swap(int a, int b, int[] arr){
        int m = arr[a];
        arr[a] = arr[b];
        arr[b] = m;
    }

    //Char case
    public static void sort(int left , int right, char[] arr){
        if(left >= right) return;

        int start = left, end = right;
        int pivot = arr[start];

        while(left < right){
            if(arr[right] < pivot) {
                left++;
                if(arr[left] > pivot) swap(left, right, arr);
            }
            else right--;
        }

        swap(start, right, arr);
        sort(start, right - 1, arr);
        sort(right + 1, end, arr);
    }

    private static void swap(int a, int b, char[] arr){
        char m = arr[a];
        arr[a] = arr[b];
        arr[b] = m;
    }
}
