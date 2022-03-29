#!/usr/bin/env python
# -*- coding: utf-8 -*-
import csv
from inspect import _void

#opening the file
file=open("DataToUpload.csv","r", encoding="utf8")

cleanAccountsFile=open("accountsData.csv","w",newline='')

cleanUsersFile=open("usersData.csv","w",newline='')

# create the csv writer
accWriter = csv.writer(cleanAccountsFile)
userWriter = csv.writer(cleanUsersFile)

id=1
for line in file:
    
    first,last,address,city,state,zip,phone,email,password=line.split(",",9)

    name=""
    checkName,checkZip,checkState,checkPhone=False,False,False,False
    #splitting up each line into different variables
    lineList=[]
    if first.isascii and last.isascii and address.isascii and city.isascii and state.isascii and zip.isascii and phone.isascii:
        name=first+" "+last
        #checking phone
        phone=phone.replace("-","")
        if phone.isdigit and (len(phone)==10):
            checkPhone=True
        #checking zip
        if zip.isdigit and (len(zip)==5):
            checkZip=True
        #checking first and last
        if (first!="null") and (last!="null") :
            checkName=True
        #checking state
        if len(state)==2:
            checkState=True
    if checkName and checkZip and checkPhone and checkState:
        lineList.append(name)
        lineList.append(address)
        lineList.append(city)
        lineList.append(zip)
        lineList.append(phone)
        lineList.append(state)
        try:
            accWriter.writerow(lineList)
        except:
            _void


    lineList=[]
    checkFirst,checkLast,checkEmail,checkPass=False,False,False,False
    password=password.rstrip()
    if email.isascii and password.isascii:
        if (first!="null"):
            checkFirst=True
        if (last!="null"):
            checkLast=True
        if len(email.split("@"))==2:
            checkEmail=True
        if password.isalnum:
            checkPass=True

    if checkFirst and checkLast and checkEmail and checkPass:
        id+=1
        lineList.append(id)
        lineList.append(email)
        lineList.append(last)
        lineList.append(first)
        lineList.append(password)
        print(lineList)
        try:
            userWriter.writerow(lineList)
        except:
            id-=1

file.close()
cleanAccountsFile.close()
cleanUsersFile.close()