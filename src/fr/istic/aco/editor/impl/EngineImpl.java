package fr.istic.aco.editor.impl;

import fr.istic.aco.editor.api.Engine;
import fr.istic.aco.editor.api.Selection;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class EngineImpl implements Engine {
    private Selection selection;
    private Clipboard clipboard;

    public EngineImpl(Selection selection) {
        this.selection = selection;
        this.clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    }

    public EngineImpl(){
        this.selection = new SelectionImpl();
        this.clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    }
    /**
     * Provides access to the selection control object
     *
     * @return the selection object
     */
    @Override
    public Selection getSelection() {

        return this.selection;
    }

    /**
     * Provides the whole contents of the buffer, as a string
     *
     * @return a copy of the buffer's contents
     */
    @Override
    public String getBufferContents() {

        return ((SelectionImpl) selection).getBuffer().getContent();
    }

    /**
     * Provides the clipboard contents
     *
     * @return a copy of the clipboard's contents
     */
    @Override
    public String getClipboardContents() {
                String result = "";
        try {

            result = (String) clipboard.getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // System.out.println("String from Clipboard:" + result);
        return result;
    }

    /**
     * Removes the text within the interval
     * specified by the selection control object,
     * from the buffer.
     */
    @Override
    public void cutSelectedText() {
        copySelectedText();
        delete();
    }

    /**
     * Copies the text within the interval
     * specified by the selection control object
     * into the clipboard.
     */
    @Override
    public void copySelectedText() {
        String recup = getBufferContents().substring(selection.getBeginIndex(), selection.getEndIndex());
        //System.out.println(recup);
        StringSelection stringSelection = new StringSelection(recup);
        clipboard.setContents(stringSelection, null);
    }

    /**
     * Replaces the text within the interval specified by the selection object with
     * the contents of the clipboard.
     */
    @Override
    public void pasteClipboard() {
        insert(getClipboardContents());
    }

    /**
     * Inserts a string in the buffer, which replaces the contents of the selection
     *
     * @param s the text to insert
     */
    @Override
    public void insert(String s) {
        ((SelectionImpl) selection).getBuffer().replace(selection.getBeginIndex(), selection.getEndIndex(), s);
    }

    /**
     * Removes the contents of the selection in the buffer
     */
    @Override
    public void delete() {
        //((SelectionImpl) selection).getBuffer().replace(selection.getBeginIndex(), selection.getEndIndex(),"");
        insert("");
    }
}
