read n
sum=0
i=1
while [ "$i" -le "$n" ]
    do 
    read num
    sum=$(( sum + num )) 
    i=$(( i + 1 ))
done;
av=$( echo "$sum / $n" | bc -l )
printf "%0.3f\n" $(echo $av)
