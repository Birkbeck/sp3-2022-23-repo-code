
module Main where

main = do  
    putStrLn "Hi there, what's your name?"  
    name <- getLine  
    putStrLn ("Hello " ++ name ++ "!")  
