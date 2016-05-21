objects = consumer

all : $(objects)

consumer : consumer.c consumer_clnt.c consumer_xdr.c consumer.h
	gcc consumer.c consumer_clnt.c consumer_xdr.c -o consumer -lnsl

run :
	./consumer host topic
	
clean : 
	rm ./consumer consumer.c consumer_clnt.c consumer_xdr.c consumer.h consumer_svc.c