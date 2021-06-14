package com.java.screenshotways;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class AShotScreenShot {

	public static String screenShot(WebDriver driver, String testCaseName) {
		String dest = null;
		BufferedImage image = null;
		Screenshot shot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		image = shot.getImage();
		dest = System.getProperty("user.dir") + "/screenShot/" + "AShot_"+testCaseName + ".png";
		try {
			ImageIO.write(image, "PNG", new File(dest));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dest;
	}

}
