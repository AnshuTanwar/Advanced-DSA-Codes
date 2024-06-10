public class InsertionS {

    static void InsertionSort(int[] arr){
        int n = arr.length;
        for(int i=1; i<n; i++){
            int temp = arr[i];
            int j = i-1;

            while(j>=0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }
    public static void main(String args[]){
        int[] arr = {8, 5, 4, 7, 2, 1};
        InsertionSort(arr);
        for(int i=0; i<=arr.length-1; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
