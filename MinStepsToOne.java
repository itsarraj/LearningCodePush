import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinStepsToOne {
	public static int countMinStepsToOne(int n) {
		int [] dp = new int[n+1];
		for( int i = 2 ; i < dp.length ; i++){
			int opt1=Integer.MAX_VALUE;
            int opt2=Integer.MAX_VALUE;
            int opt3=Integer.MAX_VALUE;
			opt1 = dp[i-1];
			if ( i % 2 == 0 ){
				opt2 = dp[i/2];
			}
			if ( i % 3 == 0 )
				opt3 = dp[i/3];
			dp[i] = 1 + Math.min(Math.min(opt1,opt2),opt3);
		}
		return dp[n];
	}
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws NumberFormatException, IOException {
            int n = Integer.parseInt(br.readLine().trim());
            System.out.println(countMinStepsToOne(n));
    }
}
