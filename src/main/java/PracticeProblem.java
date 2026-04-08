public class PracticeProblem {

	public static void main(String args[]) {

	}

	public static int searchMazeMoves(String[][] arr){
		int startRow = arr.length-1;
		int startCol = 0;

		return sMMHelper(arr, startRow, startCol, 0);
	}

	public static int sMMHelper(String[][] arr, int row, int col, int moves){

		if((row < 0) || (col >= arr.length) || (arr[row][col].equals("*"))){
			return -1;
		}

		if(arr[row][col].equals("F")){
			return moves;
		}

		int rMove = sMMHelper(arr, row, col + 1, moves + 1);
		int uMove = sMMHelper(arr, row - 1, col, moves + 1);

		if(rMove == -1 || uMove == -1){
			return Math.max(rMove,uMove);
		} else {
			return Math.min(rMove,uMove);
		}
	}

	public static int noOfPaths(String[][] arr){
		int startRow = arr.length-1;
		int startCol = 0;

		return nOPHelper(arr, startRow, startCol);
	}

	public static int nOPHelper(String[][] arr, int row, int col){

		if((row < 0) || (col >= arr.length) || (arr[row][col].equals("*"))){
			return 0;
		}

		if(arr[row][col].equals("F")){
			return 1;
		}

		int rMove = nOPHelper(arr, row, col + 1);
		int uMove = nOPHelper(arr, row - 1, col);

		return rMove+uMove;
	}




	
}
