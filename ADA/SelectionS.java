public class SelectionS{

    static void SelectionSort(int[] arr){
        int n = arr.length;

        for(int i=0; i<n-1; i++){
            int minIdx = i;
            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[minIdx]){
                    minIdx = j;
                }
            }
            //swaping
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }
    public static void main(String args[]){
        int[] arr = {7, 5, 4, 1, 3};
        SelectionSort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}