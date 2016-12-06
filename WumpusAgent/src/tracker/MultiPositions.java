package tracker;

import java.util.ArrayList;

/**
 * Liste von Positionen
 */
public final class MultiPositions {
    private ArrayList<Position> positions;

    /**
     * Konstruktor
     */
    public MultiPositions(){
        this.positions = new ArrayList<>();
    }

    /**
     * Position hinzufuegen
     * @param _position Position
     * @return Position
     */
    public Position add(Position _position){
        //TODO
        return null;
    }

    /**
     * Position loeschen
     * @param _index Index
     */
    public void remove(int _index){
        this.positions.remove(_index);
    }

    /**
     * Position abfragen
     * @param _index Index
     * @return Position
     */
    public Position get( int _index){
        return this.positions.get(_index);
    }

    /**
     * Anzahl der gespeicherten Positionen
     * @return Size
     */
    public int size(){
        return this.positions.size();
    }

    /**
     * Distanz zu einem Punkt
     * @param _position Position
     * @return Manhattan-Distanz
     */
    public int closeDistance(Position _position){
        //TODO
        return -1;
    }
}
