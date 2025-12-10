@echo off
cd /d "%~dp0"
cd src
javac App.java ui\MainWindow.java ui\NewShipmentForm.java model\*.java
java App
pause
