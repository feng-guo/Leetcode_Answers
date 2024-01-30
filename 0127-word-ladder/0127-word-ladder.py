from collections import defaultdict
import math

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        word_map = defaultdict(list)
        best = {}
        count = math.inf
        
        if endWord not in wordList:
            return 0
        wordList.append(beginWord)
        for x in range(len(wordList)):
            current = wordList[x]
            for y in range(x+1, len(wordList)):
                check = wordList[y]
                diff = 0
                for z in range(len(current)):
                    if current[z] != check[z]:
                        diff += 1
                    if diff > 1:
                        break
                if diff == 1:
                    word_map[current].append(check)
                    word_map[check].append(current)
                    
        best[beginWord] = 1
        queue = [(beginWord, 1)]
        
        while len(queue) > 0:
            current, hop = queue.pop(0)
            if hop > best[current]:
                continue
            next_hop = hop + 1
            for word in word_map[current]:
                if word == endWord:
                    count = min(count, next_hop)
                elif word not in best.keys() or next_hop < best[word]:
                    best[word] = next_hop
                    queue.append((word, next_hop))
            
        if count == math.inf:
            return 0
        return count
                    
            