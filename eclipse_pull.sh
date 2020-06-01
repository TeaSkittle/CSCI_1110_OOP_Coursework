#!/usr/bin/sh
# (c) Travis Dowd
# This is to pull eclpise files into git folder for school
# Usage: eclipse_pull.sh chapter project_name
#    ex: sh eclipse_pull.sh 11 Ex11_3

if [ ! -f "/Users/student/Desktop/CSCI_1110_OOP_Coursework/Chapter$1/$2/" ]; then
    mkdir /Users/student/Desktop/CSCI_1110_OOP_Coursework/Chapter$1/$2/
    cp /Users/student/Documents/eclipse-workspace/$2/$2/*java /Users/student/Desktop/CSCI_1110_OOP_Coursework/Chapter$1/$2/
else
    cp /Users/student/Documents/eclipse-workspace/$2/$2/*java /Users/student/Desktop/CSCI_1110_OOP_Coursework/Chapter$1/$2/
fi
