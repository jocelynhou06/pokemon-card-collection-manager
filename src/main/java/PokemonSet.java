/**
 * Represents all supported expansion sets by Pokemon TCG
 * Each set belongs to a specific main.java.Series and has a display name
 */
public enum PokemonSet {
    BASE_SET("Base Set", Series.ORIGINAL),
    JUNGLE("Jungle", Series.ORIGINAL),
    FOSSIL("Fossil", Series.ORIGINAL),
    BASE_SET_2("Base Set 2", Series.ORIGINAL),
    TEAM_ROCKET("Team Rocket", Series.ORIGINAL),
    GYM_HEROES("Gym Heroes", Series.ORIGINAL),
    GYM_CHALLENGE("Gym Challenge", Series.ORIGINAL),
    NEO_GENESIS("Neo Genesis", Series.ORIGINAL),
    NEO_DISCOVERY("Neo Discovery", Series.ORIGINAL),
    NEO_REVELATION("Neo Revelation", Series.ORIGINAL),
    NEO_DESTINY("Neo Destiny", Series.ORIGINAL),
    LEGENDARY_COLLECTION("Legendary Collection", Series.ORIGINAL),

    EXPEDITION_BASE_SET("Expedition Base Set", Series.E_CARD),
    AQUAPOLIS("Aquapolis", Series.E_CARD),
    SKYRIDGE("Skyridge", Series.E_CARD),

    EX_RUBY_SAPPHIRE("EX Ruby & Sapphire", Series.EX),
    EX_SANDSTORM("EX Sandstorm", Series.EX),
    EX_DRAGON("EX Dragon", Series.EX),
    EX_TEAM_MAGMA_VS_TEAM_AQUA("EX Team Magma vs. Team Aqua", Series.EX),
    EX_HIDDEN_LEGENDS("EX Hidden Legends", Series.EX),
    EX_FIRERED_LEAFGREEN("EX FireRed & LeafGreen", Series.EX),
    EX_TEAM_ROCKET_RETURNS("EX Team Rocket Returns", Series.EX),
    EX_DEOXYS("EX Deoxys", Series.EX),
    EX_EMERALD("EX Emerald", Series.EX),
    EX_UNSEEN_FORCES("EX Unseen Forces", Series.EX),
    EX_DELTA_SPECIES("EX Delta Species", Series.EX),
    EX_LEGEND_MAKER("EX Legend Maker", Series.EX),
    EX_HOLON_PHANTOMS("EX Holon Phantoms", Series.EX),
    EX_CRYSTAL_GUARDIANS("EX Crystal Guardians", Series.EX),
    EX_DRAGON_FRONTIERS("EX Dragon Frontiers", Series.EX),
    EX_POWER_KEEPERS("EX Power Keepers", Series.EX),

    DIAMOND_PEARL("Diamond & Pearl", Series.DIAMOND_PEARL),
    MYSTERIOUS_TREASURES("Mysterious Treasures", Series.DIAMOND_PEARL),
    SECRET_WONDERS("Secret Wonders", Series.DIAMOND_PEARL),
    GREAT_ENCOUNTERS("Great Encounters", Series.DIAMOND_PEARL),
    MAJESTIC_DAWN("Majestic Dawn", Series.DIAMOND_PEARL),
    LEGENDS_AWAKENED("Legends Awakened", Series.DIAMOND_PEARL),
    STORMFRONT("Stormfront", Series.DIAMOND_PEARL),

    PLATINUM("Platinum", Series.PLATINUM),
    RISING_RIVALS("Rising Rivals", Series.PLATINUM),
    SUPREME_VICTORS("Supreme Victors", Series.PLATINUM),
    ARCEUS("Arceus", Series.PLATINUM),

    HEARTGOLD_SOULSILVER("HeartGold & SoulSilver", Series.HEARTGOLD_SOULSILVER),
    UNLEASHED("Unleashed", Series.HEARTGOLD_SOULSILVER),
    UNDAUNTED("Undaunted", Series.HEARTGOLD_SOULSILVER),
    TRIUMPHANT("Triumphant", Series.HEARTGOLD_SOULSILVER),
    CALL_OF_LEGENDS("Call of Legends", Series.HEARTGOLD_SOULSILVER),

    BLACK_WHITE("Black & White", Series.BLACK_WHITE),
    EMERGING_POWERS("Emerging Powers", Series.BLACK_WHITE),
    NOBLE_VICTORIES("Noble Victories", Series.BLACK_WHITE),
    NEXT_DESTINIES("Next Destinies", Series.BLACK_WHITE),
    DARK_EXPLORERS("Dark Explorers", Series.BLACK_WHITE),
    DRAGONS_EXALTED("Dragons Exalted", Series.BLACK_WHITE),
    BOUNDARIES_CROSSED("Boundaries Crossed", Series.BLACK_WHITE),
    PLASMA_STORM("Plasma Storm", Series.BLACK_WHITE),
    PLASMA_FREEZE("Plasma Freeze", Series.BLACK_WHITE),
    PLASMA_BLAST("Plasma Blast", Series.BLACK_WHITE),
    LEGENDARY_TREASURES("Legendary Treasures", Series.BLACK_WHITE),

    XY("XY", Series.XY),
    FLASHFIRE("Flashfire", Series.XY),
    FURIOUS_FISTS("Furious Fists", Series.XY),
    PHANTOM_FORCES("Phantom Forces", Series.XY),
    PRIMAL_CLASH("Primal Clash", Series.XY),
    ROARING_SKIES("Roaring Skies", Series.XY),
    ANCIENT_ORIGINS("Ancient Origins", Series.XY),
    BREAKTHROUGH("BREAKthrough", Series.XY),
    BREAKPOINT("BREAKpoint", Series.XY),
    FATES_COLLIDE("Fates Collide", Series.XY),
    STEAM_SIEGE("Steam Siege", Series.XY),
    EVOLUTIONS("Evolutions", Series.XY),

    SUN_MOON("Sun & Moon", Series.SUN_MOON),
    GUARDIANS_RISING("Guardians Rising", Series.SUN_MOON),
    BURNING_SHADOWS("Burning Shadows", Series.SUN_MOON),
    CRIMSON_INVASION("Crimson Invasion", Series.SUN_MOON),
    ULTRA_PRISM("Ultra Prism", Series.SUN_MOON),
    FORBIDDEN_LIGHT("Forbidden Light", Series.SUN_MOON),
    CELESTIAL_STORM("Celestial Storm", Series.SUN_MOON),
    DRAGON_MAJESTY("Dragon Majesty", Series.SUN_MOON),
    LOST_THUNDER("Lost Thunder", Series.SUN_MOON),
    TEAM_UP("Team Up", Series.SUN_MOON),
    DETECTIVE_PIKACHU("Detective Pikachu", Series.SUN_MOON),
    UNBROKEN_BONDS("Unbroken Bonds", Series.SUN_MOON),
    UNIFIED_MINDS("Unified Minds", Series.SUN_MOON),
    HIDDEN_FATES("Hidden Fates", Series.SUN_MOON),
    COSMIC_ECLIPSE("Cosmic Eclipse", Series.SUN_MOON),

    SWORD_SHIELD("Sword & Shield", Series.SWORD_SHIELD),
    REBEL_CLASH("Rebel Clash", Series.SWORD_SHIELD),
    DARKNESS_ABLAZE("Darkness Ablaze", Series.SWORD_SHIELD),
    CHAMPIONS_PATH("Champion's Path", Series.SWORD_SHIELD),
    VIVID_VOLTAGE("Vivid Voltage", Series.SWORD_SHIELD),
    SHINING_FATES("Shining Fates", Series.SWORD_SHIELD),
    BATTLE_STYLES("Battle Styles", Series.SWORD_SHIELD),
    CHILLING_REIGN("Chilling Reign", Series.SWORD_SHIELD),
    EVOLVING_SKIES("Evolving Skies", Series.SWORD_SHIELD),
    CELEBRATIONS("Celebrations", Series.SWORD_SHIELD),
    FUSION_STRIKE("Fusion Strike", Series.SWORD_SHIELD),
    BRILLIANT_STARS("Brilliant Stars", Series.SWORD_SHIELD),
    ASTRAL_RADIANCE("Astral Radiance", Series.SWORD_SHIELD),
    POKEMON_GO("Pokémon GO", Series.SWORD_SHIELD),
    LOST_ORIGIN("Lost Origin", Series.SWORD_SHIELD),
    SILVER_TEMPEST("Silver Tempest", Series.SWORD_SHIELD),
    CROWN_ZENITH("Crown Zenith", Series.SWORD_SHIELD),

    SCARLET_VIOLET("Scarlet & Violet", Series.SCARLET_VIOLET),
    PALDEA_EVOLVED("Paldea Evolved", Series.SCARLET_VIOLET),
    OBSIDIAN_FLAMES("Obsidian Flames", Series.SCARLET_VIOLET),
    POKEMON_151("151", Series.SCARLET_VIOLET),
    PARADOX_RIFT("Paradox Rift", Series.SCARLET_VIOLET),
    PALDEAN_FATES("Paldean Fates", Series.SCARLET_VIOLET),
    TEMPORAL_FORCES("Temporal Forces", Series.SCARLET_VIOLET),
    TWILIGHT_MASQUERADE("Twilight Masquerade", Series.SCARLET_VIOLET),
    SHROUDED_FABLE("Shrouded Fable", Series.SCARLET_VIOLET),
    STELLAR_CROWN("Stellar Crown", Series.SCARLET_VIOLET),
    SURGING_SPARKS("Surging Sparks", Series.SCARLET_VIOLET),
    PRISMATIC_EVOLUTIONS("Prismatic Evolutions", Series.SCARLET_VIOLET),
    JOURNEY_TOGETHER("Journey Together", Series.SCARLET_VIOLET),
    DESTINED_RIVALS("Destined Rivals", Series.SCARLET_VIOLET),
    BLACK_BOLT("Black Bolt", Series.SCARLET_VIOLET),
    WHITE_FLARE("White Flare", Series.SCARLET_VIOLET),
    MEGA_EVOLUTION("Mega Evolution", Series.SCARLET_VIOLET),
    PHANTASMAL_FLAMES("Phantasmal Flames", Series.SCARLET_VIOLET),
    ASCENDED_HEROES("Ascended Heroes", Series.SCARLET_VIOLET),
    PERFECT_ORDER("Perfect Order", Series.SCARLET_VIOLET),
    CHAOS_RISING("Chaos Rising", Series.SCARLET_VIOLET),
    PITCH_BLACK("Pitch Black", Series.SCARLET_VIOLET),
    THIRTIETH_CELEBRATION("30th Celebration", Series.SCARLET_VIOLET);

    /**
     * The display name of Pokemon set
     */
    private final String displayName;

    /**
     * The series the set belongs to
     */
    private final Series series;

    /**
     * Constructs Pokemon set
     *
     * @param displayName the display name of the set
     * @param series the series the set belongs to
     */
    PokemonSet(String displayName, Series series) {
        this.displayName = displayName;
        this.series = series;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Series getSeries() {
        return series;
    }

    @Override
    public String toString() {
        return displayName;
    }
}