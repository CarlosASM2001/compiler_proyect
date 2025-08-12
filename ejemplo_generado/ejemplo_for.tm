*      Compilacion TINY para el codigo objeto TM
*      Archivo: NOMBRE_ARREGLAR
*      Preludio estandar:
0:       LD       6,0(0)
1:       ST       0,0(0)
2:       LDC       0,0(0)
3:       ST       0,0(5)
4:       LD       0,0(5)
5:       ST       0,0(6)
6:       LDC       0,10(0)
7:       LD       1,0(6)
8:       SUB       0,1,0
9:       JLT       0,2(7)
10:       LDC       0,0(0)
11:       LDA       7,1(7)
12:       LDC       0,1(0)
*      for: el salto hacia el final debe estar aqui
14:       LD       0,0(5)
15:       OUT       0,0,0
16:       LD       0,0(5)
17:       ST       0,0(6)
18:       LDC       0,1(0)
19:       LD       1,0(6)
20:       ADD       0,1,0
21:       ST       0,0(5)
22:       LDA       7,-19(7)
13:       JEQ       0,9(7)
*      Fin de la ejecucion.
23:       HALT       0,0,0
