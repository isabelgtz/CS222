public class MergeSort<T extends Comparable<T>> implements ISort<T >
{
  public void sort(T[] in)
  {
    if (in.length < 1)
    {
      return;
    }
    T[] first_half = (T[]) new Comparable[in.length/2];
    T[] second_half = (T[]) new Comparable[in.length - first_half.length];
    if (in.length >1 )
    {
      for (int i =0; i < first_half.length; i++)
      {
        first_half[i] = in[i];
      }
      for (int i = 0; i < second_half.length; i++)
      {
        second_half[i] = in[first_half.length + i];
      }
      // up to here, the array has been divided into two arrays.
      sort(first_half); // recursive call to keep dividing
      sort(second_half);
      merge(first_half, second_half, in); // method to merge arrays to sort them
    }
  }
  public void merge (T[] first_half, T[] second_half, T[] in)
  {
    int next_first = 0;
    int next_second = 0;
    int k = 0;

    while (next_first< first_half.length && next_second < second_half.length )
    {
      if (first_half[next_first].compareTo(second_half[next_second]) < 0)
      {
        in[k] = first_half[next_first];
        next_first++;
      }
      else
      {
        in[k] = second_half[next_second];
        next_second++;
      }
      k++;
    }
    while (next_first < first_half.length)
    {
      in[k] = first_half[next_first];
      next_first++;
      k++;
    }

    while (next_second< second_half.length)
    {
      in[k] = second_half[next_second];
      next_second++;
      k++;
    }
  }

  public String sortName()
  {
    return "Merge Sort";
  }

}
