package alexndr.api.helpers.game;

import net.minecraft.creativetab.CreativeTabs;
import alexndr.api.registry.ContentCategories.CreativeTab;
import alexndr.api.registry.ContentRegistry;

/**
 * @author AleXndrTheGr8st
 */
public class TabHelper {
	protected static boolean tabInitDone = false;
	
	public static boolean wereTabsInitialized() { return tabInitDone; }
	public static void setTabInitDone(boolean done) { tabInitDone = done; }
	
	/**
	 * Returns a CreativeTab with the specified name if it exists in the ContentRegistry.
	 * If it doesn't exist, returns null.
	 * @param tabName Name of the CreativeTab
	 * @return CreativeTab
	 */
	public static CreativeTabs getTab(String tabName) {
		if(ContentRegistry.doesTabExist(tabName))
			return ContentRegistry.getTab(tabName);
		else return null;
	}
	
	/**
	 * Returns an appropriate GENERAL CreativeTab.
	 * GENERAL tabs contain items/blocks of any type.
	 * If there is no appropriate tab, returns the vanilla BLOCKS tab.
	 * @return CreativeTab for the item/block to be placed in
	 */
	public static CreativeTabs generalTab() {
		if(ContentRegistry.getFirstTabInCategory(CreativeTab.GENERAL) != null)
			return ContentRegistry.getFirstTabInCategory(CreativeTab.GENERAL);
		else return CreativeTab.GENERAL.vanillaTab;
	}
	
	/**
	 * Returns an appropriate BLOCKS CreativeTab.
	 * BLOCKS tabs contain blocks such as ores.
	 * If there is no appropriate tab, returns the vanilla BLOCKS tab.
	 * @return CreativeTab for the block to be placed in
	 */
	public static CreativeTabs blocksTab() {
		if(ContentRegistry.getFirstTabInCategory(CreativeTab.BLOCKS) != null)
			return ContentRegistry.getFirstTabInCategory(CreativeTab.BLOCKS);
		else return CreativeTab.BLOCKS.vanillaTab;
	}
	
	/**
	 * Returns an appropriate DECORATIONS CreativeTab.
	 * DECORATIONS tabs contain items/blocks used for decoration.
	 * If there is no appropriate tab, returns the vanilla DECORATIONS tab.
	 * @return Creative tab for the item/block to be placed in
	 */
	public static CreativeTabs decorationsTab() {
		if(ContentRegistry.getFirstTabInCategory(CreativeTab.DECORATIONS) != null)
			return ContentRegistry.getFirstTabInCategory(CreativeTab.DECORATIONS);
		else return CreativeTab.DECORATIONS.vanillaTab;
	}
	
	/**
	 * Returns an appropriate MATERIALS CreativeTab.
	 * MATERIALS tabs contain items such as ingots.
	 * If there is no appropriate tab, returns the vanilla MATERIALS tab.
	 * @return Creative tab for the item to be placed in
	 */
	public static CreativeTabs materialsTab() {
		if(ContentRegistry.getFirstTabInCategory(CreativeTab.MATERIALS) != null)
			return ContentRegistry.getFirstTabInCategory(CreativeTab.MATERIALS);
		else return CreativeTab.MATERIALS.vanillaTab;
	}
	
	/**
	 * Returns an appropriate TOOLS CreativeTab.
	 * TOOLS tabs contain tools such as Mythril Tools.
	 * If there is no appropriate tab, returns the vanilla TOOLS tab.
	 * @return Creative tab for the item to be placed in
	 */
	public static CreativeTabs toolsTab() {
		if(ContentRegistry.getFirstTabInCategory(CreativeTab.TOOLS) != null)
			return ContentRegistry.getFirstTabInCategory(CreativeTab.TOOLS);
		else return CreativeTab.TOOLS.vanillaTab;
	}
	
	/**
	 * Returns an appropriate COMBAT CreativeTab.
	 * COMBAT tabs contain armor and weapons such as Onyx Armor and Copper Sword.
	 * If there is no appropriate tab, returns the vanilla COMBAT tab.
	 * @return Creative tab for the item to be placed in
	 */
	public static CreativeTabs combatTab() {
		if(ContentRegistry.getFirstTabInCategory(CreativeTab.COMBAT) != null)
			return ContentRegistry.getFirstTabInCategory(CreativeTab.COMBAT);
		else return CreativeTab.COMBAT.vanillaTab;
	}
	
	/**
	 * Returns an appropriate OTHER CreativeTab.
	 * OTHER tabs contain items/blocks that don't fit into any other tabs.
	 * If there is no appropriate tab, returns the vanilla MISC tab.
	 * @return Creative tab for the item to be placed in
	 */
	public static CreativeTabs otherTab() {
		if(ContentRegistry.getFirstTabInCategory(CreativeTab.OTHER) != null)
			return ContentRegistry.getFirstTabInCategory(CreativeTab.OTHER);
		else return CreativeTab.OTHER.vanillaTab;
	}
}
