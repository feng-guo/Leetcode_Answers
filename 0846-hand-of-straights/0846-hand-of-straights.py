class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        if len(hand) % groupSize != 0:
            return False
        card_map = {}
        hand.sort()
        for card in hand:
            if card in card_map.keys():
                card_map[card] += 1
            else:
                card_map[card] = 1
        for card in hand:
            #This better be sorted
            if card_map[card] > 0:
                for x in range(groupSize):
                    if (card+x not in card_map.keys()) or not(card_map[card+x] > 0):
                        return False
                for x in range(groupSize):
                    card_map[card+x] -= 1
        return True
        