package fr.istic.aco.editor.impl;

import fr.istic.aco.editor.api.Command;
import fr.istic.aco.editor.api.Engine;
import fr.istic.aco.editor.api.Memento;
import fr.istic.aco.editor.api.Recorder;

public class Insert implements Command {
    private Engine engine;
    private String verif;
    private Recorder recorder;

    public Insert (Engine engine,String verif, Recorder recorder){

        this.engine = engine;
        this.verif=verif;
        this.recorder = recorder;
    }
    public Insert(Engine engine, String verif){
        this.engine = engine;
        this.verif = verif;
        this.recorder = new RecorderImpl();
    }

    @Override
    public void execute() {
        this.engine.insert(verif);
    }

    @Override
    public Memento getMemento() {
        return null;
    }

    @Override
    public void setMemento(Memento memento) {

    }
    //

}
