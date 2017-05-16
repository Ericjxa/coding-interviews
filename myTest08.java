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
		// �������룬��������������һ����ת
        int[] array1 = {3, 4, 5, 1, 2};
        System.out.println(minNumberInRotateArray(array1));

        // ���ظ����֣������ظ������ָպõ���С������
        int[] array2 = {3, 4, 5, 1, 1, 2};
        System.out.println(minNumberInRotateArray(array2));

        // ���ظ����֣����ظ������ֲ��ǵ�һ�����ֺ����һ������
        int[] array3 = {3, 4, 5, 1, 2, 2};
        System.out.println(minNumberInRotateArray(array3));

        // ���ظ������֣������ظ������ָպ��ǵ�һ�����ֺ����һ������
        int[] array4 = {1, 0, 1, 1, 1};
        System.out.println(minNumberInRotateArray(array4));

        // �����������飬��ת0��Ԫ�أ�Ҳ���ǵ����������鱾��
        int[] array5 = {1, 2, 3, 4, 5};
        System.out.println(minNumberInRotateArray(array5));

        // ������ֻ��һ������
        int[] array6 = {2};
        System.out.println(minNumberInRotateArray(array6));

        // ���������ֶ���ͬ
        int[] array7 = {1, 1, 1, 1, 1, 1, 1};
        System.out.println(minNumberInRotateArray(array7));

        // ����NULL
        System.out.println(minNumberInRotateArray(null));
	}
}