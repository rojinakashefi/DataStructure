# Sorting algorithm

There all different kind of sorting algorithms here we discuss these :

1. Selection Sort

2. Bubble Sort

3. Insertion Sort

4. Shell Sort

5. Merge Sort

6. Quick Sort

   ------

   ## Selection sort

In selection sort we sort an array by finding the minimum element by comparing i'th element of array to n-i elements.

If they are in a sorted form we continue comparing till we reached end of list and continue comparing i+1 element to n-(i+1) element.

if there were not  in sorted form we swap the value and start to compare the i'th element with new value to others till we reach end of list and now array has became two parts.

1)The subarray which is already sorted.

2)Remaining subarray which is unsorted.

#### Complexity of selection sort

For each element the entire list is compared to others to find the smallest element.So in the worst case "N" elements are checked for every selected element:

Comparisions: n+n-1+n-2+....+1=O(n²)

Swaps=O(n)

So it takes ***O(n²)+O(n)=O(n²)*** time.

- It is ***not a stable sort***(Entites which are equal might be re-arranged).

- It doesn't need any extra space and ***it sorts in place.***

  

  #### Usage of selection Sort

  Selection sort is one of the slowest algorithms and can fall behind bubble sort. But slow doesn’t always mean its bad in all potential cases, often being the last to finish sorting for large arrays. However, it does work very well on small lists.

  -  Selection sort can be good at checking if everything is already sorted.

  -  It is also good to use when memory space is limited. This is because unlike  other sorting algorithms, selection sort doesn’t go around swapping things   until the very end, resulting in less temporary storage space used.
  - Sorting algorithms is often one of the things that have a high chance of cropping up in technical tests.

------

## Bubble Sort

In bubble sort for each iteration, every elements is compared with its neighbor and swapped if they are not in order.

The result of biggest elements bubbles to the last o list.

At the end of the first iteration,the biggest element is in the left position and so on.

#### Complexity of bubble sort

In the worst case(if the list is originally sorted in reverse order),N elements are checked and swapped for every selected element to get to correct position.Checking "N" elements for "N" selected elements so it makes O(n²) comparisons and O(n²) swaps

**Worst and Average Case Time Complexity:** O(n*n). Worst case occurs when array is reverse sorted.

**Best Case Time Complexity:** O(n). Best case occurs when array is already sorted.

- It is a ***stable sort***

- It takes O(1) Extra Space, ***It sorts in place.***

  

  #### Usage of bubble sort

  - Bubble sort is one of the simplest sorting algorithms to understand and implement.
  - In computer graphics bubble sort is popular for its capability to detect a very small error (like swap of just two elements) in almost-sorted arrays and fix it with just linear complexity (2*n*). For example, it is used in a polygon filling algorithm, where bounding lines are sorted by their *x* coordinate at a specific scan line (a line parallel to the *x* axis) and with incrementing *y* their order changes (two elements are swapped) only at intersections of two lines.

  - Bubble sort interacts poorly with modern CPU hardware. It produces at least twice as many writes as insertion sort, twice as many cache misses.

  - Sorting strings in java show bubble sort to be roughly one-fifth as fast as an insertion sort and 70% as fast as a selection sort.

------

## Insertion Sort

Insertion sort is an iterative algorithm,In this sorting algorithm we have two sublistes,the sorted sublist and unchecked sublist.

**The sorted sublist with one element is always sorted**,So we assume the first element of our array is sorted,then we check the next element of our array to the last element of sorted list,if they are in sorted form we insert the new element to the sorted sublist and increase it size.but if they weren't in sorted form we should check the new element to all of sorted sublist elements to find its right position of new element and insert it in sorted sublist.This will be continues till the entire list is sorted.By inserting into a sorted sub-list at every step the sub-list soon grows to be the entire list.

In the worst case "N" elements are checked and swapped for every selected element to get to the right position.

#### Complexity of insertion sort

- Worst-case performance of insertion sort is O(n²) comparisons and swaps.

- Best-case performance is O(n) comparisons and O(1) swaps.

- Average-case performance is O(n²) comparisons and swaps.

- It is a stable sort.

- It sorts in place and it takes O(1) extra space.

  #### Insertion sort vs Bubble sort

  1. Bubble sort requires an additional pass over all elements to ensure that the list is fully sorted.
  2. Bubble sort has to do N comparisons at every step.Insertion sort can stop comparison elements when the right position in the sorted list is found.
  3. Bubble sort performs poorly with modern hardware because of the number of writes and swaps that is performs.Results in cache misses so has greated overhead than insertion sort.

  ------

  ## Shell Sort
  
  shell sort partions the original list into sub-lists where a sub-list is made of elements seperated by an increment.Each sub-list is then sorted using insertion sort.The incremenet is slowly reduced till its 1,at this point it's basically insertion sort of a nearly sorted list,Then cause we have reduced the increment to 1 the shellsort with increment one is insertionsort,in last sorting we sort all of the array using insertion sort.

####         Complexity of shell sort

- **Getting the exact complexity of the shell sort is hard because it depeneds on the incremenet values chosen.**Also it is not clear what the best increment value is.

- But because at the final iteration with increment 1 has to work with a nearly sorted list the time complexity of shell sort is better than insertion sort.

- The complexity of shell sort is somewhere **between O(n) and O(n²)**.

- Its adaptive and **stable sort** since its based on insertion sort.

- It sorts **in place** and it takes O(1) extra space.

  ------

  ## Merge Sort

  This sort uses divide and conquer method which is based on recursion.

  We split each time the array in two arrays and when the size of two arrays reached 1 we will start merging them.

  ####  Complexity of shell sort

  - Merge method uses O(n) time.At total we have log(n)+1 levels in our recursion tree and each level of our recursion tree has an merge method,So the time complexity of merge sort is **O(nlog(n))**.

  - It takes **O(n) extra space** when we use arrays(All the smaller lists we create in divide phase).

  - It is a **stable sort**.

  - It is an **“Non-Adaptive”** Sorting algorithm, because the order of the elements in the input array doesn’t matter.(doesnt have break)

  - It is a stable sort.

    A sorting algorithm is said to be **adaptive**, if it takes advantage of already 'sorted' elements in the list that is to be sorted.

    A **non-adaptive** algorithm is one which does not take into account the elements which are already sorted. They try to force every single element to be re-ordered to confirm their sortedness.

    Adaptive sorting algorithms:
    \1. Bubble Sort
    \2. Insertion Sort
    \3. Quick Sort

    Non-adaptive sorting algorithms:
    \1. Selection Sort
    \2. Merge Sort
    \3. Heap Sort

    ------

    