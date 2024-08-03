JCC = javac

JVM = java

TARGET = Main

JFLAGS = -g

all: compile run

compile:
	$(JCC) $(JFLAGS) *.java

run:
	$(JVM) $(TARGET)

clean:
	$(RM) *.class

re:
	$(MAKE) clean
	$(MAKE)
	$(MAKE) run

.PHONY: all compile run clean re