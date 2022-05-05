#include <Servo.h>// library for engine use
char data;// character passed by java
Servo INDICE;//defined engine name to be moved

void setup(){
  INDICE.attach(6); //pin for motor connection
  Serial.begin(115200);//data flow
}
void loop(){
  INDICE.write(118);//starting position of the index
  if(Serial.available() > 0){//if data has been written to the Serial stream
    data = Serial.read();// entered the character in date
    Serial.flush();
   if(data == '1'){// Date equalization check and subsequent finger movement
        INDICE.write(10); 
        delay(1000);// time lag between movements
        INDICE.write(128);
    }
  }
  delay(50);
}
