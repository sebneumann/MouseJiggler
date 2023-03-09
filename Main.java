import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws AWTException {
        Robot robot = new Robot();

        Runnable mouseRunnable = new Runnable() {
            @Override
            public void run() {
                int x = MouseInfo.getPointerInfo().getLocation().x;
                int y = MouseInfo.getPointerInfo().getLocation().y;

                robot.mouseMove(x, y - 1);
                robot.mouseMove(x, y + 1);
            }
        };

        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.scheduleAtFixedRate(mouseRunnable, 0, 90, TimeUnit.SECONDS);
    }
}
