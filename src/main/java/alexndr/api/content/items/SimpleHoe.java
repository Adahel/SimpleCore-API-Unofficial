package alexndr.api.content.items;

import java.util.List;

import com.google.common.collect.Lists;

import alexndr.api.config.IConfigureItemHelper;
import alexndr.api.config.types.ConfigTool;
import alexndr.api.helpers.game.TooltipHelper;
import alexndr.api.registry.ContentCategories;
import alexndr.api.registry.ContentRegistry;
import alexndr.api.registry.Plugin;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * @author AleXndrTheGr8st
 */
public class SimpleHoe extends ItemHoe implements IConfigureItemHelper<SimpleHoe, ConfigTool>
{
	private final ToolMaterial material;
	private Plugin plugin;
	private ContentCategories.Item category = ContentCategories.Item.TOOL;
	private ConfigTool entry;
	@SuppressWarnings("unused")
	private List<String> toolTipStrings = Lists.newArrayList();

	/**
	 * Creates a simple hoe, such as the Copper Hoe.
	 * @param plugin The plugin the tool belongs to
	 * @param material The ToolMaterial of the tool
	 */
	public SimpleHoe(Plugin plugin, ToolMaterial material) {
		super(material);
		this.plugin = plugin;
		this.material = material;
	}
	
	@Override
	public SimpleHoe setUnlocalizedName(String hoeName) {
		super.setUnlocalizedName(hoeName);
        setRegistryName(this.plugin.getModId(), hoeName);
        GameRegistry.register(this);
		ContentRegistry.registerItem(this.plugin, this, hoeName, this.category);
		this.setHarvestLevel("axe", entry.getHarvestLevel());
		return this;
	}
	
	/* lifted from McJty's CompatItemTool class */
    protected ActionResult<ItemStack> clOnItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
        return super.onItemRightClick(worldIn, playerIn, hand);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
        return clOnItemRightClick(worldIn, playerIn, hand);
    }

    /**
     * Called when a Block is right-clicked with this Item
     */
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return clOnItemUse(player, world, pos, hand, facing, hitX, hitY, hitZ);
    }

    protected EnumActionResult clOnItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return super.onItemUse(player, world, pos, hand, facing, hitX, hitY, hitZ);
    }
    /* end McJty */
    

	/**
	 * Returns the ConfigTool used by this tool.
	 * @return ConfigTool
	 */
	public ConfigTool getConfigEntry() {
		return this.entry;
	}
	
	/**
	 * Sets the ConfigTool to be used for this tool.
	 * @param entry ConfigTool
	 * @return SimpleHoe
	 */
	public SimpleHoe setConfigEntry(ConfigTool entry) {
		this.entry = entry;
		this.setAdditionalProperties();
		return this;
	}
	
	/**
	 * Adds a tooltip to the tool. Must be unlocalised, so needs to be present in a localization file.
	 * @param toolTip Name of the localisation entry for the tooltip, as a String. Normal format is modId.theitem.info
	 * @return SimpleHoe
	 */
	public SimpleHoe addToolTip(String toolTip) {
		TooltipHelper.addTooltipToItem(this, toolTip);
		return this;
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return this.material.getRepairItemStack().getItem() == repair.getItem() ? true : super.getIsRepairable(toRepair, repair);
	}
	
	public void setAdditionalProperties() {
//		if(entry.getValueByName("CreativeTab") != null && entry.getValueByName("CreativeTab").isActive()) {
//			this.setCreativeTab(entry.getCreativeTab());
//		}
	}
}
