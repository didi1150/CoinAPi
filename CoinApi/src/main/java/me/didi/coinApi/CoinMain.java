package me.didi.coinApi;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import me.didi.coinApi.mysql.MySQL;

public class CoinMain
{
	File file = new File("plugins/CoinApi", "config.yml");
	FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

	public CoinMain()
	{
		init();
	}

	public void close()
	{
		MySQL.disconnect();
	}

	public void init()
	{
		if(!file.exists()) {
			try
			{
				file.createNewFile();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
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
		MySQL.connect();
	}

	private void saveCfg()
	{
		try
		{
			cfg.save(file);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}