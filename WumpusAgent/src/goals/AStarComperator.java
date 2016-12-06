package goals;

import java.util.Comparator;

public class AStarComperator implements Comparator<RatedPosition>{

    @Override
    public int compare(RatedPosition rp1, RatedPosition rp2) {
        if(rp1.getfRating() > rp2.getfRating()){
            return 1;
        }
        if(rp1.getfRating() < rp2.getfRating()){
            return -1;
        }
        return 0;
    }
}