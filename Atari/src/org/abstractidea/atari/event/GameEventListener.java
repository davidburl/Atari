package org.abstractidea.atari.event;

/**
 * Listens for a game event of type {@code E}. All in all, a
 * {@code GameEventListener} must first register a handler to be of any
 * practical use. Once registered, this handler is generally utilized by an
 * external game event dispatcher (though, there is no hard restriction to do
 * so, just recommended).<br />
 * <br />
 * The model of {@code GameEventListener} may be considered to maintain two
 * values: <br />
 * - the isEnabled property <br />
 * - the handler property<br />
 * With this in mind, a listener may only be considered ready (i.e. ready to
 * work with in an event-based architecture) only if isEnabled is true AND the
 * handler property is not {@code null}.
 * 
 * @author Matthew A.B. Vaughn
 * @since 2012/03/21 21:03:24
 * 
 * @param <E>  the type of game event which is to be listened for
 * @see GameEventHandler<E>
 */
public class GameEventListener<E> {
	/**
	 * Event handler for game events of type {@code E}.
	 */
	private IGameEventHandler<E> mHandler;

	/**
	 * Determines whether GameEventListener is presently wanting to listen.
	 */
	private boolean mIsEnabled = false;

	/**
	 * Registers {@code handler} to handle an event whenever one is heard
	 * (assuming that isEnabled is true). Important to note: this method will
	 * automatically set isEnabled to {@code true}
	 * 
	 * @param handler
	 *            the handler for game events of type {@code E}
	 */
	public void registerHandler(IGameEventHandler<E> handler) {
		this.mHandler = handler;
		this.mIsEnabled = true;
	}

	/**
	 * Registers {@code handler} to handle an event whenever one is heard
	 * (assuming that isEnabled is true). With that in mind, this method will
	 * automatically set isEnabled to the value of the parameter {@code enable}.
	 * 
	 * @param handler
	 *            the handler for game events of type {@code E}
	 * @param enable
	 *            the value {@code isEnabled} is set to
	 */
	public void registerHandler(IGameEventHandler<E> handler, boolean enable) {
		this.mHandler = handler;
		this.mIsEnabled = enable;
	}

	/**
	 * Registers {@code handler} as the new handler for this listener and
	 * returns the previously registered handler (which is automatically
	 * deregistered from this listener).<br />
	 * <br />
	 * Required: This listener must already have a handler registered, before
	 * this operation is called.
	 * 
	 * @param handler
	 *            the new handler for game events of type {@code E}
	 * @return the previously registered handler of this listener
	 */
	public IGameEventHandler<E> swapHandler(IGameEventHandler<E> handler) {
		IGameEventHandler<E> previousHandler = this.mHandler;

		this.mHandler = handler;

		return previousHandler;
	}

	/**
	 * Sets isEnabled to {@code true}.
	 */
	public void enable() {
		this.mIsEnabled = true;
	}

	/**
	 * Sets isEnabled to {@code false}.
	 */
	public void disable() {
		this.mIsEnabled = false;
	}

	/**
	 * Returns the value of isEnabled.
	 * 
	 * @return the value of isEnabled
	 */
	public boolean isEnabled() {
		return this.mIsEnabled;
	}

	/**
	 * Returns whether this listener is ready to listen for game events.
	 * 
	 * @return {@code true} if-and-only-if this listener isEnabled a handler is
	 *         registered
	 */
	public boolean isReady() {
		if (!this.mIsEnabled || this.mHandler == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Forces this listener to hear an event, which will then be handled by
	 * {@code handler}.<br />
	 * <br />
	 * Required: this.isReady must be {@code true} before calling this method.
	 * In other words, there must already be a handler registered to this
	 * listener, and isEnabled must be set to {@code true}.
	 */
	public void hearEvent(E event) {
		this.mHandler.handleEvent( event );
	}
}
