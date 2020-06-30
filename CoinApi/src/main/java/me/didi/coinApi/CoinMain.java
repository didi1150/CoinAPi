package me.didi.coinApi;


import me.didi.coinApi.mysql.MySQL;

public class CoinMain {

	public void disconnect() {
		MySQL.disconnect();
	}

	public void connect() {
		MySQL.connect();
	}
}