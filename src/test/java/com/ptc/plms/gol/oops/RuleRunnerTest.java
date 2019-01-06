package com.ptc.plms.gol.oops;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RuleRunnerTest
{
  @Test
  public void givenNoLiveCellWhenApplyRulesCalledThenZeroNextGenerationLiveCellsReturned()
  {
    RuleRunner ruleRunner = new RuleRunner();
    Set<Cell> nextGeneration = ruleRunner.applyRules(new HashSet<Cell>());
    assertEquals(0, nextGeneration.size());
  }

  @Test
  public void givenOneLiveCellWhenApplyRulesCalledThenZeroNextGenerationCellReturned()
  {
    RuleRunner ruleRunner = new RuleRunner();
    HashSet<Cell> liveCells = new HashSet<>();
    liveCells.add(new Cell(0, 1, State.LIVE));
    Set<Cell> nextGenerationLiveCells = ruleRunner.applyRules(liveCells);
    assertEquals(0, nextGenerationLiveCells.size());
  }

  @Test
  public void givenTwoLiveCellWhenApplyRulesCalledThenTwoNextGenerationCellReturned()
  {
    RuleRunner ruleRunner = new RuleRunner();
    HashSet<Cell> liveCells = new HashSet<>();
    liveCells.add(new Cell(0, 0, State.LIVE));
    liveCells.add(new Cell(0, 1, State.LIVE));
    Set<Cell> nextGenerationLiveCells = ruleRunner.applyRules(liveCells);
    assertEquals(2, nextGenerationLiveCells.size());
  }

  @Test
  public void givenThreeLiveCellInRowWhenApplyRulesCalledThenFourNextGenerationCellReturned()
  {
    List<String> expectedLiveCells = Arrays.asList("0,0", "1,1", "0,1", "0,2");
    RuleRunner ruleRunner = new RuleRunner();
    HashSet<Cell> liveCells = new HashSet<>();
    liveCells.add(new Cell(0, 0, State.LIVE));
    liveCells.add(new Cell(0, 1, State.LIVE));
    liveCells.add(new Cell(0, 2, State.LIVE));
    Set<Cell> nextGenerationLiveCells = ruleRunner.applyRules(liveCells);
    assertEquals(4, nextGenerationLiveCells.size());
    for (Cell nextGenerationLiveCell : nextGenerationLiveCells)
    {
      String actualCell = nextGenerationLiveCell.getX() + "," + nextGenerationLiveCell.getY();
      assertTrue(expectedLiveCells.contains(actualCell));
    }
  }

  @Test
  public void givenFourLiveCellInColumnWhenApplyRulesCalledThenSixNextGenerationCellReturned()
  {
    List<String> expectedLiveCells = Arrays.asList("1,0", "2,1", "0,0", "1,1", "3,0", "2,0");
    RuleRunner ruleRunner = new RuleRunner();
    HashSet<Cell> liveCells = new HashSet<>();
    liveCells.add(new Cell(0, 0, State.LIVE));
    liveCells.add(new Cell(1, 0, State.LIVE));
    liveCells.add(new Cell(2, 0, State.LIVE));
    liveCells.add(new Cell(3, 0, State.LIVE));
    Set<Cell> nextGenerationLiveCells = ruleRunner.applyRules(liveCells);
    assertEquals(6, nextGenerationLiveCells.size());
    for (Cell nextGenerationLiveCell : nextGenerationLiveCells)
    {
      String actualCell = nextGenerationLiveCell.getX() + "," + nextGenerationLiveCell.getY();
      assertTrue(expectedLiveCells.contains(actualCell));
    }
  }
}
