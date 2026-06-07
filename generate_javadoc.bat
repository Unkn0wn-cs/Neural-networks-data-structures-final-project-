@echo off
REM Genera Javadoc para el proyecto. Requiere JDK en el PATH.
REM Crea sources.txt y ejecuta javadoc para generar HTML en build\docs
dir /s /b *.java > sources.txt
if exist "%JAVA_HOME%\bin\javadoc.exe" (
  "%JAVA_HOME%\bin\javadoc.exe" -d build\docs -classpath "libs a instalar/*" @sources.txt
) else (
  javadoc -d build\docs -classpath "libs a instalar/*" @sources.txt 2>nul || echo javadoc no encontrado. Ejecute desde el JDK Command Prompt.
)
echo Done.
pause
