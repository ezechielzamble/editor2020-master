package fr.istic.aco.editor.api;

public interface UserInterface {
        void listCommands();
        void clicBoutonCopier();
        void clicBoutonColler();
        void clicBoutonSelectionner();
        void clicBoutonSupprimer();
        void clicBoutonInserer();
        void addCommand(String key, Command command);
}
