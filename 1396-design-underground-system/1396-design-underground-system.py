class UndergroundSystem:

    def __init__(self):
        self.average_time = {}
        self.customers = {}
        

    def checkIn(self, id: int, stationName: str, t: int) -> None:
        self.customers[id] = (stationName, t)

    def checkOut(self, id: int, stationName: str, t: int) -> None:
        start_place, start_time = self.customers.pop(id)
        if (start_place, stationName) in self.average_time:
            total, trips = self.average_time[start_place, stationName]
            self.average_time[start_place, stationName] = total + t-start_time, trips+1
        else:
            self.average_time[start_place, stationName] = (t-start_time, 1)
        

    def getAverageTime(self, startStation: str, endStation: str) -> float:
        total, trips = self.average_time[startStation, endStation]
        return total/trips


# Your UndergroundSystem object will be instantiated and called as such:
# obj = UndergroundSystem()
# obj.checkIn(id,stationName,t)
# obj.checkOut(id,stationName,t)
# param_3 = obj.getAverageTime(startStation,endStation)