import java.util.Arrays;

public class QuickSort3 {
    private int low,high,temp;
    public final void QuickSort(int a[]){
        low=0;
        high=a.length-1;
        //System.out.println(high);
        temp=a[0];
        while(a.length>1){
            System.out.println(a.length);
            while(low<high){
                if(a[high]<=temp){
                    a[low]=a[high];
                    low=low+1;
                    while(a[low]<=temp&&low<high){
                        low=low+1;
                    }
                    if(a[low]>temp&&low<high){
                        a[high]=a[low];
                        high=high-1;
                    }

                }
                else {
                    if(low<high)
                        high=high-1;
                }
            }
            //a[high] = temp;
            //System.out.println(temp);
            if (low>1) {
                //System.out.println(low);
                //System.out.println(high);
                //QuickSort(Arrays.copyOfRange(a, 0, low - 1));
                int b[]=Arrays.copyOfRange(a, 0, low - 1);
                QuickSort(b);
                //System.out.println(Arrays.toString(b));
            }
            if (a.length - high  >=3) {
                //QuickSort(Arrays.copyOfRange(a, high + 1, (a.length - 1)));
                //System.out.println(Arrays.copyOfRange(a, high + 1, (a.length - 1)));
                int b[]=Arrays.copyOfRange(a, high + 1, (a.length - 1));
                QuickSort(b);
            }
        }
    }

}
