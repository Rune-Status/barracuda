package org.barracuda.model.actor;

import org.barracuda.core.net.Channel;
import org.barracuda.horvik.Horvik;
import org.barracuda.horvik.bean.Discoverable;
import org.barracuda.horvik.context.session.Session;
import org.barracuda.horvik.context.session.SessionScoped;
import org.barracuda.model.actor.player.Credentials;
import org.barracuda.model.actor.player.Stats;
import org.barracuda.model.actor.player.misc.Detail;
import org.barracuda.model.actor.sync.DefaultWaypointVector;
import org.barracuda.model.actor.sync.WaypointVector;
import org.barracuda.model.actor.sync.attribute.Appearance;
import org.barracuda.model.item.Inventory;

/**
 * Represents a player controlled entity
 * 
 * @author brock
 *
 */
@Discoverable
@SessionScoped
public class Player extends Actor {
	
	/**
	 * The session for this player object
	 */
	private final Session session;
	
	/**
	 * The player's channel
	 */
	private final Channel channel;

	/**
	 * The detail mode the player is playing in
	 */
	private Detail detail;
	
	/**
	 * The player's credentials
	 */
	private Credentials credentials;
	
	/**
	 * The horvik container the player belongs to
	 */
	private final Horvik container;
	
	/**
	 * The appearance
	 */
	private final Appearance appearance;
	
	/**
	 * The player's inventory
	 */
	private final Inventory inventory = new Inventory(this);
	
	/**
	 * The player's stats
	 */
	private final Stats stats = new Stats(this);
	
	/**
	 * The player's waypoints
	 */
	private final WaypointVector waypoints = new DefaultWaypointVector(this);

	/**
	 * Constructor
	 * 
	 * @param container
	 */
	public Player(Horvik container, Session session, Channel channel) {
		this.appearance = new Appearance();
		this.container = container;
		this.channel = channel;
		this.session = session;
	}

	/**
	 * Dispatches an event to the container
	 * 
	 * @param object
	 */
	@SuppressWarnings("unchecked")
	public void notify(Object event) {
		container.getEvent().select((Class<? super Object>) event.getClass()).fire(event, session);
	}
	
	/**
	 * Update the player's appearance
	 */
	public void appear() {
		super.getRenderingHints().add(appearance);
	}

	/**
	 * @return the detail
	 */
	public Detail getDetail() {
		return detail;
	}

	/**
	 * @param detail the detail to set
	 */
	public void setDetail(Detail detail) {
		this.detail = detail;
	}

	/**
	 * @return the credentials
	 */
	public Credentials getCredentials() {
		return credentials;
	}

	/**
	 * @param credentials the credentials to set
	 */
	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	/**
	 * @return the waypoints
	 */
	public WaypointVector getWaypoints() {
		return waypoints;
	}

	/**
	 * @return the appearance
	 */
	public Appearance getAppearance() {
		return appearance;
	}

	/**
	 * @return the channel
	 */
	public Channel getChannel() {
		return channel;
	}

	/**
	 * @return the inventory
	 */
	public Inventory getInventory() {
		return inventory;
	}

	/**
	 * @return the stats
	 */
	public Stats getStats() {
		return stats;
	}

}
