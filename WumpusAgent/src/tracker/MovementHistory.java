package tracker;

import environment.World;
import environment.WorldInterface;

import java.util.ArrayList;

/**
 * Liste der besuchten Felder
 */
public final class MovementHistory {
    private Position last;
    private int maxSteps;
    private ArrayList<MultiPositions> movement;
    private int step;
    private final World world;

    /**
     * Konstruktor
     * @param _world World
     */
    public MovementHistory(WorldInterface _world){
        this.world = _world.getWorld();
    }

    /**
     * Besuchte Position hinzufuegen
     * @param _position Position
     */
    public void addPosition(Position _position){
        //TODO
    }

    /**
     * Neuen Abschnitt starten
     */
    public void nextStep(){
        //TODO
    }

    /**
     * Alle mitgeschriebenen Positionen zurueckgeben
     * @param historySteps Anzahl der "Schritte" in die Vergangenheit
     * @return
     */
    public MultiPositions getPositions(int historySteps){
        //TODO
        return null;
    }

    /**
     * Alle Felder löschen, die eine bestimmte Distanz zu den uebergebenen Position haben
     * @param _positions
     * @param minDistance
     */
    public void deleteByArea(MultiPositions _positions, int minDistance){
        //TODO
    }

    /**
     * RESET
     */
    public void reset(){
        //TODO
    }

    /**
     * Zuletzt hinzugefuegte Position zurueckgeben
     * @return
     */
    public Position getLastPosition(){
        //TODO
        return null;
    }





}
