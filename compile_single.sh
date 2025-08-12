#!/bin/bash

# Script para compilar un archivo .tny específico
# Uso: ./compile_single.sh nombre_archivo.tny

if [ $# -eq 0 ]; then
    echo "Uso: $0 <archivo.tny>"
    echo "Ejemplo: $0 ejemplo_fuente/ejemplo_funciones_simple.tny"
    exit 1
fi

archivo="$1"

# Verificar que el archivo existe
if [ ! -f "$archivo" ]; then
    echo "Error: El archivo '$archivo' no existe"
    exit 1
fi

# Verificar que el archivo tiene extensión .tny
if [[ "$archivo" != *.tny ]]; then
    echo "Error: El archivo debe tener extensión .tny"
    exit 1
fi

echo "Compilando archivo individual: $archivo"
echo "----------------------------------------"

# Asegurar que existe la carpeta ejemplo_generado
mkdir -p ejemplo_generado

# Obtener el directorio del script y cambiar al directorio raíz del proyecto
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$SCRIPT_DIR"

echo "Directorio de trabajo: $(pwd)"

# Verificar que las dependencias existen
if [ ! -f "src/ve/edu/unet/parser.class" ]; then
    echo "ERROR: No se encuentra src/ve/edu/unet/parser.class"
    echo "Por favor, compile el proyecto primero."
    exit 1
fi

if [ ! -f "src/especificacion/java-cup-11b-runtime.jar" ]; then
    echo "ERROR: No se encuentra src/especificacion/java-cup-11b-runtime.jar"
    exit 1
fi

if [ ! -f "src/especificacion/java-cup-11b.jar" ]; then
    echo "ERROR: No se encuentra src/especificacion/java-cup-11b.jar"
    exit 1
fi

echo "✓ Todas las dependencias encontradas"

# Ejecutar el compilador Java con las dependencias necesarias
if java -cp "src:src/especificacion/java-cup-11b-runtime.jar:src/especificacion/java-cup-11b.jar" ve.edu.unet.parser "$archivo"; then
    echo "✓ Compilación exitosa"
    
    # Mostrar el archivo generado
    archivo_tm=$(echo "$archivo" | sed 's|ejemplo_fuente|ejemplo_generado|g' | sed 's|\.tny|\.tm|g')
    if [ -f "$archivo_tm" ]; then
        echo "Archivo generado: $archivo_tm"
        echo "Tamaño: $(ls -lh "$archivo_tm" | awk '{print $5}')"
    fi
else
    echo "✗ Error en la compilación"
    exit 1
fi