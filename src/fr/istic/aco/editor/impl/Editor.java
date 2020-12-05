package fr.istic.aco.editor.impl;

import fr.istic.aco.editor.api.Engine;
import fr.istic.aco.editor.api.Selection;
import fr.istic.aco.editor.api.UserInterface;

public class Editor {

    private EngineImpl engine;
    private UserInterfaceImpl ihm;
    private SelectionImpl selection;

    public Editor() {
        this.selection = new SelectionImpl();
        this.engine = new EngineImpl(selection);
        this.ihm = new UserInterfaceImpl();
    }
    private void configureCommands() {

        ihm.addCommand("inserer", new Insert(engine, "ABCDEF"));
        ihm.addCommand("delete", new Delete(engine));
        ihm.addCommand("copier", new Copier(engine));
        ihm.addCommand("coller", new Coller(engine));
        ihm.addCommand("select", new SelectionChange(selection, 1,4));

        // An example of Java 8 lambdas
       // ihm.addCommand("Test", () -> System.err.println("Test : "+this.toString()));
    }
    private void run() {

       this.configureCommands();
       affichage();
       ihm.clicBoutonInserer();
       ihm.clicBoutonSelectionner();
       ihm.clicBoutonSupprimer();
       System.out.println(engine.getBufferContents());

    }
    private void affichage(){
        System.out.println("                MENU EDITEUR            ");
        ihm.listCommands();
        //for (int i)
    }
    public static void main (String [] args){
        Editor editor = new Editor();

        editor.run();

    }
}
