# Scripts de Compilación para archivos .tny

Este proyecto incluye scripts automatizados para compilar archivos `.tny` (Tiny) y generar archivos `.tm` (Tiny Machine) en la carpeta `ejemplo_generado`.

## Scripts Disponibles

### 1. `compile_examples.sh` - Compilación Masiva
Compila **todos** los archivos `.tny` en la carpeta `ejemplo_fuente/` automáticamente.

**Uso:**
```bash
./compile_examples.sh
```

**Características:**
- Compila todos los archivos `.tny` encontrados en `ejemplo_fuente/`
- Sobreescribe archivos `.tm` existentes en `ejemplo_generado/`
- Muestra un resumen detallado de compilaciones exitosas y errores
- Lista los archivos generados al final

### 2. `compile_single.sh` - Compilación Individual
Compila un archivo `.tny` específico.

**Uso:**
```bash
./compile_single.sh ejemplo_fuente/nombre_archivo.tny
```

**Ejemplo:**
```bash
./compile_single.sh ejemplo_fuente/ejemplo_funciones_simple.tny
```

**Características:**
- Compila un solo archivo especificado
- Valida que el archivo existe y tiene extensión `.tny`
- Muestra información del archivo generado (ubicación y tamaño)
- Proporciona mensajes de error claros

## Requisitos

Los scripts requieren:
- Java instalado en el sistema
- Los archivos JAR de dependencias en `src/especificacion/`:
  - `java-cup-11b-runtime.jar`
  - `java-cup-11b.jar`
- El compilador compilado en `src/ve/edu/unet/parser.class`

## Estructura de Archivos

```
/workspace/
├── ejemplo_fuente/          # Archivos fuente .tny
│   ├── ejemplo_funciones_simple.tny
│   ├── ejemplo_funciones_limpio.tny
│   └── ...
├── ejemplo_generado/        # Archivos compilados .tm (generados automáticamente)
│   ├── ejemplo_funciones_simple.tm
│   ├── ejemplo_funciones_limpio.tm
│   └── ...
├── compile_examples.sh      # Script para compilar todos los archivos
└── compile_single.sh        # Script para compilar un archivo individual
```

## Mensajes de Salida

### Compilación Exitosa
- ✓ Compilación exitosa: [archivo]
- Muestra el AST generado
- Muestra la tabla de símbolos
- Muestra el código objeto generado

### Compilación con Errores
- ✗ Error en compilación: [archivo]
- Muestra detalles del error sintáctico o semántico

## Notas Importantes

1. **Sintaxis Correcta**: Los archivos `.tny` deben seguir la sintaxis del lenguaje Tiny:
   - Declaraciones de variables al inicio del programa
   - Funciones definidas después de las declaraciones globales
   - Asignaciones y lógica del programa principal al final

2. **Sobreescritura**: Los scripts sobreescriben automáticamente archivos `.tm` existentes sin confirmación.

3. **Dependencias**: Si aparece el error "Could not find or load main class", verificar que los archivos JAR estén en la ubicación correcta.

## Solución de Problemas

### Error: "Could not find or load main class"
- Verificar que los archivos JAR estén en `src/especificacion/`
- Verificar que el compilador esté compilado correctamente

### Error de sintaxis en archivos .tny
- Asegurar que las declaraciones de variables estén al principio
- Verificar que las funciones estén correctamente definidas con `func...end`
- Revisar que no haya caracteres especiales o encoding incorrecto