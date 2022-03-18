#!/usr/bin/env python
# -*- coding: utf-8 -*-

#opening the file
fileName="DataToUpload.csv"
file=open(fileName,"r", encoding="utf8")

# cleanFileName="accountsData.csv"
# cleanFile=open(cleanFileName,"w")

i=0
for line in file:
    name=""
    checkName,checkAddress,checkCity,checkZip,checkPhone,checkState=False,False,False,False,False,False
    #splitting up each line into different variables
    first,last,address,city,state,zip,phone,email,password=line.split(",",9)

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
        if first!="null":
            checkName=True
        if last!="null":
            checkLast=True
        #checking state
        if len(state)==2:
            checkState=True

file.close()
    