#!/usr/bin/python

def displayPathtoPrincess(n,grid):
#print all the moves here


    num_steps = int((n-1)/2);
    move = ''
    if grid[0][0] == 'p' or grid[0][0] == 'P': # up left
        move = 'UP\nLEFT\n'
            
    elif grid[0][n-1] == 'p' or grid[0][n-1] == 'P': # up right
        move = 'UP\nRIGHT\n'
    
    elif grid[n-1][0] == 'p' or grid[n-1][0] == 'P': # down left
        move = 'DOWN\nLEFT\n'
        
    elif grid[n-1][n-1] == 'p' or grid[n-1][n-1] == 'P': # down right
        move = 'DOWN\nRIGHT\n'
#    else:
#        move = 'no Princess\n'

    print(move * num_steps)
    return

m = int(input())
grid = [] 
for i in range(0, m): 
    grid.append(input().strip())

displayPathtoPrincess(m,grid)
