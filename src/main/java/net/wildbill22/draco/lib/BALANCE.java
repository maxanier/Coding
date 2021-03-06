package net.wildbill22.draco.lib;

import net.minecraft.entity.SharedMonsterAttributes;

/**
 * All constants which could be used to balance the mod should be stored here
 *
 */
public final class BALANCE {
	public static class LEVELING {
		@DefaultInt(value = 200, minValue = 0, maxValue = 1000, name = "Maximum Coins for Hoard", 
				comment = "Number of coins to reach the highest player dragon level")
		public static int HOARD_COINS_TO_MAX_LEVEL;
		@DefaultInt(value = 10, minValue = 0, maxValue = 100, name = "Maximum Dragon Player Level", 
				comment = "Amount of coins needed for for each player dragon level")
		public static int MAXIMUM_LEVEL;
		@DefaultDouble(value = 0.5D, minValue = 0.3D, maxValue = 1.0D, name = "Level Modifier Type", 
				comment = "0.5 for square root, 1 for linear")
		public static double LEVEL_MOD_TYPE;
	}
	public static class CHEST_ITEMS {
		@DefaultInt(value = 20, minValue = 0, maxValue = 100, name = "Diamond Armor", 
				comment = "Chance of finding diamond armor items in village chests.")
		public static int VILLAGE_BLACKSMITH_DIAMOND_ARMOR;
		@DefaultInt(value = 80, minValue = 0, maxValue = 100, name = "Gold Coins", 
				comment = "Chance of finding gold coins in village chests.")
		public static int VILLAGE_BLACKSMITH_GOLD_COINS;
		@DefaultInt(value = 50, minValue = 0, maxValue = 100, name = "Fireballs", 
				comment = "Chance of finding fireballs in village chests.")
		public static int VILLAGE_BLACKSMITH_FIREBALLS;
		@DefaultInt(value = 10, minValue = 0, maxValue = 100, name = "Dragon Slayer Sword", 
				comment = "Chance of finding Dragon Slayer Sword in village chests.")
		public static int VILLAGE_BLACKSMITH_DRAGON_SLAYER;
	}
	public static class MOBPROP {
		// Properties for guards
		@DefaultDouble(value = 30.0D, minValue = 5.0D, maxValue = 50.0D, name = "Guard Maximum Health", 
				comment = "Maximum health")
		public static double GUARD_MAX_HEALTH;
		@DefaultDouble(value = 5.0D, minValue = 1.0D, maxValue = 10.0D, name = "Guard Attack Damage", 
				comment = "Attack damage")
		public static double GUARD_ATTACK_DAMAGE;
		@DefaultDouble(value = 3.0D, minValue = 1.0D, maxValue = 10.0D, name = "Guard Spear Damage", 
				comment = "Spear damage")
		public static double GUARD_SPEAR_DAMAGE;
		@DefaultDouble(value = 0.35F, minValue = 0.1D, maxValue = 1.0D, name = "Guard Movement Speed", 
				comment = "Guard movement speed")
		public static double GUARD_MOVEMENT_SPEED;
		@DefaultInt(value = 75, minValue = 0, maxValue = 100, name = "Guard Spawn Probability", 
				comment = "Probability of spawning guards")
		public static int GUARD_SPAWN_PROB;
		@DefaultInt(value = 6, minValue = 0, maxValue = 20, name = "Maximum Guards per Village", 
				comment = "Maximum number of guards that will spawn in a village")
		public static int GUARD_MAX_PER_VILLAGE;
		@DefaultDouble(value = 0.20F, minValue = 0.1D, maxValue = 1.0D, name = "Knight Movement Speed", 
				comment = "Knight movement speed")
		public static double KNIGHT_MOVEMENT_SPEED;
		
		// Properties for Wild (Creeper) Dragon
		@DefaultDouble(value = 25.0D, minValue = 10.0D, maxValue = 50.0D, name = "Tamed Dragon Maximum Health", 
				comment = "Maximum health for tamed Creeper dragon")
		public static double DRAGON_MAX_HEALTH_TAMED;
		@DefaultDouble(value = 10.0D, minValue = 1.0D, maxValue = 20.0D, name = "Wild Dragon Maximum Health", 
				comment = "Maximum health for wild Creeper dragon")
		public static double DRAGON_MAX_HEALTH_WILD;
		@DefaultInt(value = 6, minValue = 0, maxValue = 20, name = "Tamed Dragon Attack Damage", 
				comment = "Tamed Creeper dragon attack damage")
		public static int DRAGON_ATTACK_DAMAGE_TAMED;
		@DefaultInt(value = 2, minValue = 0, maxValue = 10, name = "Wild Dragon Attack Damage", 
				comment = "Wild Creeper dragon attack damage")
		public static int DRAGON_ATTACK_DAMAGE_WILD;
		@DefaultDouble(value = 0.3F, minValue = 0.2D, maxValue = 1.0D, name = "Dragon Movement Speed", 
				comment = "Creeper dragon movement speed")
		public static double DRAGON_MOVEMENT_SPEED;
		@DefaultInt(value = 55, minValue = 0, maxValue = 100, name = "Dragon Spawn Probability", 
				comment = "Probability of spawning creeper dragons")
		public static int DRAGON_SPAWN_PROB;		
		@DefaultInt(value = 10, minValue = 0, maxValue = 80, name = "Creeper Avoidance Distance", 
				comment = "How far away creepers will stay from dragon")
		public static int CREEPER_AVOID_LEVEL;
	}
	
	public static class WILD_FIRE_DRAGON_PROP {
		@DefaultDouble(value = 3.0F, minValue = 1.0D, maxValue = 10.0D, name = "Attack Damage", 
				comment = "")
		public static double ATTACK_DAMAGE;
		@DefaultDouble(value = 20.0F, minValue = 10.0D, maxValue = 50.0D, name = "Follow Range", 
				comment = "")
		public static double FOLLOW_RANGE;
		@DefaultDouble(value = 25.0F, minValue = 5.D, maxValue = 50.0D, name = "Max Health", 
				comment = "")
		public static double MAX_HEALTH;
		@DefaultDouble(value = 0.5F, minValue = 0.1D, maxValue = 1.0D, name = "Movement Speed", 
				comment = "")
		public static double MOVEMENT_SPEED;
		@DefaultInt(value = 55, minValue = 0, maxValue = 100, name = "Spawn Probability", 
				comment = "Probability of spawning wild fire dragons")
		public static int SPAWN_PROB;		
	}

	/**
	 * Class to store all constants related to the player modifiers See {@link:
	 * entity.player.PlayerModifiers#applyModifiers(int, EntityPlayer)} for impact
	 *
	 */
	public static class DP_MODIFIERS {
		@DefaultDouble(value = 1.0D, minValue = 0.3D, maxValue = 2.0D, name = "Health multiplier", 
				comment = "(Math.pow(level, type) / Math.pow(level cap, type)) * multiplier")
		public static double HEALTH_MAX_MOD;
		@DefaultInt(value = 20, minValue = 0, maxValue = 40, name = "Health Level Cap", 
				comment = "Dragon level where this modifier does not get stronger")
		public static int HEALTH_LCAP = 20;
		@DefaultDouble(value = 0.5D, minValue = 0.3D, maxValue = 1.0D, name = "Health Modifier Type", 
				comment = "0.5 for square root, 1 for linear")
		public static double HEALTH_TYPE;
		@DefaultDouble(value = 1.0D, minValue = 0.3D, maxValue = 2.0D, name = "Strength multiplier", 
				comment = "(Math.pow(level, type) / Math.pow(level cap, type)) * multiplier")
		public static double STRENGTH_MAX_MOD;
		@DefaultInt(value = 20, minValue = 0, maxValue = 40, name = "Strength Level Cap", 
				comment = "Dragon level where this modifier does not get stronger")
		public static int STRENGTH_LCAP;
		@DefaultDouble(value = 0.5D, minValue = 0.3D, maxValue = 1.0D, name = "Strength Modifier Type", 
				comment = "0.5 for square root, 1 for linear")
		public static double STRENGTH_TYPE;
		@DefaultDouble(value = 0.3D, minValue = 0.2D, maxValue = 1.0D, name = "Speed multiplier", 
				comment = "(Math.pow(level, type) / Math.pow(level cap, type)) * multiplier")
		public static double SPEED_MAX_MOD;
		@DefaultInt(value = 15, minValue = 0, maxValue = 30, name = "Speed Level Cap", 
				comment = "Dragon level where this modifier does not get stronger")
		public static int SPEED_LCAP;
		@DefaultDouble(value = 0.5D, minValue = 0.3D, maxValue = 1.0D, name = "Speed Modifier Type", 
				comment = "0.5 for square root, 1 for linear")
		public static double SPEED_TYPE;
	}
	
	// Dragon player (add more as needed)
	@DefaultBoolean(value = true, name = "Player as silver dragon initially?", 
			comment = "Whether player should spawn initially as a silver dragon")
	public static boolean PLAYER_AS_SILVER_DRAGON_INITIALLY;
	@DefaultInt(value = 20, minValue = 20, maxValue = 31, name = "Player Level Data Watcher", 
			comment = "If there is a conflict with another mod, this can be changed.")
	public static int LEVEL_WATCHER;	
	@DefaultInt(value = 21, minValue = 20, maxValue = 31, name = "Fire Dragon Data Watcher", 
			comment = "If there is a conflict with another mod, this can be changed.")
	public static int FIRE_DRAGON_WATCHER;	
}
