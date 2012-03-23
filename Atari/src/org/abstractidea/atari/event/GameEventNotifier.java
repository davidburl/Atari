package org.abstractidea.atari.event;

/**
 * Event notifier for game events. The client utilizing a
 * {@code GameEventNotifier} must first register a dispatcher, before sending
 * out any notifications.
 * 
 * @author Matthew A.B. Vaughn
 * @since 2012/03/21 20:44:50
 * 
 * @param <E>
 *            the type of game event which is to be sent to a dispatcher, upon
 *            notifcation
 * @see GameEventDispatcher<E>
 */
public class GameEventNotifier<E> {
	/**
	 * Dispatcher which will be used to send notifications to.
	 */
	private GameEventDispatcher<E> mDispatcher;

	/**
	 * Register {@code dispatcher} to be notified of events.<br />
	 * <br />
	 * Required: This notifier must not have a dispatcher registered, prior to
	 * calling {@code registerDispatcher}.
	 * 
	 * @param dispatcher
	 *            the dispatcher to receive event notifications
	 */
	public void registerDispatcher(GameEventDispatcher<E> dispatcher) {
		this.mDispatcher = dispatcher;
	}

	/**
	 * Deregisters this notifier's dispatcher and returns it.<br />
	 * <br />
	 * Required: This notifier must have a dispatcher registered, prior to
	 * calling {@code deregisterDispatcher}.
	 * 
	 * @return the dispatcher that was registered with
	 */
	public GameEventDispatcher<E> deregisterDispatcher() {
		GameEventDispatcher<E> dispatcher = this.mDispatcher;

		this.mDispatcher = null;

		return dispatcher;
	}

	/**
	 * Notifies the registered dispatcher of {@code event}.<br />
	 * <br />
	 * Required: This notifier must have a dispatcher registered, prior to
	 * calling {@code notifyDispatcher}.
	 * 
	 * @param event
	 *            the event which the dispatcher should be notified of
	 */
	public void notifyDispatcher(E event) {
		this.mDispatcher.dispatchEvent(event);
	}
}
