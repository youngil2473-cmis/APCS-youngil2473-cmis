public class Tester
{
    public static void main(String[] args){
        ArrayType at = ArrayType.RANDOM; //SORTED, RANDOM, or REVERSED
        int n = 10;
        // 286, 28948, 
        int[] array = Util.getArray(n, at);
        int[] tmp = new int[array.length];
        for(int i = 0; i < array.length; i++){
            tmp[i] = array[i];
        }
        long start, stop, btime, itime, stime, mtime;
        
        start = System.nanoTime();
        BubbleSort.sort(array);
        btime = System.nanoTime() - start;
        
        for(int i = 0; i < array.length; i++){
            array[i] = tmp[i];
        }
        start = System.nanoTime();
        SelectionSort.sort(array);
        stime = System.nanoTime() - start;
        
        for(int i = 0; i < array.length; i++){
            array[i] = tmp[i];
        }
        start = System.nanoTime();
        InsertionSort.sort(array);
        itime = System.nanoTime() - start;
      
        for(int i = 0; i < array.length; i++){
            array[i] = tmp[i];
        }
        start = System.nanoTime();
        MergeSort.sort(array);
        mtime = System.nanoTime() - start;
        
        System.out.format(
        "BubbleSort: %d\n"+
        "SelectionSort: %d\n"+
        "InsertionSort: %d\n"+
        "MergeSort: %d\n", 
         BubbleSort.steps, SelectionSort.steps, InsertionSort.steps, MergeSort.steps);
    }
}
