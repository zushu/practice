--Contributed by Ron Watkins
module Main where

fibonacci 0 = 0
fibonacci 1 = 1
fibonacci n = fibonacci (n-1) + fibonacci (n-2) -- Enter your code here to complete this function


-- This part is related to the Input/Output and can be used as it is
-- Do not modify it
main = do
    input <- getLine
    print . fibonacci . (read :: String -> Int) $ input
