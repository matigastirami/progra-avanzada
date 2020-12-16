% Ejercicio 1
%clauses
entrada(paella).
entrada(gazpacho).
entrada(consomé).

carne(filete_de_cerdo).
carne(pollo_asado).

pescado(trucha).
pescado(bacalao).

postre(flan).
postre(helado).
postre(pastel).
%fin clauses

%Resolución
% a. Cuáles son los menús que ofrece el restaurante
menu(En,Pp,Po):-entrada(En),(carne(Pp);pescado(Pp)),postre(Po).
%menu(X,Y,Z).

% b. Cuáles son los menús que tienen Consomé en las entradas
menu_consome(A,B,C):- A = consomé,(carne(B);pescado(B)),postre(C).
% menu_consome(A, B, C).

% c. Cuáles son los menús que no contienen flan como postre
menu_sin_flan(A,B,C):- menu(A,B,C), C \= flan.
% menu_sin_flan(A, B, C).

---- EJ 2 ----



--- Resolución parcial TM

% Ej 2 parcial TM
ruta("CABA", "Rosario", 300 ).
ruta("Rosario", "Córdoba", 400).
ruta("Córdoba", "Salta", 500).
ruta("Rosario", "Mendoza", 1500).
ruta("Mendoza", "Salta", 1500).

distancia_aux(Orig, Dest, X):-
    ruta(Orig,Dest,R),X is R;
    ruta(Orig,Dest_aux,R), distancia_aux(Dest_aux, Dest, R2),X is R + R2.

distancia(Orig, Dest, X):-
    distancia_aux(Orig, Dest, X);
    distancia_aux(Dest, Orig, X).
    
prodcart(C1,C2,R1,R2):-distancia(C1,C2,R1),distancia(C1,C2,R2).
seleccion(C1,C2,R1):-prodcart(C1,C2,R1,R2),R1>R2.
menorRuta(C1,C2,R):-distancia(C1,C2,R), \+seleccion(C1,C2,R).

% Ej 3 parcial TM

func(X, R):-
    X<4,R is -X;
    (X>=4,X=<8),R is -4;
    X>8,R is X - 12.

% Ej 4

%clauses
transporte(roma,20).
transporte(londres,30).
transporte(tunez,10).

alojamiento(roma,hotel,50).
alojamiento(roma,hostal,30).
alojamiento(roma,camping,10).
alojamiento(londres,hotel,60).
alojamiento(londres,hostal,40).
alojamiento(londres,camping,20).
alojamiento(tunez,hotel,40).
alojamiento(tunez,hostal,20).
alojamiento(tunez,camping,5).
%finclauses

viaje(C,S,H,P):-
    transporte(C, PT),
    alojamiento(C, H, PA),
    P is PT * 2 + PA * S.

viaje_economico(C,S,H,P,Pmax):-viaje(C,S,H,P), P < Pmax.

% Una clase de andá a saber cuando 
persona(juan, 22).
persona(lucas, 24).
persona(matias, 25).
persona(nicolas, 26).
persona(jonathan, 28).
persona(nahuel, 20).
persona(hernan, 28).

num(1).
num(2).
num(3).
num(4).
num(5).
num(0).

% num -> {1,2,3,4,5,0}

prod_cart(X, Y):-num(X), num(Y).

seleccion(X, Y):-prod_cart(X, Y), X < Y.

proyeccion(X):-seleccion(X, _).
% proyeccion -> {1,1,1,1,2,2,2,3,3,4,0,0,0,0,0}

max(X):-num(X), not(proyeccion(X)).
% {1,2,3,4,5,0} - {1,1,1,1,2,2,2,3,3,4,0,0,0,0,0} = {5}

prod_cart_persona(X, XA, Y, YA):-persona(X, XA), persona(Y, YA).
seleccion_persona(X, XA, Y, YA):-prod_cart_persona(X, XA, Y, YA), XA < YA.
proyeccion_persona(X):-seleccion_persona(X, _, _, _).
max_persona(X):- persona(X, _), \+proyeccion_persona(X).

edad_min_persona(EdadX):-persona(_, EdadX), persona(_, EdadY), EdadX < EdadY.
edad_max_persona(Nombre):-persona(Nombre, Edad), \+edad_min_persona(Edad).

% Ej "Promocionaste?"

parcial1(ana,7).
parcial1(juan,4).
parcial1(pedro,3).
parcial1(mario, 10).
parcial2(ana,9).
parcial2(juan,8).
parcial2(pedro,1).
parcial2(mario, 10).

nota_final(X, NF):-parcial1(X,R1),parcial2(X,R2),NF is div(R1 + R2, 2).
promocionan(X, NF):-parcial1(X, R1), R1 >= 7,parcial2(X, R2), R2 >= 7, nota_final(X, NF_AUX), NF is NF_AUX.
cursada(X):-
    (parcial1(X, R1), R1 >= 4, R1 < 7, parcial2(X, R2), R2 >= 4);
    (parcial2(X, R22), R22 >= 4, R22 < 7, parcial1(X, R12), R12 >= 4).
recursan(X):-parcial1(X, R1), R1 < 4;parcial2(X, R2), R2 < 4.


prod_cart_promo(X, NF1,Y, NF2):-promocionan(X, NF1),promocionan(Y, NF2).
seleccion(X, NF1,Y, NF2):-prod_cart_promo(X, NF1,Y, NF2),NF1<NF2.
proyeccion(X):-seleccion(X,_,_,_).
premio_merito(X, NF):-promocionan(X,NF), not(proyeccion(X)).

% factorial prolog

factorial(0,1).
   
factorial(X, R):-
    X > 0,
    Next is X - 1,
    factorial(Next, R_aux),
    R is X * R_aux.