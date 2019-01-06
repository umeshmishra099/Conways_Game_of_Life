package com.ptc.plms.gol.oops.util;

import com.ptc.plms.gol.oops.State;

public class RuleUtil
{
  public static State nextState(State currentState, int liveNeighbours)
  {
    if (State.LIVE.equals(currentState))
    {
      if (liveNeighbours == 2 || liveNeighbours == 3)
      {
        return State.LIVE;
      }
      else return State.DEAD;
    }
    else if (State.DEAD.equals(currentState))
    {
      if (liveNeighbours == 3)
      {
        return State.LIVE;
      }
    }

    return currentState;
  }

}
