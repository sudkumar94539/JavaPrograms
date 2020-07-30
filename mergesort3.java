public class mergesort3 {

    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        mergeSort(intArray, 0, intArray.length+1);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    // { 20, 35, -15, 7, 55, 1, -22 }
    public static void mergeSort(int[] input, int start, int end) {

        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(input, start, mid);
        mergeSort(input, mid+1, end);
        merge(input, start, mid, end);
    }

    // { 20, 35, -15, 7, 55, 1, -22 }
    public static void merge(int[] input, int start, int mid, int end) {

        if (input[mid - 1] <= input[mid]) {
            return;
        }

        int h = start, i = start, j = mid + 1, k;
        int[] b = (new int [end*2 - start]);
        while ((h <= mid) && (j <= end)) {
            if (input[h] <= input[j]) {
                b[i] = input[h];
                h++;
            }
            else {
                b[i] = input[j];
                j++;
            }
            i++;
        }

        if (h > mid)
            for (k = j; k <= end; k++) {
                b[i] = input[k];
                i++;
            }
        else for (k = h; k <= mid; k++) {b[i] = input[k]; i++; }

        for (k = start; k <= end; k++) input[k] = b[k];

    }
}
