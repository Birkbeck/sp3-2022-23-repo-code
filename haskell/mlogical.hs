
module MLogical where

mnot :: Bool -> Maybe Bool
mnot True = return False
mnot False = return True

mand :: Bool -> Bool -> Maybe Bool
mand False _ = Just False
mand _ False = Just False
mand True True = Just True



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

-- simpler version works with logical and &&
-- *IntIf Control.Applicative> pure (&&) <*> Just True <*> Just True
-- Just True
-- *IntIf Control.Applicative> pure (&&) <*> Just True <*> Just False
-- Just False
-- *IntIf Control.Applicative> pure (&&) <*> Just True <*> Nothing
-- Nothing
-- *IntIf Control.Applicative> pure (&&) <*> Just False <*> Nothing
-- Nothing
