class NumArray {
    int[] nums;
    int[] prefixSum;

    public NumArray(int[] nums) {
        this.nums=nums;
        prefixSum=new int[nums.length];
        prefixSum[0]=nums[0];
        calc(1);
    }

    public void calc(int i){
        for(;i<nums.length;i++){
            prefixSum[i]=prefixSum[i-1]+nums[i];
        }
    }

    public void update(int index, int val) {
        nums[index]=val;
        if(index==0){
            prefixSum[0]=val;
            calc(1);
        } else calc(index);
    }

    public int sumRange(int left, int right) {
        if(left!=0) return prefixSum[right]-prefixSum[left-1];
        return prefixSum[right];
    }

    public void print(){
        for(int i=0;i<nums.length;i++){
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) {
        int[] n={-1};
        NumArray o=new NumArray(n);
        o.print();
        System.out.println(o.sumRange(0,0));
        //o.update(0,1);
       // o.print();
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */