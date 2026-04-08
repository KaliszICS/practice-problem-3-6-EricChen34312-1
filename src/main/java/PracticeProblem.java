public class PracticeProblem {

	public static void main(String args[]) {

	}

	public static int searchMazeMoves(String[][] arr){
		//set start index
		int startRow = arr.length-1;
		int startCol = 0;

		return sMMHelper(arr, startRow, startCol, 0);
	}

	public static int sMMHelper(String[][] arr, int row, int col, int moves){
		//if index is out of bounds or in a wall, return -1
		if((row < 0) || (col >= arr.length) || (arr[row][col].equals("*"))){
			return -1;
		}

		//if the index is at F, return the moves it took 
		if(arr[row][col].equals("F")){
			return moves;
		}

		//recursively call 1 move right and up
		int rMove = sMMHelper(arr, row, col + 1, moves + 1);
		int uMove = sMMHelper(arr, row - 1, col, moves + 1);

		//if one move is valid, return the max value, if both are valid, return the min value, if both are invalid, return -1
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
		//return 0 (no path) if at wall or out of bounds
		if((row < 0) || (col >= arr.length) || (arr[row][col].equals("*"))){
			return 0;
		}
		//return 1 (one path) if at finish
		if(arr[row][col].equals("F")){
			return 1;
		}

		//recursively call a move right and up
		int rMove = nOPHelper(arr, row, col + 1);
		int uMove = nOPHelper(arr, row - 1, col);

		//return the sum of the moves, will accumulate for every path found
		return rMove+uMove;
	}




	
}
