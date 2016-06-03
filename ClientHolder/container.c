
#include <stdio.h>    // Used for printf() statements
#include <stdlib.h>
#include <string.h>
#include "container.h"


/**
@author Bowen Wang

container of the messages from Raspberry Pi
write in mode 0 and read in mode 1

*/

/*
void init(){

container.header=0;
container.mode = 0;


}
*/
char* container_pop(struct Container* container){
if(container_checkMode(container)==0){

    container->header-- ;
    if(container->header==-1)
        container->header=NUM-1;
   return container->array[container->header];

 }

else
     printf("the container is not usable !");
}

int container_push(struct Container* container,char* String){

if(container_checkMode(container)==0){
     container->array[container->header] = String;

     container->header= (container->header+1)%NUM;

     if(container->header==0)
        container_changeMode(container,1);
     return 1;
  }
else
    return 0;


}

void container_printall(struct Container* container){
  int i=0;
    printf("--------------result--------------------- \n");
  for(i=0;i<NUM;i++){

     if(container->array[i]!=NULL)
     printf("%d : %s\n",i,container->array[i]);



  }
   printf("----------------------------------------- \n");

}

void container_clear(struct Container* container){
   int i=0;
   for(i=0;i<NUM;i++){
    container->array[i]=0;
   }
   container->header=0;
   container->mode=0;
    printf("clear the container!");
}



int container_checkMode(struct Container* container){

   return container->mode;
}

void container_changeMode(struct Container* container,int Mode){

    container->mode=Mode;
}

int container_getAll(struct Container* container,char** arr){
   if(container->mode==1){
     arr = container->array;
    container_clear(container);
     return 1;

   }
  else
    return 0;
}

