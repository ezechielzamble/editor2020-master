package fr.istic.aco.editor.impl;

import fr.istic.aco.editor.api.Command;
import fr.istic.aco.editor.api.Memento;
import fr.istic.aco.editor.api.Recorder;

import java.util.HashMap;
import java.util.Map;

public class RecorderImpl implements Recorder {
    private Map<Command, Memento> commands;


    public RecorderImpl(){
        this.commands = new HashMap<Command, Memento>();
    }

    @Override
    public void save(Command c) {

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void replay() {

    }
}
