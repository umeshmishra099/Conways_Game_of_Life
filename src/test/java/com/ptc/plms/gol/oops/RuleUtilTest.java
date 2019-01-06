package com.ptc.plms.gol.oops;

import com.ptc.plms.gol.oops.util.RuleUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RuleUtilTest
{
  @Test
  public void givenLiveCellWithLessThanTwoLiveNeighborWhenNextStateCalledThenReturnStateDead()
  {
    int[] lessThanTwo = {0, 1};
    for (int liveNeighbours : lessThanTwo)
    {
      State state = RuleUtil.nextState(State.LIVE, liveNeighbours);
      assertEquals(State.DEAD.name(), state.name());
    }
  }

  @Test
  public void givenLiveCellWithTwoOrThreeLiveNeighborWhenNextStateCalledThenReturnStateLive()
  {
    int[] twoOrThree = {2, 3};
    for (int liveNeighbours : twoOrThree)
    {
      State state = RuleUtil.nextState(State.LIVE, liveNeighbours);
      assertEquals(State.LIVE.name(), state.name());
    }
  }

  @Test
  public void givenLiveCellWithGreaterThanThreeLiveNeighborWhenNextStateCalledThenReturnStateDead()
  {
    int[] greaterThanThree = {4, 5, 6, 7, 8};
    for (int liveNeighbours : greaterThanThree)
    {
      State state = RuleUtil.nextState(State.LIVE, liveNeighbours);
      assertEquals(State.DEAD.name(), state.name());
    }
  }

  @Test
  public void givenDeadCellWithExactlyThreeLiveNeighborWhenNextStateCalledThenReturnStateLive()
  {
    State state = RuleUtil.nextState(State.DEAD, 3);
    assertEquals(State.LIVE.name(), state.name());
  }

  @Test
  public void givenDeadCellWithNotExactlyThreeLiveNeighborWhenNextStateCalledThenReturnStateDead()
  {
    int[] greaterThanThree = {0, 1, 2, 4, 5, 6, 7, 8};
    for (int liveNeighbours : greaterThanThree)
    {
      State state = RuleUtil.nextState(State.DEAD, liveNeighbours);
      assertEquals(State.DEAD.name(), state.name());
    }
  }

}
