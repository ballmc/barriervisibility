package me.ballmc.BarrierVisibility;
import com.google.gson.Gson;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;

public class BarrierVisibility {
  public static BarrierVisibility instance;
  private File configFile;
  private Config config = new Config();
  private final Gson gson = new Gson();

  public BarrierVisibility() {
    instance = this;
  }

  public static BarrierVisibility getInstance() {
    if (instance == null) {
        instance = new BarrierVisibility();
    }
    return instance;
  }
  
  public boolean initialize(String workingDirectory) {
        System.out.println("BarrierVisibility.initialize");
        configFile = new File(workingDirectory, "BarrierVisibility.json");

        if (configFile.exists()) {
            try {
                String jsonConfig = new String(Files.readAllBytes(configFile.toPath()), StandardCharsets.UTF_8);
                config = gson.fromJson(jsonConfig, Config.class);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        } else {
            saveConfig();
        }
        return true;
  }
  public Config getConfig() {
    return config;
  }

  public void saveConfig() {
      try {
          if (!configFile.exists()) {
              if (!configFile.createNewFile()) {
                  System.err.println("Failed to create config file!");
                  return;
              }
          }
          BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(configFile));
          bufferedWriter.write(gson.toJson(config));
          bufferedWriter.close();
      } catch (IOException exception) {
          exception.printStackTrace();
      }
  }
}