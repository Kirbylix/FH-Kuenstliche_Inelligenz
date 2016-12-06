package goals.wumpus;

import de.fh.State;
import goals.Goal;
import tracker.Position;

/**
 * Verfolgt den Wumpus, und versucht, sich in eine gute Schussposition zu bewegen.
 */
public class Hunter extends Goal{

    /**
     * Konstruktor
     * @param _state Sate
     */
    public Hunter(State _state) {
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
     * Naechstes freies Feld in einer bestimmten Richtung finden
     * @param _position aktuelle Position
     * @param _direction Richtung
     * @return
     */
    private int getNextFreeField(Position _position, int _direction){
        //TODO
        return -1;
    }

}
