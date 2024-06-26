public class MergeSort {
    
    public static void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
    }
    
    private static void mergeSort(int[] array, int[] helper, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergeSort(array, helper, low, middle); 
            mergeSort(array, helper, middle + 1, high); 
            merge(array, helper, low, middle, high); 
        }
    }
    
    private static void merge(int[] array, int[] helper, int low, int middle, int high) {

        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }
        
        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;
        
   
        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                array[current] = helper[helperLeft];
                helperLeft++;
            } else {
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }
        
        
        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            array[current + i] = helper[helperLeft + i];
        }
    }
    

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
 
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        System.out.println("Original array:");
        printArray(array);
        
        mergeSort(array);
        
        System.out.println("Sorted array:");
        printArray(array);
    }
}
