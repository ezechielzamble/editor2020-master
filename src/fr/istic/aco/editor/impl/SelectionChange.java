package fr.istic.aco.editor.impl;

import fr.istic.aco.editor.api.Command;
import fr.istic.aco.editor.api.Memento;
import fr.istic.aco.editor.api.Recorder;
import fr.istic.aco.editor.api.Selection;

public class SelectionChange implements Command {
    private Selection selection;
    private int debut, fin;
    private Recorder recorder;

    public SelectionChange (Selection selection,int debut, int fin, Recorder recorder){
                this.selection=selection;
                this.debut=debut;
                this.fin=fin;
                this.recorder = recorder;
    }

    public SelectionChange(Selection selection, int debut, int fin) {
        this.selection=selection;
        this.debut=debut;
        this.fin=fin;
        this.recorder = new RecorderImpl();
    }

    @Override
    public void execute() {
        this.selection.setBeginIndex(debut);
        this.selection.setEndIndex(fin);
    }

    @Override
    public Memento getMemento() {
        return null;
    }

    @Override
    public void setMemento(Memento memento) {

    }
}
