#include <stdio.h>
#include "consumer.h"

int main(int argc, char* argv[]){
	CLIENT *clnt;	
	call_result *result;
	char *server="localhost";
	char *topic="LightRef";

	//create a client handle using the info
	clnt = clnt_create(server, CONSUMER, CONSUMERVERS, "TCP");
	printf("Consumer client started\n");
	if(clnt==(CLIENT *)NULL){
		clnt_pcreateerror(server);
		printf("CConsumer create failed\n");
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
	subscribe_1(topic,clnt);
	
	printf("%s\n",*subscription_1(clnt));

	clnt_destroy(clnt);
	return 0;
}
