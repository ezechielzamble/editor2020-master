package fr.istic.aco.editor.impl;

import fr.istic.aco.editor.api.Command;
import fr.istic.aco.editor.api.Engine;

public class Insert implements Command {
    private Engine engine;
    private String verif;

    public Insert (Engine engine,String verif){

        this.engine = engine;
        this.verif=verif;
    }

    @Override
    public void execute() {
        this.engine.insert(verif);
    }
    //

}
