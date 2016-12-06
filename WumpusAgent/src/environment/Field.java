package environment;

import tracker.Position;

/**
 * Created by Kai on 18.11.2015.
 */
public final class Field {

    private boolean breeze;
    private boolean bump;
    private boolean trap;
    private boolean wall;
    private boolean visited;
    private int typ;
    private final Field[] neighbors;
    private final World world;
    public final Position position;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_FREE = 1;
    public static final int TYPE_WALL = 2;
    public static final int TYPE_TRAP = 3;

    public Field(WorldInterface _world, Position _position){
        //TODO
        this.neighbors = null;
        this.breeze = false;
        this.bump = false;
        this.trap = false;
        this.wall = false;
        this.visited = false;
        this.position = _position;
        this.world = _world.getWorld();
        this.world.addField(this);
    }

    /**
     * Art des Feldes
     * @return
     */
    public int getTyp(){
        return this.typ;
    }

    /**
     * Typ des Feldes setzten
     * @param _typ
     */
    public void setTyp(int _typ){
        this.typ = _typ;
    }

    /**
     * Wurde dieses Feld schon besucht?
     */
    public void setVisited(){
        this.visited = true;
    }

    public boolean isVisited(){
        return this.visited;
    }

    /**
     * Koennte hier eine Wand sein ?
     * @return
     */
    public boolean isWall(){
        return this.wall;
    }

    /**
     * Prueft, ob es sich nur um eine virtuelle (vermutete) Levelgrenze handelt.
     * @return
     */
    public boolean isOnlyVirtualWall(){
        //TODO
        /*Returns:
        true, genau dann wenn:
        - es sich um eine vermutete Levelgrenze handelt
        - der Agent noch nicht gegen diese Wand gelaufen ist

        false, falls:
        - es keine vermutete Levelgrenze ist
        - es eine echte Wand ist (also der Agent bereits gegen sie gelaufen ist)*/
        return false;
    }

    public void cannotBeWall(){
        //TODO
    }

    /**
     * Koennte hier eine Wand sein ?
     * @return
     */
    public boolean couldBeWall(){
        return this.wall;
    }

    /**
     * Koennte hier eine Falle liegen?
     */
    public void cannotBeTrap(){
        //TODO
    }

    public boolean couldBeTraße(){
        return this.trap;
    }

    /**
     * Falle in der naehe ?
     */
    public void setBreeze(){
        //TODO
    }

    public boolean hasBreeze(){
        return this.breeze;
    }

    /**
     * Wand in der Naehe ?
     */
    public void setBump(){
        //TODO
    }

    public boolean hasBump(){
        return this.bump;
    }

    /**
     * Nachbarn setzten
     * @param _field neuer Nachbar
     * @param _direction Richtung des Nachbarn
     */
    public void setNeighbors(Field _field, int _direction){
        //TODO
    }

    /**
     * Nachbarn auslesen
     * @param _direction Richtung des Nachbarn
     * @return Nachbar
     */
    public Field getNeighbor(int _direction){
        //TODO
        return null;
    }

    /**
     * Nachbarn auslesen
     * @return Nachbarn
     */
    public Field[] getNeighbors(){
        //TODO
        return null;
    }

    /**
     * Ein Nachbarfeld auslesen und notfalls ein neues Feld erzeugen, falls Nachbar noch nicht existiert
     * @param _direction Richtung des Nachbarn
     * @return Nachbarn
     */
    public Field forceGetNeigboar(int _direction){
        //TODO
        return null;
    }

    /**
     * Nachbarfelder auslesen und notfalls neue Felder erzeugen, falls der Nachbar noch nicht exisiterit
     * @return Nachbarn
     */
    public Field[] forceGetNeighbors(){
        //TODO
        return null;
    }



































}
