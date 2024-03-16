
module Cards where

data Suit = Spades | Clubs | Hearts | Diamonds 
     deriving (Show)
data Rank = Ace | Ten | King | Queen | Jack 
     deriving (Show)
type Card = (Rank,Suit)
type Hand = [Card]

value :: Rank -> Int
value Ace = 11
value Ten = 10
value King = 4
value Queen = 3
value Jack = 2

backwards :: [a] -> [a]
backwards [] = []
backwards (h:t) = backwards t ++ [h]
