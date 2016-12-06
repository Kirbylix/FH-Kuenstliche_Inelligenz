package tracker;

import environment.World;
import environment.WorldInterface;

import java.util.ArrayList;

public final class WumpusTracker {
    private MovementHistory movement;
    private World world;
    private ArrayList<TrackedWumpus> wumpi;

    /**
     * Konstruktor
     * @param _world
     */
    public WumpusTracker(WorldInterface _world){
        this.world = _world.getWorld();
    }

    /**
     *
     * @param _id
     * @return
     */
    private TrackedWumpus getWumpusById(int _id){
        for(TrackedWumpus wumpus: this.wumpi){
            if(wumpus.id == _id){
                return wumpus;
            }
        }
        System.err.println("WumpusTracker.getWumpusById: Es wurde kein Wumpus mit der ID: " + _id + " gefunden!");
        return null;
    }

    /**
     * Ein Wumpus hat sich bewegt
     */
    public void wumpusMoved(){
        //TODO
    }

    /**
     * Der Agent hat sich bewegt, und zwar auf die
     * @param _position Position
     */
    public void agentMoved(Position _position){
        //TODO
    }

    /**
     * Riechdistanz updaten
     * @param _id
     * @param _distance
     */
    public void addStenchInfo(int _id, int _distance){
        this.getWumpusById(_id).setStench(_distance);
    }

    /**
     * Positionen der Wumpi neu berechnen
     * @param wumpusMoved
     */
    public void updatePositions(boolean wumpusMoved){
        //TODO
    }

    /**
     * Alle getrackten Wumpi zurueckgeben
     * @return Liste der getrackten Wumpi´s
     */
    public ArrayList<TrackedWumpus> getTrackedWumpi(){
        return this.wumpi;
    }

    /**
     * Agent hat geschossen
     */
    public void Shoot(){
        //TODO
    }

    /**
     * Aufhoeren, einen Wumpus zu tracken
     * @param _wumpus
     */
    protected void untrack(TrackedWumpus _wumpus){
        this.wumpi.remove(_wumpus);
    }


}
