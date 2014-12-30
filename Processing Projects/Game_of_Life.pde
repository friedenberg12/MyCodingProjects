PVector[] coords;
Box[] boxes;
int num;
int count;
int size;
int on = -13750530;
boolean gamestart;

void setup() {
  size(1200,700);
  num = 0;
  size = 50;
  gamestart = false;
  boxes = new Box[(height/size)*(width/size)];
  for(int i =0;i<height/size;i++) {
    for(int j=0;j<width/size;j++) {
      boxes[num] = new Box(j*size,i*size);
      num++;
    }
  }
}

void draw() {
  background(#000000);
  fill(#000000);
  stroke(#FFFFFF);
  count = 0;
  if(gamestart) {
    for(int i =0;i<boxes.length;i++) {
      boxes[i].checkEdges();
      count++;
    }
    for(int i =0;i<boxes.length;i++) {
      boxes[i].update();
    }
    wait(0.1);
  }
  for(int i =0;i<boxes.length;i++) {
      boxes[i].display();
  }
}

void mousePressed() {
  for(int i =0;i<boxes.length;i++) {
    if(boxes[i].checkHover()) {
      boxes[i].colored = !boxes[i].colored;
    }
  }
}
void mouseDragged() {
  for(int i =0;i<boxes.length;i++) {
    if(boxes[i].checkHover()) {
      boxes[i].colored = true;
    }
  }
}   
void keyPressed() {
  if(key == ' ') {
    gamestart = !gamestart;
    if(!gamestart) {
      setup();
    }
  }
}

void wait(float _time) {
  float waittime = _time*1000;
  float timer = millis();
  while(millis()-timer<waittime) {
    waittime = _time*1000;
  }
}

class Box {
  
  PVector location;
  PVector center;
  boolean colored;
  int[] neighbors;
  
  Box(int _x,int _y) {
    location = new PVector(_x,_y);
    center = new PVector(_x+size/2,_y+size/2);
    colored = false;
    neighbors = new int[8];
  }
  void display() {
    if(colored) {
      fill(#2E2EFE);
    } else {
      fill(#000000);
    }
    rect(location.x,location.y,size,size);
  }
  boolean checkHover() {
    if(mouseX>location.x && mouseX<location.x+size && mouseY>location.y && mouseY<location.y+size) {
      return true;
    } else {
      return false;
    }
  }
  
  void checkEdges() {
    
    if(count<(width/size*height/size)-(width/size)) {
      if(boxes[count+width/size].colored) {
        neighbors[0] = 1;
      }
    }
    if(count>=width/size) {
      if(boxes[count-width/size].colored) {
        neighbors[1] = 1;
      }
    }
    if(count<(width/size*height/size)-(width/size) && (count)%(width/size)!=(width/size)-1) {
      if(boxes[count+(width/size)+1].colored) {
        neighbors[2] = 1;
      }
    }
    if(count<(width/size*height/size)-(width/size) && (count)%(width/size)!=0) {
      if(boxes[count+(width/size)-1].colored) {
        neighbors[3] = 1;
      }
    }
    if(count>=width/size && (count)%(width/size)!=(width/size)-1) {
      if(boxes[count-(width/size)+1].colored) {
        neighbors[4] = 1;
      }
    }
    if(count>=width/size && (count)%(width/size)!=0) {
      if(boxes[count-(width/size)-1].colored) {
        neighbors[5] = 1;
      }
    }
    if((count)%(width/size)!=0) {
      if(boxes[count-1].colored) {
        neighbors[6] = 1;
      }
    }
    if((count)%(width/size)!=(width/size)-1) {
      if(boxes[count+1].colored) {
        neighbors[7] = 1;
      }
    }
  }
  
  void update() {
    int sum = neighbors[0] + neighbors[1] + neighbors[2] + neighbors[3] + neighbors[4] + neighbors[5] + neighbors[6] + neighbors[7];
    if(colored) {
      if(sum==1 || sum>=4 || sum==0) {
        colored = false;
      } else {
        colored = true;
      }
    }
    if(colored == false) {
      if(sum==3) {
        colored = true;
      } else {
        colored = false;
      }
    }
    for(int i=0;i<neighbors.length;i++) {
      neighbors[i] = 0;
    }
  }
}
