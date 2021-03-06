public class MergeSort
{
    public static int[] MergeSort(int[] array)
    {
        if (array.length == 1)
        {
            return array;
        }
        else
        {
            //Splitting
            int[] front = new int [array.length/2];
            for (int index = 0; index < front.length; index ++)
            {
                front[index] = array[index];
            }
            int[] back = new int [array.length - front.length];
            for (int index = 0; index < back.length; index ++)
            {
                back[index] = array[index + front.length];
            }
            front = MergeSort (front);
            back = MergeSort (back);
            //Merging
            int[] mergedArray = new int [front.length + back.length];
            int frontIndex = 0;
            int backIndex = 0;
            for (int index = 0; index < mergedArray.length; index ++)
            {
                if (frontIndex < front.length && backIndex < back.length)
                {
                    if (front[frontIndex] <= back[backIndex])
                    {
                        mergedArray[index] = front[frontIndex];
                        frontIndex ++;
                    }
                    else 
                    {
                        mergedArray[index] = back[backIndex];
                        backIndex ++;
                    }
                }
                else if (frontIndex == front.length)
                {
                    mergedArray[index] = back[backIndex];
                    backIndex ++;
                }
                else
                {
                    mergedArray[index] = front[frontIndex];
                    frontIndex ++;
                }
            }
            return mergedArray;
        }
    }
}
