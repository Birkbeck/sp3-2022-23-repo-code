module Main where

main = do { print (factorial 6) }

factorial 0 = 1
factorial n = n * factorial (n-1)
