#include <stdio.h>    // Used for printf() statements
#include <stdlib.h>
#include <string.h>
#include <errno.h>
#include <stdint.h>
#include <wiringPi.h> // Include WiringPi library!

#include <time.h>

#define TRUE 1;
#define FALSE 0;

int analogRead(int pin);
int Initial_Device ();

int Read_Switches ();

int Move_Engine (int posicion);

int Read_All_Sensores (int valores[]);

int Set_Light (int Valor_led_rojo, int Valor_led_amarillo);

int Read_Button ();

int Clear_Device ();

