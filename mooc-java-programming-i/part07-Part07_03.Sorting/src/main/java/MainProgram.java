
public class MainProgram {

    public static void main(String[] args) {
        // write your test code here
        int[] array = {3, 1, 5, 99, 3, 12};
        MainProgram.sort(array);
    }

    public static int smallest(int[] array){
        int result = array[0];
        
        for(int i=1; i<array.length; i++){
            if(array[i] < result) result = array[i];
        }
        
        return result;
    }
    
    public static int indexOfSmallest(int[] array){
        int index = 0;
        
        for(int i=1; i<array.length; i++){
            if(array[i] < array[index]){
                index = i;
            }
        }
        
        return index;
    }
    
    public static int indexOfSmallestFrom(int[] table, int startIndex){
        int index = startIndex;
        
        for(int i=startIndex+1; i<table.length; i++){
            if(table[i] < table[index]){
                index = i;
            }
        }
        
        return index;
    }
    
    public static void swap(int[] array, int index1, int index2){
        int tempIndex1 = array[index1];
        array[index1] = array[index2];
        array[index2] = tempIndex1;
    }
    
    public static void sort(int[] array){
        System.out.println(array);
        for(int i=0; i<array.length; i++){
            int currMinIndex = MainProgram.indexOfSmallestFrom(array, i);
            MainProgram.swap(array, i, currMinIndex);
            
            System.out.println(array);
        }
    }
}
