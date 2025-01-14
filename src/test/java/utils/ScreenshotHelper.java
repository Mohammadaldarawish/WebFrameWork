package utils;

import base.BaseTest;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ScreenshotHelper extends BaseTest {
    public ScreenshotHelper() throws IOException {
    }

    public static void TakePicture(String name) throws IOException {
        // Capture the screenshot
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Use a relative path for the snapshots directory
        String snapshotPath = "Snapshots/" + name + ".png";
        File destinationFile = new File(snapshotPath);
        // Save the screenshot
        FileUtils.copyFile(srcFile, destinationFile);
        // Add the screenshot as an attachment in Allure
        try (InputStream is = new FileInputStream(destinationFile)) {
            Allure.addAttachment("Screenshot", is);
        }

    }
}