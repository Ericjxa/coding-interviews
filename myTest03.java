include java.io.PrintWriter
public class myTest03 {
	public static boolean find(int[][] metrix,int target) {
		if (metrix == null || metrix.length < 1 || metrix[0].length<1) {
			return false;
		}
		int len = metrix.length-1;
		int i = 0;
		while (len>=0 && i <metrix[0].length) {
			if (target < metrix[len][i]) {
				len--;
			}else if (target > metrix[len][i]){
				i++;
			}else {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[][] metrix = {
				{1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
		};
		System.out.println(find(metrix,7));
		System.out.println(find(metrix,15));
		System.out.println(find(metrix,3));
		System.out.println(find(metrix,0));
		System.out.println(find(null,0));
	}
}