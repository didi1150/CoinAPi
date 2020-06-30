package me.didi.coinApi;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import me.didi.coinApi.mysql.MySQL;

public class CoinMain extends JavaPlugin {

	FileConfiguration cfg = this.getConfig();
	public File file = new File("plugins/" + this.getName(), "config.yml");


	private void saveCfg() {
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void disconnect() {
		MySQL.disconnect();
	}
	
	public void init() {
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		cfg.options().copyDefaults(true);
		cfg.addDefault("username", "root");
		cfg.addDefault("password", "");
		cfg.addDefault("database", "Universum");
		cfg.addDefault("host", "localhost");
		cfg.addDefault("port", "3306");
		saveCfg();
		MySQL.username = cfg.getString("username");
		MySQL.password = cfg.getString("password");
		MySQL.host = cfg.getString("host");
		MySQL.port = cfg.getString("port");
		MySQL.database = cfg.getString("database");
		MySQL.connect();
	}
}