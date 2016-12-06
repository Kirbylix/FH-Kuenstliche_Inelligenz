package de.fh;

import java.util.*;

public class SearchAlgo {
    private PriorityQueue<State> openListA;
    private PriorityQueue<State> openListG;
    private AStarComperator aComp = new AStarComperator();
    private GreedyComperator gComp = new GreedyComperator();
    private ArrayList<State> closedList;
    private State finalState;

    /**
     * Konstruktor
     * @param
     */
    public SearchAlgo() {
    	this.openListG = new PriorityQueue<State>(gComp);
    	this.openListA = new PriorityQueue<State>(aComp);
        this.closedList = new ArrayList<State>();
    }

    /**
     * findet den Weg
     * @return
     * @param state
     */
    public void findWay(State state, Position target) {
        //OpenList leeren
        this.openListA.clear();
        this.finalState = null;
        this.closedList.clear();
        // Initialisierung der OpenList, die ClosedList ist noch leer
        this.openListA.add(state);
        //bis eine oder keine Lösung gefunden worden ist
        do{
            //Knoten mit dem geringsten f Wert aus der OpenList entfernen
            State currentState = this.openListA.poll();
            //sind alle Dots gefressen
            if(currentState.getPosition().equals(target)){
                System.out.println("Weg zum Target gefunden");
                this.finalState = currentState;
            }
            //Die aktuelle State soll durch nachfolgende Aktionen nicht weriter unstersucht werden
            this.closedList.add(currentState);
            //NachfolgeStates untersuchen
            expandState(currentState);
        }while(!this.openListA.isEmpty());
        //System.err.println("Keine Loesung gefunden");
    }

    public void expandState(State currentState){
        for(Position posi: currentState.getArround()){
            State child;
            if(currentState.getWorld()[posi.getY()][posi.getX()] == 4){
                child = currentState.move(posi, true);
            }else{
                child = currentState.move(posi, false);
            }
            //wenn der Nachfolgeknoten bereits auf der ClosedListe ist - tue nichts

            if(closedList.contains(child)){
                continue;
            }

            child.setParent(currentState);

            if(this.openListA.contains(child)){
                this.openListA.remove(child);
            }else {
                this.openListA.add(child);
            }
        }
    }

    public State findBestPerformance(State root, boolean hillClimb){
        this.openListG.clear();
        this.closedList.clear();
        ArrayList<Position> explored = new ArrayList<>();       // schon besuchten Felder
        State field;                                            // Hilfsbaum
        LinkedList<State> liste = new LinkedList<>();           // Liste
        if(root != null){
            liste.add(root);                                    // root in Liste
        }
        while(!liste.isEmpty()){                                // solange Liste nicht leer
            field = liste.poll();                               // hole erste State + L�sche Sie
            explored.add(field.getPosition());

            /* weiter wandern */
            for(Position posi: field.getArround()) {
                if(!explored.contains(posi)) {
                    State child;
                    if(field.getWorld()[posi.getY()][posi.getX()] == 4){
                        child = field.move(posi, true);
                        //HILL Climb
                        if(hillClimb){
                            if(child.getPerformance() >= 0) {
                                this.openListG.add(child);
                            }
                        }else{
                            this.openListG.add(child);
                        }

                    }else{
                        child = field.move(posi, false);
                    }
                    liste.add(child);
                }
            }
        }
        if(this.openListG.size() > 0){
            return this.openListG.poll();
        }else{
            return null;
        }
    }

    public LinkedList<Position> getWay()
    {
        if(this.finalState != null) {
            LinkedList<Position> way = new LinkedList<>();
            State state = this.finalState;
            do{
                way.add(state.getPosition());
                state = state.getParent();
            }while(state.getParent() != null);
            return way;
        }
        return null;
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
