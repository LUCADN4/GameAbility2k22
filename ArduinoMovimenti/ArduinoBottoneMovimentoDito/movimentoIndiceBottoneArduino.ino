#include <Servo.h>// library for engine use
Servo INDICE;//defined engine name to be moved

int pulsante = A0;//position of the button
int statoPulsante = 0; 
int statoPulsantePrec = 0;
int i = 0;//set count for connection code processing
void setup(){
  INDICE.attach(6);//pin for motor connection
  pinMode(pulsante, INPUT);
  randomSeed(analogRead(A1));
}

void loop(){
   INDICE.write(118);//starting position of the index
   statoPulsante = digitalRead(pulsante);
  if (statoPulsante != statoPulsantePrec){// status control button different from the previous one, to avoid double clicking
    if(statoPulsante == HIGH){
        INDICE.write(20); 
        delay(1000);// time lag between movements
        INDICE.write(118);
        Serial.println(i);//used to see if there is a data pass with the processing code
        i++;  
    }
    statoPulsantePrec = statoPulsante;
}
}
