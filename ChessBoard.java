import java.util.Arrays;

public class ChessBoard {
	
	public int[][] board;
	private int count;

	public ChessBoard(int N) {
		count = N;
		board = new int[N+1][N+1];
		for(int i=0;i<=N;i++) {
			board[i][0] = i;
			board[0][i] = i;
		}
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				board[i][j] = smallestInt(rowColumnBefore(i,j));
			}
		}
	}

	private int smallestInt(int[] arr) {
		for(int i=0;i<=(count*count);i++) {
			if(!useLoop(arr,i)) {
				return i;
			}
		}
		throw new IllegalArgumentException("There is a problem with the array.");
	}

	private int[] rowColumnBefore(int r, int c) {
		int[] ans = new int[r+c];
		for(int i=0;i<r;i++) {
			ans[i] = board[i][c];
		}
		for(int i=0;i<c;i++) {
			ans[r+i] = board[r][i];
		}
		return ans;
	}

	public int find(int i, int j) {
		return board[i][j];
	}

	public static String arrayToString(int[][] a) {
		String aString;     
    	aString = "";
    	int column;
    	int row;
    	for (row = 0; row < a.length; row++) {
        	for (column = 0; column < a[0].length; column++ ) {
        		aString = aString + " " + a[row][column];
        	}
    		aString = aString + "\n";
    	}
    	aString = aString.replaceAll("(?m)^ ", "");
		return aString;
	}

	public static boolean useLoop(int[] arr, int targetValue) {
		for(int s: arr){
			if(s == targetValue) {
				return true;
			}
		}
	return false;
	}

	public static void main(String[] args) {
		ChessBoard myBoard = new ChessBoard(Integer.parseInt(args[0]));
		System.out.println(myBoard.find(Integer.parseInt(args[1]),Integer.parseInt(args[2])));
	}
}