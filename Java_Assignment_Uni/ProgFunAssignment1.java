// import scanner to take user inputs
import java.util.Scanner;

class ProgFunAssignment1 
{
	//Made a static function so that I don't have to make any object of this class.
	//to take Rows user input and check if input is correct or not 
	static int enterRows(){
		Scanner console = new Scanner(System.in);
		System.out.println("Enter the number of rows");
		int maxRows = console.nextInt();
		if(maxRows > 2 && maxRows <= 10){
			return maxRows;
		}
		else{
			System.out.println("Incorrect input");
			//Recursively called the function to prompt user that wrong input has been entered and Please enter correct input.
			return enterRows();
		}
	}
	//Same explaination as above
	static int enterColumns(){
		Scanner console = new Scanner(System.in);
		System.out.println("Enter the number of columns");
		int maxColumns = console.nextInt();
		if(maxColumns > 2 && maxColumns <=10){
			return maxColumns;
		}
		else{
			System.out.println("Incorrect input");
			return enterColumns();
		}
	}

	public static void main(String[] args) 
	{
		//Calling enterRows function to take user input
		int maxRows = enterRows();
		int maxColumns = enterColumns();

		MyBlock block = new MyBlock(maxRows, maxColumns);

		Scanner sc = new Scanner(System.in);
		//Choice variable ch for the menu
		//Using while loop instead of for loop
		//As we dont want to increment or decrement the variable, it is user's choice
		int ch = 0;
		while(ch != 4){
			System.out.println("Enter your choice");
			System.out.println("1. Add House");
			System.out.println("2. Display block");
			System.out.println("3. Clear block");
			System.out.println("4. Exit");
			ch = sc.nextInt();
			switch (ch) {
				case 1:
					System.out.println("Enter the position");
					int rowPos = sc.nextInt();
					int colPos = sc.nextInt();
					System.out.println("Enter the no. of rows");
					int rows = sc.nextInt();
					System.out.println("Enter the no. of columns");
					int cols = sc.nextInt();
					block.addHouse(rowPos, colPos, rows, cols);
					break;
				case 2:
					block.displayBlock();
					break;
				case 3:
					block.clearBlock();
					break;
				case 4:
					System.exit(0);
				default:
					System.out.println("Wrong Choice");
					break;
			}
		}	
	}
}


// MyBlock class 
class MyBlock 
{	
	private int[][] block;
	private boolean vacant;
	//Declared two variables to keep the intial rows and columns of the matrix
	private int rows_c;
	private int columns_c;
	
	//Initialization step
	public MyBlock(int maxRows, int maxColumns) {
		rows_c = maxRows;
		columns_c = maxColumns;
		block = new int[maxRows][maxColumns];
		for(int i = 0; i < maxRows; i++) {
			for(int j = 0; j < maxColumns; j++) {
				block[i][j] = 0;
			}
		}
		vacant = true;
	}
	// Displays the matrix
	public void displayBlock() {
		for(int i = 0; i < rows_c; i++) {
			for(int j = 0; j < columns_c; j++) {
				System.out.print(block[i][j] + " ");
			}
			System.out.println();
		}
	}
	// Clear out the block i.e. set each value to '0'
	public void clearBlock() {
		for(int i = 0; i < rows_c; i++) {
			for(int j = 0; j < columns_c; j++) {
				block[i][j] = 0;
			}
		}
		vacant = true;
	}

	public void addHouse(int rowPos, int colPos, int rows, int columns) 
	{
		boolean flag_empty = false;
		boolean flag_filled = false;
		if(rowPos > 0 && rowPos < rows_c-1 && colPos > 0 && colPos < columns_c-1){
			if(block[rowPos][colPos] == 0 && (rows+rowPos) < (rows_c) && (columns+colPos) < (columns_c)){
				for(int i = rowPos-1; i <= rows+rowPos; i++){
					for(int j = colPos-1; j <= colPos+columns ; j++){
						if(block[i][j] == 0){
							flag_empty = true;
						}
						else{
							flag_filled = true;
						}
					}
				}
				if(flag_empty == true && flag_filled == false){
					for(int i = rowPos; i <= rows+rowPos-1;i++){
						for(int j = colPos; j <= colPos+columns-1 ; j++){
							block[i][j] = 1;
						}
					}
					vacant = true;
					displayBlock();
				}
				else{
					vacant = false;
					System.out.println("No House added");
				}
			}
			else{
				System.out.println("No house added");
			}
		}
		else{
			System.out.println("No house added");
		}
	}
}