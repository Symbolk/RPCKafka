objects = producerServer.class 

all : $(objects)

producerServer.class : producerServer.java producerServerStub.java producer.java
	javac -cp '.:oncrpc.jar' producerServer.java

run :
	java -cp '.:oncrpc.jar' producerServer
	
clean : 
	rm *.class 
