module MyMath (
factorial
) where

factorial :: Int -> Integer
factorial x
    | x > 0 = x * factorial (x - 1)
    | otherwise = 1
