package lists;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ThorsHummerItem extends Item
{
	public ThorsHummerItem(Item.Properties builder) {
		super(builder);
		 this.addPropertyOverride(new ResourceLocation("throwing"), (p_210315_0_, p_210315_1_, p_210315_2_) -> {
	         return p_210315_2_ != null && p_210315_2_.isHandActive() && p_210315_2_.getActiveItemStack() == p_210315_0_ ? 1.0F : 0.0F;
	      });
	}

	public static Item thors_hummer;
}

