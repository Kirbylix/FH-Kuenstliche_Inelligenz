package tracker;


import environment.World;
import environment.WorldInterface;

public final class TrackedWumpus {
    public final int id;
    private final MovementHistory agent;
    private int currentStench;
    private boolean initalized;
    static final int MOVEMENT_NO = 0;
    static final int MOVEMENT_MAYBE = 1;
    static final int MOVEMENT_YES = 2;
    private final World world;
    private final MovementHistory wumpus;

    /**
     * Konstruktor
     * @param _world
     * @param _id
     * @param _agentMovement
     */
    public TrackedWumpus(WorldInterface _world, int _id, MovementHistory _agentMovement){
        this.agent = _agentMovement;
        this.id = _id;
        this.world = _world.getWorld();
        this.wumpus = new MovementHistory(_world);
    }

    /**
     * Riechdistanz setzten
     * @param _stench Riechdistanz
     */
    public void setStench(int _stench){
        this.currentStench = _stench;
    }

    /**
     * Aktuelle Daten auswerten (neue Entfernung, hat er sich bewegt, ...)
     * @param _wumpusMoved
     */
    public void update(int _wumpusMoved){
        //TODO
    }

    /**
     * Moegliche Positionen Einfügen
     */
    private void insertPossibleLocation(){
        //TODO
    }

    /**
     * Alte Positionen erweitern, wenn sich der Wumpus bewegt hat
     * @param definetlyMoved
     */
    private void morphOldPosition(boolean definetlyMoved){
        //TODO
    }

    /**
     * Alle Positionen abfragen, auf denen der Wumpus stehen koennte
     * @return
     */
    public MultiPositions getPossibleLocations(){
        //TODO
        return null;
    }

    /**
     * Es wurde geschossen - Alle moegliche Positionen eintlang der Schussrichtung loeschen
     * @param _position Position
     * @param _direction Shoot Direction
     */
    public void Shoot(Position _position, int _direction){
        //TODO
    }






















}
