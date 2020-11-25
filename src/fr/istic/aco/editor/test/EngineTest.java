package fr.istic.aco.editor.test;

import fr.istic.aco.editor.api.Engine;
import fr.istic.aco.editor.api.Selection;
import fr.istic.aco.editor.impl.EngineImpl;
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
        String ts= "Bonjour";
        /*Selection selection = engine.getSelection();
        selection.setBeginIndex(1);
        selection.setEndIndex(6);*/
        engine.insert(ts);
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
        assertEquals("BCDE",engine.getClipboardContents());
    }

    @Test
    void cutSelectedText() {
        String test = "ABCDEF";
        engine.insert(test);
        Selection selection = engine.getSelection();
        selection.setBeginIndex(1);selection.setEndIndex(4);
        engine.cutSelectedText();
        assertEquals("BCDE",engine.getClipboardContents());
        assertEquals("AF",engine.getBufferContents());

    }

    @Test
    void copySelectedText() {
        String test = "ABCDEF";
        engine.insert(test);
        Selection selection = engine.getSelection();
        selection.setBeginIndex(1);selection.setEndIndex(4);
        engine.copySelectedText();
        assertEquals("BCDE",engine.getClipboardContents());
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
        assertEquals("BCDE",engine.getClipboardContents());
        assertEquals("BCDE",engine.getBufferContents());
    }
}
