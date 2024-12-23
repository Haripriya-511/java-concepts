package parallelalgorithms;

public class SequentialSumProblem {
    //linear time o(n)
    public int sum(int[] nums){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        int [] nums={1,2,3,4,5};
        SequentialSumProblem sumProblem=new SequentialSumProblem();
        System.out.println(sumProblem.sum(nums));

    }
}
