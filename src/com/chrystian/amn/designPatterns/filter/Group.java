package com.chrystian.amn.designPatterns.filter;

import java.util.List;
import java.util.function.Predicate;

public interface Group {
    List<? extends Item> getItems();
    Group filtered(Predicate<? extends Item> predicate);

}
