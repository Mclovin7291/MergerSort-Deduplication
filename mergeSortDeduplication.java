public class mergeSortDeduplication {
    public static void main(String[] args) {
        int[ ] array ={50, 11, 33, 21, 40, 50, 40, 40, 21};// initialize the array
        int start = 0; // start of the array
        int end = array.length;// end of the array
        if (end == 0){// if the length of array is empty, print empty.
            System.out.println("The array is empty.");
        }
        else if(end==1){ // if there is only one element in the array, print that one element.
            printArray(array, end);;
        }

        else{
            mergeSort(array, start, end-1);
            int n = deDuplication(array, end);
            printArray(array,n); //prints the new array.
        }
    }

    public static void mergeSort(int[ ]arr, int s, int e ){// the first part of the merge sort function
        if(s<e){
            int mid= (s+e)/2;// finds the midpoint with given start and end point

            mergeSort(arr, s, mid); // recursivly run the method with new parameters as mid being the new end
            mergeSort(arr, mid+1, e);// recursivly run the method with new parameters as mid+1 being the new start(everything after mid).
            merge(arr, s,mid,e);// after they are divided into single sub-arrays, start to merge them.

        }
    }

    public static void merge(int []a, int start,int  mid, int end ){
        int s= start;//temperary variable
        int m= mid+1;//temperary variable
        int[] array= new int[end-start+1];// new array
        int j= 0;//temperary variable

        for (int i= start; i <= end;i++){           
            if(s > mid){
                array[ j++] = a[m++];//sees if the first half is done 
            }

            else if(m > end){
                array[j++] = a[s++];//sees if the second half is done
            }
            
            else if ( a[s] < a[m]){//if the element on the left is less than element on the right, set  the element on the left to the next element of the new array.
                array[j++]= a[s++];
            }
            else {
                array[j++]= a[m++]; //if not set the element on the right to the next element of the new array.
            }   

        }
        for(int k= 0; k<j; k++){
            a[start++] = array[ k ];// copys everything from the new array to the old one.
        }
    }   
    public static int deDuplication(int arr[], int n){ // sets the dupilicate elements to the end of the array and sets the index to be before those elements.

        if (n == 1 || n== 0){ // if the array length is 1 or zero, then there should not be any duplicates. return that array
            return n;
        }
        int j =0;// a temperary variable to swap elements.
    
        for (int i = 0; i < n - 1; i++) {//loop that goes through every element.
    
            if (arr[i] != arr[i + 1]) {// if the current element is not the same as the next element, set next increment of j in the array to the current index of i. 
                arr[j++] = arr[i];
            }
        }
     
        arr[j++] = arr[n - 1];
    
    
        return j;// the index for the duplicate variables.
    
    }
    public static void printArray(int []a, int n){//prints the array with index returned from the deduplicate.

        for(int i = 0; i <= n-1;i++){

            System.out.print(a[i] +" ");
        }    
    }
}      


/*  if the array size is 1, the it just prints that array. 
list={2}
if(high ==1){
            printArray(list, high);

Output: 2
 } */


/*if the array size is 0(null) it will print out that the array is empty.
list={}
 * if (high == 0){
            System.out.println("The array is empty.");

Output:The array is empty.
 }
 */