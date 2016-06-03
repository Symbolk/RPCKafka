#ifndef CONTAINER_H_INCLUDED
#define CONTAINER_H_INCLUDED
#include <string.h>
#define NUM 20

#endif // CONTAINER_H_INCLUDED

struct Container{
   char*   array[NUM];
   int header ;
   int mode;
}Light,Temperature;

//void init();
char* container_pop(struct Container*);
int container_push(struct Container*,char* i);
void container_printall(struct Container*);
void container_clear(struct Container*);



int container_checkMode(struct Container*);
void container_changeMode(struct Container*,int);
int container_getAll(struct Container*,char**);
