public class myTest08 {
    public static int minNumberInRotateArray(int [] array) {
        int low = 0 ; int high = array.length - 1;
        while(low < high){
            int mid = low + (high - low) / 2; 
            if(array[mid] > array[high]){
                low = mid + 1;
            }else if(array[mid] == array[high]){
                high = high - 1;
            }else{
                high = mid;
            } 
        } 
        return array[low];
    }
	public static int minNumberInRotateArray1(int[] array) {
		if (array == null || array.length == 0) 
			throw new RuntimeException("invalid input");
		int firstnode = 0;
		int lastnode = array.length-1;
		int midnode = 0;
		while(array[firstnode] >= array[lastnode]) {
			if (lastnode - firstnode == 1)
				return array[lastnode];
			if (array[midnode] == array[firstnode] && array[midnode] == array[lastnode])
				return mixinarray(array,firstnode,lastnode);
			midnode = firstnode+(lastnode-firstnode)/2;
			if (array[midnode] >  array[firstnode]) 
				firstnode = midnode;
			else if (array[midnode] <array[lastnode])
				lastnode = midnode ;			
				
			}
			return array[midnode];	
		}
	public static int mixinarray(int[]array,int firstnode,int lastnode){
		int result = array[firstnode];
		for(int i=firstnode+1;i<=lastnode ;i++){
			if (array[i] <result)
				result = array[i];
		}
		return result;
	}

	public static void main(String[] args) {
		// 典型输入，单调升序的数组的一个旋转
        int[] array1 = {3, 4, 5, 1, 2};
        System.out.println(minNumberInRotateArray(array1));

        // 有重复数字，并且重复的数字刚好的最小的数字
        int[] array2 = {3, 4, 5, 1, 1, 2};
        System.out.println(minNumberInRotateArray(array2));

        // 有重复数字，但重复的数字不是第一个数字和最后一个数字
        int[] array3 = {3, 4, 5, 1, 2, 2};
        System.out.println(minNumberInRotateArray(array3));

        // 有重复的数字，并且重复的数字刚好是第一个数字和最后一个数字
        int[] array4 = {1, 0, 1, 1, 1};
        System.out.println(minNumberInRotateArray(array4));

        // 单调升序数组，旋转0个元素，也就是单调升序数组本身
        int[] array5 = {1, 2, 3, 4, 5};
        System.out.println(minNumberInRotateArray(array5));

        // 数组中只有一个数字
        int[] array6 = {2};
        System.out.println(minNumberInRotateArray(array6));

        // 数组中数字都相同
        int[] array7 = {1, 1, 1, 1, 1, 1, 1};
        System.out.println(minNumberInRotateArray(array7));

        // 输入NULL
        System.out.println(minNumberInRotateArray(null));
	}
}