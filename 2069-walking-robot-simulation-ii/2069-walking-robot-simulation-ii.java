class Robot {

    int width;
    int height;
    int x;
    int y;
    String dir;

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    String[] names = {"East", "North", "West", "South"};

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        x = 0;
        y = 0;
        dir = "East";
    }
    
    public void step(int num) {

        int perimeter = 2 * (width + height) - 4;

        num %= perimeter;

        if (num == 0) {
            num = perimeter;
        }

        while (num > 0) {

            int available;

            if (dir.equals("East")) {
                available = width - 1 - x;
            }
            else if (dir.equals("North")) {
                available = height - 1 - y;
            }
            else if (dir.equals("West")) {
                available = x;
            }
            else {
                available = y;
            }

            if (available == 0) {
                if (dir.equals("East")) {
                    dir = "North";
                }
                else if (dir.equals("North")) {
                    dir = "West";
                }
                else if (dir.equals("West")) {
                    dir = "South";
                }
                else {
                    dir = "East";
                }

                continue;
            }

            int move = Math.min(num, available);

            if (dir.equals("East")) {
                x += move;
            }
            else if (dir.equals("North")) {
                y += move;
            }
            else if (dir.equals("West")) {
                x -= move;
            }
            else {
                y -= move;
            }

            num -= move;

            if (num > 0) {
                if (dir.equals("East")) {
                    dir = "North";
                }
                else if (dir.equals("North")) {
                    dir = "West";
                }
                else if (dir.equals("West")) {
                    dir = "South";
                }
                else {
                    dir = "East";
                }
            }
        }
    }
    
    public int[] getPos() {
        return new int[]{x, y};
    }
    
    public String getDir() {
        return dir;
    }
}