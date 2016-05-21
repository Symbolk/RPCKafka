objects = producer 

all : $(objects)

producer : producer.c producer_clnt.c producer_xdr.c producer.h
	gcc producer.c producer_clnt.c producer_xdr.c -o producer -lnsl

run :
	./producer
	
clean : 
	rm ./producer
