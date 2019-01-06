package com.ptc.plms.gol.oops.util;

import com.ptc.plms.gol.oops.Cell;
import com.ptc.plms.gol.oops.State;

import java.util.HashSet;
import java.util.Set;

public class NeighboursUtil
{
  public static Set<Cell> findNeighbours(Cell cell, Set<Cell> liveCells)
  {
    Set<Cell> neighbours = new HashSet<>();

    int x = cell.getX();
    int y = cell.getY();
    Cell tempCell;
    for (int i = x - 1; i <= x + 1; i++)
    {
      if (i < 0) continue;

      for (int j = y - 1; j <= y + 1; j++)
      {
        if (j < 0) continue;

        tempCell = new Cell(i, j);
        if (liveCells.contains(tempCell))
        {
          tempCell.setState(State.LIVE);
        }
        neighbours.add(tempCell);
      }
    }
    return neighbours;
  }

  public static int findLiveNeighbourCount(Cell cell, Set<Cell> liveCells)
  {
    int count = 0;
    Set<Cell> neighbours = findNeighbours(cell, liveCells);
    for (Cell c : neighbours)
    {
      if (State.LIVE.equals(c.getState())) count++;
    }
    return count;
  }
}
