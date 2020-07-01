package me.didi.coinApi;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import me.didi.coinApi.mysql.MySQL;

public class CoinMain extends JavaPlugin {
	File file = new File("plugins/CoinApi", "config.yml");
	FileConfiguration cfg = this.getConfig();

	public void disconnect() {
		MySQL.disconnect();
	}

	public void connect() {
		MySQL.connect();
	}

	public void init() {
		cfg.addDefault("username", "root");
		cfg.addDefault("password", "");
		cfg.addDefault("database", "onlinetime");
		cfg.addDefault("port", "3306");
		cfg.addDefault("host", "localhost");
		saveCfg();
		MySQL.username = cfg.getString("username");
		MySQL.password = cfg.getString("password");
		MySQL.database = cfg.getString("database");
		MySQL.host = cfg.getString("host");
		MySQL.port = cfg.getString("port");
	}

	private void saveCfg() {
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}