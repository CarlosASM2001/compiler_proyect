#!/bin/bash

# Script para compilar archivos .tny a .tm
# Compila todos los archivos .tny de ejemplo_fuente y los guarda en ejemplo_generado

echo "=== Compilador de archivos .tny ===="
echo "Compilando archivos de ejemplo_fuente/ a ejemplo_generado/"
echo

# Asegurar que existe la carpeta ejemplo_generado
mkdir -p ejemplo_generado

# Contador de archivos procesados
total=0
exitosos=0
con_errores=0

# Compilar desde la raíz del proyecto
cd /workspace

# Buscar todos los archivos .tny en ejemplo_fuente
for archivo in ejemplo_fuente/*.tny; do
    if [ -f "$archivo" ]; then
        echo "Compilando: $archivo"
        total=$((total + 1))
        
        # Ejecutar el compilador Java con las dependencias necesarias
        if java -cp "src:src/especificacion/java-cup-11b-runtime.jar:src/especificacion/java-cup-11b.jar" ve.edu.unet.parser "$archivo"; then
            echo "✓ Compilación exitosa: $archivo"
            exitosos=$((exitosos + 1))
        else
            echo "✗ Error en compilación: $archivo"
            con_errores=$((con_errores + 1))
        fi
        echo "----------------------------------------"
    fi
done

echo
echo "=== Resumen de compilación ==="
echo "Total de archivos procesados: $total"
echo "Compilaciones exitosas: $exitosos"
echo "Compilaciones con errores: $con_errores"
echo

# Mostrar archivos generados
if [ $exitosos -gt 0 ]; then
    echo "Archivos .tm generados:"
    ls -la ejemplo_generado/*.tm 2>/dev/null || echo "No se encontraron archivos .tm generados"
fi