import java.util.ArrayList;
import java.util.List;

public class MatrixOperations {
    public static void main(String[] args) {
        
        // ---------------------------------------------------------
        // 1. INITIALIZATION
        // ---------------------------------------------------------
        // Create the outer list that will hold our rows
        List<List<Integer>> matrix = new ArrayList<>();

        // ---------------------------------------------------------
        // 2. ADDING ELEMENTS
        // ---------------------------------------------------------
        // Add three empty rows (Inner Lists) to the matrix
        matrix.add(new ArrayList<>()); // Row 0
        matrix.add(new ArrayList<>()); // Row 1
        matrix.add(new ArrayList<>()); // Row 2

        // Append values to the end of Row 0
        matrix.get(0).add(10);
        matrix.get(0).add(20);
        matrix.get(0).add(30);

        // Insert a value at a specific index in Row 0 (shifts 20 and 30 to the right)
        matrix.get(0).add(1, 15); 
        
        // Add values to Row 1 and Row 2
        matrix.get(1).add(40); // Row 1 only has one element (jagged array)
        matrix.get(2).add(50);
        matrix.get(2).add(60);

        System.out.println("After Adding: " + matrix);
        // Output: [[10, 15, 20, 30], [40], [50, 60]]

        // ---------------------------------------------------------
        // 3. ACCESSING ELEMENTS (Reading)
        // ---------------------------------------------------------
        // Get the element at Row 0, Column 2
        int targetValue = matrix.get(0).get(2);
        System.out.println("Value at (0,2): " + targetValue); // Output: 20

        // ---------------------------------------------------------
        // 4. UPDATING ELEMENTS (Modifying)
        // ---------------------------------------------------------
        // Replace the value at Row 2, Column 1 (which is 60) with 99
        matrix.get(2).set(1, 99);
        System.out.println("After Updating (2,1): " + matrix);
        // Output: [[10, 15, 20, 30], [40], [50, 99]]

        // ---------------------------------------------------------
        // 5. CHECKING SIZE (Dimensions)
        // ---------------------------------------------------------
        int totalRows = matrix.size();
        int rowZeroLength = matrix.get(0).size();
        System.out.println("Total Rows: " + totalRows);           // Output: 3
        System.out.println("Length of Row 0: " + rowZeroLength);  // Output: 4

        // ---------------------------------------------------------
        // 6. REMOVING ELEMENTS
        // ---------------------------------------------------------
        // A. Remove by Index: Remove the element at index 1 from Row 0 (the number 15)
        matrix.get(0).remove(1); 
        
        // B. Remove by Value: Remove the actual number '30' from Row 0
        // We must use Integer.valueOf() so Java doesn't think 30 is an index number!
        matrix.get(0).remove(Integer.valueOf(30)); 

        // C. Remove an entire row: Remove Row 1
        matrix.remove(1); 

        System.out.println("After Removals: " + matrix);
        // Output: [[10, 20], [50, 99]]

        // ---------------------------------------------------------
        // 7. CLEARING AND CHECKING IF EMPTY
        // ---------------------------------------------------------
        boolean isMatrixEmptyBefore = matrix.isEmpty(); // false
        
        // Wipe out all rows
        matrix.clear(); 
        
        boolean isMatrixEmptyAfter = matrix.isEmpty(); // true
        
        System.out.println("Is empty before clear? " + isMatrixEmptyBefore);
        System.out.println("Is empty after clear? " + isMatrixEmptyAfter);
    }
}