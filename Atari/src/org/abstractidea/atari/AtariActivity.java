package org.abstractidea.atari;

import org.andengine.engine.options.EngineOptions;
import org.andengine.entity.scene.Scene;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import android.app.Activity;
import android.os.Bundle;

/**
 * Hello World
 * 
 * HEY!
 * 
 * @author David Burl, Matthew A.B. Vaughn
 * @since  2012/03/25 22:23:22
 */
public class AtariActivity extends SimpleBaseGameActivity {
	/**
	 * The width of the camera view.
	 */
	private static final int CAMERA_WIDTH = 480;
	/**
	 * The height of the camera width.
	 */
	private static final int CAMERA_HEIGHT = 800;
	/**
	 * The number of rows and columns to draw
	 */
	private static final int NUM_ROWSCOLS = 19;
	/**
	 * The size of the edge
	 */
	private static final float BORDER_SIZE = 0.01f;
	/**
	 * The top border (leaving room for a HUD)
	 */
	private static final float TOP_BORDER = 0.25f * CAMERA_HEIGHT;
	/**
	 * First space on the board
	 */
	private static final float FIRST_SPACE = BORDER_SIZE * CAMERA_WIDTH;
	/**
	 * Amount of space between each row
	 */
	private static final float SPACING = (CAMERA_WIDTH * (1 - (2 * BORDER_SIZE)))
			/ NUM_ROWSCOLS;
	
	// removed, due to redundancy in HudZoomListener
	private static final float MAX_ZOOM = 4f;
	private static final float MIN_ZOOM = 1f;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        
        
    }
    
	public EngineOptions onCreateEngineOptions() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected void onCreateResources() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected Scene onCreateScene() {
		// TODO Auto-generated method stub
		return null;
	}
}