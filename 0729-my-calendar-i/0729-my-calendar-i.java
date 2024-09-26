class MyCalendar {
    List<int[]> bookings;

    public MyCalendar() {
        bookings = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        boolean overlapping = false;
        for(int[] booking : bookings){
            int s = booking[0];
            int e = booking[1];
            if(end<=s)
                overlapping = false;
            else if(start>=e)
                overlapping = false;
            else{
                overlapping = true;
                break;
            }
                
        }
        if(!overlapping) bookings.add(new int[]{start,end});
        return !overlapping;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */