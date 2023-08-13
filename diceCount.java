import java.util.Arrays;

public class diceCount {

    public static int countWays(int n, int m, int sum) {
        
        // Create a table to store the results of subproblems.
        int[][] table = new int[n + 1][sum + 1];
        int count;
        
        // Initialize all entries as 0.
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                table[i][j] = 0;
            }
        }
        
        // Assign first line
        for(int i=1;i<7;i++){
            table[0][i]=1;
        }
        
        // Find value of all dp
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                count=0;
                //last 6 sum
                for(int k=j-6;k<j;k++){
                    if(k>0 && k<sum){
                        count += table[i-1][k];    
                    }
                }
                table[i][j] = count;
            }
        }
        
        for (int i = 0; i < n; i++) {
                for (int j= 1; j <= sum; j++) {
                    System.out.print(table[i][j] + " ");
                }
            System.out.println("");
        }
        return table[n-1][sum];
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 6;
        int sum = 7;
        int ways = countWays(n, m, sum);
        System.out.println("The number of ways to roll a total of " + sum + " with " + n + " dice is " + ways);
    }
}
