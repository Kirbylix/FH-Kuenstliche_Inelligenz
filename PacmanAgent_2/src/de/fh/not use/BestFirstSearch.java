package de.fh;

import java.util.*;

public class BestFirstSearch{
    private PriorityQueue<State> prioQueue;
    private BFSComperator comp = new BFSComperator();

    /**
     * Konstruktor
     * @param
     */
    public BestFirstSearch() {
        this.prioQueue = new PriorityQueue<State>(comp);
    }

    /**
     * Löst das Masze nach bfs
     * @param state
     * @return
     */
    public State findWay(State state){
        System.out.println("Starte BFS");
        if(state.getDots() == 0){
            System.out.println("Maze geloest, Loesung gefunden");
            return state;
        }
        this.prioQueue.add(state);
        while(!this.prioQueue.isEmpty()){
            State currentState = this.prioQueue.poll();
            ArrayList<Position> env = currentState.getArround();
            if(env.size() >= 1) {
                boolean dot = false;
                //Prüft ob ein Dot in der nähe ist
                for (Position posi1 : env) {
                    if (currentState.getWorld()[posi1.getY()][posi1.getX()] == 4) {
                        dot = true;
                    }
                }
                State child;
                // Dot ist in der nähe
                if (dot) {
                    ArrayList<Position> delete = new ArrayList<>();
                    // entfernt die Positionen ohne Dots
                    for (Position posi2 : env) {
                        if (currentState.getWorld()[posi2.getY()][posi2.getX()] == 0) {
                            delete.add(posi2);
                        }
                    }
                    if(delete.size() > 0) {
                        for (Position posi3 : delete) {
                            env.remove(posi3);
                        }
                    }
                    for(Position posi: env){
                        child = currentState.move(posi);
                        if (child.getDots() == 0) {
                            return child;
                        }
                        this.prioQueue.add(child);
                    }
                }else{
                    child = findNextDot(currentState);
                    if (child.getDots() == 0) {
                        return child;
                    }
                    this.prioQueue.add(child);
                }
            }
        }
        System.out.println("Keine L�sung gefunden");
        return null;
    }

    /**
     * Findet den neachsten Dot nach Breitensuche
     * @param root
     * @return
     */
    public State findNextDot(State root){
        ArrayList<Position> explored = new ArrayList<>();
        State field;                                            // Hilfsbaum
        LinkedList<State> liste = new LinkedList<>();           // Liste
        if(root != null){
            liste.add(root);                                    // root in Liste
        }
        while(!liste.isEmpty()){                                // solange Liste nicht leer
            field = liste.poll();                               // hole erste State + L�sche Sie

            if(field.getWorld()[field.getY()][field.getX()] == 9){  // falls Dot gefunden -> return
                return field;
            }

            /* weiter wandern */
            for(Position posi: field.getArround()) {
                if(!explored.contains(posi)) {
                    State child = field.move(posi);

                    if (field.getWorld()[posi.getY()][posi.getX()] == 4) {                   // neue Posi = Dot
                        return child;
                    } else {      // kein Dot an Posi
                        liste.add(child);
                    }
                    explored.add(posi);
                }
            }
        }
        System.err.println("KEIN DOT GEFUNDEN !");
        return null;
    }

    // Test
    public void printPQeue(){
        System.out.println("Qeue Size: " + this.prioQueue.size() + ":");
        System.out.println(this.prioQueue);
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
