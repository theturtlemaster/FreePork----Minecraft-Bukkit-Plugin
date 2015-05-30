import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class FreePork extends JavaPlugin {
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments) {
		if (label.equalsIgnoreCase("freepork")) {
			if (sender instanceof Player) {
				Player me = (Player) sender;
				Location spot = me.getLocation();
				World world = me.getWorld();
				
				for (int i = 0; i < 10; i++) {
					Location pigSpot = new Location(world, spot.getX() + (Math.random() * 5), spot.getY() + 10, spot.getZ() + (Math.random() * 5));
					Pig pig = world.spawn(pigSpot, Pig.class);
					pig.setHealth(2);
				}
				me.sendMessage("Time to cook!");
				return true;
			}
		}
		return false;
	}
}
