package parallelalgorithms;

class MergeSort{
    private int[] nums;
    private int[] tempArray;
   public  MergeSort(int []nums){
        this.nums=nums;
        this.tempArray=new int[nums.length];
    }
    public void sort(){
       mergeSort(0,this.nums.length-1);
    }
    private   void mergeSort(int low,int high){
        if(low>=high) return;
        int mid=(low+high)/2;
        mergeSort(low,mid);
        mergeSort(mid+1,high);
        merge(low,mid,high);
    }

    private void merge(int low, int mid, int high) {
       for(int i=0;i<nums.length;i++){
           tempArray[i]=nums[i];
       }
       int i=low;
       int j=mid+1;
       int k=low;
       while(i<=mid && j<=high){
           if(tempArray[i]<=tempArray[j]){
               nums[k]=tempArray[i];
               ++i;
           }
           else{
               nums[k]=tempArray[j];
               ++j;
           }
           ++k;
       }
       while (i<=mid){
           nums[k]=tempArray[i];
           ++i;k++;
       }
       while (j<=high){
           nums[k]=tempArray[j];
           ++j;k++;
       }
    }

    public void showArray(){
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
public class MergeSortApplication {
    public static void main(String[] args) {
        int num=Runtime.getRuntime().availableProcessors();
        System.out.println(num);
        int array[]={5,4,3,2,1,0};
        MergeSort sort=new MergeSort(array);
        sort.sort();
        sort.showArray();
    }
}
