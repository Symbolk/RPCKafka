objects = consumerServer.class

all : $(objects)

consumerServer.class : consumerServer.java consumerServerStub.java consumer.java
	javac -cp '.:oncrpc.jar' consumerServer.java

run :
	java -cp '.:oncrpc.jar' consumerServer

clean : 
	rm *.class 