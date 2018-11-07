package facade;

import sun.java2d.pipe.BufferedBufImgOps;

import java.util.ArrayList;
import java.util.List;

public class Buffer {

    private char[] characters;
    private int lineWidth;

    public Buffer(int lineHeight, int lineWidth) {
        this.lineWidth = lineWidth;
        characters = new char[lineWidth * lineHeight];
    }

    public char charAt(int x, int y){
        return characters[y * lineWidth + x];
    }

}

class ViewPort {

    private Buffer buffer;
    private int width;
    private int height;
    private int offsetX;
    private int offsetY;

    public ViewPort (Buffer buffer, int width, int height, int offsetX, int offsetY){
        this.buffer = buffer;
        this.width = width;
        this.height = height;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    public char charAt(int x, int y){
        return buffer.charAt(x+offsetX, y+ offsetY);
    }
}

class Console {

    private List<ViewPort> viewports = new ArrayList<>();
    int width, height;

    public Console(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void addViewport(ViewPort viewport){
        viewports.add(viewport);
    }

    //Facade 
    public static Console newConsole(int width, int height){
        Buffer buffer = new Buffer(width, height);
        ViewPort viewport = new ViewPort(buffer, width, height, 0, 0 );
        Console console = new Console(width, height);
        console.addViewport(viewport);
    }

    public void render(){
        for (int y = 0; y < height; ++y){
            for (int x = 0; x < width; ++x) {
                for (ViewPort vp : viewports){
                    System.out.println(vp.charAt(x,y));
                }
                System.out.println();
            }
        }
    }

}

class ConsoleDemo {

    public static void main(String[] args) {
        Buffer buffer = new Buffer(20, 30);
        ViewPort viewPort = new ViewPort(buffer, 30, 30, 0, 0);
        Console console = new Console(30, 20);
        console.addViewport(viewPort);
        console.render();

        Console console1 = Console.newConsole(30, 20);
        console1.render();

    }



}
