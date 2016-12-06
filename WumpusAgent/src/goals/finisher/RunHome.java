package goals.finisher;

import de.fh.State;
import goals.Goal;

/**
 * Wurde das Gold aufgehoben, so führt dieses Goal den Agenten nach Hause, und beendet den Level.
 */
public class RunHome extends Goal{

    /**
     * Konstruktor
     * @param _state Sate
     */
    public RunHome(State _state) {
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
