JCC = javac

JVM = java

TARGET = test_prims

JFLAGS = -g

all: $(TARGET).class run

$(TARGET).class: $(TARGET).java
	$(JCC) $(JFLAGS) $(TARGET).java

run:
	$(JVM) $(TARGET)

clean:
	$(RM) *.class

re:
	$(MAKE) clean
	$(MAKE)
	$(MAKE) run

.phony: all run clean re