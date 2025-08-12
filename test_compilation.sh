#!/bin/bash

# Script de prueba para verificar que la compilación funciona

echo "=== Prueba de Compilación ==="

# Obtener el directorio del script
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$SCRIPT_DIR"

echo "Directorio de trabajo: $(pwd)"

# Verificar Java
echo "Verificando Java..."
java -version

echo
echo "Verificando archivos..."
echo "Parser class: $(ls -la src/ve/edu/unet/parser.class 2>/dev/null || echo "NO ENCONTRADO")"
echo "JAR runtime: $(ls -la src/especificacion/java-cup-11b-runtime.jar 2>/dev/null || echo "NO ENCONTRADO")"
echo "JAR cup: $(ls -la src/especificacion/java-cup-11b.jar 2>/dev/null || echo "NO ENCONTRADO")"

echo
echo "Probando classpath..."
java -cp "src:src/especificacion/java-cup-11b-runtime.jar:src/especificacion/java-cup-11b.jar" ve.edu.unet.parser --help 2>&1 | head -5

echo
echo "Listando archivos .tny disponibles:"
ls -la ejemplo_fuente/*.tny

echo
echo "=== Fin de la prueba ==="