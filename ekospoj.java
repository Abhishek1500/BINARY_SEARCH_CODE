import java.util.*;
public class ekospoj {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];

        int requiredtree=sc.nextInt();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
            max=Math.max(max,arr[i]);
        }


        int start=0;
        int end=max;
        
        while(start<=end){
            int mid=start+(end-start)/2;
            if(sumcutmid(arr, mid)>requiredtree){
                start=mid+1;
            }
            else if(sumcutmid(arr, mid)<requiredtree){
                end=mid-1;
            }
            else{
                System.out.println(mid);
                break;
            }
        }
   
    }

    public static int sumcutmid(int[] arr,int mid){
        int sum=0;
        for(int a:arr){
            if((a-mid)>0)
            sum+=a-mid;
        }
        return sum;
    }
}
