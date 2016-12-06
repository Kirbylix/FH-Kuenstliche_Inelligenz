package de.fh;

import java.util.*;

public class SearchAlgo {
    private PriorityQueue<State> openList;
    private AStarComperator aComp = new AStarComperator();
    private ArrayList<State> closedList;
    private Position cherry;
    private State finalCherry;

    /**
     * Konstruktor
     * @param
     */
    public SearchAlgo(Position Cherry) {
        this.openList = new PriorityQueue<State>(aComp);
        this.closedList = new ArrayList<State>();
        this.cherry = Cherry;
    }

    /**
     * findet den Weg
     * @return
     * @param state
     */
    public void findWay(State state) {
        //OpenList leeren
        this.openList.clear();
        this.closedList.clear();
        // Initialisierung der OpenList, die ClosedList ist noch leer
        this.openList.add(state);
        //bis eine oder keine Lösung gefunden worden ist
        do{
            //Knoten mit dem geringsten f Wert aus der OpenList entfernen
            State currentState = this.openList.poll();
            //sind alle Dots gefressen
            if(currentState.getPosition().equals(this.cherry)){
                System.out.println("Loesung gefunden");
                this.finalCherry = currentState;
                continue;
            }
            //Die aktuelle State soll durch nachfolgende Aktionen nicht weriter unstersucht werden
            this.closedList.add(currentState);
            //NachfolgeStates untersuchen
            this.expandState(currentState);
        }while(!this.openList.isEmpty());
        System.err.println("Keine Loesung gefunden");
    }

    public void expandState(State currentState){
        for(Position posi: currentState.getArround()){
            State child = currentState.move(posi);
            //wenn der Nachfolgeknoten bereits auf der ClosedListe ist - tue nichts
            if(closedList.contains(child)){
                continue;
            }

            child.setParent(currentState);

            if(this.openList.contains(child)){
                this.openList.remove(child);
            }else {
                this.openList.add(child);
            }
        }
    }


    public LinkedList<Position> getWay()
    {
        if(this.finalCherry != null) {
            LinkedList<Position> way = new LinkedList<>();
            State state = this.finalCherry;
            do{
                way.add(state.getPosition());
                state = state.getParent();
            }while(state.getParent() != null);
            return way;
        }
        return null;
    }

//TEST
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
