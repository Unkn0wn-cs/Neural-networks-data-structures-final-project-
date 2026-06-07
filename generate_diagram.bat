@echo off
REM Genera PNG desde PlantUML. Requiere plantuml.jar en la raíz del proyecto.
if exist plantuml.jar (
  java -jar plantuml.jar -tpng docs\class_diagram.puml -o docs
) else (
  echo plantuml.jar no encontrado. Descargar plantuml.jar y ejecutar: java -jar plantuml.jar -tpng docs\class_diagram.puml
)
echo Done.
pause
