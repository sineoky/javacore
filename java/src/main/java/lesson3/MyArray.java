package lesson3;
//обобщения
public class MyArray <T>{
    private T[] nums;

    public MyArray(T... nums) {
        this.nums = nums;
    }


    //печать массива
    public void printMyArray()
    {
        for(int i=0;i<nums.length;i++)
        {
            System.out.print(nums[i]+" ");
        }
    }

    //смена элементов массива
    public void changeMyArray(int index1, int index2)
    {
        T k;
        k=nums[index1];
        nums[index1]=nums[index2];
        nums[index2]=k;
    }

}
