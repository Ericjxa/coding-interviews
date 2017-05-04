import java.io.*;
class Solution1 {
    public boolean Find(int [][] array,int target) {
int len = array.length-1;
System.out.println(len);
System.out.println(array[0].length);
        int i = 0;
        while((len >= 0)&& (i < array[0].length)){
            if(array[len][i] > target){
                len--;
            }else if(array[len][i] < target){
                i++;
            }else{
                return true;
            }
        }
        return false;
    }
}
class test  
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    int [][] array1={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
	    int target=5;
	    Solution1 solution = new Solution1();
	    boolean result = solution.Find(array1,target);
		System.out.println(result + " hehe");
	}
}
