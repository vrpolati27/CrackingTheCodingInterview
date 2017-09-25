package ctci.stacksNqueues;

import java.util.Arrays;

public class Stack3<T1>{

    private Object[][] stacks;
    private float growingFactor;
    private int[] stacksIndex;
    private int stacksCount;

    /* constructor. */
    public Stack3(int initialSize, float growingFactor){
        this.stacksCount = 3;
        stacksIndex = new int[stacksCount];
        Arrays.fill(stacksIndex,-1);
        stacks = new Object[stacksCount][initialSize];
        this.growingFactor = growingFactor;
    }

    /* push an element onto stack# specified
    * T(n)=O(n). */
    public void push(int stackNumber, T1 element) throws Exception{
        if(!(stackNumber>=0 && stackNumber<stacksCount)) throw new Exception();
        if((stacks[stackNumber].length-1)==stacksIndex[stackNumber])
            extend(stackNumber);
        stacks[stackNumber][++stacksIndex[stackNumber]] = element;
    }

    /**/
    private void extend(int stackNumber){
       Object[] copy = new Object[(int)(stacksIndex[stackNumber]*(1+growingFactor))];
       int c1 = 0;
       for(Object arr:stacks[stackNumber]){
           copy[c1++] = arr;
       }
       this.stacks[stackNumber] = copy;
    }

    /**/
    public T1 pop(int stackNumber) throws Exception{
        if(!(stackNumber>=0 && stackNumber<stacksCount)) throw new Exception();
        if(stacksIndex[stackNumber]==-1) throw new Exception();
        T1 end = (T1)stacks[stackNumber][stacksIndex[stackNumber]];
        stacks[stackNumber][stacksIndex[stackNumber]--] = null;
        return end;
    }

    /**/
    public T1 peek(int stackNumber) throws Exception{
        if(!(stackNumber>=0 && stackNumber<stacksCount)) throw new Exception();
        if(stacksIndex[stackNumber]==-1) throw new Exception();
        T1 end = (T1)stacks[stackNumber][stacksIndex[stackNumber]];
        return end;
    }

    public boolean isEmpty(int stackNumber) throws Exception{
        if(!(stackNumber>=0 && stackNumber<stacksCount)) throw new Exception();
        return stacksIndex[stackNumber]==-1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for(int stnum=0;stnum<stacks.length;stnum++){
            sb.append("\t[ ");
            for(int c=0;c<=stacksIndex[stnum];c++){
                sb.append(stacks[stnum][c].toString()+", ");
            }
            sb.append("]\n");
        }
        sb.append(" ]");
        return sb.toString();
    }
}
