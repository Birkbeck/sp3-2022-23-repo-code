module Main where
  
main = do  
    putStrLn "What's your name?"  
    name <- fmap reverse getLine  
    putStrLn ("!" ++ name ++ " iH")
