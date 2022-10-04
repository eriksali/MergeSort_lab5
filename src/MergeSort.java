/**
 * 
 * https://www.geeksforgeeks.org/in-place-algorithm/
 */

import java.util.Random;
import java.util.Arrays;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors


public class MergeSort {
    public static void main(String [] args){
        Random g = new Random();
        int [] number = new int [10];
        FileWriter myWriter;
        System.out.println();


        try {
            myWriter = new FileWriter("random-integers.txt");    

            for (int d = 0 ; d<number.length ; d++){
                number[d] = g.nextInt(100)+1;

                try {
                    //myWriter.write("\r\n");
                    myWriter.write(new Integer(number[d]).toString());  
                    myWriter.write("\r\n");
                    System.out.println(number[d]);

                } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                }
            }
            
            myWriter.close();

        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        System.out.print("\nunsorted Numbers:" + Arrays.toString(number));
        //System.out.print("\nSorted Numbers:  " + Arrays.toString(mergeSort(number,number.length));
        
        mergeSort(number,number.length);

        System.out.print("\nSorted Numbers:  [");
        for(int i = 0; i < number.length; ++i){
            if(i < number.length - 1)
                System.out.print(number[i]+ ", ");
            else
                System.out.print(number[i]);
        }

        System.out.print("]\n");

    }



    public static void merge(int[] left_arr,int[] right_arr, int[] arr,int left_size, int right_size){
        
        int i=0,l=0,r = 0;
        //The while loops check the conditions for merging
        while(l<left_size && r<right_size){
            
            if(left_arr[l]<right_arr[r]){
                arr[i++] = left_arr[l++];
            }
            else{
                arr[i++] = right_arr[r++];
            }
        }
        while(l<left_size){
            arr[i++] = left_arr[l++];
        }
        while(r<right_size){
          arr[i++] = right_arr[r++];
        }
    }
  
    public static void mergeSort(int [] arr, int len){
        if (len < 2){return;}
        
        int mid = len / 2;
        int [] left_arr = new int[mid];
        int [] right_arr = new int[len-mid];
        
      //Dividing array into two and copying into two separate arrays
        int k = 0;
        for(int i = 0;i<len;++i){
            if(i<mid){
                left_arr[i] = arr[i];
            }
            else{
                right_arr[k] = arr[i];
                k = k+1;
            }
        }
      // Recursively calling the function to divide the subarrays further
        mergeSort(left_arr,mid);
        mergeSort(right_arr,len-mid);
      // Calling the merge method on each subdivision
        merge(left_arr,right_arr,arr,mid,len-mid);
    }
 
    /** 
     * 
     *     public static void main( String args[] ) {
          int [] array = {12,1,10,50,5,15,45};
          mergeSort(array,array.length);
          for(int i =0; i< array.length;++i){
              System.out.print(array[i]+ " ");
          }
      }
    */

  }