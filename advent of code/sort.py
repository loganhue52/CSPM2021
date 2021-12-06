originalFileName="input.txt"

file=open(originalFileName,"r")
listy=[]
for line in file:
    listy.append(int(line))

x=0
y=0
previous=0
for i in listy:
    try:
        #returns 1536, this is too low
        if (listy[listy.index(i)+1]+listy[listy.index(i)+2]+listy[listy.index(i)+3])>(i+listy[listy.index(i)+1]+listy[listy.index(i)+2]):
            x+=1
    except:
        print('end')
    # if y==0:
    #     y+=1
    # else:
    #     if int(line)>previous:
    #         x+=1
    #         previous=int(line)
    #     else:
    #         previous=int(line)

print(x)
file.close()