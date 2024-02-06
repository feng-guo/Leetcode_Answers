from collections import OrderedDict

class LFUCache:
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.size = 0
        
        self.key_frequency_value_map = {}
        self.frequency_key_map = defaultdict(OrderedDict)
        
        self.minf = 0
        

    def get(self, key: int) -> int:
        if key in self.key_frequency_value_map:
            ##Get the frequency and value from the key
            frequency, value = self.key_frequency_value_map[key]
            ##Remove it from the map temporarily
            self.key_frequency_value_map.pop(key)
            ##Remove the key from the frequency_key map
            ordered_map = self.frequency_key_map[frequency]
            ordered_map.pop(key)
            ##Increase the minf if it is the smallest frequency and there are no others with the same frequency
            if len(ordered_map) == 0 and frequency == self.minf:
                self.minf += 1
            ##Add the key to the correct frequency map
            self.frequency_key_map[frequency+1][key] = None
            ##Add the key back with the correct frequency value
            self.key_frequency_value_map[key] = (frequency+1, value)
            return value
        else:
            return -1
        

    def put(self, key: int, value: int) -> None:
        if key in self.key_frequency_value_map:
            ##Pop the frequency from the map
            frequency, _ = self.key_frequency_value_map[key]
            self.key_frequency_value_map.pop(key)
            ##Remove the key from the frequency_key map
            ordered_map = self.frequency_key_map[frequency]
            ordered_map.pop(key)
            ##Increase the minf if it is the smallest frequency and there are no others with the same frequency
            if len(ordered_map) == 0 and frequency == self.minf:
                self.minf += 1
            ##Add the key to the correct frequency map
            self.frequency_key_map[frequency+1][key] = None
            ##Add the key back with the correct frequency value
            self.key_frequency_value_map[key] = (frequency+1, value)
        else:
            if self.size == self.capacity:
                old_key, _ = self.frequency_key_map[self.minf].popitem(last=False)
                self.key_frequency_value_map.pop(old_key)
            else:
                self.size += 1
            ##Add the key value pair to the map
            self.key_frequency_value_map[key] = (1, value)
            ##Add the frequency, value pair to the map
            self.frequency_key_map[1][key] = None
            self.minf = 1
        


# Your LFUCache object will be instantiated and called as such:
# obj = LFUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)