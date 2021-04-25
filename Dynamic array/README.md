



# Arrays

Arrays are one of the most popular data structer we will always use in our programming.

There is so much benefits of using arrays such as:

1. Storing and accessing data

2. Temprorarily storing object

3. Used as a IO buffer to store information from an input or output stream

4. Look up tables

5. Return multiple values from a function

6. Dynamic programming to cache answers to subproblems

   There are two types of array : Static Array , Dynamic Array

## Static Array

A static array is a **fixed** lenght container containing n elements **indexable** (can be reached with a number) from the range **[0,n-1 ]**.

- we can find/Access to an element in O(1) because arrays are indexiable and each element has it own index.
- we can search within an array with size n to find a special value.(for loop
- Because static array is a fixed size array Insertion,Appending,Deletion can't be implemented.(can't grow larger or smaller).

## Dynamic Array

we implement dynamic array using static array.

- Insertion in dynamic array taked O(n) cause we have to shift all elements to right and recopying all elements to new static array.

- Appending is constant because if our array has capacity we only have to put our element in index=size.

- Deletion is linear (O(n)) as same reason as insertion.

  ------

  ###   Complexity of Static Array vs. Dynamic Array                                            

​                                                                      **Static array                   Dynamic array**

| **Access**    | **O(1)** | **O(1)** |
| :------------ | :------: | -------- |
| **Search**    | **O(n)** | **O(n)** |
| **Insertion** |  **--**  | **O(n)** |
| **Appending** |  **--**  | **O(1)** |
| **Deletion**  |  **--**  | **O(n)** |

------

### Diffrences between Dynamic array & Linked List

####   Dynamic array

- Accessing and assignment by index is very fast O(1) process, since internally index access is just [address of first member] + [offset].

- Appending object (inserting at the end of array) is relatively fast amortized O(1). Same performance characteristic as removing objects at the end of the array.

- Inserting or removing objects in a random position in a dynamic array is very slow O(n/2), as it must shift (on average) half of the array every time. Especially poor is insertion and removal near the start of the array, as it must copy the whole array.

- Unpredictable performance when insertion or removal requires resizing.

- There is a bit of unused space, since dynamic array implementation usually allocates more memory than necessary (since resize is a very slow operation).

- Arrays which uses a contiguous addresses in memory. Arrays (slightly) benefits from processor caching since they are all near each other.

  ------

  ####   Linked List

  - Fast O(1) insertion and removal at any position in the list, as insertion in linked list is only breaking the list, inserting, and repairing it back together (no need to copy the tails).
  - Linked list is a persistent data structure.
  - Slow O(n) index access (random access), since accessing linked list by index means you have to recursively loop over the list.
  - Poor locality, the memory used for linked list is scattered around in a mess.