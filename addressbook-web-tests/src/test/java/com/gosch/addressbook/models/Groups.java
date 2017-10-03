package com.gosch.addressbook.models;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

/*
    Коллекция с расширенным набором методов
 */
public class Groups extends ForwardingSet<GroupData> {

    private Set<GroupData> delegate;

    // The following constructor is made to create copy of SET
    public Groups(Groups groups) {
        this.delegate = new HashSet<>(groups.delegate);
    }

    public Groups() {
        this.delegate = new HashSet<>();
    }

    @Override
    protected Set<GroupData> delegate() {
        return delegate;
    }

    public Groups withAdded(GroupData group) {
        // Created copy of object so that old object will stay not changed
        // The method will return new object with ADDED NEW GROUP
        // In this case we can work with both SETs (with added group and without)
        Groups groups = new Groups(this);
        groups.add(group); // method took from class ForwardingSet
        return groups;
    }

    public Groups without(GroupData group) {
        Groups groups = new Groups(this);
        groups.remove(group);
        return groups;
    }
}
