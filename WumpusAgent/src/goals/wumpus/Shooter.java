package goals.wumpus;

import de.fh.State;
import goals.Goal;

/**
 * Steht der Agent gut, oder der Wumpus schlecht, so wird geschossen.
 */
public class Shooter extends Goal{

    /**
     * Konstruktor
     * @param _state Sate
     */
    public Shooter(State _state) {
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
}
