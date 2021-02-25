import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        // write your code here
        int a[]={3,2,7,2,6,5,4,11,11,16};
        System.out.println(a.length);
        if(a.length<=1) {
            System.out.println("请输入符合要求的数组，数组元素个数需大于2");
        }
        else {
            QuickSort3 quickSort3=new QuickSort3();
            quickSort3.QuickSort(a);
            System.out.println(Arrays.toString(a));

        }
    }
}
