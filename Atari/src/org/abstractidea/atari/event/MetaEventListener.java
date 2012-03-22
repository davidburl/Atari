package org.abstractidea.atari.event;

/**
 * Allows a meta event handler to utilize a listener for handling a given
 * MetaEvent.
 * 
 * @author Matthew Vaughn
 * @since 2012/03/21 21:03:24
 */
public abstract class MetaEventListener {
	
	public abstract void handleMetaEvent( MetaEvent e );
}
