*      Compilacion TINY para el codigo objeto TM
*      Archivo: NOMBRE_ARREGLAR
*      Preludio estandar:
0:       LD       6,0(0)
1:       ST       0,0(0)
2:       LD       0,0(5)
3:       ST       0,0(6)
4:       LD       0,1(5)
5:       LD       1,0(6)
6:       ADD       0,1,0
7:       ST       0,2(5)
8:       LD       0,2(5)
9:       HALT       0,0,0
10:       LDC       0,5(0)
11:       ST       0,0(5)
12:       LDC       0,2(0)
13:       LDC       0,3(0)
14:       LDC       0,0(0)
15:       OUT       0,0,0
*      Fin de la ejecucion.
16:       HALT       0,0,0
