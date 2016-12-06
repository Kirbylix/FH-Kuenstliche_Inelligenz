package goals.exploration;

import de.fh.State;
import goals.Goal;
import tracker.Position;

/**
 * Die bekannte Karte wird möglichst grob abgelaufen, um den Wumpus zu finden.
 */
public class WumpusFinder extends Goal {

    private int executions;
    private Position lastNextPosition;
    private int lastUse;
    private static final int[][] movemod = new int[0][];

    /**
     * Konstruktor
     * @param _state Sate
     */
    public WumpusFinder(State _state) {
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
     * Hat sich Actions fuer dieses Goal entschieden wird ueber diese Funktion nach der auszufuehenden Aktion gefragt,
     * um das Ziel bestmoeglichst zu erreichen
     * @return
     */
    @Override
    public int getAction(){
        //TODO
        return -1;
    }

    /**
     * das folge-Makrofeld suchen
     * @param _sorce
     * @param _max
     * @return
     */
    private int[] nextMacroFeld(Position _sorce, Position _max){
        //TODO
        return null;
    }
}
