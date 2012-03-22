package org.abstractidea.atari.event;

/**
 * Information container that holds the state of a meta event.
 * 
 * @model 1-tuple, consisting of a MetaEventAction
 * 
 * @author Matthew A.B. Vaughn
 * @since 2012/03/21 20:40:38
 */
public class MetaEvent {
	/**
	 * The action associated with this particular meta event.
	 */
	private MetaEventAction mAction;

	/**
	 * Produces MetaEvent as ( {@code action} )
	 * 
	 * @param action
	 *            The action to associate with the produced MetaEvent
	 */
	public MetaEvent(MetaEventAction action) {
		this.mAction = action;
	}

	/**
	 * Returns the action associated with this MetaEvent
	 * 
	 * @return the action associated with this MetaEvent
	 */
	public MetaEventAction getAction() {
		return this.mAction;
	}

	/**
	 * Enumeration of the various possible actions to be associated with a
	 * MetaEvent.
	 * 
	 * @author Matthew A.B. Vaughn
	 * @since 2012/03/22 12:45:30
	 */
	enum MetaEventAction {
		/**
		 * Occurs when game is to be paused.
		 */
		ACTION_PAUSE_GAME,
		/**
		 * Occurs when game has started. At this point, it should be the first
		 * player's move.
		 */
		ACTION_BEGIN_GAME
	}
}
