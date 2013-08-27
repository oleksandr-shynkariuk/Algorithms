package algorithms.recursion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Oleksandr Shynkariuk oleksandr.shynkariuk@gmail.com
 * This is the algorithm: suppose we want to extract the subsets of

A = {a, b, c, …}

First we separate the first element from A:

first-element: a

B = {b, c, …}

Now we use this recursive law:

The subsets of A are the collection of subsets of B,
plus the collection of subsets of B once again, but this time
the first element a is added to these subset:

Subsets-Of (A) = Subsets-Of (B) + ({a} + Subsets-Of (B))

For example, if A has only two members:

A = {a, b}

then

first-element = a

B = {b}

The subsets of B:

{}, {b}

The subsets of B, a added:

{a}, {a, b}

Now the whole collection is

Subsets of A: {}, {b}, {a}, {a, b}
 */
public class AllSubsetsOfSet {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<String>();
        set.add("A");
        set.add("B");
        set.add("C");
        //set.add("D");
        ArrayList<Set<String>> subsets = getSubsets(set, 0);
        for(Set s : subsets){
            Iterator iter = s.iterator();
            while(iter.hasNext()){
                System.out.print(iter.next() + " ");
            }
            System.out.println();
        }
    }

    static ArrayList<Set<String>> getSubsets(Set<String> set, int index){
        ArrayList<Set<String>> allSubsets = new ArrayList<Set<String>>();
        if(set.size() == index){   //base case -- return empty set
            Set<String> emptySet = new TreeSet<String>();
            emptySet.add("_");
            allSubsets.add(emptySet);
        } else {
            String elem = (String) set.toArray()[index];
            allSubsets = getSubsets(set, index + 1);
            ArrayList<Set<String>> moreSubsets = new ArrayList<Set<String>>();
            for(Set<String> subset : allSubsets){
                Set<String> newsubset = new TreeSet<String>();
                newsubset.addAll(subset);
                newsubset.add(elem);
                moreSubsets.add(newsubset);
            }
            allSubsets.addAll(moreSubsets);
        }

        return allSubsets;
    }
}
