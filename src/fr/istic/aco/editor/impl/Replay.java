package fr.istic.aco.editor.impl;

import fr.istic.aco.editor.api.Command;
import fr.istic.aco.editor.api.Memento;
import fr.istic.aco.editor.api.Recorder;

public class Replay implements Command {
    private Recorder recorder;

    public Replay(Recorder recorder) {
        this.recorder = recorder;
    }

    @Override
    public void execute() {
        this.recorder.replay();
    }

    @Override
    public Memento getMemento() {
        return null;
    }

    @Override
    public void setMemento(Memento memento) {

    }
}
