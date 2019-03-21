@echo off
cd /d %~dp0
set SRCDIR=..\
set DSTDIR=..\..\src\
set FILELIST=registerList.txt

if exist %DSTDIR% (
	del /f /s /q %DSTDIR%com\fsgame\proto\*.java
) else (
	md %DSTDIR%
)

for /f %%i in (%SRCDIR%%FILELIST%) do (
	echo Generating the files %%i.proto
	protoc --proto_path=%SRCDIR% --java_out=%DSTDIR% %SRCDIR%%%i.proto
)

pause
