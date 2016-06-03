#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "producer.h"

int main(int argc, char* argv[]){
	CLIENT *clnt;	
	call_result *result;
	//get info from console
	char *server="localhost";
	char *topic="testlight";

	char* key="";
	char* value="";
	char* delim=",";
	char* raw="1569,2015-06-01 12:23:30";
	char lvalue[25];
	int n=sprintf(lvalue,"%s",raw);
	char* p=strtok(lvalue,delim);
	//The id of params
	int count = 0;
	while(p!=NULL){
		count++;
		if(count==1){
			value=p;
		}
		if(count==2){
			key=p;
		}
		p=strtok(NULL,delim);
		
	}
	printf("%d   %s:%s\n",n,key,value);
	//create a client handle using the info
	clnt = clnt_create(server, PRODUCER, PRODUCERVERS, "TCP");
	printf("CProducer started\n");
	if(clnt==(CLIENT *)NULL){
		clnt_pcreateerror(server);
		printf("CProducer create failed\n");
		return -1;
	}

	//call the remote procedure
	result=connect_1(clnt);
	//judge the calling result itself
	if(result==(call_result *)NULL){
		clnt_perror(clnt, server);
		printf("Connect to local server failed\n");
		return -1;
	}
	result=sendwithack_1(topic,key,value,clnt);//pop from the queue and get the record 
	if(result->error==1){
		fprintf(stderr, "%s sending failed.\n",argv[0]);
		return -1;
	}else{
		//result->error==0, no errors
		printf("Record sent to %s\n", server);
	}
	
	clnt_destroy(clnt);
	return 0;
}
