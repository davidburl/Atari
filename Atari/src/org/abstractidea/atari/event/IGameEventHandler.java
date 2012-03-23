package org.abstractidea.atari.event;

/**
 * Game event handler interface for game events of type {@code E}.
 * Pragmatically, this interface is usually implemented as a local inner class
 * that, in turns, calls the proper code for handling a game event.
 * 
 * @author Matthew A.B. Vaughn
 * @since 2012/03/22 23:00:10
 * 
 * @param <E>
 *            the type of game event which is to be handled
 */
public interface IGameEventHandler<E> {
	/**
	 * Handles {@code event}. Generally speaking, this event has been dispatched
	 * to this handler, in order to be processed in some useful way.
	 * 
	 * @param event  the game event to be processed
	 */
	public void handleEvent(E event);
}
