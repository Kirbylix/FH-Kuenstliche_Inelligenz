package goals;

import environment.Field;
import tracker.Position;
import de.fh.State;
import environment.World;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Abstrakte Klasse, die als Design-Vorlage für alle Goals dient. Sie stellt außerdem die Methode actionTowardsDestination(x, y)
 * zur Verfügung, die mit dem A*-Algorithmus nach dem schnellsten Weg zum angegebenen Ziel (x, y) sucht, und die dafür nötige
 * Aktion zurückgibt. Wird kein Weg gefunden, wird die Aktion Action.SIT zurückgegeben, was dann von den Goals abgefangen werden kann.
 */
public class Goal {
    private ArrayList<RatedPosition> closedList;
    private PriorityQueue<RatedPosition> openList;
    private static final int MAXIMUM_IMPORTANCE = 100;
    private boolean suicide;
    private Position destination;
    protected final State state;
    protected final World world;

    /**
     * Konstruktor
     * @param _state Sate
     */
    protected Goal(State _state){
        this.state = _state;
        this.world = _state.getWorld();
        this.openList = new PriorityQueue<RatedPosition>(new AStarComperator());
    }

    /**
     * Soll unegfähr angeben, wie sinnvoll das Ziel moementan ist.
     * Der Wert sollte <= 100 sein.
     * @return
     */
    public int rateGoal(){
        //TODO
        return 100;
    }

    /**
     * Hat sich Action für diese Goals entschieden, wird über diese Funktion nach auszuführende Aktion gefragt,
     * um das Ziel bestmöglich zu erreichen.
     * @return
     */
    public int getAction(){
        //TODO
        return 0;
    }

    /**
     *
     * @param _field Field
     * @return
     */
    protected int actionTowardsSuicidalDestination(Field _field){
        //TODO
        return -1;
    }

    /**
     *
     * @param _position Position
     * @return
     */
    protected int actionTowardsSuicidalDestination(Position _position){
        //TODO
        return -1;
    }

    /**
     *
     * @param _field Field
     * @return
     */
    protected int actionTowardsDestination(Field _field){
        //TODO
        return -1;
    }

    /**
     *
     * @param _destination Destination
     * @return
     */
    protected int actionTowardsDestination(Position _destination){
        //TODO
        return -1;
    }

    /**
     * A*-Suche nach einer Position
     * @param _destination Destination
     * @return
     */
    protected int astarTowardsDestination(Position _destination){
        //OpenList leeren
        this.openList.clear();
        this.closedList.clear();
        // Initialisierung der OpenList, die ClosedList ist noch leer
        /*this.openList.add(state);
        //bis eine oder keine Lösung gefunden worden ist
        do{
            //Knoten mit dem geringsten f Wert aus der OpenList entfernen
            RatedPosition currentRP = this.openList.poll();
            //sind alle Dots gefressen
            if(currentRP.getPosition().equals(this.cherry)){
                System.out.println("Loesung gefunden");
                this.finalCherry = currentRP;
                continue;
            }
            //Die aktuelle State soll durch nachfolgende Aktionen nicht weriter unstersucht werden
            this.closedList.add(currentRP);
            //NachfolgeStates untersuchen
            this.astarExpand(currentRP);
        }while(!this.openList.isEmpty());
        System.err.println("Keine Loesung gefunden");*/
        //TODO
        return -1;
    }

    /**
     *
     * @param _currentRP Expandierte Position
     */
    private void astarExpand(RatedPosition _currentRP){
        //TODO
        /*for(Position posi: _currentRP.getArround()){
            RatedPosition child = _currentRP.move(posi);
            //wenn der Nachfolgeknoten bereits auf der ClosedListe ist - tue nichts
            if(closedList.contains(child)){
                continue;
            }

            child.setParent(_currentRP);

            if(this.openList.contains(child)){
                this.openList.remove(child);
            }else {
                this.openList.add(child);
            }
        }*/
    }

    /**
     * Eventuell eine Position in die Warteschlange einreihen
     * @param _list Position Liste
     * @param _position Position
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

    /**
     * Maximale Weite, die man von einer Position aus gehen kann
     * @param _position Position
     * @param direction Richtung
     * @return Anzahl der Felder
     */
    protected int maxPathLength(Position _position, int direction){
        //TODO
        return -1;
    }



}
