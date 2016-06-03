objects = overall 

all : $(objects)

overall : threadmode1.c  RasberryDevice.c container.c periodic_tasks.c producer.h producer_clnt.c producer_xdr.c
	gcc -o overall threadmode1.c  RasberryDevice.c container.c periodic_tasks.c producer.h producer_clnt.c producer_xdr.c -lwiringPi -lrt -lpthread



run :
	chmod a+x ./overall
	sudo ./overall
	
clean : 
	rm ./overall
