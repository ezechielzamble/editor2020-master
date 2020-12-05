package fr.istic.aco.editor.impl;

import fr.istic.aco.editor.api.Command;
import fr.istic.aco.editor.api.UserInterface;

import java.util.HashMap;
import java.util.Map;

public class UserInterfaceImpl implements UserInterface {
    private Map<String, Command> commands;

    public UserInterfaceImpl(Map<String, Command> commands) {
        this.commands = commands;
    }

    public UserInterfaceImpl() {
        commands = new HashMap<String, Command>();
    }

    @Override
    public void listCommands() {
       int numCommand = 0;
        for (String command : commands.keySet()){
            System.out.println(numCommand+ "."+ command);
            numCommand++;
        }
    }

    @Override
    public void clicBoutonCopier() {
        this.commands.get("copier").execute();

    }

    @Override
    public void clicBoutonColler() {
        this.commands.get("coller").execute();

    }

    @Override
    public void clicBoutonSelectionner() {
        this.commands.get("select").execute();
    }

    @Override
    public void clicBoutonSupprimer() {
        this.commands.get("delete").execute();

    }

    @Override
    public void clicBoutonInserer() {
        this.commands.get("inserer").execute();
    }


    @Override
    public void addCommand(String key, Command command) {
        commands.put(key, command);
    }
}
