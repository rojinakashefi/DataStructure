# Hash Table

​	Hash table is a data structure that maps keys to values using **hashing**.

- **Keys** must be **unique**, but values can be repeated.

- The key-value pairs used in hash table can be **any type of objects** , but the **keys** must be **hashable**. (To make keys hashable (we are going to use hash functions for hash tables and a property of hash function is to be deterministic) the **keys must be immutable**.

- Removal, Insertion, Look ups can be achived in O(1) time using **hash function as a way to index to hash table**. The constant time behaviour is only true if we have a **uniform hash functions**.

  | Operation | Average | Worst |
  | :-------: | :-----: | :---: |
  | Insertion |  O(1)   | O(n)  |
  |  Removal  |  O(1)   | O(n)  |
  |  Search   |  O(1)   | O(n)  |

- If we have hash collisions in insertion of hash tables we use **Separate chaining** and **Open addressing**.

------

#### Hash Function

​	To undrestand mapping between keys and values we must must know thier **hash functions**.

##### 		A hash functions H(x) is a function that maps a key 'x' to whole number in a fixed range.

​	Hash functions can be defined for arbitrary objects such as strings,lists,.... .There are infinite hash functions.

##### 	Properties

1. ###### if H(x) == H(y) then objects x and y **might be equal** , but if H(x) != H(y) then objects x and y are **definitely not equal**.

   ​		This means instaed of comparing x and y directly a smarter approch will be comparing thier Hash values and only if their hash values matched we do need to compare x and y directly.

   ​		Hash functions for files are more sophisticated than for hash tables.Instead for files we use cryptographic hash functions also called checksums.

2. ###### A hash function H(x) must be deterministic.

   ​		This means if H(x) = Y , it will always produce Y and never another value. ( Example of non-deterministic hash functions : using global variables ,lists as keys which we can add and remove elements from them. )

3. ###### We try very hard to make Uniform hash functions.

   ​		A hash collision is when two objects x and y has the same value H(x) = H(y).

####   Usage

​		Hash tables can be used to track item frequencies.

------

#### Separate chaining

​	It deals with hash collisions by maintaining a data structure (usually linked list) to hold all the diffrenet values hashed to the same value.

To get O(1) insertion and look up time complexity when you *hash table is **really full and you have a long linked list** chain,you should **create a new hash table** with **larger capacity** and **rehash all** the old hash table and disperse them throughout the new hash table at different locations.

For removal is the same as searching for a value in hash table, but instead of returing the value you remove the node in linked list.

You can use a different data structure instead of linked list like arrays, binary trees, self balancing trees,... .

------

#### Open addressing

​	It deals with hash collisions by finding another place within hash table for the object to go by offsetting it from the position to which it hashed to .