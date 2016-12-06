package goals.finisher;

import de.fh.State;
import environment.Field;
import goals.Goal;
import goals.RatedPosition;
import tracker.Position;

import java.util.ArrayList;

/**
 * Wurde das Gold aufgehoben, so führt dieses Goal den Agenten nach Hause, und beendet den Level.
 */
public class GoldFinder extends Goal{

    private ArrayList<RatedPosition> closedList;
    private ArrayList<RatedPosition> openList;
    private Position chosenSuicide;
    private boolean searchingWall;

    /**
     * Konstruktor
     * @param _state Sate
     */
    protected GoldFinder(State _state) {
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
     * Array durchsuchen
     * @param _list Liste
     */
    private void randomize(ArrayList<Field> _list){
        //TODO
    }

    /**
     * Tauscht zwei Elemente des Arrays
     * @param _list Liste
     * @param _index1 Element1
     * @param _index2 Element1
     */
    private void swap(ArrayList<Field> _list, int _index1, int _index2){
        //TODO
    }

    /**
     * das naechste unbesuchte Feld suchen
     * @return
     */
    protected int findClosestUnvisitedField(){
        //TODO
        return -1;
    }

    /**
     * Die naechste vermutete Wand suchen, gegen die der Agent noch nicht gelaufen ist
     * @return
     */
    protected int findClosestSuspectedWall(){
        //TODO
        return -1;
    }

    /**
     * das dichteste Feld finden
     * @param searchingWall true: nach einer Wand suchen, false: nach einer Falle suchen
     * @return
     */
    protected int findClosestField(boolean searchingWall){
        //TODO
        return -1;
    }

    /**
     * Erweitern einer Position
     * @param _position
     */
    private void astarExpand(RatedPosition _position){
        //TODO
    }

    /**
     * Eventuell eine Position in die Warteschalnge einreihen
     * @param _list
     * @param _position
     */
    private void tryAdd(ArrayList<RatedPosition> _list, RatedPosition _position){
        //TODO
    }

    /**
     * Eine Position sortiert in die Warteschlange einreihen
     * @param _list
     * @param _position
     */
    private void insertSorted(ArrayList<RatedPosition> _list, RatedPosition _position){
        //TODO
    }

    /**
     * Index einer Position in der Liste herausfinden
     * @param _list Liste von Positionen
     * @param _position Position
     * @param _direction Richtung
     * @return Index in der Liste, oder -1 falls die Position nicht vorhanden ist
     */
    private int getPosition( ArrayList<RatedPosition> _list, Position _position, int _direction){
        //TODO
        return -1;
    }

    /**
     * Pruefe ob eine bestimme Position in der Liste vorhanden ist
     * @param _list Liste von Positionen
     * @param _position Position
     * @return true/ false
     */
    private boolean contains(ArrayList<RatedPosition> _list, RatedPosition _position){
        //TODO
        return false;
    }
}