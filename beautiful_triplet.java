import java.util.*;

public class beautiful_triplet {
    public static void main(String[] args) {
        int[] arr={2,2,3,4,5};
        int d=1;
        for(int i=0;i<arr.length;i++){
            int temp=arr[i];
            indexholder obj=new indexholder();
            indexadder(arr, true, i+1, temp,d, obj);
            if(obj.second_start!=-1&&obj.third_start!=-1){
                while(i<arr.length && arr[i]==temp){
                    for(int j=obj.second_start;j<=obj.second_end;j++)
                        for(int k=obj.third_start;k<=obj.third_end;k++)
                            System.out.println(i+" "+j+" "+k);
                    i++;
                }
                i--;
            }
        }
    }

    public static void indexadder(int[] arr,boolean second,int indexstart,int target,int d,indexholder obj){
        if(second){
            obj.second_start=binaryindexfinder(arr, indexstart, target+d, true);
            if(obj.second_start!=-1){
            obj.second_end=binaryindexfinder(arr, indexstart, target+d, false);
            indexadder(arr, false, obj.second_end+1, target, 2*d, obj);
            }  
        }
        else{
            obj.third_start=binaryindexfinder(arr, obj.second_end, target+d,true);
            if(obj.third_start!=-1){
                obj.third_end=binaryindexfinder(arr, obj.second_end, target+d, false);
            }
        }
        return;
    }

    public static int binaryindexfinder(int[] arr,int index,int target,boolean start){
        int s=index;
        int e=arr.length-1;
        int ans=-1;
        
        while(s<=e){
            int mid=s+(e-s)/2;
            if(arr[mid]<target){
                s=mid+1;
            }
            else if(arr[mid]>target){
                e=mid-1;
            }
            else{
                ans=mid;
                if(start){
                    e=mid-1;
                }
                else{
                    s=mid+1;
                }
            }
        }

        return ans;
    }

}



class indexholder{
    int second_start=-1;
    int second_end=-1;
    int third_start=-1;
    int third_end=-1;
}