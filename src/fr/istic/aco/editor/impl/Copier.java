package fr.istic.aco.editor.impl;

import fr.istic.aco.editor.api.Command;
import fr.istic.aco.editor.api.Engine;
import fr.istic.aco.editor.api.Memento;
import fr.istic.aco.editor.api.Recorder;

public class Copier implements Command {
    private Engine engine;
    private Recorder recorder;

    public Copier(Engine engine, Recorder recorder) {
        this.engine = engine;
        this.recorder = recorder;
    }
    public Copier(Engine engine) {
        this.engine = engine;
        this.recorder = new RecorderImpl();
    }

    @Override
    public void execute() {
        this.engine.copySelectedText();

    }

    @Override
    public Memento getMemento() {
        return null;
    }

    @Override
    public void setMemento(Memento memento) {

    }
}
