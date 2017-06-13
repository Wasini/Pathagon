package model;
import framework.AdversarySearchState;

/**
 * Created by grazi on 13/06/17.
 */
public class PathagonState implements AdversarySearchState {

    private PathagonBoard pathagonBoard;
    private int[] avaibleTokens;

    public PathagonState() {

    }

    @Override
    public boolean isMax() {
        return false;
    }

    @Override
    public boolean equals(AdversarySearchState other) {
        return false;
    }

    @Override
    public Object ruleApplied() {
        return null;
    }
}
