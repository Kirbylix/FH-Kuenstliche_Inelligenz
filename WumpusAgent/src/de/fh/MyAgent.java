package de.fh;

import de.fh.agentI.IAction;
import de.fh.agentI.IAgentActions;
import de.fh.agentI.IAgentState;
import de.fh.connection.ActionEffect;
import de.fh.connection.Percept;
import de.fh.connection.StartInfo;
import de.fh.connection.client.WumpusClientConnector;
import de.fh.connection.wumpus.AgentAction;
import de.fh.connection.wumpus.AgentPercept;
import de.fh.connection.wumpus.AgentStartInfo;

class MyAgent implements IAgentActions, IAgentState {

	private AgentAction nextAction = AgentAction.GO_FORWARD;
	private AgentPercept percept;
	private int actionEffect;
	private AgentStartInfo agentStartInfo;
	//Eigene
	private State state;
	private Actions action;
	private boolean addon = false;


	public static void main(String[] args) {
		MyAgent ki = new MyAgent();
		WumpusClientConnector wumpusClient = new WumpusClientConnector(ki, ki);
		wumpusClient.run();
	}

	@Override
	public void setStartInfo(StartInfo startInfo) {
		this.agentStartInfo = (AgentStartInfo) startInfo;
		this.state = new State(this.agentStartInfo);
		this.action = new Actions(this.state);

		//this.agentStartInfo.getSteps();
		//this.agentStartInfo.getTeams();
		//this.agentStartInfo.isMovableWumpi();
		//this.agentStartInfo.isTeamsActive();
		//this.agentStartInfo.getFieldSize();
		//this.print("" +this.agentStartInfo.getShoots());

		System.out.println(agentStartInfo.toString());
	}


	@Override
	public void updateState(Percept percept, int actionEffect) {

		this.actionEffect = actionEffect;
		switch (actionEffect) {
			case ActionEffect.SUCCESS:
				this.state.setScore(-1);
				break;
			case ActionEffect.GOLD_FOUND:
				this.state.setScore(100);
				this.state.setGoldFound(true);
				break;
			case ActionEffect.GOLD_NOT_FOUND:
				this.state.setGoldFound(false);
				break;
			case ActionEffect.INVALID_LOCATION:
				break;
			case ActionEffect.WUMPUS_KILLED:
				this.state.setScore(75);
				break;
			case ActionEffect.WUMPUS_NOT_KILLED:
				break;
			default:
				//Startsituation - aller erster Aufruf!
				break;
		}

		this.percept = (AgentPercept) percept;
		this.state.updateState((AgentPercept) percept);


		//Beispiel:
		// In diesem Array kann man den Wumpus vielleicht wahrnehmen,
		// wenn nah genug
		for (int i = 0; this.percept.getWumpusStenchRadar()[i][0] != 0; i++){
			System.out.println("Dis: [" + this.percept.getWumpusStenchRadar()[i][0] + "]: "
					+ this.percept.getWumpusStenchRadar()[i][1]);
		}

		// Der Wumpus hat das Feld gewechselt
		if (this.percept.isRumble() == true) {
			System.out.println("<------- Der Wumpus bewegt sich! ------->");
		}

		if (this.percept.isBreeze() == true) {
			System.out.println("<------- Der Agent spürt eine briese! ------->");
		}

		if (this.percept.isBump() == true) {
			System.out.println("<------- BUMB ???? ------->");
		}

		if (this.percept.isScream() == true) {
			System.out.println("<------- Der Pfeil hat einen Wumpus getroffen! ------->");
		}

		if (this.percept.isStench() == true) {
			System.out.println("<------- STENCH! ------->");
		}




		System.out.println("-----------");
	}

	@Override
	public IAction chooseAction() {
		//Spiel beenden
		if(this.state.getRound() == 1000 || (this.state.isGoldFound() && !this.addon)){
			System.out.println("Punktestand: " + this.state.getScore());
			System.out.println("Anzahl abgefuerte Pfeile: " + this.state.shootedArrow());
			System.out.println("Wumpus getötet: " + this.state.wasAWumpusKilled());
			System.out.println("Gold gefunden: " + this.state.isGoldFound());
			return AgentAction.EXIT_TRIAL;
		}

		//Gold gefunden -> GRAB
		if (percept.isGold()) {
			System.out.println("GOLD BELOW");
			return AgentAction.GRAB;
		}



		nextAction = AgentAction.GO_FORWARD;

		switch (actionEffect) {
			case ActionEffect.INVALID_LOCATION:
				nextAction = AgentAction.TURN_RIGHT;
				break;
		}
		return nextAction;
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

	public void printWorld(int[][] maze){
		for(int y = 0; y < maze.length; y++){
			for(int x = 0; x < maze[0].length; x++){
				System.out.print(maze[y][x] + " | ");
			}
			System.out.println();
		}
	}

	public void print(Object _string){
		System.out.println(_string);
	}
}