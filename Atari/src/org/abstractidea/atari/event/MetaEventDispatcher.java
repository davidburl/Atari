package org.abstractidea.atari.event;

/**
 * Event dispatcher for meta events.
 * 
 * @author Matthew Vaughn
 * @since 2012/03/21 20:44:50
 */
public abstract class MetaEventDispatcher {
	public void registerMetaEventHandler( MetaEventHandler handler ) {
		
	}
	/**
	 * 
	 * @param e
	 */
	public abstract void dispatchMetaEvent( MetaEvent e );
}
