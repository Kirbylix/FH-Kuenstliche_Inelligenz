package de.fh;

import de.fh.connection.wumpus.AgentPercept;
import de.fh.connection.wumpus.AgentStartInfo;
import environment.Field;
import environment.World;
import tracker.Position;
import tracker.WumpusTracker;

public class State {
    private int facing;
    private int round;
    private int shots;
    private final int maxArrow;
    private final int smellDistance = 3; // Manhattendistance
    private int wumpusCount;
    private int score;

    int implementation;
    private boolean goldFound;
    private boolean goldTaken;
    private boolean suicide;
    private boolean shotWumpus;

    private Position posiGold;
    private Position posiMax;
    private Position posiAgent;
    private WumpusTracker wumpiTracker;
    private World world;

    /**
     * Konstruktor
     * @param _startInfo
     */
    public State(AgentStartInfo _startInfo) {
        this.facing = _startInfo.getDirection();
        this.round = 0;
        this.shots = 0;
        this.maxArrow = _startInfo.getShoots();
        this.wumpusCount = _startInfo.getPlayerPerTeam();
        this.score = 1000;
        this.implementation = 0;
        this.goldFound = false;
        this.goldTaken = false;
        this.suicide = false;
        this.shotWumpus = false;
        this.posiGold = new Position(0,0);
        this.posiMax = new Position(0,0);
        this.posiAgent = new Position(1,1);
        this.world = new World(this);
        this.wumpiTracker = new WumpusTracker(this.world);
    }

    /**
     * Update der State
     */
    public void updateState(AgentPercept _percept){
        //TODO
        this.updateWorld(_percept);
        if (_percept.isStench() == true) {
            System.out.println("<------- Der Wumpus Stinkt! ------->");

        }



    }

    /**
     * Update der Welt
     * @param _percept
     */
    public void updateWorld(AgentPercept _percept){

    }

    /**
     * Aktualisierung der aktuellen Score
     * @param _value +/- Punkte
     */
    public void setScore(int _value){
        this.score = this.score + _value;
    }

    /**
     * Überprüft ob man durch das Ausschlussverfahren die Position einer Falle ermitteln kann, statt diese nur zu vermuten
     * @param _field
     */
    public void searchTraps(Field _field){

    }

    /**
     * Trägt ein, welche Aktion gewählt wurde, damit man aus der Reaktion zum Beispiel feststellen kann ob man beim Schießen
     * auch getreoffen hat, oder ob man vor einer Wand gelaufen ist.
     * @param _action
     */
    public void actionQueued(int _action){

    }

    /**
     * X Position des Agenten
     * @return
     */
    public int getAgentX(){
        return this.posiAgent.getX();
    }

    /**
     * Y Position des Agenten
     * @return
     */
    public int getAgentY(){
        return this.posiAgent.getY();
    }

    /**
     * Blickrichtung des Agenten
     * @return
     */
    public int getAgentFacing(){
        return this.facing;
    }

    /**
     * Position des Agenten
     * @return
     */
    public Field getAgentField(){
        //TODO
        return null;
    }

    /**
     * Wurde das Gold gefunden ?
     * @return
     */
    public boolean isGoldFound(){
        return this.goldFound;
    }

    public void setGoldFound(boolean _found){
        this.goldFound = _found;
    }

    /**
     * Wurde das Gold genommen ?
     * @return
     */
    public boolean goldTaken(){
        return this.goldTaken;
    }

    /**
     * Position des Goldes
     * @return
     */
    public Position getGold(){
        return this.posiGold;
    }

    /**
     * World
     * @return
     */
    public World getWorld(){
        return this.world;
    }

    /**
     * Wumpus Riechdistanz
     * @return
     */
    public int getSmellDistance(){
        return this.smellDistance;
    }

    /**
     * Anzahl der noch lebenden Wumpi´s
     * @return
     */
    public int getWumpusCount(){
        return this.wumpusCount;
    }

    /**
     * ein Wumpi wurde getötet
     */
    public void wumpusKilled(){
        this.wumpusCount--;
    }

    /**
     * Aktuelle Spielrunde
     * @return
     */
    public int getRound(){
        return this.round;
    }

    /**
     * Wurde in der aktuellen Runde ein Wumpus getötet ?
     * @return
     */
    public boolean wasAWumpusKilled(){
        //TODO
        return false;
    }

    /**
     * Verbleibende Pfeile
     * @return
     */
    public int getShots(){
        return this.shots;
    }

    /**
     * Maximale Pfleile
     * @return
     */
    public int getMaxArrow(){
        return this.maxArrow;
    }

    /**
     * 3, 2, Risiko
     * @return
     */
    public boolean maybeSuicide(){
        return this.suicide;
    }

    /**
     *
     * @return
     */
    public boolean isMovableWumpus(){
        //TODO
        return false;
    }

    /**
     * Rückgabe des Punktestandes
     * @return
     */
    public int getScore(){
        return this.score;
    }

    /**
     * abgefuerte Pfeile
     * @return
     */
    public int shootedArrow(){
        return (this.maxArrow - this.shots);
    }


















}
