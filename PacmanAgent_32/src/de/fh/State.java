package de.fh;

import java.util.*;

public class State{
    private int[][] world;
    private Position position;
    private ArrayList<Position> arround;
    private int pathCost;
    private int dots = 0;
    private State parent;

    public int getDotEaten() {
        return dotEaten;
    }

    public int getPerformance() {
        return performance;
    }

    private int dotEaten;
    private int performance;

    /**
     * Konstruktor
     * @param newWorld
     */
    public State(int[][] newWorld){
        this.world = new int[newWorld.length][newWorld[0].length];
        for(int y = 0; y < newWorld.length; y++){
            for(int x = 0; x < newWorld[0].length; x++){
                this.world[y][x] = newWorld[y][x];
            }
        }
        this.position = setPosition();
        this.setNodesArround();
        this.pathCost = 0;
        this.dots = countDots();
        this.dotEaten = 0;
        this.performance = (3*this.dotEaten) - this.pathCost;
    }

    /**
     * Konstruktor
     * @param newWorld
     * @param
     */
    public State(int[][] newWorld, int _pathCost, int _dotsGefressen){
        this.world = new int[newWorld.length][newWorld[0].length];
        for(int y = 0; y < newWorld.length; y++){
            for(int x = 0; x < newWorld[0].length; x++){
                this.world[y][x] = newWorld[y][x];
            }
        }
        this.position = setPosition();
        this.setNodesArround();
        this.pathCost = _pathCost;
        this.dots = countDots();
        this.dotEaten = _dotsGefressen;
        this.performance = (3*this.dotEaten) - this.pathCost;
    }

    public State move(Position newPosition, boolean _dotEaten){
        assert (newPosition != null);
        int[][] newWorld = new int[this.getWorld().length][this.getWorld()[0].length];
        for(int y = 0; y < this.getWorld().length; y++){
            for(int x = 0; x < this.getWorld()[0].length; x++){
                newWorld[y][x] = this.getWorld()[y][x];
            }
        }
        newWorld[newPosition.getY()][newPosition.getX()] = 5;
        newWorld[this.getY()][this.getX()] = 0;
        int dotsGefressen;
        if(_dotEaten) {
            dotsGefressen = this.dotEaten + 1;
        }else{
            dotsGefressen = this.dotEaten;
        }


        State result = new State(newWorld, this.pathCost+1, dotsGefressen);
        return result;
    }

    /**
     * Felder die um die Position liegen
     * @param
     * @return
     */
    public void setNodesArround(){
        this.arround = new ArrayList<>();

        // TOP
        if(this.world[this.position.getY()-1][this.position.getX()] != 1){
            this.arround.add(new Position(this.position.getX(), this.position.getY()-1));
        }
        //Right
        if(this.position.getX()+1 < this.world[0].length){
            if(this.world[this.position.getY()][this.position.getX()+1] != 1){
                this.arround.add(new Position(this.position.getX() + 1, this.position.getY()));
            }
        }

        // Bottom
        if(this.position.getY()+1 < this.world.length) {
            if (this.world[this.position.getY() + 1][this.position.getX()] != 1) {
                this.arround.add(new Position(this.position.getX(), this.position.getY() + 1));
            }
        }
        //Left
        if(this.world[this.position.getY()][this.position.getX()-1] != 1){
            this.arround.add(new Position(this.position.getX()-1, this.position.getY()));
        }
    }
    /**
     * z�hlt wieviele Dots noch �brig sind
     * @return
     */
    public int countDots(){
        int counter = 0;
        for(int y = 0; y < world.length; y++){
            for(int x = 0; x < world[0].length; x++){
                if(world[y][x] == 4){
                    counter++;
                }
            }
        }
        return counter;
    }


    private Position setPosition(){
        for(int y = 0; y < world.length; y++){
            for(int x = 0; x < world[0].length; x ++){
                if(world[y][x] == 5 || world[y][x] == 9){
                    return new Position(x,y);
                }
            }
        }

        System.err.println("Agent wurde nicht gefunden");
        printWorld();
        this.STOP();
        return new Position(-1, -1);
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof State){
            State s2 = (State) obj;
            return this.position.equals(s2.getPosition());
        }
        return false;
    }

    public String toString(){
        return "Position: " + this.position + ", Dots uebrig: " + this.dots + ", Wegkosten: " + this.pathCost + "\n";
    }

    /* Getter & Setter */
    public int getDots() {
        return dots;
    }

    public int[][] getWorld() {
        return world;
    }

    public int getPathCost() {
        return pathCost;
    }

    public ArrayList<Position> getArround() {
        return arround;
    }

    public int getX(){
        return this.position.getX();
    }

    public int getY(){
        return this.position.getY();
    }

    public Position getPosition() {
        return position;
    }

    public State getParent() {
        return parent;
    }

    public void setParent(State parent) {
        this.parent = parent;
    }
    /*TEST */
    public void printWorld(){
        for(int y = 0; y < this.world.length; y++){
            for(int x = 0; x < this.world[0].length; x++){
                System.out.print(this.world[y][x] + " | ");
            }
            System.out.println();
        }
    }

    public void printState(){
        System.out.println("----------STATE:");
        printWorld();
        System.out.println("Wegkosten: " + this.getPathCost());
        System.out.println("Position: " + this.getPosition());
        System.out.println("Arround: " + this.getArround().size());
        System.out.println("Dots uebrig: " + this.countDots());
    }

    public void STOP(){
        try {
            System.out.println("STOP !! TEST");
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}