import java.util.*;
public class paratsopj {
    public static void main(String[] args) {
        int[] a={1};
        Arrays.sort(a);
        int p=8;
        int max=p*(16+(p-1)*8)/2;
        int min=0;
        int ans=-1;
        while(min<=max){
            int mid=min+(max-min)/2;
            if(nopatamade(a,mid,p)){
                ans=mid;
                max=mid-1;
            }
            else{
                min=mid+1;
            }
        }
        System.out.println(ans);
    }

    public static int countpratamadeintime(int a,int mid){
        int n=1;
        while(n*(2*a+(n-1)*a)/2<=mid){
            n++;
        }
        return --n;
    }

    public static boolean nopatamade(int[] arr,int mid,int p){
        int sum=0;
        for(int a:arr){
            sum+=countpratamadeintime(a,mid);
            if(sum>=p)
            return true;
        }
        return false;
    }
}