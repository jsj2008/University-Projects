ex1: main.o
	gcc -Wall -g main.o -o ex1

main.o: main.c 
	gcc -c -g -Wall main.c -o main.o

run: ex1 clean
	./ex1

clean:
	rm -f main.o

remove: clean
	rm -f ex1
