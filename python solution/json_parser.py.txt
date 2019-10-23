class JsonComparator:
    def __init__(self,first,second,exclude):
        self.first = self.flatten_json(first)
        self.second = self.flatten_json(second)
        self.seenkeys = set()
        self.exclude = exclude
        self.parse()
        self.execute()


    def parse(self):
        #parse and add all keys from first json
        for keynode in self.first:
            keys = keynode.split('.')
            for key in keys:
                self.seenkeys.add(key)


    def execute(self):
        #walk through both dictionaries and identify missing keys
        for keynode in self.second:
            if keynode in self.exclude:
                continue
            if keynode in self.first:
                #keys are same, so compare values
                key = keynode.split('.')[-1]
                if self.second[keynode] != self.first[keynode]:
                    print("the key:{0} value changed from:{1} to {2} in the second json".format(key,self.first[keynode],self.second[keynode]))
            else:
                #now check each individual key if they are already seen
                newkeys = keynode.split('$')
                for new_key in newkeys:
                    if new_key not in self.seenkeys:
                        print("the new key:{0} was added in the second json".format(new_key))
                        self.seenkeys.add(new_key)


    def flatten_json(self,y):
        """
            input: nested json
            output: flattened json

        """
        out = {}

        def flatten(x, name=''):
            if type(x) is dict:
                for a in x:
                    flatten(x[a], name + a + '.')
            elif type(x) is list:
                i = 0
                for a in x:
                    flatten(a, name + str(i) + '.')
                    i += 1
            else:
                out[name[:-1]] = x

        flatten(y)
        return out

#y = {"tokenPhrase": "TIME_PERIOD", "level": 4, "wordPos": 1, "tokenValues": { "12": [ { "tokenType": "PAST", "value": "last", "word": "last", "wordPos": 1, "opt": False, "matchedNode": 12, "terminal": False, "valueKey": None, "next": None, "valueTypeList": False } ], "14": [ { "tokenType": "TIME", "value": "YEAR", "word": "year", "wordPos": 2, "opt": False, "matchedNode": 14, "terminal": True, "valueKey": "unit", "next": None, "valueTypeList": False } ] }, "valueTokenType": "NUMBER", "nodeId": 14, "values": { "unit": "YEAR", "number": 1 }, "wordPosOfValues": [ 2, 2 ] }
x = { "workspace": "a123", "request": { "header": { "uuid": "00000000-0000-0008-6cfc-3b60d1900000", "workspace": "salesdata", "ts": None, "originatorType": "testUser", } } }
y = { "request": { "header": { "identifier": "00000000-0000-0008-6cfc-3b60d1900000", "workspace": "salesdata", "ts": None, "originatorType": "devUser", "country":"usa", } } }

ex = {"header.workspace"}
obj = JsonComparator(x,y,ex)