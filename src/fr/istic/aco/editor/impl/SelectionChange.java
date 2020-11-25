package fr.istic.aco.editor.impl;

import fr.istic.aco.editor.api.Command;
import fr.istic.aco.editor.api.Selection;

public class SelectionChange implements Command {
    private Selection selection;
    private int debut, fin;

    public SelectionChange (Selection selection,int debut, int fin){
                this.selection=selection;
                this.debut=debut;
                this.fin=fin;
    }

    @Override
    public void execute() {
        this.selection.setBeginIndex(debut);
        this.selection.setEndIndex(fin);
    }
}
