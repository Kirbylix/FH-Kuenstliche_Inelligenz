package goals;

import environment.Field;
import tracker.Position;

public class Destination {
    private Field destination;
    private final Position position;

    /**
     * Konstruktor
     * @param _field Field
     */
    public Destination(Field _field){
        this.destination = _field;
        this.position = _field.position;
    }

    /**
     * Konstruktor
     * @param _position Position
     */
    public Destination(Position _position){
        this.position = _position;
    }

    /**
     * Rueckgabe des Feldes
     * @return Field
     */
    public Field getField(){
        return this.destination;
    }


}
