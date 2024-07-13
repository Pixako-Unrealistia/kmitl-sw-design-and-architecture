JCC = javac

JVM = java

TARGET = TestGuitarHero

JFLAGS = -g

all: $(TARGET).class

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