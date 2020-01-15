package com.github.ManuelCaba.mytest.items.unique_items;

import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.item.EnderPearlEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class MjlnirItem extends TridentItem
{

	public MjlnirItem(Properties builder) 
	{
		super(builder);
	}
	
	@Override
	public boolean canPlayerBreakBlockWhileHolding(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) 
	{
		return player.isCreative();
	}
	   
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) 
	{
		//Comprobamos si la entidad que esta sujetando el martillo es un jugador o un mob
		if (entityLiving instanceof PlayerEntity) 
		{
			//Creamos un objeto PlayerEntity (jugador) para facilitarnos el proceso
			PlayerEntity playerentity = (PlayerEntity)entityLiving;
			
			//Declaramos el tiempo de duración usando el martillo para usarlo más adelante
		    int i = this.getUseDuration(stack) - timeLeft;
		    
		    if (i >= 20) //Si el tiempo de duración excede o igual la unidad 20 se realizará la operación (NO SON SEGUNDOS!)
		    {
		    	if (!worldIn.isRemote) 
		    	{
		    		
		    		
		    		stack.damageItem(1, playerentity, (p_220047_1_) -> 
		    		{
		    			p_220047_1_.sendBreakAnimation(entityLiving.getActiveHand());
		            });
		                 
		            TridentEntity tridententity = new TridentEntity(worldIn, playerentity, stack);
		            tridententity.shoot(playerentity, playerentity.rotationPitch, playerentity.rotationYaw, 0.0F, 2.5F + (float)0 * 0.5F, 1.0F);
		            if (playerentity.abilities.isCreativeMode) 
		            {
		            	tridententity.pickupStatus = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
		            }

		            worldIn.addEntity(tridententity);
		            worldIn.playMovingSound((PlayerEntity)null, tridententity, SoundEvents.ITEM_TRIDENT_THROW, SoundCategory.PLAYERS, 1.0F, 1.0F);
		                     if (!playerentity.abilities.isCreativeMode) {
		                        playerentity.inventory.deleteStack(stack);
		                     }
		                  
		               }

		               playerentity.addStat(Stats.ITEM_USED.get(this));

		            }
		         }
		      }
	
	
	@Override
	public int getUseDuration(ItemStack stack) 
	{
	      return 0;
	}
	
	
	

}
	