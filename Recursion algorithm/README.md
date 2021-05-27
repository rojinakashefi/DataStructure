# Recursion Algorithms

As we all know recursions are so important,they can make our programs work faster for example we use recursions in quick sort,merge sort,....

The most famous example of recursion is HanoiTower:

## HanoiTower

The question is we have three towers : first,second,last.

We want to move n disks from first tower to last towers in which:

1.  Each time we can move only one disk.
2.  At last , disks must be sorted from small to biggest one (the biggest must be lowest one).
3. It can't be big disk on a small disk within the operations.

### Runtime of this algorithm is 

#####              T(n) = 2 T(n-1) + 1

------

## Binary Search

It's an algorithm for finding an element in **sorted array**,in which we basically ignore half of the elements just after one comparison.

The idea of  the algorithm is :

1. First choose an pivot

2. Then compare the element we are looking for with the pivot ---> if element=pivot we return pivot value

3. If element was smaller than pivot we choose a  new pivot in left side of pivot and compare it with element and we recurse on left half.

4. If element was bigger than pivot we choose a new pivot in right half of pivot and compare it with element and we recurse on right half.

5. We contiune recursion till the array which has been left has only one element, if the element which has been left is equal to the item we are looking for we have found it ,and if not there is no such an element in array.

   

   ### Runtime of this algorithm is :

   #####       T(n) = T(n/2)+ c

   ------

   ## Find k'th smallest element

   - If k==1 means we are looking for smallest element O(n)
   - If k==n means we are looking for biggest element O(n)
   - Select a pivot ->T(n/5)
   - Partition around it (Left array , Right array) -> 2O(n)
   - Recurse

Length of left array and right array depends on the piviot postion :

​      1) If we choose the first or last element as a pivot, n-1 elements are left which we should recurse on them

​             T(n) <= T(n-1) + O(n)

​     2) If we choose the middle element as a pivot,each time we should recurse on n/2 elements

​          T(n) <= T(n/2) + O(n)

Seems like the second way is better ,but finding middle element means  K=n/2 which we are looking for.

But we can :

​      1) Divide the original list into ⌈n/p⌉ groups (each group has <= p elements)

​      2) Find the submedian of each small group ( ⌈p/2⌉ smallest out of p)  ----> constant work for each group ---> 

​      ⌈n/p⌉ gropus total * O(1) = O(n) ----> keep recursing T(n/p)

​      3) Find the median of all the sub-medians.

If we choose the median of sub-medians (p==5) as a pivot the length of right and left arrays will be :

 3n/10 - 6 ≤ len(Left) ≤ 7n/10 + 5 ----> worst case T(7n/10)

 3n/10 - 6 ≤ len(Right) ≤ 7n/10 + 5  ----> worst case T(7n/10)

### Runtime of this algorithm is :

#####             T(n) ≤ T(7n/10) + T(n/p) + O(n)

------

We can solve recursion algorithms with several ways:

1. Divide and conquer
2. Master Theorem
3. Substitution method