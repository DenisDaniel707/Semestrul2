const int ledPin = 6;
const int Hi=255, Lo=0;
const int RED=11, BLUE=10, GREEN=9;
int c=0, val=5;

void setup()
{
  Serial.begin(9600);
  //c=millis();
  pinMode(ledPin, OUTPUT);
  pinMode(RED, OUTPUT);
  pinMode(GREEN, OUTPUT);
  pinMode(BLUE, OUTPUT);
}

void loop()
{
  	analogWrite(RED,Hi);
  	analogWrite(BLUE,Lo);
  	delay(1000);
  	analogWrite(RED,Lo);
  	analogWrite(GREEN,Hi);
  	delay(1000);
  	analogWrite(GREEN,Lo);
  	analogWrite(BLUE,Hi);
	delay(1000);
  	analogWrite(RED,Hi);
  	analogWrite(GREEN,Hi);
  	delay(1000);
  	analogWrite(RED,75);
	analogWrite(BLUE,130);
	analogWrite(GREEN,Lo);
  	delay(1000);
  
  	/*
  	if(c<0 || c>255)
	    val = val * -1;
  	c = c + val;
  	analogWrite(ledPin,c);
	Serial.println(c);*/
}