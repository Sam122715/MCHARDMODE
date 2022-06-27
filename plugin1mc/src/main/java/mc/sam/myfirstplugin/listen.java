package mc.sam.myfirstplugin;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class listen implements Listener {
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event){
        Material type = event.getBlock().getType();
        if (type == Material.TNT) {
            event.setCancelled(true);
        }
        if (type == Material.TNT_MINECART) {
            event.setCancelled(true);
        }
    }
    public void onCreatureSpawn(CreatureSpawnEvent event){
        if (event.getEntityType() == EntityType.CREEPER) {
            Creeper creeper = (Creeper) event.getEntity();
            creeper.setPowered(true);
        }
        if (event.getEntityType() == EntityType.ZOMBIE) {
            Zombie zombie = (Zombie) event.getEntity();
            ItemStack axe_zombie = new ItemStack(Material.DIAMOND_AXE);
            zombie.getEquipment().setItemInMainHand(axe_zombie);

        }
        if (event.getEntityType() == EntityType.SKELETON) {
            Skeleton skeleton = (Skeleton) event.getEntity();
            ItemStack bow_skeleton = new ItemStack(Material.BOW);
            bow_skeleton.addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
            skeleton.getEquipment();
        }
    }
}
