package com.chrystian.amn.designPatterns.filter;

import java.util.List;
import java.util.function.Predicate;

public interface ScoreGroup extends Group{
    @Override
    List<? extends ScoreItem> getItems();

//    @Override
//    ScoreGroup filered(Predicate<? extends ScoreItem> predicate);
}
