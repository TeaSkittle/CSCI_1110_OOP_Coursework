#!/usr/bin/sh
# (c) Travis Dowd
#
# copy eclipse project files into git folder from school macOS machines, and place them into git directory
#
# Usage: epull.sh chapter project_name
#    ex: sh epull.sh 11 Ex11_3
#

echo "[+] Pulling java files from eclipse folder.."
if [ ! -f "/Users/student/Desktop/CSCI_1110_OOP_Coursework/Chapter$1/$2/" ]; then
    mkdir "/Users/student/Desktop/CSCI_1110_OOP_Coursework/Chapter$1/$2/"
    cp "/Users/student/Documents/eclipse-workspace/$2/$2/*java" "/Users/student/Desktop/CSCI_1110_OOP_Coursework/Chapter$1/$2/"
else
    cp "/Users/student/Documents/eclipse-workspace/$2/$2/*java" "/Users/student/Desktop/CSCI_1110_OOP_Coursework/Chapter$1/$2/"
fi
echo "[+] File pull complete"
echo "[+] Moving to project folder.."
cd /Users/student/Desktop/CSCI_1110_OOP_Coursework/ || { echo "[!] Error: directory not found"; exit 1; }
pwd
echo "[+] Checking git status.."
git status
echo "[-] Need to add, commit, and pull to finalize..."
