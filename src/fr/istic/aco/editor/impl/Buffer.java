package fr.istic.aco.editor.impl;

public class Buffer {
    private String content;


    public Buffer(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void replace(int begin, int end, String text){
        String partOne = content.substring(0,begin);
        String partTwo = content.equals("")?"":content.substring(end);
        //this.content = content.equals("")?text:partOne+text+partTwo;
        this.content=partOne+text+partTwo;

    }
}
