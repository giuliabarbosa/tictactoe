package br.com.arrow.metro;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Board {

	private Set<Position> positions;
	private int size;
	
	public Board(int size) {
		this.size = size;
		positions = new HashSet<Position>();
		for (int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++)
			{
				positions.add(new Position(i,j));
			}
		}
	}

	public Status getPositionStatus(int i, int j) {
		return positions.stream()
				.filter(position -> position.getX() == i && position.getY() == j).findFirst()
				.map(position -> position.getStatus())
				.orElse(Status.OPEN);
	}

	public boolean markPosition(int i, int j, Player player) {
		Position position = positions.stream()
						.filter(p -> p.getX() == i && p.getY() == j).findFirst()
						.orElseThrow(() -> new ArrayIndexOutOfBoundsException(String.format("Position %d, %d is out of board", i,j)));
		return position.mark(i,j,player);
	}

	public int getSize() {
		return this.size;
	}

	public void clearBoard() {
		for (Position position : positions) {
			position.setStatus(Status.OPEN);
		}
		
	}

	public Player getPlayerFromPosition(int i, int j) {
		return positions.stream()
			.filter(position -> position.getX() == i && position.getY() == j).findFirst()
			.map(position -> position.getPlayer())
			.orElse(null);
	}

	public Set<Position> getOpenPositions() {
		return positions.stream().filter(x -> x.getStatus().equals(Status.OPEN)).collect(Collectors.toSet());
	}

	public Set<Position> getClosedPositions() {
		return positions.stream().filter(x -> x.getStatus().equals(Status.CLOSED)).collect(Collectors.toSet());
	}
	
	

}
