Ball myball;
float boxX;
float boxY;
float mass;
boolean hoverGrav;
boolean hoverMass;
boolean hoverReset;
boolean hoverPause;
boolean paused;

void setup() {
  size(500,500);
  myball = new Ball();
  boxX = 0;
  boxY = 400;
  mass = 1;
  paused = false;
}

void draw() {
  if(paused) {
    fill(#5882FA);
    rect(25,350,100,50);
    fill(255);
    text("Play",59,378);
    if (mouseX > 25 && mouseX < 125 && mouseY > 350 && mouseY < 400) {
    hoverPause = true;
  } else {
    hoverPause = false;
  }
  } else {
    
  background(#585858);
  
  boxX = constrain(boxX,0,400);
  boxY = constrain(boxY,0,400);
  
  mass = round(map(boxY,0,400,10,1));
  
  line(0,20,500,20);
  
  myball.update();
  myball.checkEdges();
  myball.display();
  myball.setAccel(0,map(round(boxX),0,400,0,0.1));
  
  ellipse(boxX+50,20,100,20);
 
  line(460,height,460,0);
  
  rect(25,350,100,50);
  rect(25,425,100,50);
  
  //rect(boxX,10,100,20);
  fill(255);
  text(str(round(map(myball.acceleration.y,0,0.1,0,10))) + " m/s^2",boxX+23,25);
  fill(#5882FA);
  rect(450,boxY,20,100);
  fill(255);
  text(str(round(mass)),455,boxY+40);
  text("kg",454,boxY+60);
  
  text("Acceleration Due To Gravity",10,50);
  text("Mass",410,450);
  text("Force Of Gravity: " + str(round(myball.netforce.y*100)) + " N",10,200);
  text("Speed: " + nf(abs(myball.velocity.y),1,2) + " m/s",10,240);
  text("Reset",59,453);
  text("Pause",59,378);
  
  if (mouseX > boxX && mouseX < boxX + 100 && mouseY > 0 && mouseY < 50) {
    hoverGrav = true;
  } else {
    hoverGrav = false;
  }
  if (mouseX > 425 && mouseX < 490 && mouseY > boxY && mouseY < boxY+100) {
    hoverMass = true;
  } else {
    hoverMass = false;
  }
  if (mouseX > 25 && mouseX < 125 && mouseY > 425 && mouseY < 475) {
    hoverReset = true;
  } else {
    hoverReset = false;
  }
  if (mouseX > 25 && mouseX < 125 && mouseY > 350 && mouseY < 400) {
    hoverPause = true;
  } else {
    hoverPause = false;
  }
  }
}

void mouseDragged() {
  if(hoverGrav) {
    boxX = mouseX-50;
  }
  if(hoverMass) {
    boxY = mouseY-50;
  }
}

void mouseClicked() {
  if(hoverReset) {
    setup();
  }
  if(hoverPause) {
    paused = !paused;
  }
}

class Ball {
  
  PVector location;
  PVector velocity;
  PVector acceleration;
  PVector netforce;
  
  Ball() {
    location = new PVector(width/2,height/2);
    velocity = new PVector(0,0);
    acceleration = new PVector(0,0);
    netforce = new PVector(0,0);
  }
  
  void update() {
    
    netforce = PVector.mult(acceleration,mass);
    velocity.add(acceleration);
    location.add(velocity);
  }
  
  void setAccel(float x, float y) {
    PVector newForce = new PVector(x,y);
    acceleration = newForce;
  }
  
  void display() {
    stroke(0);
    fill(#5882FA);
    ellipse(location.x,location.y,map(mass,1,10,10,100),map(mass,1,10,10,100));
  }
  
  void checkEdges() {
    if(location.x > width) {
      location.x = 0;
    } else if (location.x < 0) {
      location.x = width;
    }
    if(location.y > height-map(mass,1,10,10,100)/2) {
      velocity.y = velocity.y*-1;
    } else if (location.y < map(mass,1,10,10,100)/2) {
      velocity.y = velocity.y*-1;
    }
  }
  
}
