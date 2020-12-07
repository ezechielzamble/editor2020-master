package fr.istic.aco.editor.test;

import fr.istic.aco.editor.api.Engine;
import fr.istic.aco.editor.api.Selection;
import fr.istic.aco.editor.impl.EngineImpl;
import fr.istic.aco.editor.impl.Insert;
import fr.istic.aco.editor.impl.UserInterfaceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EngineTest {

    private Engine engine;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        engine = new EngineImpl();
    }

    private void todo() {
        fail("Unimplemented test");
    }
    @Test
    @DisplayName("Buffer must be empty after initialisation")
    void getSelection() {
        Selection selection = engine.getSelection();
        assertEquals(selection.getBufferBeginIndex(),selection.getBeginIndex());
        assertEquals("",engine.getBufferContents());
    }

    @Test
    void getBufferContents() {
        UserInterfaceImpl ihm = new UserInterfaceImpl();
        String ts= "Bonjour";

        ihm.addCommand("inserer", new Insert(engine, ts));
        /*Selection selection = engine.getSelection();
        selection.setBeginIndex(1);
        selection.setEndIndex(6);*/
        ihm.clicBoutonInserer();
        //String gbf= engine.getBufferContents();
        assertEquals(ts, engine.getBufferContents());
    }

    @Test
    void getClipboardContents() {
        String nom ="ABCDEF";
        engine.insert(nom);
        Selection selection = engine.getSelection();
        selection.setBeginIndex(1);selection.setEndIndex(4);
        engine.copySelectedText();

        assertEquals("BCD",engine.getClipboardContents());
    }

    @Test
    void cutSelectedText() {
        String test = "ABCDEF";
        engine.insert(test);
        Selection selection = engine.getSelection();
        selection.setBeginIndex(1);selection.setEndIndex(4);
        engine.cutSelectedText();
        assertEquals("BCD",engine.getClipboardContents());
        assertEquals("AEF",engine.getBufferContents());

    }

    @Test
    void copySelectedText() {
        String test = "ABCDEF";
        engine.insert(test);
        Selection selection = engine.getSelection();
        selection.setBeginIndex(1);selection.setEndIndex(4);
        engine.copySelectedText();
        assertEquals("BCD",engine.getClipboardContents());
        assertEquals("ABCDEF",engine.getBufferContents());
    }

    @Test
    void pasteClipboard() {
        String test = "ABCDEF";
        engine.insert(test);
        Selection selection = engine.getSelection();
        selection.setBeginIndex(1);selection.setEndIndex(4);
        engine.copySelectedText();
        selection.setBeginIndex(0);selection.setEndIndex(5);
        engine.pasteClipboard();
        assertEquals("BCD",engine.getClipboardContents());
        assertEquals("BCDF",engine.getBufferContents());
    }
}
