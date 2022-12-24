import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class minSquares {

	public static int minCountHelper(int n , int [] dp) {
		if ( n == 0 ){
			return 0 ;
		}
		int minAns = Integer.MAX_VALUE;
		for(int i=1; i*i <= n;i++) {
			int currAns;
			if(dp[n-(i*i)] == -1){
				currAns = minCountHelper(n-(i*i),dp);
				dp[n-(i*i)] = currAns;
			} else {
				currAns = dp[n-(i*i)];
			}
			if(minAns > currAns) {
				minAns = currAns;
			}
		}
		int myAns = 1 + minAns;
		return myAns;
	}

	public static int minCount(int n) {
		int [] dp = new int [n+1];
		for(int i=0;i<dp.length;i++) {
			dp[i] = -1;
		}
		return minCountHelper( n , dp );
	}


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
            int n = Integer.parseInt(br.readLine().trim());
            System.out.println(minCount(n));
    }
}
