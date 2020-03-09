// import whatever packages are needed here
import java.util.Scanner;
class ProgFunAssignment1 
{
	public static void main(String[] args) 
	{    
		// Create a Scanner object for input
		Scanner console = new Scanner(System.in);
		int maxRows = console.nextInt();
		int maxColumns = console.nextInt();
		if(maxRows > 2 && maxRows <= 10) {
			if(maxColumns > 2 && maxColumns <= 10) {
				MyBlock block = new MyBlock(maxRows,  maxColumns);
			}
		}
		else {
			
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
	private int rows;
	private int columns;
	// you may need to add other variables.
	// Constructor...
	// Assumption - rows and columns has been validated beforehand.
	// Initialise the block so that each cell is set to the character '0' 
	// (hint: use one of your methods!).
	// Set the initial value of any other variables
	public MyBlock(int maxRows, int maxColumns) {
		rows = maxRows;
		columns = maxColumns;
		for(int i = 0; i < maxRows; i++) {
			for(int j = 0; j < maxColumns; j++) {
				block[i][j] = 0;
			}
		}
		vacant = true;
	}
	// Display the entrie block as a matrix 
	public void displayBlock() {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				System.out.print(block[i][j] + " ");
			}
			System.out.println();
		}
	}
	// Clear out the block. This involves setting each cell to be '0'
	public void clearBlock() {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
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
		if (true)
			return true;
		else
			return false;
	}
}
