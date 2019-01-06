package com.ptc.plms.gol.oops;

import com.ptc.plms.gol.oops.util.NeighboursUtil;
import com.ptc.plms.gol.oops.util.RuleUtil;

import java.util.*;

class RuleRunner
{

  Set<Cell> applyRules(Set<Cell> liveCells)
  {
    Set<Cell> nextGeneration = new HashSet<>();

    Set<Cell> neighbouringCells;
    for (Cell cellFromCurrentGeneration : liveCells)
    {
      if (!nextGeneration.contains(cellFromCurrentGeneration))
      {
        nextGeneration.add(processCell(cellFromCurrentGeneration, liveCells));
      }
      neighbouringCells = NeighboursUtil.findNeighbours(cellFromCurrentGeneration, liveCells);

      for (Cell neighbouringCell : neighbouringCells)
      {
        if (!nextGeneration.contains(neighbouringCell))
        {
          nextGeneration.add(processCell(neighbouringCell, liveCells));
        }
      }
    }
    return filterDead(nextGeneration);
  }

  private Cell processCell(Cell cell, Set<Cell> currentGeneration)
  {
    cell = cell.createCopy();
    State nextState = RuleUtil.nextState(cell.getState(), NeighboursUtil.findLiveNeighbourCount(cell, currentGeneration));
    cell.setState(nextState);
    return cell;
  }


  private Set<Cell> filterDead(Set<Cell> nextGeneration)
  {
    Iterator<Cell> iterator = nextGeneration.iterator();

    while (iterator.hasNext())
    {
      if (State.DEAD.equals(iterator.next().getState()))
      {
        iterator.remove();
      }
    }
    return nextGeneration;
  }

}
