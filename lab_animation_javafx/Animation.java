// Loosely based on https://github.com/tutsplus/Introduction-to-JavaFX-for-Game-Development/blob/master/Example3.java 

/*
 * Aaron Knestaut, Dylan Kirk
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.animation.AnimationTimer;

import java.io.IOException;
import java.io.File;

// Animation of Orc walking
public class Animation extends Application {
    final int canvasCount = 10;
    int picInd = 0;
    double xloc = 0;
    double yloc = 0;
    final double xIncr = 5;
    final double yIncr = 8;
    final static int canvasWidth = 600;
    final static int canvasHeight = 600;
    final static int imgWidth = 165;
    final static int imgHeight = 165;
    int xDir = 1;
    int yDir = -1;

    // TODO: Change the code so that at least eight orc animation pngs are loaded
    // DONE (in start)

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage theStage) {
        theStage.setTitle("Orc");

        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);

        Canvas canvas = new Canvas(canvasWidth, canvasHeight);
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        //loads 8 images
        Image orc_imgSE = createImage("orc/orc_forward_southeast.png");
        Image orc_imgS = createImage("orc/orc_forward_south.png");
        Image orc_imgSW = createImage("orc/orc_forward_southwest.png");
        Image orc_imgW = createImage("orc/orc_forward_west.png");
        Image orc_imgNW = createImage("orc/orc_forward_northwest.png");
        Image orc_imgN = createImage("orc/orc_forward_north.png");
        Image orc_imgNE = createImage("orc/orc_forward_northeast.png");
        Image orc_imgE = createImage("orc/orc_forward_east.png");
        

        final long startNanoTime = System.nanoTime();

        new AnimationTimer() {
            public void handle(long currentNanoTime)
            {
                double t = (currentNanoTime - startNanoTime) / 1e9; 
                Image orc_img = orc_imgNE;
                
                if(xloc >= 500) {
                	xDir = -1;
                }
                else if(xloc <= -100) {
                	xDir = 1;
                }
                else if(yloc >= 500) {
                	yDir = -1;
                }
                else if(yloc <= -100) {
                	yDir = 1;
                }

                xloc += xIncr * xDir;
                yloc += yIncr * yDir;

                // Clear the canvas
                gc.clearRect(0, 0, canvasWidth, canvasHeight);
                
                if(xDir == 1 && yDir == 1) {
                	orc_img = orc_imgNE;
                }
                else if(xDir == -1 && yDir == 1) {
                	orc_img = orc_imgNW;
                }
                else if(xDir == 1 && yDir == -1) {
                	orc_img = orc_imgSE;
                }
                else if(xDir == -1 && yDir == -1) {
                	orc_img = orc_imgSW;
                }
                
                // draw the subimage from the original png to animate the orc's motion
                gc.drawImage(orc_img, imgWidth*picInd, 0, imgWidth, imgHeight,
                                    xloc, yloc, imgWidth, imgHeight);
                picInd = (picInd + 1) % canvasCount;
                
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                // TODO: Keep the orc from walking off-screen, turn around when bouncing off walls.
                //Be sure that animation picture direction matches what is happening on screen.
            }
        }.start();
        theStage.show();
    }

    //Read image from file and return
    private Image createImage(String fileName) {
        Image img = new Image(fileName);
        return img;   	
    	// TODO: Change this method so you can load other orc animation bitmaps
        // DONE
    }
}


