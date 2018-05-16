package br.com.arrow.metro;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {

	private Board board;
	
	@Before
	public void initBoard() {
		board = new Board(3);
	}
	
	@After
	public void clearBoardAfterTests()
	{
		board.clearBoard();
	}
	
	@Test
	public void whenTryMarkOpenPositionShouldMarkAsClosed()
	{
		board.markPosition(0,0, new Player("Joaquim", 'j'));
		Assert.assertEquals(Status.CLOSED, board.getPositionStatus(0,0));
	}
	
	@Test
	public void whenTryMarkOpenPositionShouldReturnTrue()
	{
		Assert.assertTrue(board.markPosition(0, 0, new Player("Joaquim", 'j')));
	}
	
	@Test
	public void whenTryMarkClosedPositionShouldReturnFalse()
	{
		Assert.assertTrue(board.markPosition(0, 0, new Player("Joaquim", 'j')));
		Assert.assertFalse(board.markPosition(0, 0, new Player("Joaquim", 'j')));
	}
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void whenTryMarkInvalidPositionShouldThrowOutArrayOfBoundsException()
	{
		board.markPosition(10, 10, new Player("Joaquim", 'j'));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void whenTryMarkAPositionWithoutAPlayerShouldThrowIllegalArgumentException()
	{
		board.markPosition(0, 0, null);
	}
	
	@Test
	public void whenGetStatusOfAClosedPositionShouldReturnClosed()
	{
		board.markPosition(0, 0, new Player("Joaquim", 'j'));
		Assert.assertEquals(Status.CLOSED, board.getPositionStatus(0, 0));
	}
	
	@Test
	public void whenGetStatusOfAnOpenPositionShouldReturnOpen()
	{
		Assert.assertEquals(Status.OPEN, board.getPositionStatus(0, 0));
	}
	
	@Test
	public void whenGetPlayerOfAndOpenPositionShouldReturnNull()
	{
		Assert.assertNull(board.getPlayerFromPosition(0,0));
	}
	
	@Test
	public void whenGetPlayerOfAndClosedPositionShouldReturnPlayer()
	{
		Player player = new Player("Joaquim", 'j');
		board.markPosition(0, 0, player);
		Assert.assertEquals(player, board.getPlayerFromPosition(0, 0));
	}
	
	@Test
	public void whenGetOpenPositionsShouldReturnList()
	{
		int positionsSize = new Double(Math.pow(board.getSize(), 2)).intValue();
		Assert.assertEquals(positionsSize, board.getOpenPositions().size());
	}
	
	@Test
	public void whenGetClosedPositionsShouldReturnList()
	{
		Assert.assertEquals(0, board.getClosedPositions().size());
	}
	
	@Test
	public void whenClearBoardShouldMarkAllPositionAsOpen()
	{
		int pos = board.getSize();
		for(int i = 0; i < pos; i++)
		{
			for(int j = 0; j < pos; j++) {
				Assert.assertTrue(board.getPositionStatus(i, j).equals(Status.OPEN));
			}
		}
	}
	
}
