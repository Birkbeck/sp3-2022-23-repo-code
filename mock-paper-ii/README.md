Using the appropriate stream functions (e.g., map, filter, reduce, zip, etc.) write a method called `sumStrings` which takes a map data structure whose keys are strings and values are points. The method returns a map data structure that associates each point with the sum of the lengths of the strings it is associated with in the first map. For example, suppose that a map called `data` has the following associations:

```java
{a=[x=1,y=3], apple=[x=7,y=7], be=[x=4,y=7], bear=[x=7,y=4],
           carpet=[x=2,y=19], cat=[x=1,y=3], dog=[x=2,y=18],
           specialty=[x=7,y=4], student=[x=1,y=3], umbrella=[x=42,y=8]}
```

Then the call `sumStrings(data)` should return the following map:

```java
{[x=7,y=7]=5, [x=42,y=8]=8, [x=2,y=18]=3, [x=1,y=3]=11,
			[x=2,y=19]=6, [x=7,y=4]=13, [x=4,y=7]=2}
```

Notice that the point `[x=7,y=7]` maps to `5` in the result because it was associated with a string of length `5` in the original (`"apple"`).
Notice that `[x=1,y=3]` maps to `11` because it was associated with three strings (`"a"`, `"cat", "student"`) whose lengths add up to 11 (1, 3, 7).

Your method should construct the new map and can create iterators but should otherwise not build any new data structures. It should also not modify the map passed as a parameter and should be reasonably efficient.
