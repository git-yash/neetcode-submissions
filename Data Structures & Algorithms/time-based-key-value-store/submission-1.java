class Value {
    String value;
    int timestamp;

    public Value(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}

class TimeMap {
    HashMap<String, List<Value>> map = new HashMap<>();

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Value val = new Value(value, timestamp);
        if(map.containsKey(key)) {
            map.get(key).add(val);
        } else {
            List<Value> list = new ArrayList<>();
            list.add(val);
            map.put(key, list);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
            return "";
        }

        String ans = "";
        List<Value> list = map.get(key);
        int left = 0;
        int right = list.size() - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            Value val = list.get(mid);

            if(val.timestamp <= timestamp) {
                ans = val.value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;

    }
}
