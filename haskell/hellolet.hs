module Main where

import Data.Char  
  
main = do  
    putStrLn "What's your name?"  
    name <- getLine  
    let bigName = map toUpper name  
    putStrLn ("Hi " ++ bigName ++ ", how are you?")  
