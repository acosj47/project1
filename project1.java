// Justin Acosta 
// CST 112 eve
// Project 1

// Tasks
// Create a scene with a monster and Hero
// monster chases hero
// hero chases gold
// animate hero and monster
// add scoring


//Globals
float goldX, goldY, goldDX, goldDY;         //Gold variables
float monX,  monY,  monDX, monDY;           //Monster variables
float heroX, heroY, heroDX, heroDY;         //Hero variables
float horizon;                              //Horizon variable
float sunX, sunY;                           //Sun variables
float buttonX, buttonY, buttonW, buttonH;   //button to reset gold
int   count;                                //count for animation
int   score;                                //score 






/* Setup.  Monster on one side of screen at random height
Hero starts safely in the house(above horizon)
Gold at random postion near the center of screen */

void setup(){
  size( 800, 600);
  horizon = height/4;            
  score = 0;                     // score starts at 0
  sunX  = width*3/4;             // position of sun, sun does not reset
  sunY  = horizon - 80;          // postion of sun
  reset();
  
}

void draw(){
  count = count + 1;
  scene();
  showHero();
  showMonster();
  showGold();
  showButton();
  messages();
  score();
  move();
  bounce();
  gameRules();
  
}
// starting positions, and speeds
void reset(){
  heroX = width/2 -220;                               //Hero starting position
  heroY = horizon - 100;                
  monX  = width-30;                                   // Monster starting position
  monY  = random(horizon,height);
  goldX = random(width/2 -80 , width/2 + 80);         //gold starting position
  goldY = random(height/2 -80, height/2 + 80);
  goldDX= random(-6,6);                              //gold speed
  goldDY= random(-6,6);                              //gold speed
  buttonX = width/10;                                // postion of reset button
  buttonY = height-70; 
  buttonW = 100;
  buttonH = 50;
  
  
  
}

//Scene: light blu sky, light green grass, a few trees on the horizon
// House(in front of trees) above horizon, sun(behind trees) moving left to right
// Title centered near top of window
// Name at lower left

void scene(){
  fill(100, 200, 100);
  rect(0, horizon, width, height);           //Grass
  fill(100, 100, sunX+100);                  //Sky changes color based on sun position  
  rect(0, 0, width, horizon);                // Sky 
  
  
    noStroke();                              //sun light
  if ( count/30 % 2 == 0) {
    fill(0, 0, 255, 30);
    ellipse(sunX, sunY, 125, 125);
    fill(255, 255, 255, 30);
    ellipse(sunX, sunY, 150, 150);
    }else{
    fill(255, 255, 255, 30);
    ellipse(sunX, sunY, 100, 100);
    
  }
  
  stroke(1); 
  fill(255, 255, 0);
  ellipse(sunX, sunY, 75, 75);                    // Sun
  
  
  
  tree(width/2 - 100, horizon-60, 60);           // Trees
  tree(width/2 - 300, horizon-60, 60);
  tree(width/2 - 200, horizon-60, 60);
  tree(width/2 + 300, horizon-60, 60);
  
  
  fill(255, 0, 0);                               // House
  rect(width/2 - 250, horizon-60, 80, 60);  
  fill(0);
  triangle(width/2- 270, horizon-60, width/2-214, horizon-100, width/2-150, horizon-60);  //roof
  fill(0, 0, 200);
  rect(width/2 -245, horizon-50, 20, 20);        //windows
  rect(width/2 -195, horizon-50, 20, 20);
  fill(255, 255, 255, 150);
  rect(width/2 -240, horizon-50, 10, 20);    
  rect(width/2 -190, horizon-50, 10, 20);
  
 fill(100, 50,0);
 rect(width/2 - 220, horizon-30, 20, 30);        //door
 fill(255,255,0);
 ellipse(width/2 - 205, horizon-15, 5, 5);       //door knob
  

  
  
  
  
}

//Hero
void showHero(){                                    //shows hero
  float headX, headY;
  headX= heroX + 15;
  headY= heroY - 15;
  
  fill(0, 0, 255);
  rect(heroX, heroY, 30, 70);                       //body
  fill(0, 0, 255);
  fill(200, 190, 190);
  ellipse(headX, headY, 30, 30);                    //head
  fill(255);
  ellipse(headX - 10, headY, 8, 8);                 //eyes
  ellipse(headX + 7, headY, 8, 8);
  fill(0, 200, 0);
  ellipse(headX - 10, headY, 4, 4);                 // pupils
  ellipse(headX + 7, headY, 4, 4);
  fill(255, 0, 0);
  ellipse(headX, headY+ 10, 10, 5);                  //mouth 
  
  strokeWeight(5);                                   //arms 
  stroke(0,0,255);
  
  if(count/30 % 2 == 0){           //arm animation
    line(heroX, heroY, heroX - 20, heroY + 20);      //left arm
    line(heroX+30, heroY, heroX + 50, heroY + 20);   //right arm
  }else{
    line(heroX, heroY, heroX - 30, heroY + 10);      // left arm
    line(heroX+30, heroY, heroX + 60, heroY + 10);   //right arm
    
  }
                                                       // legs
  if(count/30 % 2 == 0){                               // animation
    line(heroX, heroY+70, heroX-15, heroY+100);        // left leg
    line(heroX+30, heroY+70, heroX+ 45, heroY+100);    // right leg
  }else{
    line(heroX, heroY+70, heroX-25, heroY+90);         //left leg
    line(heroX+30, heroY+70, heroX+55, heroY+90);      // right leg
    
    
  }
  
  
  
  
  
  
  
  strokeWeight(1);   // reset stroke and stroke weight
  stroke(0);
  
  
}

//Monster
void showMonster(){                                  //show monster
  fill(255, 0, 0);
  ellipse(monX, monY, 70, 90);                       //body
  arc(monX, monY-35, 40, 50, PI, TWO_PI);            //head
  fill(0);
  ellipse(monX-10, monY-45, 8, 8);                  //eyes
  ellipse(monX+10, monY-45, 8, 8);                  //eyes
  fill(255,255,0);
  ellipse(monX-10, monY-45, 5, 5);                 //pupils
  ellipse(monX+10, monY-45, 5, 5);
  
  if(count/30 % 2 == 0){                          //Bite animation
     fill(0);
     ellipse(monX, monY-35, 20, 10);              //mouth
  
     fill(255, 255,0);
     ellipse(monX-4, monY-38, 4, 4);              // Teeth
     ellipse(monX+4, monY-38, 4, 4);
  }else{
    ellipse(monX, monY-35, 20, 3);
  }
  
  fill(255, 0, 0);                             //arms
  ellipse(monX-40, monY, 30, 10);
  ellipse(monX+40, monY, 30, 10);
  

  

  
  
}

void showGold(){                                //shows gold
  
  noStroke();                                   //gold shiny-ness animation
  if(count/30 % 2 == 0){
    fill(200, 200, 0, 100);
    ellipse(goldX, goldY, 90, 90);
  }else{
    fill(255, 255, 0, 100);
    ellipse(goldX, goldY, 110, 110);
  }
  
  
  //Gold
  stroke(0);
  fill(255, 255, 0);
  ellipse(goldX, goldY, 60, 15);            //gold base
  ellipse(goldX, goldY, 20, 20);
  ellipse(goldX+10, goldY, 20, 20);         //gold coins on top
  ellipse(goldX+20, goldY, 20, 20);
  ellipse(goldX-10, goldY, 20, 20);
  ellipse(goldX-20, goldY, 20, 20);
  fill(0);
  arc(goldX, goldY, 60, 80, 0, PI );       //black pot
  
  
}

//Trees
void tree(float x, float y, float h){
  fill( 155, 150, 100);
  rect(x, y, h/2, h); 
  fill(100,250,150);
  triangle(x-30, y+30, x+15 , y-60, x + 60, y+30);
  

}

void showButton(){   // Shows Button to create new gold, deduct 50 points from score
                      
   fill(150);                   
   rect(buttonX, buttonY, buttonW, buttonH);  
   fill(0);
   text("click here", buttonX + 5, buttonY + 15);
   text("to reset gold", buttonX + 5, buttonY + 30);
   text("-50 points!", buttonX + 5, buttonY + 45);
                                          
                                         
  
}

void move(){                           // Move characters
 
 goldX += goldDX;   goldY += goldDY;        //move gold
 heroX = heroX + (goldX - heroX) / 60;      //move Hero, Hero follows gold 
 heroY = heroY + (goldY - heroY) / 60;
 
 monX = monX + (heroX - monX) / 80;        // move monster, Monster followes Hero
 monY = monY + (heroY - monY) / 80;        // monster moves at slower pace
 
 
 
  sunX += 2;                                 //move sun
  if (sunX > width + 200){                   // sun returns 
    sunX = 0;
  }
 
}

void bounce(){                               //Bounce gold off walls
 if (goldX > width - 20 || goldX < 20) {
     goldDX *= -1;
 }

  if(goldY < horizon || goldY > height - 20){
    goldDY *= -1;
  }


}

void messages(){           //Titles, name, help
fill(0);
textSize(20);
text("Justin Acosta", width/2 + 200, height - 40);  // Name
text("Gold Rush", width/2 -100, height/25);  //Title
textSize(15);
text("Press 'r' to reset score", width/2 + 200, height - 15); //help 

}

void score(){                                     // The score
  text(score, width/2 + 200, height/25);
  text("Score-", width/2 + 120, height/25);
  
  
}

void gameRules(){                                       // Rules of the game
  if (dist(heroX, heroY, goldX, goldY) < 90){            //hero catches gold + 50 points
    score += 50;                                         //resets positions
    reset();
  }
  
  
  if (dist(heroX, heroY, monX, monY) < 70) {          //monster catches hero - 100 points, reset positions
      score -= 100;
      reset();
  }
  
  if (score < 0){                               // score cannot be negative
    score = 0;
  }
}

void keyPressed(){    
 if (key == 'r'){                            // press "r" to reset position AND score
   score= 0;
   reset();
 }
}


 void mousePressed(){                          // Click button to reset postions 
   if (mouseX > buttonX &&                     // Clicking button deducts 50 points
       mouseX < buttonX + buttonW &&
       mouseY > buttonY &&
       mouseY < buttonY + buttonH){
         
         score = score - 50;
         reset();
         
         if(score < 0){              // score cannot be negative
            score = 0;
  }
       }
       
  
}
