// import whatever packages are needed here
import java.util.Scanner;
class ProgFunAssignment1 
{
	static int enterRows(){
		Scanner console = new Scanner(System.in);
		System.out.println("Enter the number of rows");
		int maxRows = console.nextInt();
		if(maxRows > 2 && maxRows <=10){
			return maxRows;
		}
		else{
			System.out.println("Incorrect input");
			return enterRows();
		}
	}
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

	static void menu(){
		
	}
	public static void main(String[] args) 
	{    
		// Create a Scanner object for input
		int maxRows = enterRows();
		int maxColumns = enterColumns();
		MyBlock block = new MyBlock(maxRows, maxColumns);

		Scanner sc = new Scanner(System.in);
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

		// Create an object of class MyBlock using the 'new' operator, calling on the MyBlock constructor.
		
		// Build a loop to display the menu, prompt for input and process it as per requirements.        
		// Your program should quit gracefully
	}
}
// MyBlock class 
// It does NOT need to handle any input at all.  
// All the input should occur in the main method
//
// If you find yourself needing to do input here rethink your solution.
class MyBlock 
{	
	private int[][] block;
	private boolean vacant;
	private int rows_c;
	private int columns_c;
	// you may need to add other variables.
	// Constructor...
	// Assumption - rows and columns has been validated beforehand.
	// Initialise the block so that each cell is set to the character '0' 
	// (hint: use one of your methods!).
	// Set the initial value of any other variables
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
	// Display the entrie block as a matrix 
	public void displayBlock() {
		for(int i = 0; i < rows_c; i++) {
			for(int j = 0; j < columns_c; j++) {
				System.out.print(block[i][j] + " ");
			}
			System.out.println();
		}
	}
	// Clear out the block. This involves setting each cell to be '0'
	public void clearBlock() {
		for(int i = 0; i < rows_c; i++) {
			for(int j = 0; j < columns_c; j++) {
				block[i][j] = 0;
			}
		}
		vacant = true;
	}
	// Build a house on the block
	// Ensure none of the other rules are violated
	// Return if any rule is violated
	// An error message should display when an error occurs
	// If all is ok "build" the house on the block 
	// Update relevant variable(s) and call on displayLand().
	public boolean addHouse(int rowPos, int colPos, int rows, int columns) 
	{
		// You may find the code snippt below useful
		boolean flag = false;
		if(rowPos > 0 && rowPos < rows_c-1 && colPos > 0 && colPos < columns_c-1){
			if(block[rowPos][colPos] == 0){
				for(int i = rowPos; i <= rows+rowPos-1; i++){
					for(int j = colPos; j <= colPos+columns-1 ; j++){
						block[i][j] = 1;
					}
				}
				for(int k = 0; k < colPos+columns; k++){
					if(block[rowPos+rows][k] == 0){
						block[rowPos+rows][k] = 2;
					}
				}
				for(int h=0; h < rows+rowPos; h++){
					if(block[h][colPos+columns] == 0){
						block[h][colPos+columns] = 2;
					}
				}
				block[rowPos+rows][colPos+columns] = 2;
				flag = true;
				vacant = false;
				displayBlock();
			}
			else{
				System.out.println("No house added");
				flag = false;
			}
		}
		else{
			System.out.println("No house added");
			flag = false;
		}
		return flag;
	}
}
