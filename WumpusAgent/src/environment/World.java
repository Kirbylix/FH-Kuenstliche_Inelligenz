package environment;

import de.fh.State;
import tracker.Position;

import java.util.ArrayList;

public class World implements WorldInterface{

    private final ArrayList<Field> fields;
    private final int[] posMax;
    private static final int[] WALL_INDOCATOR = new int[0];
    private final int[] posiWall;
    private final boolean[] walls;
    public final State state;

    /**
     * Konstruktor
     * @param _state State
     */
    public World(State _state){
        this.state = _state;
        this.fields = new ArrayList<>();
        this.posMax = null;
        this.posiWall = null;
        this.walls = null;
    }

    /**
     * Fügt ein neues Feld ein
     * @param _field Field
     */
    protected void addField(Field _field){
        this.fields.add(_field);
    }

    /**
     * Fragt den Index im Array ab, den ein bestimmtes Feld hat
     * @param _position Position
     * @return ID
     */
    protected int getID(Position _position){
        int id = 0;
        for(Field field: this.fields){
            if(field.position == _position){
                return id;
            }
            id++;
        }
        System.err.println("World.getID konnte kein Feld mit der Position: " + _position + " finden");
        return -1;
    }

    /**
     * Fragt ein Feld ab
     * @param _position Position
     * @return Das Feld, das an der Position (x,y) ist, oder NULL, falls das Feld noch nicht exisiterit
     */
    public Field tryGet(Position _position){
        for(Field field: this.fields){
            if(field.position == _position){
                return field;
            }
        }
        return null;
    }

    /**
     * Fragt ein Feld ab.
     * @param _position Position
     * @return Das Feld, das an der Position und erzeugt ist, falls das Feld noch nciht existiert
     */
    public Field forceGet(Position _position){
        for(Field field: this.fields){
            if(field.position == _position){
                return field;
            }
        }
        Field field = new Field(this.getWorld(), _position);
        this.addField(field);
        return field;
    }

    /**
     * Fragt ab, ob eine Levelgrenzen schon gefunden wurde
     * @param _direction Richtung der Grenze
     * @return true/ false
     */
    public boolean wallKnown(int _direction){
        //TODO
        return false;
    }

    /**
     * Fragt die Position einer Levelgrenze ab -> siehe wallKnown(int)
     * @param _direction Richtung der Grenze
     * @return Position der Levelgrenze
     */
    public int getWall(int _direction){
     //TODO
        return -1;
    }

    /**
     * Setzt die Position einer vermuteten Levelgrenze
     * @param _direction Richtung
     * @param _position Position
     */
    public void setWall(int _direction, int _position){
        //TODO
    }

    /**
     * Loescht eine vermutete Levelgrenze -> dahinter geht es noch weiter
     * @param _direction Richtung
     */
    public void removeWall(int _direction){
        //TODO
    }

    /**
     * Ueberpruefen, ob an der Position eine Levelgrenze ist
     * @param _position Position
     */
    public void searchWall(Position _position){
        //TODO
    }

    /**
     * Zaehlt die gefunden und vermutete Waende entlang einer vermutete Levelgrenze
     * @param _position Position
     * @param _horizontal Horizontale Richtung ?
     * @return {gefundene, vermutete} oder null falls es keine Levelgrenze sein kann
     */
    public int[] countWallField(int _position, boolean _horizontal){
        //TODO
        return null;
    }

    /**
     * Gibt die genutzte Instanz der Klasse zurueck
     * @return this
     */
    @Override
    public World getWorld() {
        return this;
    }

    /**
     * Groesste besuchte Koordinate in der entsprechende Richtung
     * @param _direction Blick-Richtung
     * @return
     */
    public int getMaxPosition(int _direction){
        //TODO
        return -1;
    }

    /**
     * Befindet sich an Position im bereits besuchten Bereich des Spielfelds?
     * @param _position Position
     * @param _direction Blick-Richtung
     * @return
     */
    public boolean withInMaxPosition(Position _position, int _direction){
        //TODO
        return false;
    }
}
