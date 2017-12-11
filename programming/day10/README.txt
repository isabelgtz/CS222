This project directory holds files for sorting algorithm implementations. You should implement your own test code to verify that your sorting algorithm produces correctly sorted output.

When complete, the directory should have MergeSort.java and SelectSort.java. The sort interface takes in an array and, when the sort method returns, the contents of the array will be in sorted order.

SelectSort.java
Selection sort uses two loops to complete the sort. The outer loop selects the index to select for and the inner loop scans for the value to be inserted. Selection sort can be done in place (without allocating new arrays).
Pass 1 - scan indexes 0 through n for the minimum value, swap into index 0
Pass 2 - scan indexes 1 through n for the minimum value, swap into index 1
Pass 3 - scan indexes 2 through n for the minimum value, swap into index 2
...
Pass n - scan indexes n through n for the minimum value, swan into index n-1


MergeSort.java
Merge sort uses recursion to achieve better time complexity than O(n^2). Merge sort can be done in place (without allocating new arrays) but that optimization is not required for this assignment. The sort operates in two major phases. In phase 1, recursion is used to repeatedly split the list in half, until there are n lists of length 1 (trivially sorted). In phase 2, the sorted lists are merged together in sorted order. 


Files:
ISort.java - An interface for sorter implementations
Test.java  - Performance test that times sorting arrays of random values