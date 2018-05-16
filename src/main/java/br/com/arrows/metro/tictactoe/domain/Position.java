package br.com.arrows.metro.tictactoe.domain;

public class Position {

	private int x, y;
	private Player player;
	private Status status;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
		this.status = Status.OPEN;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public boolean mark(int i, int j, Player player) {
		if(this.status.equals(Status.CLOSED)) { return false; }
		if(player == null) { throw new IllegalArgumentException(); }
		this.x = i;
		this.y = j;
		this.player = player;
		this.status = Status.CLOSED;
		return true;
	}
	
}
