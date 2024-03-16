
module IntIf where

intif :: Bool -> Int -> Int -> Int
intif b x y = 
    if b then
        x
    else
        y


-- comes crashing down with applicative functors
-- *IntIf Control.Applicative> pure intif <*> Just True <*> Just 3 <*> Just 4
-- Just 3
-- *IntIf Control.Applicative> pure intif <*> Just False <*> Just 3 <*> Just 4
-- Just 4
-- *IntIf Control.Applicative> pure intif <*> Just False <*> Just 3 <*> Nothing
-- Nothing
-- *IntIf Control.Applicative> pure intif <*> Just True <*> Just 3 <*> Nothing
-- Nothing
-- *IntIf Control.Applicative> pure intif <*> Just False <*> Nothing <*> Just 4
-- Nothing

