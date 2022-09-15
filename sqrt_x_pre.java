import java.util.Scanner;

public class sqrt_x_pre{
    public static void main(String arg[]){
        int simpleint=closestsqareroot(45);
        double ans=doubleprecise(simpleint,3,45);
        System.out.println(ans);     
    }

    public static double doubleprecise(int a,int n, int x){
        double factor=1;
        double ans=a;
        for(int i=0;i<n;i++){
            factor/=10;
            for(double j=ans;j*j<x;j+=factor){
                ans=j;
            }
        }
        return ans;
    }


    public static int closestsqareroot(int x){
        int start=0;
        int end=x;
        while(start!=end-1){
            int mid=start+(end-start)/2;
            if(mid*mid==x){
                return mid;
            }
            else if(mid*mid<x){
                start=mid;
            }
            else{
                end=mid;
            }
        }
        return start;
    } 

}