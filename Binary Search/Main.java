/**
* This is the recursive way to write to this code
*/    


public class Main {
    public static void main(String[] args){
        int[] num1 = {0,2,4,6,8,10,12,14,16,18,20};
        System.out.println(binarySearch(num1, 18));
    }

    /**
     * this function calls the main binary search function
     * @param num
     * @param x
     * @return
     */
    public static int binarySearch(int[] num, int x) {
        return binarySearch(num, x, 0, num.length - 1);
    }

    /**
     * this function has the main code for the binary search
     * @param num
     * @param x
     * @param start
     * @param end
     * @return
     */
    public static int binarySearch(int[] num, int x, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (x == num[mid]) {
            return mid;
        } else if (x < num[mid]) {
            return binarySearch(num, x, start, mid - 1);
        } else {
            return binarySearch(num, x, mid + 1, end);
        }
    }
}
