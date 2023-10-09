@echo off
set numberOfTimes=5
set outputFileName=output.txt

rem Clear the existing output file (if any)
echo. > %outputFileName%

for /l %%i in (1, 1, %numberOfTimes%) do (
    java Tester >> %outputFileName%
)

echo "Batch script execution complete."
