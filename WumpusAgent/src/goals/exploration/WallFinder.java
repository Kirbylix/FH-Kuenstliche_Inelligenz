package goals.exploration;

import de.fh.State;
import goals.Goal;

/**
 * Dieses Goal versucht, die östliche und südliche Levelgrenze zu finden.
 */
public class WallFinder extends Goal{

    /**
     * Konstruktor
     * @param _state Sate
     */
    public WallFinder(State _state) {
        super(_state);
    }

    /**
     * Soll ungefaehr angeben, wie sinnvoll das Ziel momentan ist. Der wert sollte <= 100 sein
     * @return Sinn/ Wichtigkeit des Ziels
     */
    @Override
    public int rateGoal(){
        //TODO
        return -1;
    }

    /**
     * Bereits gefundene Levelgrenzen zaehlen
     * @return
     */
    private int countWallsKnown(){
        //TODO
        return -1;
    }
}
