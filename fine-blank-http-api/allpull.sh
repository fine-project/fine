#!/bin/bash

echo
echo "はじめ"
echo "fineのすべてのgit pullを実行します"
echo "-----------------------------------------------"

cd ..
filapath=`pwd`


echo
echo "---------  /fine-server-core pull  ------------"
cd $filapath/fine-server-core
git pull origin master

echo
echo "---------  /fine-server-spring  ------------"
cd $filapath/fine-server-spring
git pull origin master

echo
echo "---------  /fine-blank-http-api pull  ------------"
cd $filapath/fine-blank-http-api
git pull origin master

echo "-----------------------------------------------"
echo "おわり"




