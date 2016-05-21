#include <stdio.h>    // Used for printf() statements
#include <stdlib.h>
#include <string.h>
#include <errno.h>
#include <stdint.h>
#include <wiringPi.h> // Include WiringPi library!
#include "periodic_tasks.c"
#include "RasberryDevice.h"
#include "container.h" //its function is to contain the data from Raspberry
#include <sys/time.h>
#include <time.h>
#include "producer.h"

#define TRUE 1;
#define FALSE 0;
#include <pthread.h>



  //  int i,j,analog ;
   // int bright ;
   // const int pwmValue = 75; // Use this to set an LED brightness

  //  int sensores [8] = {0,0,0,0,0,0,0,0};

   // int modo, switch1, switch2, pulsador;

    int reference,temper,light,move_Mode,move_Off;


    pthread_t process1;
    pthread_t process2;
    pthread_t process3;
    pthread_t process4;
    pthread_t process5;
    pthread_t process6;

    struct sched_param sp;
    pthread_attr_t attrs;

    pthread_mutex_t light_mutex;
    pthread_mutex_t temper_mutex;
    pthread_mutex_t refer_mutex;


///////////////time count //////////
double timeval_diff(struct timeval *a, struct timeval *b)
{
  return
    (double)(a->tv_sec + (double)a->tv_usec/1000000) -
    (double)(b->tv_sec + (double)b->tv_usec/1000000);
}


///////////////light////////////////
int getlight(){
  struct timeval t_ini, t_fin;
  double secs;
  gettimeofday(&t_ini, NULL); ///start


  pthread_mutex_lock(&light_mutex);
  int result = light;
  pthread_mutex_unlock(&light_mutex);

  gettimeofday(&t_fin, NULL); ///stop
  secs = timeval_diff(&t_fin, &t_ini);
 // printf("Time to get light:    %.16g milliseconds\n", secs * 1000.0);

  return result;
}
void setlight(int l){
  struct timeval t_ini, t_fin;
  double secs;

gettimeofday(&t_ini, NULL); ///start

   pthread_mutex_lock(&light_mutex);
   light = l;
   pthread_mutex_unlock(&light_mutex);

  gettimeofday(&t_fin, NULL);///stop
  secs = timeval_diff(&t_fin, &t_ini);
 // printf("Time to set light:    %.16g milliseconds\n", secs * 1000.0);
}
////////////////reference////////////////
int getreference(){
    struct timeval t_ini, t_fin;
    double secs;
    gettimeofday(&t_ini, NULL);///start

    pthread_mutex_lock(&refer_mutex);
    int result = reference;
    pthread_mutex_unlock(&refer_mutex);
    gettimeofday(&t_fin, NULL); ///stop
   secs = timeval_diff(&t_fin, &t_ini);
   //printf("Time to get reference :    %.16g milliseconds\n", secs * 1000.0);

    return result;
}

void setreference(int r){
    struct timeval t_ini, t_fin;
    double secs;
    gettimeofday(&t_ini, NULL);///start

   pthread_mutex_lock(&refer_mutex);
   reference = r;
   pthread_mutex_unlock(&refer_mutex);

   gettimeofday(&t_fin, NULL);///stop
  secs = timeval_diff(&t_fin, &t_ini);
 // printf("Time to set reference :    %.16g milliseconds\n", secs * 1000.0);
}
////////////////temperature///////////////
int gettemper(){
    struct timeval t_ini, t_fin;
    double secs;
    gettimeofday(&t_ini, NULL);///start

   pthread_mutex_lock(&temper_mutex);
   int result = temper;
   pthread_mutex_unlock(&temper_mutex);

    gettimeofday(&t_fin, NULL);///stop
  secs = timeval_diff(&t_fin, &t_ini);
 // printf("Time to get temperature :    %.16g milliseconds\n", secs * 1000.0);
   return result;

}

void settemper(int t){
     struct timeval t_ini, t_fin;
    double secs;
    gettimeofday(&t_ini, NULL);///start

    pthread_mutex_lock(&temper_mutex);
    temper = t;
    pthread_mutex_unlock(&temper_mutex);

    gettimeofday(&t_fin, NULL);///stop
  secs = timeval_diff(&t_fin, &t_ini);
 // printf("Time to set temperature :    %.16g milliseconds\n", secs * 1000.0);
}
////////////////threads/////////////////////

void threadlight(void){ //this thread read the light intensity

  struct timeval t_ini, t_fin;
  double secs;



   struct periodic_task *p_d;

   p_d = start_periodic_timer(0, 500);




    while(1){

       wait_next_activation(p_d);

       gettimeofday(&t_ini, NULL);  ///start
       int tmp_1 = analogRead(1);
       int tmp_2 = analogRead(1);
       int tmp_3 = analogRead(1);
       int result = (tmp_1+tmp_2+tmp_3)/3;
     //  printf("Light Intensity:%d\n",result);
       setlight(result);


      int localrefer = getreference();

    //  printf("Reference parameter of engine:%d\n",localrefer);



    if(result>=(localrefer+50)){
     move_Mode=0;
     move_Off=1;
    }
     else if(result<=(localrefer-50)){

     move_Mode=1;
     move_Off=1;

    }
    else{
     move_Mode=0;
     move_Off=0;
    }

     //delay(100);
     gettimeofday(&t_fin, NULL);///end
     secs = timeval_diff(&t_fin, &t_ini);
   //  printf("Time to run thread light :    %.16g milliseconds\n", secs * 1000.0);
    }



}

//this thread read the temperature
void threadtemper(void){
   struct timeval t_ini, t_fin;
  double secs;


   struct periodic_task *p_d;
   p_d = start_periodic_timer(0, 1500);

    while(1){
         wait_next_activation(p_d);
        gettimeofday(&t_ini, NULL); ///start

        int tmp = analogRead(2);
     //   printf("Temperature:%d\n",tmp);
        settemper(tmp);

       gettimeofday(&t_fin, NULL);///stop
       secs = timeval_diff(&t_fin, &t_ini);

   //     printf("Time to run thread temperature :    %.16g milliseconds\n", secs * 1000.0);
        //delay(1500);

    }
}

//this thread read the reference of light
void threadrefer(void){
    struct timeval t_ini, t_fin;
    double secs;
    struct periodic_task *p_d;
    p_d = start_periodic_timer(0, 1000);

while(1){
      wait_next_activation(p_d);
     gettimeofday(&t_ini, NULL);///start

    int tmp = analogRead(0);
   // printf("Reference:%d\n",tmp);
    setreference(tmp);
    gettimeofday(&t_fin, NULL);///stop
secs = timeval_diff(&t_fin, &t_ini);
  //  printf("Time to run thread reference :    %.16g milliseconds\n", secs * 1000.0);
   // delay(1000);
}

}

//this thread  control the engine
void threadengine(void)
{
struct timeval t_ini, t_fin;
double secs;
struct periodic_task *p_d;
p_d = start_periodic_timer(200, 200);

while(1){

  wait_next_activation(p_d);
  gettimeofday(&t_ini, NULL);///start
  if(move_Off==1&&move_Mode==0){
    Move_Engine(150);
   // wait_next_activation(p_d);
   // delay (200);

    //Move_Engine(0);

    //delay(200);


    }
    else if((move_Off==1&&move_Mode==1)){

    Move_Engine(600);
    // wait_next_activation(p_d);
  //  delay (200);

   // Move_Engine(0);

   // delay(200);
    }

     else if(move_Off==0){
    
     Move_Engine(0);

   }

    gettimeofday(&t_fin, NULL); ///stop
secs = timeval_diff(&t_fin, &t_ini);
  //  printf("Time to run thread engine :    %.16g milliseconds\n", secs * 1000.0);
  }
}
/////////////////////shenbo////// 
// Get the data from container and send to kafka
void threadshenbo(){
	send_1("Light","0",container_pop(&Light),clnt);
	send_1("Temperature","0",container_pop(&Temperature),clnt);
    // container_printall(&Light);
   //printf("In shenbo thread value  %d \n",container_pop(&Light));
}
/////////////////////////////////////////
//this thread send the data to some containers
void threadsend(void){

struct timeval t_ini, t_fin;
double secs;
struct periodic_task *p_d;

p_d = start_periodic_timer(1600,4000);
  while(1){
    wait_next_activation(p_d);

    gettimeofday(&t_ini, NULL);

    int locallight = getlight();
    int localtemper = gettemper();

 //functions provided by container.h
 //in order to push the data to a container

    container_push(&Light,locallight);
    container_push(&Temperature,localtemper);
  //  printf("value  %d",container_pop(&Light));
  //  printf("Sending Parameter Now: %d %d %d\n",light,reference,temper);
   // delay(4000);



    gettimeofday(&t_fin, NULL);

    secs = timeval_diff(&t_fin, &t_ini);
  //  printf("Time to run thread send :    %.16g milliseconds\n", secs * 1000.0);



     sp.sched_priority = 1;
    pthread_attr_setschedparam(&attrs, &sp);
    pthread_create(&process6,&attrs,(void *) threadshenbo,NULL);
     pthread_join(process6,NULL);
  }

}




////////////////////////main///////////////
 int main(void)
{

    // initiation
    pthread_mutex_init(&light_mutex,NULL);
    pthread_mutex_init(&temper_mutex,NULL);
    pthread_mutex_init(&refer_mutex,NULL);
    //Get a client handle
    CLIENT *clnt;	
	call_result *result;
	char *server="192.168.1.0";
	clnt = clnt_create(server, PRODUCER, PRODUCERVERS, "TCP");
		if(clnt==(CLIENT *)NULL){
		clnt_pcreateerror(server);
		printf("CProducer create failed\n");
		return -1;
	}
	result=connect_1(clnt);
		if(result==(call_result *)NULL){
		clnt_perror(clnt, server);
		printf("connect failed\n");
		return -1;
	}

    Initial_Device();

    pthread_attr_init(&attrs);
   // pthread_attr_setschedpolicy(&attr,   SCHED_RR);

    sp.sched_priority = 4;
    pthread_attr_setschedparam(&attrs, &sp);
    pthread_create(&process1,&attrs,(void *) threadlight,NULL); //

    sp.sched_priority = 2;
    pthread_attr_setschedparam(&attrs, &sp);
    pthread_create(&process2,&attrs,(void *) threadtemper,NULL);

    sp.sched_priority = 3;
    pthread_attr_setschedparam(&attrs, &sp);
    pthread_create(&process3,&attrs,(void *) threadrefer,NULL);

    sp.sched_priority = 5;
    pthread_attr_setschedparam(&attrs, &sp);
    pthread_create(&process4,&attrs,(void *) threadengine,NULL);

    sp.sched_priority = 1;
    pthread_attr_setschedparam(&attrs, &sp);
    pthread_create(&process5,&attrs,(void *) threadsend,NULL);

   



/*
    for(i=0;i<20;i++){
    printf("Main Parameter Now: %d %d %d\n",light,reference,temper);

    delay(500);
    }
*/

    pthread_join(process1,NULL);
    pthread_join(process2,NULL);
    pthread_join(process3,NULL);
    pthread_join(process4,NULL);
    pthread_join(process5,NULL);


    Clear_Device();

    //pthread_attr_destroy(&attr);

    return (0);
}
