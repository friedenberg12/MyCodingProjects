Planet[] myplanets;
boolean drawPlanet;
float boxX;
boolean hover;
boolean hoverReset;
int i;
int x;
PImage sun;
PImage[] planet;
final float G = 6.67e-11;
final int MASS_P = 150;

void setup() {
   size(1000,650);
   myplanets = new Planet[10];
   planet = new PImage[10];
   boxX = 0;
   i = 0;
   drawPlanet = false;
   sun = loadImage("sun.jpg");
   for(int p=0;p<10;p++) {
     planet[p] = loadImage(str(p)+".png");
   }
}

void draw() {
  background(sun.get(1,1));
  boxX = constrain(boxX,0,width-100);
  
  fill(#5882FA);
  
  line(0,20,width,20);
  ellipse(boxX+50,20,100,20);
  rect(25,575,100,50);
  sun.resize(MASS_P,MASS_P);
  image(sun,width/2-MASS_P/2,height/2-MASS_P/2);
  //ellipse(width/2,height/2,MASS_P,MASS_P);
  
  if (mouseX > boxX && mouseX < boxX + 100 && mouseY > 0 && mouseY < 50) {
    hover = true;
  } else {
    hover = false;
  }
  
  if (mouseX > 25 && mouseX < 125 && mouseY > 575 && mouseY < 625) {
    hoverReset = true;
  } else {
    hoverReset = false;
  }
  
  if(drawPlanet) {
    for(x=0;x<i;x++) {
      myplanets[x].update();
      myplanets[x].display();
      if(x>0) {
        for(int y=0;y<x;y++) {
          myplanets[y].attract(myplanets[x]);
        }
      }
    }
  }
  fill(255);
  text("Reset",59,603);
}

void mousePressed() {
  if(mouseY>50) {
  if(i!=10) {
    myplanets[i] = new Planet(int(map(boxX,0,900,25,90)));
    myplanets[i].initialVelocity();
    drawPlanet = true;
    i++;
  }
  }
}

void mouseDragged() {
  if(hover) {
    boxX = mouseX-50;
  }
}

void mouseClicked() {
  if(hoverReset) {
    setup();
  }
}

class Planet {
  
  PVector location;
  PVector velocity;
  PVector acceleration;
  PVector force;
  PVector dist;
  int mass;
  long multiplyer = 1000000000000l;
  
  Planet(int newMass) {
    location = new PVector(mouseX,mouseY);
    velocity = new PVector(0,0);
    acceleration = new PVector(0,0);
    force = new PVector(0,0);
    dist = new PVector(width/2-location.x,height/2-location.y);
    mass = newMass;
  }
  
  void attract(Planet p) {
    PVector distance = new PVector(0,0);
    PVector shareForce = new PVector(0,0);
    distance.x = this.location.x-p.location.x;
    distance.y = this.location.y-p.location.y;
    shareForce.x = multiplyer*((G*p.mass*this.mass)/sq(sqrt(sq(distance.x)+sq(distance.y))))*cos(radians(degrees(acos((sq(sqrt(sq(distance.x)+sq(distance.y)))+sq(distance.x)-sq(distance.y))/(2*sqrt(sq(distance.x)+sq(distance.y))*distance.x)))));
    shareForce.y = multiplyer*((G*p.mass*this.mass)/sq(sqrt(sq(distance.x)+sq(distance.y))))*sin(radians(degrees(acos((sq(sqrt(sq(distance.x)+sq(distance.y)))+sq(distance.x)-sq(distance.y))/(2*sqrt(sq(distance.x)+sq(distance.y))*distance.x)))));
    this.force.add(shareForce);
  }
  
  void update() {
    dist.x = width/2-location.x;
    dist.y = height/2-location.y;
    force.x = multiplyer*((G*MASS_P*mass)/sq(sqrt(sq(dist.x)+sq(dist.y))))*cos(radians(degrees(acos((sq(sqrt(sq(dist.x)+sq(dist.y)))+sq(dist.x)-sq(dist.y))/(2*sqrt(sq(dist.x)+sq(dist.y))*dist.x)))));
    force.y = multiplyer*((G*MASS_P*mass)/sq(sqrt(sq(dist.x)+sq(dist.y))))*sin(radians(degrees(acos((sq(sqrt(sq(dist.x)+sq(dist.y)))+sq(dist.x)-sq(dist.y))/(2*sqrt(sq(dist.x)+sq(dist.y))*dist.x)))));
    if(dist.y < 0) {
      force.y = force.y * -1;
    }
    acceleration = PVector.div(force,mass);
    velocity.add(acceleration);
    location.add(velocity);
  }
  
  void display() {
    stroke(0);
    fill(#5882FA);
    planet[x].resize(mass,mass);
    image(planet[x],location.x-mass/2,location.y-mass/2);
  }
  
  void initialVelocity() {
    if(location.x < width/2) {
      velocity.y = -5;
    } else {
      velocity.y = 5;
    }
    if(location.y < height/2) {
      velocity.x = 5;
    } else {
      velocity.x = -5;
    }
  }
}
