class Value {
    public String val;
    public int timestamp;

    public Value(String val, int timestamp) {
        this.val = val;
        this.timestamp = timestamp;
    }
}

class TimeMap {
    private HashMap<String, List<Value>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)) {
            List<Value> list = map.get(key);
            list.add(new Value(value, timestamp));
            return;
        }

        List<Value> list = new ArrayList<>();
        list.add(new Value(value, timestamp));
        map.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        if(map.containsKey(key)) {
            List<Value> values = map.get(key);
            int left = 0;
            int right = values.size() - 1;
            String result = "";

            while(left <= right) {
                int mid = (left + right) / 2;

                if(values.get(mid).timestamp == timestamp) {
                    result = values.get(mid).val;
                    return result;
                } else if(values.get(mid).timestamp < timestamp) {
                    result = values.get(mid).val;
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }

            return result;
        }

        return "";
    }
}
