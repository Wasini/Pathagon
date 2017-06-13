package model;

import framework.AdversarySearchProblem;

import java.util.List;

/**
 * Created by grazi on 13/06/17.
 */
public class PathagonSearchProblem<P> implements AdversarySearchProblem<PathagonState> {


    @Override
    public PathagonState initialState() {
        return null;
    }

    @Override
    public List<PathagonState> getSuccessors(PathagonState state) {
        return null;
    }

    @Override
    public boolean end(PathagonState state) {
        return false;
    }

    @Override
    public int value(PathagonState state) {
        return 0;
    }

    @Override
    public int minValue() {
        return 0;
    }

    @Override
    public int maxValue() {
        return 0;
    }
}
