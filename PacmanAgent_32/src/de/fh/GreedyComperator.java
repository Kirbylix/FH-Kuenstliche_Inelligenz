package de.fh;

import java.util.Comparator;

public class GreedyComperator implements Comparator<State>{

    @Override
    public int compare(State s1, State s2) {
        if(s1.getPerformance() < s2.getPerformance()){
            return 1;
        }
        if(s1.getPerformance() > s2.getPerformance()){
            return -1;
        }
        return 0;
    }
}