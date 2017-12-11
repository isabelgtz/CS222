public class SelectSort<T extends Comparable<T>> implements ISort<T>
{
  public void sort(T[] in)
  {
    for (int i = 0; i < in.length-1; i++)
    {
      int smallest_index = i;
      for (int j =i+1; j < in.length; j++) // compares values to find smallest
      {
        if (in[j].compareTo(in[smallest_index]) < 0)
        {
          smallest_index = j; // stores smallest value index to be swapped
        }
      }
      T temp = in[smallest_index];
      in[smallest_index] = in[i];
      in[i] = temp;
    }
  }

  public String sortName()
  {
    return "Select Sort";
  }

}
