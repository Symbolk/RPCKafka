#include <stdio.h>
#include <stdlib.h>
#include "producer.h"

int main(int argc, char* argv[]){
	CLIENT *clnt;	
	call_result *result;
	//get info from console
	char *server="localhost";
	char *topic="Light";

	char* key="20160520";
	int value=1300;
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
	send_1(topic,key,value,clnt);//pop from the queue and get the record 
	//judge the calling result itself
	if(result==(call_result *)NULL){
		clnt_perror(clnt, server);
		printf("call failed\n");
		return -1;
	}
	if(result->error==1){
		fprintf(stderr, "%s sending failed.\n",argv[0]);
		return -1;
	}else{
		//result->error==0, no errors
		printf("record sent to %s\n", server);
	}
	
	clnt_destroy(clnt);
	return 0;
}
