#!/usr/bin/sh
#
# This creates a new java class file using skeleton.java, call as;
# sh make.sh CLASS_NAME PACKAGE_NAME
#
FILE=$1.java
cp skeleton.java "$FILE"
today=$(date | awk '{print $2"-"$3"-"$4}')
sed -i "s/_DATE/$today/" "$FILE"
if [ -n "$2" ]; then
    sed -i "s/PACKAGE_NAME/$2/" "$FILE"
fi
sed -i "s/CLASS_NAME/$1/" "$FILE"
cat "$FILE"
