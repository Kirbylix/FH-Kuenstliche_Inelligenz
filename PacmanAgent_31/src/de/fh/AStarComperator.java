package de.fh;

import java.util.Comparator;

public class AStarComperator implements Comparator<State>{

    @Override
    public int compare(State s1, State s2) {
        if((s1.getPathCost() + s1.getManhattan()) > (s2.getPathCost() + s2.getManhattan())){
            return 1;
        }
        if((s1.getPathCost() + s1.getManhattan()) < (s2.getPathCost() + s2.getManhattan())){
            return -1;
        }
        return 0;
    }


}
