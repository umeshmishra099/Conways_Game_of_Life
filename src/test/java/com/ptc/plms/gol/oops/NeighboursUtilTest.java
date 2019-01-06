package com.ptc.plms.gol.oops;

import com.ptc.plms.gol.oops.util.NeighboursUtil;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class NeighboursUtilTest
{
  @Test
  public void givenCellAtZeroZeroLocationWhenFindNeighboursCalledThenFourNeighboursReturned()
  {
    Set<Cell> neighbourCells = NeighboursUtil.findNeighbours(new Cell(0, 0), new HashSet<Cell>());
    assertEquals(4, neighbourCells.size());
  }

  @Test
  public void givenCellAtOneZeroLocationWhenFindNeighboursCalledThenSixNeighboursReturned()
  {
    Set<Cell> neighbourCells = NeighboursUtil.findNeighbours(new Cell(1, 0), new HashSet<Cell>());
    assertEquals(6, neighbourCells.size());
  }

  @Test
  public void givenCellAtTwoZeroLocationWhenFindNeighboursCalledThenSixNeighboursReturned()
  {
    Set<Cell> neighbourCells = NeighboursUtil.findNeighbours(new Cell(2, 0), new HashSet<Cell>());
    assertEquals(6, neighbourCells.size());
  }

  @Test
  public void givenCellAtOneOneLocationWhenFindNeighboursCalledThenNineNeighboursReturned()
  {
    Set<Cell> neighbourCells = NeighboursUtil.findNeighbours(new Cell(1, 1), new HashSet<Cell>());
    assertEquals(9, neighbourCells.size());
  }

  @Test
  public void givenCellAtTwoTwoLocationWhenFindNeighboursCalledThenNineNeighboursReturned()
  {
    Set<Cell> neighbourCells = NeighboursUtil.findNeighbours(new Cell(2, 2), new HashSet<Cell>());
    assertEquals(9, neighbourCells.size());
  }

  @Test
  public void givenCellWithNoLiveCellWhenFindLiveNeighbourCountCalledThenReturnZeroLiveNeighbourCount()
  {
    int liveNeighbourCount = NeighboursUtil.findLiveNeighbourCount(new Cell(0, 0), new HashSet<Cell>());
    assertEquals(0, liveNeighbourCount);
  }

  @Test
  public void givenCellWithOneLiveCellInNeighbourWhenFindLiveNeighbourCountCalledThenReturnOneLiveNeighbourCount()
  {
    HashSet<Cell> liveCells = new HashSet<>();
    liveCells.add(new Cell(0, 1, State.LIVE));

    int liveNeighbourCount = NeighboursUtil.findLiveNeighbourCount(new Cell(0, 0), liveCells);
    assertEquals(1, liveNeighbourCount);
  }

  @Test
  public void givenCellWithTwoLiveCellOneInNeighbourOneNotWhenFindLiveNeighbourCountCalledThenReturnOneLiveNeighbourCount()
  {
    HashSet<Cell> liveCells = new HashSet<>();
    liveCells.add(new Cell(0, 1, State.LIVE));
    liveCells.add(new Cell(5, 5, State.LIVE));

    int liveNeighbourCount = NeighboursUtil.findLiveNeighbourCount(new Cell(0, 0), liveCells);
    assertEquals(1, liveNeighbourCount);
  }

  @Test
  public void givenCellWithTwoLiveCellBothInNeighbourWhenFindLiveNeighbourCountCalledThenReturnTwoLiveNeighbourCount()
  {
    HashSet<Cell> liveCells = new HashSet<>();
    liveCells.add(new Cell(0, 1, State.LIVE));
    liveCells.add(new Cell(1, 1, State.LIVE));

    int liveNeighbourCount = NeighboursUtil.findLiveNeighbourCount(new Cell(0, 0), liveCells);
    assertEquals(2, liveNeighbourCount);
  }

  @Test
  public void givenCellWithThreeLiveCellTwoInNeighbourOneNotWhenFindLiveNeighbourCountCalledThenReturnTwoLiveNeighbourCount()
  {
    HashSet<Cell> liveCells = new HashSet<>();
    liveCells.add(new Cell(0, 1, State.LIVE));
    liveCells.add(new Cell(1, 1, State.LIVE));
    liveCells.add(new Cell(5, 5, State.LIVE));

    int liveNeighbourCount = NeighboursUtil.findLiveNeighbourCount(new Cell(0, 0), liveCells);
    assertEquals(2, liveNeighbourCount);
  }

  @Test
  public void givenCellWithThreeLiveCellAllInNeighbourWhenFindLiveNeighbourCountCalledThenReturnThreeLiveNeighbourCount()
  {
    HashSet<Cell> liveCells = new HashSet<>();
    liveCells.add(new Cell(0, 1, State.LIVE));
    liveCells.add(new Cell(1, 0, State.LIVE));
    liveCells.add(new Cell(1, 1, State.LIVE));

    int liveNeighbourCount = NeighboursUtil.findLiveNeighbourCount(new Cell(0, 0), liveCells);
    assertEquals(3, liveNeighbourCount);
  }

  @Test
  public void givenCellWithFourLiveCellAllInNeighbourWhenFindLiveNeighbourCountCalledThenReturnFourLiveNeighbourCount()
  {
    HashSet<Cell> liveCells = new HashSet<>();
    liveCells.add(new Cell(0, 0, State.LIVE));
    liveCells.add(new Cell(0, 1, State.LIVE));
    liveCells.add(new Cell(0, 2, State.LIVE));
    liveCells.add(new Cell(1, 0, State.LIVE));

    int liveNeighbourCount = NeighboursUtil.findLiveNeighbourCount(new Cell(1, 1), liveCells);
    assertEquals(4, liveNeighbourCount);
  }

  @Test
  public void givenCellWithFiveLiveCellAllInNeighbourWhenFindLiveNeighbourCountCalledThenReturnFiveLiveNeighbourCount()
  {
    HashSet<Cell> liveCells = new HashSet<>();
    liveCells.add(new Cell(0, 0, State.LIVE));
    liveCells.add(new Cell(0, 1, State.LIVE));
    liveCells.add(new Cell(0, 2, State.LIVE));
    liveCells.add(new Cell(1, 0, State.LIVE));
    liveCells.add(new Cell(2, 2, State.LIVE));

    int liveNeighbourCount = NeighboursUtil.findLiveNeighbourCount(new Cell(1, 1), liveCells);
    assertEquals(5, liveNeighbourCount);
  }

  @Test
  public void givenCellWithSixLiveCellAllInNeighbourWhenFindLiveNeighbourCountCalledThenReturnSixLiveNeighbourCount()
  {
    HashSet<Cell> liveCells = new HashSet<>();
    liveCells.add(new Cell(0, 0, State.LIVE));
    liveCells.add(new Cell(0, 1, State.LIVE));
    liveCells.add(new Cell(0, 2, State.LIVE));
    liveCells.add(new Cell(1, 0, State.LIVE));
    liveCells.add(new Cell(2, 0, State.LIVE));
    liveCells.add(new Cell(2, 2, State.LIVE));
    int liveNeighbourCount = NeighboursUtil.findLiveNeighbourCount(new Cell(1, 1), liveCells);
    assertEquals(6, liveNeighbourCount);
  }

  @Test
  public void givenCellWithSevenLiveCellAllInNeighbourWhenFindLiveNeighbourCountCalledThenReturnSevenLiveNeighbourCount()
  {
    HashSet<Cell> liveCells = new HashSet<>();
    liveCells.add(new Cell(0, 0, State.LIVE));
    liveCells.add(new Cell(0, 1, State.LIVE));
    liveCells.add(new Cell(0, 2, State.LIVE));
    liveCells.add(new Cell(1, 0, State.LIVE));
    liveCells.add(new Cell(2, 0, State.LIVE));
    liveCells.add(new Cell(2, 1, State.LIVE));
    liveCells.add(new Cell(2, 2, State.LIVE));
    int liveNeighbourCount = NeighboursUtil.findLiveNeighbourCount(new Cell(1, 1), liveCells);
    assertEquals(7, liveNeighbourCount);
  }

  @Test
  public void givenCellWithEightLiveCellAllInNeighbourWhenFindLiveNeighbourCountCalledThenReturnEightLiveNeighbourCount()
  {
    HashSet<Cell> liveCells = new HashSet<>();
    liveCells.add(new Cell(0, 0, State.LIVE));
    liveCells.add(new Cell(0, 1, State.LIVE));
    liveCells.add(new Cell(0, 2, State.LIVE));
    liveCells.add(new Cell(1, 0, State.LIVE));
    liveCells.add(new Cell(1, 2, State.LIVE));
    liveCells.add(new Cell(2, 0, State.LIVE));
    liveCells.add(new Cell(2, 1, State.LIVE));
    liveCells.add(new Cell(2, 2, State.LIVE));
    int liveNeighbourCount = NeighboursUtil.findLiveNeighbourCount(new Cell(1, 1), liveCells);
    assertEquals(8, liveNeighbourCount);
  }
}
