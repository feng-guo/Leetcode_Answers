class Solution:
    def removeSubfolders(self, folder: List[str]) -> List[str]:
        #sorting the current folders makes all parent folders appear, if one string is contained at the beginning of another, it will sort the shorter one to be first
        folder.sort()
        
        folder_set = []
        for f in folder:
            exists = False
            for i, c in enumerate(f):
                if (c) == "/":
                    if f[:i] in folder_set:
                        exists = True
                        break
                        
            if not exists:
                folder_set.append(f)
                
        
        return folder_set
        