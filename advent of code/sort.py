originalFileName="input.txt"

file=open(originalFileName,"r")
listy=[]
for line in file:
    # listy.append(int(line))
    listy.append(line)

zero=0
one=0
x=0
gamma=""
epsilon=""
while x<12:
    for i in listy:
        if i[x]=="0":
            zero+=1
        elif i[x]=="1":
            one+=1
    x+=1
    if zero>one:
        gamma=gamma+"0"
        epsilon=epsilon+"1"
        zero=0
        one=0
    elif one>zero:
        gamma=gamma+"1"
        epsilon=epsilon+"0"
        zero=0
        one=0

gammaint=int(gamma,2)
epint=int(epsilon,2)

print(gammaint*epint)
file.close()
# horizontal=0
# depth=0
# aim=0

# for i in listy:
#     # print(i[len(i)])
#     if "forward" in i:
#         horizontal+=int(i[len(i)-2])
#         if aim!=0:
#             depth+=(int(i[len(i)-2]))*aim
            
#         # print(int(i[len(i)-2]))
#     elif "up" in i:
#         aim-=int(i[len(i)-2])
#         # print(int(i[len(i)-2]))
#     elif "down" in i:
#         aim+=int(i[len(i)-2])
#         # print(int(i[len(i)-2]))
#     else:
#         print('none')
#     # print(horizontal,depth)

# x=0
# for i in range(len(listy)):
#     try:
#         a=listy[i]+listy[i+1]+listy[i+2]
#         b=listy[i+1]+listy[i+2]+listy[i+3]
#         #returns 1536, this is too low
#         if (b>a):
#             x+=1
#     except:
#         print('end')
    # if y==0:
    #     y+=1
    # else:
    #     if int(line)>previous:
    #         x+=1
    #         previous=int(line)
    #     else:
    #         previous=int(line)
