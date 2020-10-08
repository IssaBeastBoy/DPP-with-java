import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ForkJoinPool;
package multithread;

/** This class contains a recursive form of the QuickSort algorithm.
  * @author George Wells
  */
public class Sort extends RecursiveAction
  {
    /** Partition a list between given start and end points, returning the partition
      * point.   The value at <CODE>list[start]</CODE> is used as the partition
      * element.  This method is used by the Quick Sort.
      * <BR><I>Precondition:</I> The list contains data that implements
      *    the <CODE>Comparable</CODE> interface.
      * <BR><I>Postcondition:</I> The items in the list before the partition point are
      *    less than or equal to the partition element, and the items in the list after
      *    the partition point are greater than the partition element.
      * @param list The list of items to be partitioned.
      * @param start The index of the first item in the list to be considered.
      * @param end The index of the last item in the list to be considered.
      * @return The index of the partition point.
      */
    @SuppressWarnings("unchecked")
    private static int partition (Comparable[] list, int start, int end)
      { int left = start,
            right = end;
        Comparable tmp;
        while (left < right)
          { // Work from right end first
            while (list[right].compareTo(list[start]) > 0)
              right--;
            // Now work up from start
            while (left < right && list[left].compareTo(list[start]) <= 0)
              left++;
            if (left < right)
              { tmp = list[left];
                list[left] = list[right];
                list[right] = tmp;
              }
          }
        // Exchange the partition element with list[right]
        tmp = list[start];
        list[start] = list[right];
        list[right] = tmp;
        return right;
      } // partition

      @Override
      protected void compute() {
        if(start < end){
          int pivot = partition(list, start, end);
          invokeAll(new Sort(list, start, pivot),
                    new Sort(list, start + 1, end));
        }
      }

    /** Sort a list of items into ascending order using a recursive form of the
      * Quick Sort.
      * <BR><I>Precondition:</I> The list contains data that implements
      *    the <CODE>Comparable</CODE> interface.
      * <BR><I>Postcondition:</I> The list between <CODE>start</CODE> and
      *    <CODE>end</CODE> is in ascending order.
      * @param list The list of items to be sorted.
      * @param start The index of the first item in the list to be considered.
      * @param end The index of the last item in the list to be considered.
      */

    public Sort(Comparable[] list) {
        this.list = list;
        start = 0;
        end = data.length - 1;
      }  

    public Sort (Comparable[] list, int start, int end){
      this.list = list;
      this.start = start;
      this.end = end;
    }

    
  } // class Sort
