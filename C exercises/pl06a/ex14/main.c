#include <stdio.h>
#include "diferentes.h"
short int ptrvec1[12] = {1,5,45,423,234,3,4,2,4,453,10,666};
short int ptrvec2[12] = {1,8,45,423,234,83,4,88,4,89,10,88};
int ptrvec3[12] = {};
int num=12;


void imprimirShort(short int ptrvec[]){
	int i = 0;  	
	for(i = 0 ; i < num; i++){
		printf("  %d",ptrvec[i]);	
	}
	printf("\n");
}

void imprimir( int ptrvec[], int ocorrencias){
	int i = 0;  	
	for(i = 0 ; i < ocorrencias; i++){
		printf("  %d",ptrvec[i]);	
	}
	printf("\n");
}

int main(void) {
	imprimirShort(ptrvec1);
	imprimirShort(ptrvec2);
	int ocorrencias;	
	ocorrencias = diferentes();
	imprimir(ptrvec3,ocorrencias);
	printf("Foram encontrados %d numeros \n",ocorrencias);

	return 0;
}

