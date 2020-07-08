package me.didi.coinApi;

import org.bukkit.Bukkit;

import me.didi.coinApi.events.CoinChangeEvent;
import me.didi.coinApi.mysql.MySQL;

public class CoinManagement
{

	public static CoinManagement instance = new CoinManagement();

	public static CoinManagement getInstance()
	{
		return instance;
	}

	public void addCoins(String uuid, int amount)
	{
		int coinsBefore = 0;
		if (MySQL.getValue(uuid) != null)
		{
			coinsBefore = Integer.parseInt(MySQL.getValue(uuid));
		}

		int coinsAfter = coinsBefore + amount;
		MySQL.setValue(String.valueOf(coinsAfter), uuid);
		Bukkit.getPluginManager().callEvent(new CoinChangeEvent(Bukkit.getPlayer(uuid)));
	}

	public void removeCoins(String uuid, int amount)
	{
		int coinsBefore = 0;
		if (MySQL.getValue(uuid) != null)
		{
			coinsBefore = Integer.parseInt(MySQL.getValue(uuid));
		}

		int coinsAfter = coinsBefore - amount;
		MySQL.setValue(String.valueOf(coinsAfter), uuid);
		Bukkit.getPluginManager().callEvent(new CoinChangeEvent(Bukkit.getPlayer(uuid)));
	}

	public int getCoins(String uuid)
	{
		return Integer.parseInt(MySQL.getValue(uuid));
	}

	public void setCoins(String uuid, int amount)
	{
		MySQL.setValue(String.valueOf(amount), uuid);
		Bukkit.getPluginManager().callEvent(new CoinChangeEvent(Bukkit.getPlayer(uuid)));
	}
}
