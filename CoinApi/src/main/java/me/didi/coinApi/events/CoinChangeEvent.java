package me.didi.coinApi.events;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class CoinChangeEvent extends Event implements Cancellable
{

	private static HandlerList handlers = new HandlerList();
	public boolean cancelled = false;

	public boolean isCancelled()
	{
		return false;
	}

	public void setCancelled(boolean cancel)
	{
		cancelled = cancel;
	}

	public static HandlerList getHandlerList()
	{
		return handlers;
	}

	@Override
	public HandlerList getHandlers()
	{
		return handlers;
	}

}
