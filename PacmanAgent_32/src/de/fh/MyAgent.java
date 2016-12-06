package de.fh;

import de.fh.agentI.IAction;
import de.fh.agentI.IAgentActions;
import de.fh.agentI.IAgentState;
import de.fh.connection.ActionEffect;
import de.fh.connection.Percept;
import de.fh.connection.StartInfo;
import de.fh.connection.Vector2;
import de.fh.connection.client.PacmanClientConnector;
import de.fh.connection.pacman.PacmanAction;
import de.fh.connection.pacman.PacmanPercept;
import de.fh.connection.pacman.PacmanStartInfo;

import java.util.ArrayList;
import java.util.LinkedList;

class MyAgent implements IAgentActions, IAgentState {

    private PacmanAction nextAction = PacmanAction.GO_EAST;
    private PacmanPercept percept;
    private int actionEffect;
    private PacmanStartInfo agentStartInfo;
    /* eigene */
    private int steps;
    private LinkedList<Position> perfectWay;
    private Position pacmanPosition;
    private SearchAlgo searchAlgo;
    private ArrayList<State> closedList;
    private int[][] world;
    private int gefresseneDots;

    public static void main(String[] args) {
        MyAgent ki = new MyAgent();
        PacmanClientConnector pacmanClient = new PacmanClientConnector(ki, ki);
        pacmanClient.run();
    }

    @Override
    public void setStartInfo(StartInfo startInfo) {
        this.steps = 0;
        this.gefresseneDots = 0;
        this.pacmanPosition = new Position(5,5);
        this.searchAlgo = new SearchAlgo();
        this.closedList = new ArrayList<>();
        this.agentStartInfo = (PacmanStartInfo) startInfo;
        System.out.println(agentStartInfo.toString());
    }


    @Override
    public void updateState(Percept percept, int actionEffect) {
        System.out.println("-UPDATE------------------------------");
        // WELT
        this.actionEffect = actionEffect;
        switch (actionEffect) {
            case ActionEffect.SUCCESS:
                this.updatePacmanPosition();
                this.steps++;
                System.out.println("Steps: " + this.steps);
                break;
            case ActionEffect.DOT_EATEN:
                break;
            case ActionEffect.INVALID_LOCATION:
                break;
            case ActionEffect.NO_DOT_FOUND:
                break;
            default:
                //Startsituation - aller erster Aufruf!
                break;
        }

        this.percept = (PacmanPercept) percept;
        int[][] view = this.mirrorView(this.percept.getView());
        this.updateWorld(view);
    }

    @Override
    public IAction chooseAction() {

        if (percept.isDotBelow()) {
            System.out.println("DOT BELOW");
            this.gefresseneDots++;
            return PacmanAction.EAT;
        }

        // Alle möglichen Serverrückmeldungen:
        switch (actionEffect) {
            case ActionEffect.SUCCESS:
                break;
            case ActionEffect.DOT_EATEN:
                break;
            case ActionEffect.INVALID_LOCATION:
                break;
            case ActionEffect.NO_DOT_FOUND:
                break;
            default:
                //Startsituation - aller erster Aufruf!
                break;
        }
        //aktuelle State anlegen
        State state = new State(this.world);
        //Dot mit bester Performance suchen
        
        State targetState = this.searchAlgo.findBestPerformance(state, true);
       
        if(targetState != null) {
            Position bestPerformance = targetState.getPosition();
            System.out.println("PERFORMANCE (p): " + targetState.getPerformance() + " zur Position " + bestPerformance + " von " + this.pacmanPosition);
            //Finde Weg zur Position
            this.searchAlgo.findWay(state, bestPerformance);
            this.perfectWay = this.searchAlgo.getWay();
            if(this.perfectWay.size() > 0 && this.perfectWay != null) {
                Position nextPosi = this.perfectWay.pollLast();
                this.nextAction = this.getNextAction(nextPosi);
            }
        }

        if(this.perfectWay == null || targetState == null){
            System.out.println("TOTAL STEPS: " + this.steps);
            System.out.println("Gefressene Dots: " + this.gefresseneDots);
            this.STOP();
            this.nextAction = PacmanAction.EXIT_TRIAL;
        }
        return nextAction;
    }

    /**
     * Gibt die Nächste Action des Pacman zurück, auf die nächste Position
     * @return
     * @param
     */
    public PacmanAction getNextAction(Position nPosi){
        assert (nPosi != null);
        if(this.pacmanPosition.getX() == nPosi.getX() && this.pacmanPosition.getY() < nPosi.getY()){
            System.out.println("GO SOUTH");
            return PacmanAction.GO_SOUTH;
        }else if(this.pacmanPosition.getX() == nPosi.getX() && this.pacmanPosition.getY() > nPosi.getY()){
            System.out.println("GO NORTH");
            return PacmanAction.GO_NORTH;
        }else if(this.pacmanPosition.getX() < nPosi.getX() && this.pacmanPosition.getY() == nPosi.getY()){
            System.out.println("GO EAST");
            return PacmanAction.GO_EAST;
        }else if(this.pacmanPosition.getX() > nPosi.getX() && this.pacmanPosition.getY() == nPosi.getY()){
            System.out.println("GO WEST");
            return PacmanAction.GO_WEST;
        }
        System.out.println("FAIL: getNextAction");
        return null;
    }


    /**
     * spiegelt die View in richtiger x/y Ansicht
     * @param view
     * @return
     */
    public int[][] mirrorView(int[][] view){
        int[][] tmp = new int[view[0].length][view.length];

        for(int y = 0; y < view.length; y++){
            for(int x = 0; x < view[0].length; x++){
                tmp[x][y] = view[y][x];
            }
        }
        return tmp;
    }

    public Position findMove(State state){
        LinkedList<State> openList = new LinkedList<>();
        for(Position posi: state.getArround()){
            State child;
            if(state.getWorld()[posi.getY()][posi.getX()] == 4){
                child = state.move(posi, true);
            }else{
                child = state.move(posi, false);
            }

            //wenn der Nachfolgeknoten bereits auf der ClosedListe ist - tue nichts
            if(closedList.contains(child)){
                continue;
            }

            if(openList.contains(child)){
                openList.remove(child);
            }else {
                openList.add(child);
            }
        }
        State way = openList.poll();
        this.closedList.add(way);
        return way.getPosition();
    }

    public void updateWorld(int[][] view) {
        System.out.println("Update der Welt");
        int vx = 0;
        int vy = 0;
        if (this.world == null) {
            System.out.println("Welt wird erstellt");
            this.world = new int[8][8];
            for (int y = 0; y < this.world.length; y++) {
                for (int x = 0; x < this.world[0].length; x++) {
                    // Mauern = unendeckt
                    this.world[y][x] = 1;
                    if(y>2 && x>2){
                        this.world[y][x] = view[vy][vx];
                        vx++;
                        if(vx == 5){vx = 0;}
                    }
                }
                if(y>2){vy++;}
                if(vy == 5){vy = 0;}
            }
        }
        else {
            // zwischenspeichern der Welt
            int[][] tmp = this.world;

            // neue Arraygroesse
            int newY = (this.pacmanPosition.getY() + 2 >= world[0].length) ? this.pacmanPosition.getY() + 3 : world[0].length;
            int newX = (this.pacmanPosition.getX() + 2 >= world.length) ? this.pacmanPosition.getX() + 3 : world.length;
            this.world = new int[newY][newX];
            // initial auf 1 = Wand = nicht begehbar == erkundet
            for (int y = 0; y < newY; y++) {
                for (int x = 0; x < newX; x++) {
                    this.world[y][x] = 1;
                }
            }
            // tmp reinkopieren
            for (int y = 0; y < tmp.length; y++) {
                for (int x = 0; x < tmp[0].length; x++) {
                    this.world[y][x] = tmp[y][x];
                }
            }
            //view reinkopieren
            vx = this.pacmanPosition.getX() - 2;
            vy = this.pacmanPosition.getY() - 2;
            int xStart = 0;
            int xEnd = view[0].length;
            int yStart = 0;
            int yEnd = view.length;
            //oben
            if (this.pacmanPosition.getY() == 1) {
                yStart = 1;
                vy = 0;
            }
            //unten
            if (this.pacmanPosition.getY() == this.world.length - 2) {
                yEnd = 3;
            }
            //links
            if (this.pacmanPosition.getX() == 1) {
                xStart = 1;
                vx = 0;
            }
            // rechts
            if (this.pacmanPosition.getX() == this.world[0].length - 2) {
                xEnd = 3;
            }
            for (int y = yStart; y < yEnd; y++) {
                for (int x = xStart; x < xEnd; x++) {
                    if (view[y][x] != -1) {
                        this.world[vy][vx] = view[y][x];
                    } else {
                        this.world[vy][vx] = 1;
                    }
                    vx++;
                }
                if (this.pacmanPosition.getX() == 1) {
                    vx = 0;
                } else {
                    vx = this.pacmanPosition.getX() - 2;
                }
                vy++;
            }
        }
    }


    public void updatePacmanPosition() {
        if (this.nextAction == PacmanAction.GO_SOUTH) {
            this.pacmanPosition.incY();
        } else if (nextAction == PacmanAction.GO_EAST) {
            this.pacmanPosition.incX();
        } else if (this.nextAction == PacmanAction.GO_WEST) {
            this.pacmanPosition.decX();
        } else if (this.nextAction == PacmanAction.GO_NORTH) {
            this.pacmanPosition.decY();
        }
    }


/* TEST */
    public void STOP(){
        try {
            System.out.println("STOP !! TEST");
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void printWorld(int[][] maze){
        for(int y = 0; y < maze.length; y++){
            for(int x = 0; x < maze[0].length; x++){
                System.out.print(maze[y][x] + " | ");
            }
            System.out.println();
        }
    }

    public void printWay(){
        for(Position posi: this.perfectWay){
            System.out.println("Posi: " + posi);
        }
    }

}