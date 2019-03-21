/// TEMA PAA - Ardelean Denis-Daniel - Subgrupa 1.1 ///
/// Tablou de parinti ; Afisare in inordine ; Inaltime ///
#include <stdio.h>
#include <stdlib.h>

int parinte[] = {0,1,1,1,2,5,5,2,3,9,9,4,12};
int copii[sizeof(parinte)/4];
int b = 0; 
int inaltime[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};


int aflare_copii(int x) {
    int j = 0;
    for(int i=0; i<sizeof(parinte)/4; i++) {
        if(parinte[i] == x) {
            copii[j++] = i+1;
        }
    }
    return j;
}

void inordine(int rad) {
    int j;
    inaltime[b]++; //de fiecare data cand parcurgem un nod crestem inaltimea pentru bratul curent
    j = aflare_copii(rad);  //aflam copii radacinii curente actualizand vectorul copii declarat global 
                            //si salvam numarul de copii ai radacinii in variabila j
    if(j != 0) {    //verificam daca nodul nu este cumva frunza
        inordine(copii[0]); //apel recursiv pentru primul subarbore
        printf("%d ", rad); //afisam radacina
        for(int i=1; i<j; i++) { //pentru fiecare subarbore ramas
            aflare_copii(rad);  //reactualizam tabloul copii pentru radacina curenta deoarece acesta
                                //a fost modificat pentru ceilalti fii ai acestei radacini
            inordine(copii[i]); //apel recursiv pentru ceilalti subarbori
        }
    } else {
        printf("%d ", rad); //afisam frunza
    }
    // cand iesim din apel trecem la urmatorul brat pentru a-i afla inaltimea
    b++;
    inaltime[b] = inaltime[b-1];
    inaltime[b]--; // scadem inaltimea pentru ca am iesit din apelul lui inordine
}

void maxim() {
    int max = 0;
    for(int i=0; i<sizeof(parinte)/4; i++) {
        if(max < inaltime[i])
            max = inaltime[i];
    }
    printf("\n\nInaltimea maxima este %d\n", max);
}

int main() {

    printf("Arborele parcurs in inordine:\n\t");
    inordine(1);
    maxim();

    return 0;
}