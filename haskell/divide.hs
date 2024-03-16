
module Divide where

divideAmong :: Int -> Int -> Maybe Int
divideAmong x y =
    if mod y x /= 0 then
        Nothing
    else
        Just (div y x)


divideAmongTwice :: Int -> Int -> Int -> Maybe Int
divideAmongTwice x y z =
    if mod y x /= 0 then
        Nothing
    else
        if mod (div y x) z /= 0 then
            Nothing
        else
            Just (div (div y x) z)


divideUp :: Int -> Int -> Int
divideUp x y = div y x

routine :: Maybe Int
routine = do
    x <- divideAmong 2 120
    y <- divideAmong 3 x
    divideAmong 4 y

