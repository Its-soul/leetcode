class Robot {

    private int w;
    private int h;
    private int x;
    private int y;
    private String dir;


    public Robot(int width, int height) {
        w = width;
        h = height;
        x = 0;
        y = 0;
        dir = "East";
    }

    public void step(int num) {
        num %= w * 2 + h * 2 - 4;
        if (num == 0) num = w * 2 + h * 2 - 4;
        
        for (int i = 0; i < num; i++) {
            switch (dir) {
                case "East":
                    if (x == w - 1) {
                        dir = "North";
                        y++;
                    }
                    else {
                        x++;
                    }
                    break;
                case "North":
                    if (y == h - 1) {
                        dir = "West";
                        x--;
                    }
                    else {
                        y++;
                    }
                    break;
                case "West":
                    if (x == 0) {
                        dir = "South";
                        y--;
                    }
                    else {
                        x--;
                    }
                    break;
                case "South":
                    if (y == 0) {
                        dir = "East";
                        x++;
                    }
                    else {
                        y--;
                    }
            }
        }
    }

    public int[] getPos() {
        return new int[] {x, y};
    }

    public String getDir() {
        return dir;
    }

}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */