#include <stdio.h>
#include "producer.h"

call_result* connect_1_svc(struct svc_req *req){
	static call_result result;
	printf("Sent!\n");
	
	return (&result);
}
