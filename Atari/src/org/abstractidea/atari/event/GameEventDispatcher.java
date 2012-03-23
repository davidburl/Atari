package org.abstractidea.atari.event;

import java.util.ArrayList;
import java.util.List;

/**
 * GameEventDispatcher contains a list of game event listeners , which are used
 * to properly dispatch game events of type {@code E}. These listeners, in turn,
 * provide a way to handle/process an event, every time one is heard from this
 * dispatcher.
 * 
 * @author Matthew A.B. Vaughn
 * @since 2012/03/21 20:58:28
 * 
 * @param <E>
 *            the type of game event which is to be dispatched
 * @see GameEventListener<E>
 */
public class GameEventDispatcher<E> {
	/**
	 * List of listeners that may receive game events of type {@code E}
	 */
	private List<GameEventListener<E>> mListeners = new ArrayList<GameEventListener<E>>();

	/**
	 * Adds {@code listener} to the internal list of game event listeners.
	 * 
	 * @param listener
	 *            the listener to be added to the list. Required: The listener
	 *            MUST have a handler registered to it, before
	 *            {@code addListener} is called.
	 * @return the position where {@code listener} was added to the list
	 */
	public int addListener(GameEventListener<E> listener) {
		this.mListeners.add(listener);

		return this.mListeners.size() - 1;
	}

	/**
	 * Adds {@code listener} to this dispatcher's internal list of game event
	 * listeners.
	 * 
	 * @param listener
	 *            the listener to be added to the list. Required: The listener
	 *            MUST have a handler registered to it, before
	 *            {@code addListener} is called.
	 * @param priorityPos
	 *            the position where {@code listener} should be added to the
	 *            list. Required: 0 <= {@code priorityPos} <= the size of the
	 *            list of listeners, prior to adding @{code listener}.
	 * @return
	 */
	public int addListener(GameEventListener<E> listener, int priorityPos) {
		this.mListeners.add(priorityPos, listener);

		return priorityPos;
	}

	/**
	 * Removes a listener, located at position {@code priorityPos} from this
	 * dispatcher's list of listeners.
	 * 
	 * @param priorityPos
	 *            the position where the listener should be removed from.
	 *            Required: 0 <= {@code priorityPos} < the size of the list of
	 *            listeners, prior to removing the listener.
	 * @return the removed listener
	 */
	public GameEventListener<E> removeListener(int priorityPos) {
		return this.mListeners.remove(priorityPos);
	}

	/**
	 * Returns the total number of listeners contained by this dispatcher.
	 * 
	 * @return the total number of listeners contained by this dispatcher
	 */
	public int totalListeners() {
		return this.mListeners.size();
	}

	/**
	 * Sends {@code event} to each listener held internally by
	 * {@code GameEventDispatcher}. Each listener, will be communicated to in
	 * the order in which they are held in this dispatcher's list model. A
	 * listener will only be spoken to, if that particular listener is ready.
	 * 
	 * @param event
	 *            the event to be dispatched
	 */
	public void dispatchEvent(E event) {
		for (GameEventListener<E> listener : this.mListeners) {
			if (listener.isReady()) {
				listener.hearEvent(event);
			}
		}
	}
}
