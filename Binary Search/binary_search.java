import java.util.ArrayList;
import java.util.List;

public class binary_search {
    public static void main(String[] args){
        int[] num1 = {0,2,4,6,8,10,12,14,16,18,20};
        System.out.println(binarySearch(num1, 18));
    }

    /**
     * this is the iterative way of writing this function
     * @param num
     * @param x
     * @return
     */
    public static int binarySearch(int[] num, int x){
        int start = 0; // start = beginning of list
        int end = num.length-1; // end of list

        while(start <= end){ // while we still have elements we haven't checked
            int mid = (start + end)/2; // mid = middle element in the current list

            System.out.println("START\n");
            for(int i = start; i <= end; i++){
                System.out.print(num[i] + " ");
            }
            System.out.println("END\n");

            if (x == num[mid]){ // if x = middle element
                return mid; //element found, return index of x
            } else if (x < num[mid]){ // if x < middle element
                end = mid-1; // go to the left list, move the ending variable
            }
            else if(x > num[mid]){ // if x > middle element
                start = mid+1; // go to the right list, move the starting variable
            }
        }
        return -1; // if element doesn't exist in list
    }

}
