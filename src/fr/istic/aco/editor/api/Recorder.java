package fr.istic.aco.editor.api;

public interface Recorder {
    void save(Command c);
    void start();
    void stop();
    void replay();
}
