package test;

import com.jayfella.jme.jfx.JavaFxUI;
import com.jme3.app.SimpleApplication;
import com.jme3.system.AppSettings;
import java.nio.file.Paths;
import javafx.scene.CacheHint;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class JmeJfxVideoTest extends SimpleApplication {

    private MediaPlayer videoPlayer;
    private MediaView mediaView;
    private final boolean MUTE = false;
    private final String VIDEO_FILE = "sun.mp4";

    @Override
    public void simpleInitApp() {
        JavaFxUI.initialize(this);

        videoPlayer = new MediaPlayer(new Media("file:" + Paths.get(VIDEO_FILE).toAbsolutePath().normalize().toString()));
        videoPlayer.setMute(MUTE);
        videoPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        videoPlayer.play();
        mediaView = new MediaView(videoPlayer);
        mediaView.setFitWidth(1920);
        mediaView.setFitHeight(1080);
        mediaView.setCache(true);
        mediaView.setCacheHint(CacheHint.SPEED);
        mediaView.setSmooth(true);
        JavaFxUI.getInstance().attachChild(mediaView);

        inputManager.setCursorVisible(true);
        flyCam.setEnabled(false);
    }

    public static void main(String... args) {
        JmeJfxVideoTest main = new JmeJfxVideoTest();
        AppSettings settings = new AppSettings(true);
        settings.setWidth(1920);
        settings.setHeight(1080);
        settings.setVSync(true);
        settings.setTitle("JmeJfxVideoTest");
        main.setShowSettings(false);
        main.setSettings(settings);
        main.start();
    }
}
