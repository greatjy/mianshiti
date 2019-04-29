import java.util.*;

public class GuoHe {
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    int n = scanner.nextInt();
	    for (int i = 0; i < n; i++) {
	        int tmp = scanner.nextInt();
	        int[] a = new int[tmp];
	        for (int j = 0; j < tmp; j++) {
	            a[j] = scanner.nextInt();
	        }
	        Arrays.sort(a);
	        minTime(a);
	    }
	}

	private static void minTime(int[] a) {
	    int sum = 0;
	    int num = a.length;
	    if(num == 3){
	        sum = a[2];
	    }
	    else if(num == 2){
	        sum = a[1];
	    }
	    else {
	        num--;
	        while (num > 1) {
	            int tmp1 = Math.max(a[num], a[num - 1]);
	            int max = Math.max(a[num - 2], tmp1);
	            int tmp2 = Math.min(a[num], a[num - 1]);
	            int min = Math.min(a[num - 2], tmp2);
	            if (num == 2) sum += max;
	            else sum += max + min;
	            num -= 2;
	        }
	        if (num == 1) sum += a[1];
	    }
	    System.out.println(sum);
	}
}