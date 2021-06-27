echo "Iniciando verificação de diretorios necessarios..."
if [ ! -d "DirShell01" ]
then
    echo "O diretorio DirShell01 não existe. Iniciando criação..."
    mkdir DirShell01
    echo "criação concluida!"
else
    echo "O diretorio DirShell01 já existe!"
fi

if [ ! -d "DirShell02" ]
then
    echo "O diretorio DirShell02 não existe. Iniciando criação..."
    mkdir DirShell02
    echo "criação concluida!"
else
    echo "O diretorio DirShell02 já existe!"
fi

echo "=============================================================="
echo "Digite o primeiro valor: "
read n1

echo "Digite o segundo valor: "
read n2

echo "-----Operações-----"
echo "1 - Adição"
echo "2 - Subtração"
echo "3 - Multiplicação"
echo "4 - Divisão"
echo "Digite o tipo de operação: "
read o
#!/bin/bash

javac op.java
java op $n1 $n2 $o

$SHELL