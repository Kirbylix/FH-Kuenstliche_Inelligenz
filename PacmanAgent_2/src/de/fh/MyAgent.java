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

import java.util.LinkedList;

class MyAgent implements IAgentActions, IAgentState {

    private PacmanAction nextAction = PacmanAction.GO_EAST;
    private PacmanPercept percept;
    private int actionEffect;
    private PacmanStartInfo agentStartInfo;
    /* eigene */
    private int steps;
    private String search = "A";
    private LinkedList<Position> perfectWay;

    public static void main(String[] args) {
        MyAgent ki = new MyAgent();
        PacmanClientConnector pacmanClient = new PacmanClientConnector(ki, ki);
        pacmanClient.run();
    }

    @Override
    public void setStartInfo(StartInfo startInfo) {
        this.steps = 0;
        this.agentStartInfo = (PacmanStartInfo) startInfo;
        System.out.println(agentStartInfo.toString());
    }


    @Override
    public void updateState(Percept percept, int actionEffect) {
        System.out.println("-UPDATE------------------------------");
        // WELT
        this.percept = (PacmanPercept) percept;
        int[][] world = this.mirrorView(this.percept.getView());
        System.out.println("Viewsize X: " + world[0].length + " | Y:" + world.length);

        if(this.perfectWay == null && world[0][0] != 0){
            State state = new State(world);
            SearchAlgo searchAlgo = new SearchAlgo(this.search);
            this.perfectWay = searchAlgo.findWay(state).getWay();
        }

        this.actionEffect = actionEffect;
        switch (actionEffect) {
            case ActionEffect.SUCCESS:
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
        System.out.println("Agent Posi: " + this.percept.getPosition());
    }

    @Override
    public IAction chooseAction() {

        if (percept.isDotBelow()) {
            System.out.println("DOT BELOW");
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

        if(!this.perfectWay.isEmpty()) {
            System.out.println("setzte neuen Weg");
            Position nextPosi = this.perfectWay.pollFirst();
            Position agentPosi = new Position(this.percept.getPosition().getX(), this.percept.getPosition().getY());
            System.out.println("agent Posi: " + agentPosi);
            System.out.println("next Posi: " + nextPosi);
            this.nextAction = this.getNextAction(nextPosi, this.percept.getPosition());
        }else{
            System.out.println("TOTAL STEPS: " + this.steps);
            this.nextAction = PacmanAction.EXIT_TRIAL;
        }

        return nextAction;
    }

    /**
     * Gibt die Nächste Action des Pacman zurück, auf die nächste Position
     * @return
     * @param
     */
    public PacmanAction getNextAction(Position nPosi, Vector2 aPosi){

        if(aPosi.getX() == nPosi.getX() && aPosi.getY() < nPosi.getY()){
            System.out.println("GO SOUTH");
            return PacmanAction.GO_SOUTH;
        }else if(aPosi.getX() == nPosi.getX() && aPosi.getY() > nPosi.getY()){
            System.out.println("GO NORTH");
            return PacmanAction.GO_NORTH;
        }else if(aPosi.getX() < nPosi.getX() && aPosi.getY() == nPosi.getY()){
            System.out.println("GO EAST");
            return PacmanAction.GO_EAST;
        }else if(aPosi.getX() > nPosi.getX() && aPosi.getY() == nPosi.getY()){
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

}