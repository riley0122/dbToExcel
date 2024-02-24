set echo off

echo "Generating jar with maven..."

mvn package

echo "Copying jar to dist..."

mkdir -p dist

shopt -s globstar

cp target/dbToExcel*.jar dist/dbToExcel.jar

cp src/main/bash/dbToExcel.cmd dist/dbToExcel.cmd

echo "finished!"