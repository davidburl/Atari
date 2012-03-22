package org.abstractidea.atari.event;

import java.util.ArrayList;
import java.util.List;

/**
 * MetaEventHandler is a list of MetaEvent's, which receives and sends
 * notifications of MetaEvent's. This class should be used in conjunction with,
 * at least, one MetaEventDispatcher, of which MetaEventHandler should be
 * registered to.
 * 
 * @model list of MetaEventListener's, using zero-indexing
 * 
 * @author Matthew A.B. Vaughn
 * @since 2012/03/21 20:58:28
 */
public class MetaEventHandler {
	/**
	 * List of MetaEventListener's that MetaEventHandler will send MetaEvent's
	 * to.
	 */
	private List<MetaEventListener> mListeners = new ArrayList<MetaEventListener>();

	/**
	 * Produces a MetaEventHandler with an empty list of listeners.
	 */
	public MetaEventHandler() {
		// do nothing
	}

	/**
	 * Adds {@code listener} to the list of MetaEventListener's
	 * 
	 * @param listener
	 *            the listener to be added to the list. Required:
	 *            {@code listener} is not already inside the handler's list of
	 *            listeners.
	 * @return the position where {@code listener} was added to the list
	 */
	public int addMetaEventListener(MetaEventListener listener) {
		this.mListeners.add(listener);

		return this.mListeners.size() - 1;
	}

	/**
	 * Adds {@code listener} to the list of MetaEventListener's.
	 * 
	 * @param listener
	 *            the listener to be added to the list
	 * @param priorityPos
	 *            the position where {@code listener} should be added to the
	 *            list. Required: 0 <= {@code priorityPos} <= the size of the
	 *            list of listeners, prior to adding @{code listener}.
	 * @return
	 */
	public int addMetaEventListener(MetaEventListener listener, int priorityPos) {
		this.mListeners.add(priorityPos, listener);

		return priorityPos;
	}

	/**
	 * Removes a MetaEventListener from the handler's list.
	 * 
	 * @param priorityPos
	 *            the position where the listener should be removed from.
	 *            Required: 0 <= {@code priorityPos} < the size of the list of
	 *            listeners, prior to removing the listener.
	 * @return the removed listener
	 */
	public MetaEventListener removeMetaEventListener(int priorityPos) {
		return this.mListeners.remove(priorityPos);
	}

	/**
	 * Returns the total number of listeners contained by the handler
	 * 
	 * @return the total number of listeners contained by the handler
	 */
	public int totalMetaEventListeners() {
		return this.mListeners.size();
	}

	/**
	 * TODO change this to reflect generics architecture - Matthew
	 * 
	 * Notifies all the listeners of the {@code event}. Listeners will be
	 * notified in the order in which they appear in the handler's list model.
	 * 
	 * @param event
	 *            the event to be handled
	 */
	public void handleMetaEvent(MetaEvent event) {
		for (MetaEventListener listener : this.mListeners) {
			listener.listenerMetaEvent();
		}
	}
}
