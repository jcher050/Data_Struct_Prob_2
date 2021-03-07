package data_struct_prob_2;

/************************************************************** 
Purpose/Description: < implement a recursive search function 
*int terSearch(int A[], int l, int r, int x)
that returns the location of x in a given sorted array of n integers A 
if x is present, otherwise -1.
The terSearch search function, unlike the binary search, 
must consider two dividing points >
Author’s Panther ID: <6135255>
Certification: I hereby certify that this work is my own and none of it is 
the work of any other person.
**************************************************************/

public class Data_Struct_Prob_2 {

  // A function that implements a recursive ternary search through a sorted array of 
  // int by diving the array into three parts and eliminating the parts that 
  // does not hold the value that we are for.
    
    
     // The implementation of the recursive ternary Search terSearch
     // A is an array of int.
     // I is the head of the array or the leftmost index.
     // r is tail of the array or the rightmost index.
     // x is the value we are searching for. 
       
    public static int terSearch(int A[], int I, int r, int x) 
        {
            // Returns index of x if it is present in A[I....r], else 
            // return -1
            
            int d1, d2;
            
           //if head > tail  
            if (I > r) 
              {
                 // We reach here when element is not present in array 
                return -1;
              } 
            // if first is the same as last 
            else if (I == r) 
              {
                // if the head hold a number similar to the integer we are searching for   
                if (A[I] == x) 
                {
                    return I;
                } 
                else 
                {
                    // We reach here when element is not present in array
                    return -1;
                }
              } 
            else 
              {
                // I < r
                // else if head is less than tail
                  
                // partition formulas  
                int div3 = (r - I) / 3;
                
                //d1 = last location in the first partition
                //d2 = last location in the second partition
                d1 = I + div3;
                d2 = d1 + div3;
                
                //if value in d1 == x
                if (A[d1] == x) 
                  {
                    return d1;
                  } 
                // if value in d2 == x
                else if (A[d2] == x) 
                  {
                    return d2;
                  } 
                // if x is less  d1 value 
                else if (x < A[d1]) 
                  {
                      //recursive search the first partition
                    return terSearch(A, I, d1 - 1, x);
                  } 
                // if x value is in between first and second partition
                else if (x > A[d1] && x < A[d2]) 
                  {
                      //recursive search between both partition
                    return terSearch(A, d1 + 1, d2 - 1, x);
                  } 
                //if x value is greater than d2 value 
                else 
                  {
                    // recursive search the values after the second partition
                    return terSearch(A, d2 + 1, r, x);
                  }
              }

        }
        
        //Print function for TerSearch
        public static void Print_func(int lossNum, int Position, int[] Arr) 
        {
            //lossNum is the number that we will be searching for 
            // Position is the location of the search number returned by terSearch 
            // Arr is the actual array that terSearch will search through.
            
            
            int size = Arr.length;
            if (Position == -1) 
              {
                System.out.print("The number " + lossNum + " does not exist in the array ");
                System.out.print("{");
                for (int i = 0; i < size - 1; i++) 
                {
                    System.out.print(Arr[i] + ",");
                }
                System.out.print(Arr[size - 1]);
                System.out.println("}");
              } 
            else 
              {
                System.out.print("The number " + lossNum + " exist at position " + Position + " in Array ");
                System.out.print("{");
                for (int i = 0; i < size - 1; i++) 
                {
                    System.out.print(Arr[i] + ",");
                }
                System.out.print(Arr[size - 1]);
                System.out.println("}");
              }
        }
        
        
        // Driver method to test above functions
    public static void main(String[] args) {
        
            // Some Sample test cases for terSearch
            int a[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
            int b[] = new int[]{1, 9};
            int c[] = new int[]{19};
            int d[] = new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

            
            
            
            // Search for a few numbers in the above test cases
            Print_func(1, terSearch(a, 0, 14, 1), a);
            Print_func(14, terSearch(a, 0, 14, 14), a);
            System.out.println();
            Print_func(1, terSearch(b, 0, 1, 1), b);
            Print_func(-1, terSearch(b, 0, 1, -1), b);
            System.out.println();
            Print_func(1, terSearch(c, 0, 0, 1), c);
            Print_func(19, terSearch(c, 0, 0, 19), c);
            System.out.println();
            Print_func(8, terSearch(d, 0, 9, 8), d);
            Print_func(1, terSearch(d, 0, 9, 1), d);
            System.out.println();
        
    }
    
}
