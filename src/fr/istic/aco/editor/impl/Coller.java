package fr.istic.aco.editor.impl;

import fr.istic.aco.editor.api.Command;
import fr.istic.aco.editor.api.Engine;

public class Coller implements Command {
    private Engine engine;

    public Coller(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void execute() {
        this.engine.pasteClipboard();
    }
}
