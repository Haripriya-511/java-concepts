package parallelalgorithms;


import java.util.Random;

class PMergeSort{
    private int[] nums;
    private int[] tempArray;
    public  PMergeSort(int []nums){
        this.nums=nums;
        this.tempArray=new int[nums.length];
    }
    private Thread createThread(int low,int high,int numOfThreads){
        return new Thread(){
            @Override
            public void run() {
                parallelMergeSort(low,high,numOfThreads/2);

            }
        };


    }

    public void parallelMergeSort(int low, int high, int numOfThreads) {
        if(numOfThreads<=1){
            mergeSort(low,high);
            return;
        }
        int mid=(low+high)/2;
        Thread leftSorted= createThread(low,mid,numOfThreads);
        Thread rightSorted= createThread(mid+1,high,numOfThreads);
        leftSorted.start();
        rightSorted.start();
        try {
            leftSorted.join();
            rightSorted.join();
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
        merge(low,mid,high);


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
public class ParallelMergeSort {
    public static void main(String[] args) {
int numOfThreads= Runtime.getRuntime().availableProcessors();
int array1[]=createArray(100000);
int array2[]=new int[array1.length];
for(int i=0;i<array1.length;i++){
    array2[i]=array1[i];
}
//parallel merge sort
PMergeSort parallelMergeSort=new PMergeSort(array1);
long startTime= System.currentTimeMillis();
parallelMergeSort.parallelMergeSort(0,array1.length-1,numOfThreads);

long endtime=System.currentTimeMillis();
 System.out.printf("Time taken with parralel: %6d ms\n",endtime-startTime);
  //Sequential Merge Sort
     //   Arrays.stream(array2).forEach(System.out::println);
  startTime=System.currentTimeMillis();
  MergeSort seq=new MergeSort(array2);
  seq.sort();
   endtime=System.currentTimeMillis();
//       //Arrays.stream(array2).forEach(System.out::println);
 System.out.printf("Time taken with sequential: %6d ms\n",endtime-startTime);



    }
    private static int[] createArray(int n){
        Random random=new Random();
        int []a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=random.nextInt(n);
        }
        return a;
    }
}
