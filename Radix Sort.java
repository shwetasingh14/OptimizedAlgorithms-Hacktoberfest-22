public class RadixSort {
	
	public static void main(String[] args){
		
		int[] a = {1, 19, 15, 18, 20, 9, 14, 7, 5, 24, 1, 13, 16, 12, 5};
		
		straight_radix(a);
		for (int e : a)
			System.out.print(e+"  ");
	}
	
	public static void radix_exchange(int a[], int l, int r, int b) {
		
		 int t, i, j;
		 
		 if ((r > l) && (b >= 0)) {
		
			 i = l;
			 j = r;
			 while (j != i) {
				while ((((bits(a[i],b,1)) == 0) && (i < j))) i++;
				while ((((bits(a[j],b,1)) != 0) && (i < j))) j--;

				t=a[i];
				a[i]=a[j];
				a[j]=t;
			 }
			 if (bits(a[r],b,1) == 0)
			   j++;

			 radix_exchange(a, l, j - 1, b - 1);
			 radix_exchange(a, j ,r ,b - 1);
		 }
	}
	
	public static void distribution_count(int[] a){
		
		int N = a.length;
		
		int[] t = new int[N];
		
		int max = a[0];
		
		int min = a[0];
		
		for(int e : a){
			if (e < min)  min = e;
			if (e > max)  max = e;
		}
				
		int range = max - min + 1;
		
		int[] count = new int[range];

		//update frequency
		for (int i=0; i<N; i++)
			count[a[i]-min]++;

		//get last indices
		count[0]--;
		for (int j=1; j<range; j++)
			count[j] += count[j-1];

		//fill in values
		for (int i=N-1; i>=0; i--){
			t[count[a[i]-min]] = a[i];
			count[a[i]-min]--;
		}

		//copy back results
		for (int i=0; i<N; i++){
			a[i] = t[i];
		}
	}

	
	public static void straight_radix(int[] a) {

		final int w = 5, m = 1, M = (int) Math.pow(2, m);
    	int i,j,pass;
    	int N = a.length;
    	int[] b = new int[N];
        int[] count = new int[M];
    	    	
        for (pass = 0; pass < w/m; pass++) {
        	
            for (j = 0; j < M; j++) 
            	count[j] = 0;
            
            for (i = 0; i < N; i++){
            	int c = bits(a[i], pass*m, m);
                count[c]++;
            }
            
            for (j = 1; j < M; j++)
                count[j] += count[j-1];
            
            for (i = N-1; i >= 0; i--){
            	int c = bits(a[i], pass*m, m);
                b[--count[c]] = a[i];
            }
            
            for (i = 0; i < N; i++) 
            	a[i] = b[i];
        }
	}
	
	public static int bits(int x, int k, int j)  { 

		return ( x/ (int) Math.pow(2, k) ) % (int) Math.pow(2, j);
		
	} 
	
}
