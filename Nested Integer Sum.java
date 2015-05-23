From LinkedIn

/** 
* Given a nested list of integers, returns the sum of all integers in the list weighted by their depth 
* For example, given the list {{1,1},2,{1,1}} the function should return 10 (four 1's at depth 2, one 2 at depth 1) 
* Given the list {1,{4,{6}}} the function should return 27 (one 1 at depth 1, one 4 at depth 2, one 6 at depth2) 
*/ 
/** 
* This is the interface that represents nested lists. 
* You should not implement it, or speculate about its implementation. 
*/ 
public interface NestedInteger 
{ 
// Returns true if this NestedInteger holds a single integer, rather than a nested list 
public boolean isInteger(); 

// Returns the single integer that this NestedInteger holds, if it holds a single integer 
// Returns null if this NestedInteger holds a nested list 
public Integer getInteger(); 

// Returns the nested list that this NestedInteger holds, if it holds a nested list 
// Returns null if this NestedInteger holds a single integer 
public List<NestedInteger> getList(); 
}


DFS:

public int getSum(NestedInteger ni) {
    if(ni.isInteger())          //如果是single integer直接返回值
        return ni.getInteger();
    else
        return getListSum(ni.getList(), 1);
}

private int getListSum(List<NestedInteger> list, int depth) {
    int sum = 0;
    for(int i=0; i<list.size(); i++) {
        if(list.get(i).isInteger())
            sum+=list.get(i).getInteger()*depth;
        else
            sum+=getListSum(list.get(i).getList(), depth+1);
    }
    return sum;
}