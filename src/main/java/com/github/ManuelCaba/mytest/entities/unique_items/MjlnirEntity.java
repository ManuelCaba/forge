package com.github.ManuelCaba.mytest.entities.unique_items;

import com.github.ManuelCaba.mytest.lists.ItemList;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MjlnirEntity extends AbstractArrowEntity
{

	private ItemStack thrownStack = new ItemStack(ItemList.mjlnir);
	private boolean dealtDamage;
	
	public MjlnirEntity(EntityType<? extends MjlnirEntity> entityTypeIn, World worldIn) 
	{
		super(entityTypeIn, worldIn);
	}
	
	public MjlnirEntity(World worldIn, LivingEntity entity, ItemStack itemStack) 
	{
		      super(EntityType.TRIDENT, entity, worldIn);
		      this.thrownStack = itemStack.copy();
	}

	@OnlyIn(Dist.CLIENT)
	public MjlnirEntity(World worldIn, double x, double y, double z) 
	{
		super(EntityType.TRIDENT, x, y, z, worldIn);
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void tick() 
	{
		if (this.timeInGround > 4) 
		{
			this.dealtDamage = true;
		}

	      Entity entity = this.getShooter();
	      if ((this.dealtDamage || this.func_203047_q()) && entity != null) {
	         int i = this.dataManager.get(LOYALTY_LEVEL);
	         if (i > 0 && !this.shouldReturnToThrower()) {
	            if (!this.world.isRemote && this.pickupStatus == AbstractArrowEntity.PickupStatus.ALLOWED) {
	               this.entityDropItem(this.getArrowStack(), 0.1F);
	            }

	            this.remove();
	         } else if (i > 0) {
	            this.func_203045_n(true);
	            Vec3d vec3d = new Vec3d(entity.posX - this.posX, entity.posY + (double)entity.getEyeHeight() - this.posY, entity.posZ - this.posZ);
	            this.posY += vec3d.y * 0.015D * (double)i;
	            if (this.world.isRemote) {
	               this.lastTickPosY = this.posY;
	            }

	            double d0 = 0.05D * (double)i;
	            this.setMotion(this.getMotion().scale(0.95D).add(vec3d.normalize().scale(d0)));
	            if (this.returningTicks == 0) {
	               this.playSound(SoundEvents.ITEM_TRIDENT_RETURN, 10.0F, 1.0F);
	            }

	            ++this.returningTicks;
	         }
	      }

	      super.tick();
	   }

}
