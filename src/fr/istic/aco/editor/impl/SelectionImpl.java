package fr.istic.aco.editor.impl;

import fr.istic.aco.editor.api.Selection;

public class SelectionImpl implements Selection {
   private int beginIndex;
   private int endIndex;
   private Buffer buffer;

    public SelectionImpl(int beginIndex, int endIndex, Buffer buffer) {
        this.beginIndex = beginIndex;
        this.endIndex = endIndex;
        this.buffer = buffer;
    }

    public Buffer getBuffer() {
        return buffer;
    }

    public SelectionImpl() {
        this.buffer = new Buffer("");
    }

    @Override
    public int getBeginIndex() {
        return this.beginIndex;
    }

    @Override
    public int getEndIndex() {
        return this.endIndex;
    }

    @Override
    public int getBufferBeginIndex() {
        return 0;
    }

    @Override
    public int getBufferEndIndex() {
        return this.buffer.getContent().length();
    }

    @Override
    public void setBeginIndex(int beginIndex) {
            this.beginIndex = beginIndex;
    }

    @Override
    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }
}
