int x;
int y;
int num;
int mul = 1;
int limit = 18;

void setup() {
  size(displayWidth,displayHeight-100);
  num = 0;
  fill(#190707);
  stroke(#FFFF00);
}

void draw() {
  background(#190707);
  x = width/2;
  y = height/2;
  num = 0;
  fibCurve(0,0);
  fibCurve(0,-1);
  while(num<limit) {
    if(num % 4 == 2) {
      fibPatt();
    }
  }
}

void fibCurve(int incrementX,int incrementY) {
  x+=incrementX*mul;
  y+=incrementY*mul;
  int cx = fib(num)*mul;
  if(num%4 == 1) {
    arc(x,y+cx,2*cx,2*cx,3*PI/2,2*PI,PIE);
  } else if(num%4==2) {
    arc(x+cx,y+cx,2*cx,2*cx,PI,3*PI/2,PIE);
  } else if(num%4==3) {
    arc(x+cx,y,2*cx,2*cx,PI/2,PI,PIE);
  } else if(num%4==0) {
    arc(x,y,2*cx,2*cx,0,PI/2,PIE);
  }
  num++;
}
  
void fibPatt() {
  int a;
  int b;
  int c;
  a = fib(num);
  b = fib(num+1);
  c = fib(num+3);
  fibCurve(-a,0);
  fibCurve(0,a);
  fibCurve(b,-a);
  fibCurve(-b,-c);
}

int fib(int n) {
  if(n == 1 || n == 0) {
    return 1;
  } else {
    return fib(n-1) + fib(n-2);
  }
}
