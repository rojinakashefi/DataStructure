# Union find

Union find is a data structure which keep track of elements which are split into two or more disjoint sets.it has two primary operations:

1- Find : will tell you what group an element belongs too ( find the root of that group by following the parent nodes until self loop is reached.  )

2- Union : merges two groups together (find root nodes of each group and if the root nodes are different make one of the root nodes be the parent of the other)

we see union find in :

- [ ] Kruskal's minimum spanning tree algorithm

  - a minimum spanning tree is subset of the edges which connect all vertices in the graph with the minimal total edge cost.(it may not be unique)

- [ ] Grid percolation :

  - where there is bunch of dots on a grid and then we see if there is path from bottom of grid to top of grid (or vice versa)

- [ ] Network connectivity :

  - are two vertices in the graph connected to each other through series of edges

- [ ] Least common ancestor in trees

- [ ] Image processing

  ------

  ### Implementation details

  - Find and union operations:

    1. First construct a mapping between your objects and the integer in the range [0, n).
    2. Store union find information in an array. Each index has an associated object we can lookup through our mapping.

  - path compression

    ------

    ### Complexity:

|    Construction    | O(n) |
| :----------------: | :--: |
|       Union        | α(n) |
|        Find        | α(n) |
| get component size | α(n) |
| check if connected | α(n) |
|  count components  | O(1) |

**The number of components is equal to the number of the roots remaing. **

**Also,remark that the number of root nodes never increases.**
