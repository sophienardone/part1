package utils;

/**
 *
 * @author michelle
 */
public class DynamicArrayList {

private String [] data;

private static final int capacity = 10;

private int numElements;

public DynamicArrayList(){
this.data = new String[capacity];
this.numElements = 0;
}



    /**
     * A dynamic arraylist constructor that allows the user to supply an initial array of added values
      * @param array takes in a String array to be added to the arraylist
     * @throws IllegalArgumentException if array is equal to null
     */
public DynamicArrayList(String [] array){
    if(array == null){
        throw new IllegalArgumentException("Input array cannot be null");
        }
    this.data = new String[capacity];
    this.numElements=0;
    addAll(array);
    }

    /**
     * method called size that takes no parameters
      * @return the number of elements stored in the array
     */
public int size(){
return numElements;
}


    /**
     * method called get that retrieves the element at the specified position in the list
     * @param position represents the index of the element that's returned
     * @return the element at the specific position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public String get(int position){
    if(position < 0 || position >= numElements) {
        throw new IndexOutOfBoundsException("Invalid position" + position);
    }
        return data[position];
    }


    /**
     * method called indexOf which returns the index of the first occurrence of the specific element
     * @param pos this represents the element to search for
     * @return index of the first occurrence of the specific element or -1 otherwise
     */
    public int indexOf(String pos){

    for(int i=0; i<numElements; i++){
        if ((pos == null && data[i] == null) || (pos != null && pos.equals(data[i]))){
            return i;
        }
    }
        return -1;
}


    /**
     * method called add which adds a new element to the end of the list
     * @param element represents the element to be added
     * @return true if the element is added
     */
    public boolean add(String element){
        //if array is full, grow array before adding
    if(numElements== data.length){
    grow();

    }
    data[numElements] = element;
    numElements++;
return true;
}


    /**
     * Grow method that is implemented in add
     * This increases the capacity of the arraylist by 10
     */
    public void grow(){
    int newSize = data.length + 10;
    String[] newArray = new String[newSize];
    System.arraycopy(data,0,newArray,0,data.length);
    data = newArray;
}


    /**
     * addAll method that adds all the elements in the specified array to the end of the list in specific order
     * @param array an array containing elements to be added to list
     * @throws IllegalArgumentException if the input array is equal to null
     */
    public void addAll(String [] array){
    if(array == null) {
        throw new IllegalArgumentException("Input array cannot be null");
    }
        for(int i=0; i<array.length; i++){
            add(array[i]);
    }
}


    /**
     * removeAll method that removes all occurrences of the specified element from the list
     * @param removedString removes the element if present
     * @return true if the list contains the specific element
     * @throws IllegalArgumentException if String array is equal to null
     */
    public boolean removeAll(String removedString ){
   if(removedString == null){
       throw new IllegalArgumentException(("Removed string cannot be null"));
   }
   boolean remove = false; //keeps track of removed elements
   for(int i=0; i< numElements; i++){
       if(data[i] != null && data[i].equals(removedString)){
           remove = true;

            //loop that moves each element one position to the left starting with the current index
           for(int j=i; j< numElements-1; j++){
               data[j]=data[j+1];
           }

           //last element is set to null as it's a duplicate
           data[numElements-1]=null;
           numElements--; //next element shifts to current index so numElements is decremented
           i--;
       }
   }
   return remove;
}


//Your list should contain a method called clone() that takes no parameters.
// The method should return an independent copy of the current list.

    /**
     * method called clone that creates an independent copy of the DynamicArrayList instance
     * @return a clone of the instance
     */

public DynamicArrayList clone(){
DynamicArrayList clone = new DynamicArrayList();
clone.data = new String[this.numElements];

for(int i=0; i<this.numElements; i++){
clone.data[i] = this.data[i]; //copies each element from data array to clone array
}
clone.numElements = this.numElements; //makes sure clone is the same size as original
return clone;

}




    
}
