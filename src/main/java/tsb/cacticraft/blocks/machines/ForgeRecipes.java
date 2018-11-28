package tsb.cacticraft.blocks.machines.recipes;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import tsb.cacticraft.init.ModItems;

public class ForgeRecipes 
{	
	private static final ForgeRecipes INSTANCE = new ForgeRecipes();
	private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
	private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();
	
	public static ForgeRecipes getInstance()
	{
		return INSTANCE;
	}
	
	private ForgeRecipes() 
	{
		//Ores
		addForgeRecipe(new ItemStack(ModItems.COPPER_INGOT), new ItemStack(ModItems.TIN_INGOT), new ItemStack(ModItems.BRONZE_INGOT), 5.0F);
		addForgeRecipe(new ItemStack(Items.IRON_INGOT), new ItemStack(ModItems.NICKEL_INGOT), new ItemStack(ModItems.STEEL_INGOT), 5.0F);
		addForgeRecipe(new ItemStack(Items.GOLD_INGOT), new ItemStack(Items.REDSTONE), new ItemStack(ModItems.MAGNETIC_GOLD_INGOT), 5.0F);
		addForgeRecipe(new ItemStack(ModItems.STEEL_INGOT), new ItemStack(ModItems.MAGNETIC_GOLD_INGOT), new ItemStack(ModItems.RED_STEEL_INGOT), 5.0F);
		addForgeRecipe(new ItemStack(ModItems.NICKEL_INGOT), new ItemStack(ModItems.COBALT), new ItemStack(ModItems.NICO_INGOT), 5.0F);
		addForgeRecipe(new ItemStack(ModItems.RED_STEEL_INGOT), new ItemStack(Blocks.OBSIDIAN), new ItemStack(ModItems.TEMPERED_SILICATE), 5.0F);
		addForgeRecipe(new ItemStack(ModItems.NICO_INGOT), new ItemStack(Blocks.OBSIDIAN), new ItemStack(ModItems.HARDENED_SILICATE), 5.0F);
		addForgeRecipe(new ItemStack(ModItems.TEMPERED_SILICATE), new ItemStack(ModItems.HARDENED_SILICATE), new ItemStack(ModItems.REINFORCED_SILICATE), 5.0F);
		addForgeRecipe(new ItemStack(Items.DIAMOND), new ItemStack(ModItems.REINFORCED_SILICATE), new ItemStack(ModItems.KIMBERLITE), 5.0F);
		addForgeRecipe(new ItemStack(ModItems.LEAD_INGOT), new ItemStack(ModItems.BRONZE_INGOT), new ItemStack(ModItems.ORICHALCUM_INGOT), 5.0F);
		
		//Tools
		addForgeRecipe(new ItemStack(ModItems.TRIDENT_HEAD_MOLD), new ItemStack(Items.IRON_INGOT), new ItemStack(ModItems.TRIDENT_HEAD), 5.0F);
		addForgeRecipe(new ItemStack(ModItems.TOOL_ROD_MOLD), new ItemStack(Blocks.PRISMARINE), new ItemStack(ModItems.PRISMARINE_TOOL_ROD), 5.0F);
		addForgeRecipe(new ItemStack(ModItems.PICKAXE_HEAD_MOLD), new ItemStack(ModItems.COPPER_INGOT), new ItemStack(ModItems.COPPER_PICKAXE_HEAD), 5.0F);
		addForgeRecipe(new ItemStack(ModItems.PICKAXE_HEAD_MOLD), new ItemStack(ModItems.TIN_INGOT), new ItemStack(ModItems.TIN_PICKAXE_HEAD), 5.0F);
		addForgeRecipe(new ItemStack(ModItems.PICKAXE_HEAD_MOLD), new ItemStack(ModItems.BRONZE_INGOT), new ItemStack(ModItems.BRONZE_PICKAXE_HEAD), 5.0F);
		addForgeRecipe(new ItemStack(ModItems.PICKAXE_HEAD_MOLD), new ItemStack(Items.IRON_INGOT), new ItemStack(ModItems.IRON_PICKAXE_HEAD), 5.0F);
		addForgeRecipe(new ItemStack(ModItems.PICKAXE_HEAD_MOLD), new ItemStack(Items.GOLD_INGOT), new ItemStack(ModItems.GOLD_PICKAXE_HEAD), 5.0F);
		addForgeRecipe(new ItemStack(ModItems.PICKAXE_HEAD_MOLD), new ItemStack(ModItems.STEEL_INGOT), new ItemStack(ModItems.STEEL_PICKAXE_HEAD), 5.0F);
		addForgeRecipe(new ItemStack(ModItems.PICKAXE_HEAD_MOLD), new ItemStack(ModItems.MAGNETIC_GOLD_INGOT), new ItemStack(ModItems.MAGNETIC_GOLD_PICKAXE_HEAD), 5.0F);
		addForgeRecipe(new ItemStack(ModItems.PICKAXE_HEAD_MOLD), new ItemStack(ModItems.RED_STEEL_INGOT), new ItemStack(ModItems.RED_STEEL_PICKAXE_HEAD), 5.0F);
		addForgeRecipe(new ItemStack(ModItems.PICKAXE_HEAD_MOLD), new ItemStack(ModItems.NICO_INGOT), new ItemStack(ModItems.NICO_PICKAXE_HEAD), 5.0F);
		
		
	}

	
	public void addForgeRecipe(ItemStack input1, ItemStack input2, ItemStack result, float experience) 
	{
		if(getForgeResult(input1, input2) != ItemStack.EMPTY) return;
		this.smeltingList.put(input1, input2, result);
		this.experienceList.put(result, Float.valueOf(experience));
	}
	
	public ItemStack getForgeResult(ItemStack input1, ItemStack input2) 
	{
		for(Entry<ItemStack, Map<ItemStack, ItemStack>> entry : this.smeltingList.columnMap().entrySet()) 
		{
			if(this.compareItemStacks(input1, (ItemStack)entry.getKey())) 
			{
				for(Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet()) 
				{
					if(this.compareItemStacks(input2, (ItemStack)ent.getKey())) 
					{
						return (ItemStack)ent.getValue();
					}
				}
			}
		}
		return ItemStack.EMPTY;
	}
	
	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
	{
		return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
	}
	
	public Table<ItemStack, ItemStack, ItemStack> getDualSmeltingList() 
	{
		return this.smeltingList;
	}
	
	public float getForgeExperience(ItemStack stack)
	{
		for (Entry<ItemStack, Float> entry : this.experienceList.entrySet()) 
		{
			if(this.compareItemStacks(stack, (ItemStack)entry.getKey())) 
			{
				return ((Float)entry.getValue()).floatValue();
			}
		}
		return 0.0F;
	}
}