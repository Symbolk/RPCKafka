#include <stdio.h>
#include "consumer.h"

int main(int argc, char* argv[]){
	CLIENT *clnt;	
	//get info from console
	char *server;
	char *topic;
	//for testing
	/*if(argc!=3){
		fprintf(stderr, "usage : %s host topic1+topic2+...\n",argv[0]);
		return -1;	
	}*/
	server = argv[1];
	topic = argv[2];
	//create a client handle using the info
	clnt = clnt_create(server, CONSUMER, CONSUMERVERS, "TCP");
	printf("CConsumer started\n");
	if(clnt==(CLIENT *)NULL){
		clnt_pcreateerror(server);
		printf("CConsumer create failed\n");
		return -1;
	}

	//call the remote procedure
	//subscribe_1(topic,clnt);
	printf("%s\n",*subscription_1(clnt));

	clnt_destroy(clnt);
	return 0;
}
