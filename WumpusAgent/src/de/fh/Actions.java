package de.fh;

import environment.World;
import environment.WorldInterface;
import goals.Goal;

import java.util.Random;

public class Actions implements WorldInterface{
    private final Goal[] goals;
    private static final Random random = null;
    private final int[] ratings;
    private State state;
    private World world;

    /**
     * Konstruktor
     * @param _state State
     */
    public Actions(State _state){
        this.state = _state;
        this.goals = null;
        this.ratings = null;
    }

    /**
     * Waehelt die auszufuehrende Aktion aus
     * @return
     */
    public int chooseAction(){
        //TODO
        return -1;
    }

    /**
     * Bewertet alle Ziele, und schiebt das sinnvollste auf Position 0 im Array goals
     */
    private void rateGolas(){

    }

    /**
     * Tauscht die Positionen zweier Eintraege im Array goals
     * @param g1 Goal 1
     * @param g2 Goal 2
     */
    private void swapGoals(int g1, int g2){
        //TODO
    }

    @Override
    public World getWorld() {
        return this.world;
    }
}
