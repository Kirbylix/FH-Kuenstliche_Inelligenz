package de.fh;

import java.util.Random;

import de.fh.agentI.IAction;
import de.fh.agentI.IAgentActions;
import de.fh.agentI.IAgentState;
import de.fh.connection.ActionEffect;
import de.fh.connection.Percept;
import de.fh.connection.StartInfo;
import de.fh.connection.client.PacmanClientConnector;
import de.fh.connection.pacman.PacmanAction;
import de.fh.connection.pacman.PacmanPercept;
import de.fh.connection.pacman.PacmanStartInfo;
import de.fh.elements.Element;

class MyAgent implements IAgentActions, IAgentState {

    private PacmanAction nextAction = PacmanAction.GO_EAST;
    private PacmanPercept percept;
    private int actionEffect;
    private PacmanStartInfo agentStartInfo;

    public static void main(String[] args) {
        MyAgent ki = new MyAgent();
        // Client connect to the server with given predefined settings
        PacmanClientConnector pacmanClient = new PacmanClientConnector(ki, ki);
        pacmanClient.run();
    }

    @Override
    public void setStartInfo(StartInfo startInfo) {
        /**
         *In dem Startinfo Objekt befinden sich alle Startinformationen,
         *auf die die "interne Welt", die Wissenbasis aufbaut
         * Achtung: Die Feldgröße ist im Standard unbekannt also -1
         */
        this.agentStartInfo = (PacmanStartInfo) startInfo;
        //Startinformationen einmal ausgeben
        System.out.println("Agent Start Info: " + agentStartInfo.toString());
    }

    @Override
    public void updateState(Percept percept, int actionEffect) {
    	System.out.println("-------------------------------");
    	// percept.getView() enthält die aktuelle Felderbelegung je nach Level/Sichtweite in einem Array
        this.percept = (PacmanPercept) percept;
        int[][] view = this.percept.getView();
        System.out.println("viewsize: " + view.length + "*" + view[0].length);
        System.out.println("position: " + this.percept.getPosition());
        
	    this.actionEffect = actionEffect;
	    switch (actionEffect) {
	        case ActionEffect.SUCCESS:
	        	System.out.println("updateState -> SUCCESS: " + actionEffect);
	            break;
	        case ActionEffect.DOT_EATEN:
	        	System.out.println("updateState -> DOT_EATEN: " + actionEffect);
	            break;
	        case ActionEffect.INVALID_LOCATION:
	        	System.out.println("updateState -> INVALID_LOCATION: " + actionEffect);
	            break;
	        case ActionEffect.NO_DOT_FOUND:
	        	System.out.println("updateState -> NO_DOT_FOUND: " + actionEffect);
	            break;
	        default:
	            //Startsituation - aller erster Aufruf!
	            break;
	    }
    }

    @Override
    public IAction chooseAction() {
    	
    	System.out.println("-------------------------------");
    	
    	//Serverrückmeldungen:
        switch (actionEffect) {
            case ActionEffect.SUCCESS:
            	System.out.println("chooseAction -> SUCCESS: " + actionEffect);
                break;
            case ActionEffect.DOT_EATEN:
            	System.out.println("chooseAction -> DOT_EATEN: " + actionEffect);
                break;
            case ActionEffect.INVALID_LOCATION:
            	System.out.println("chooseAction -> INVALID_LOCATION: " + actionEffect);
            	return this.nextAction = this.getRightDirection();
            case ActionEffect.NO_DOT_FOUND:
            	System.out.println("chooseAction -> NO_DOT_FOUND: " + actionEffect);
                break;
            case ActionEffect.GOLD_NOT_FOUND:
            	System.out.println("chooseAction -> GOLD NOT FOUND: " + actionEffect);
            	break;
            default:
                //Startsituation - aller erster Aufruf!
                break;
        }
        
        System.out.println("Percept/ Element: " + this.getPercept(0,0));
    	if (this.getPercept(0,0) == Element.AGENT_GOLD) {
            System.out.println("DOT BELOW");
            return PacmanAction.EAT;
        }
        
        Random random = new Random();
        int count = random.nextInt(6);
        if(count == 1){
        	this.nextAction = this.getRightDirection();
        }else if(count == 2){
        	this.nextAction = this.getLeftDirection();
        }
        return nextAction;
    }
    
    public PacmanAction getRightDirection(){
    	System.out.println("GO RIGHT");
    	PacmanAction nextDirection = null;
    	switch(this.nextAction){
    	case GO_EAST:
    		nextDirection = PacmanAction.GO_SOUTH; 
    		break;
    	case GO_NORTH:
    		nextDirection = PacmanAction.GO_EAST;
    		break;
    	case GO_SOUTH:
    		nextDirection = PacmanAction.GO_WEST;
    		break;
    	case GO_WEST:
    		nextDirection = PacmanAction.GO_NORTH;
    		break;
    	default:
    		break;
    	}
    	return nextDirection;
    }
    
    public PacmanAction getLeftDirection(){
    	System.out.println("GO Left");
    	PacmanAction nextDirection = null;
    	switch(this.nextAction){
    	case GO_EAST:
    		nextDirection = PacmanAction.GO_NORTH; 
    		break;
    	case GO_NORTH:
    		nextDirection = PacmanAction.GO_WEST;
    		break;
    	case GO_SOUTH:
    		nextDirection = PacmanAction.GO_EAST;
    		break;
    	case GO_WEST:
    		nextDirection = PacmanAction.GO_SOUTH;
    		break;
    	default:
    		break;
    	}
    	return nextDirection;
    }
    
    public int getPercept(int x, int y){
    	int[][] view = this.percept.getView();
        
        switch(view[x][y]){
        case Element.OUT_OF_RANGE:
        	return Element.OUT_OF_RANGE;
        case Element.FREE:
        	return Element.FREE;
        case Element.WALL:
        	return Element.WALL;
        case Element.GOLD:
        	return Element.GOLD;
        case Element.AGENT:
        	return Element.AGENT;
        case Element.CHERRY:
        	return Element.CHERRY;
        case Element.AGENT_CHERRY:
        	return Element.AGENT_CHERRY;
        case Element.AGENT_GOLD:
        	return Element.AGENT_GOLD;
        default:
        	return 42;
        }
    }
}