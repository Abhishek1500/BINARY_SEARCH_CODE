import java.util.*;
public class bookallocation{
    public static void main(String[] arg){
         int [] arr={5,17,100,11};
         int min=Integer.MAX_VALUE;
         int sum=0;
         for(int a:arr){
            min=Math.min(min,a);
            sum+=a;            
         }

         System.out.println(bookallocationvalue(arr,sum,min,4));

    }

    public static boolean ifvalid(int[] arr,int m, int mid){
        int sum=0;
        int count=1;
        for(int a:arr){
            if(sum+a>mid){
                sum=a;
                count++;
                if(count>m||sum>mid)
                return false;
            }
            else{
                sum+=a;
            }
        }
        return true;
    }

    public static int bookallocationvalue(int []arr, int max , int min,int m){
        int ans=-1;
        int s=min;
        int e=max;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(ifvalid(arr,m,mid)){
                ans=mid;
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return ans;
    }


}