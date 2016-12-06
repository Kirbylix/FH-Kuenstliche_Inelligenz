package de.fh;

import java.util.*;

public class SearchAlgo {
    private PriorityQueue<State> openList;
    private AStarComperator aComp = new AStarComperator();
    private BFSComperator bComp = new BFSComperator();
    private ArrayList<State> closedList;

    /**
     * Konstruktor
     * @param
     */
    public SearchAlgo(String algo) {
        assert (algo != null);
        switch(algo){
            case "A":
                System.out.println("Der Weg wird mit AStar gesucht");
                this.openList = new PriorityQueue<State>(aComp);
                break;
            case "B":
                System.out.println("Der Weg wird mit BestFirstSearch gesucht");
                this.openList = new PriorityQueue<State>(bComp);
                break;
            default:
                System.out.println("SearchAlgo = A, BestFirst Search = B");
                break;
        }

        this.closedList = new ArrayList<State>();
    }

    /**
     * findet den Weg
     * @return
     * @param state
     */
    public State findWay(State state) {
        // Initialisierung der OpenList, die ClosedList ist noch leer
        this.openList.add(state);
        //bis eine oder keine Lösung gefunden worden ist
        do{
            //Knoten mit dem geringsten f Wert aus der OpenList entfernen
            State currentState = this.openList.poll();
            //sind alle Dots gefressen
            if(currentState.getDots() == 0){
                System.out.println("Maze geloest, Loesung gefunden");
                return currentState;
            }
            //Die aktuelle State soll durch nachfolgende Aktionen nicht weriter unstersucht werden
            this.closedList.add(currentState);
            //NachfolgeStates untersuchen
            expandState(currentState);
        }while(!this.openList.isEmpty());
        System.err.println("Keine L�sung gefunden");
        return null;
    }

    public void expandState(State currentState){
        for(Position posi: currentState.getArround()){
            State child = currentState.move(posi);
            //wenn der Nachfolgeknoten bereits auf der ClosedListe ist - tue nichts

            if(closedList.contains(child)){
                continue;
            }

            //child.setfScore(child.getPathCost() + child.getDots());
            if(this.openList.contains(child)){
                this.openList.remove(child);
            }else {
                this.openList.add(child);
            }
        }
    }
}
