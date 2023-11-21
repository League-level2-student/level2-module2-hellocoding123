package _08_LeagueSnake;

import java.util.ArrayList;

import processing.core.PApplet;

public class LeagueSnake extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 800;
    
    /*
     * Game variables
     * 
     * Put all the game variables here.
     */
    
    int segment;
    int foodX;
    int foodY;
    int headX = 260;
    int headY= 60;
    int direction=UP;
    int foodEaten;
    int tailX;
    int tailY;
    ArrayList<Segment>tail= new ArrayList();
    
    /*
     * Setup methods
     * 
     * These methods are called at the start of the game.
     */
    @Override
    public void settings() {
        size(500,500);
    }

    @Override
    public void setup() {
        Segment head = new Segment(headX,headY);
        frameRate(15);
        dropFood();
    }

    void dropFood() {
        // Set the food in a new random location
    	foodX = ((int)random(25)*20);
    	foodY = ((int)random(25)*20);
    }

    /*
     * Draw Methods
     * 
     * These methods are used to draw the snake and its food
     */

    @Override
    public void draw() {
        background(0,0,0);
        move();
        drawSnake();
        drawFood();
        eat();
    }

    void drawFood() {
        // Draw the food
    	fill(255,0,0);
    	noStroke();
        rect(foodX,foodY,20,20);
    }

    void drawSnake() {
        // Draw the head of the snake followed by its tail
    	fill(0,255, 0);
    	noStroke();
    	rect(headX,headY,20,20);
    	manageTail();
    }

    void drawTail() {
        // Draw each segment of the tail
        rect(tailX,tailY,20,20);
    }

    /*
     * Tail Management methods
     * 
     * These methods make sure the tail is the correct length.
     */

    void manageTail() {
    	checkTailCollision();
    	drawTail();
        // After drawing the tail, add a new segment at the "start" of the tail and
        tailX=headX;
        tailY=headY;
    	Segment tailSegment = new Segment(tailX, tailY);
    	tail.add(tailSegment);
        // remove the one at the "end"
    	tail.remove(tail.size()); 
        // This produces the illusion of the snake tail moving.

    }

    void checkTailCollision() {
        // If the snake crosses its own tail, shrink the tail back to one segment
        for(int i = 0; i >= tail.size(); i++) {
            if(tail.get(i).x == headX && tail.get(i).y == headY) {
                foodEaten=1;
                tail.clear();
                tailX=headX;
                tailY=headY;
        	    Segment tailSegment = new Segment(tailX, tailY);
        	    tail.add(tailSegment);
                break;
            }    
        }    
    }

    /*
     * Control methods
     * 
     * These methods are used to change what is happening to the snake
     */

    @Override
    public void keyPressed() {
        // Set the direction of the snake according to the arrow keys pressed
        System.out.println(keyCode);
        direction = keyCode;
    }

    void move() {
        // Change the location of the Snake head based on the direction it is moving.

        
        if (direction == UP) {
            headY -= 20;
            
        } else if (direction == DOWN) {
            headY += 20;
                
        } else if (direction == LEFT) {
        	headX -= 20;
            
        } else if (direction == RIGHT) {
            headX += 20;
        	
        }
        checkBoundaries();
    }

    void checkBoundaries() {
        // If the snake leaves the frame, make it reappear on the other side
        if(headX < 0) {
        	headX = 480;
        }
        if(headX > 480) {
        	headX = 0;
        }
        if(headY < 0) {
        	headY = 480;
        }
        if(headY > 480) {
        	headY = 0;
        }
    }

    void eat() {
    	if(headX == foodX && headY == foodY) {
        // When the snake eats the food, its tail should grow and more
    		foodEaten += 1;
            tailX=headX;
            tailY=headY;
            Segment tailSegment = new Segment(tailX, tailY);
            tail.add(tailSegment);
        // food appear
    		foodX = ((int)random(25)*20);
        	foodY = ((int)random(25)*20);
    	}
    }

    static public void main(String[] passedArgs) {
        PApplet.main(LeagueSnake.class.getName());
    }
}
