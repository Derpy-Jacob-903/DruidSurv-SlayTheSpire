package druidsurv;

import basemod.AutoAdd;
import basemod.BaseMod;
import basemod.abstracts.DynamicVariable;
import basemod.helpers.RelicType;
import basemod.interfaces.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.mod.stslib.Keyword;
import com.evacipated.cardcrawl.mod.stslib.icons.CustomIconHelper;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.google.gson.Gson;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.ModHelper;
import com.megacrit.cardcrawl.localization.*;
import com.megacrit.cardcrawl.relics.IceCream;
import com.megacrit.cardcrawl.relics.RunicPyramid;
import com.megacrit.cardcrawl.screens.custom.CustomMod;
import com.megacrit.cardcrawl.unlock.UnlockTracker;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.cards.cardvars.AbstractEasyDynamicVariable;
import druidsurv.potions.AbstractEasyPotion;
import druidsurv.powers.icons.*;
import druidsurv.relics.AbstractEasyRelic;
import druidsurv.relics.StormBlight;
import druidsurv.relics.TodoItemNew;
import druidsurv.util.DeckHandler;
import druidsurv.util.ProAudio;
import druidsurv.util.dailymods.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static druidsurv.util.Wiz.*;

@SuppressWarnings({"unused", "WeakerAccess"})
@SpireInitializer
public class ModFile implements
        EditCardsSubscriber,
        EditRelicsSubscriber,
        EditStringsSubscriber,
        EditKeywordsSubscriber,
        EditCharactersSubscriber,
        AddCustomModeModsSubscriber,
        PostDungeonInitializeSubscriber,
        AddAudioSubscriber {

    public static final String modID = "druidsurv";

    public static String makeID(String idText) {
        return modID + ":" + idText;
    }

    public static Color characterColor = new Color(.129f, .529f, .075f, 1); // Lime
    public static Color NeutralMonkeysColor = new Color(.392f, .392f, .392f, 1);
    public static Color NemCharacterColor = new Color(.549f, .0f, .192f, 1);
    public static Color MoxCharacterColor = new Color(.840f, .258f, .367f, 1); // Pink
    public static Color StrikerCharacterColor = new Color(.474f, .515f, .0f, 1); // Olive
    public static Color AdoraCharacterColor = new Color(.517f, .371f, .027f, 1); // Gold
    public static Color CrowCharacterColor = new Color(.268f, .599f, .8f, 1); // Teal

    /*public static Color characterColor = new Color(.259f, .573f, .051f, 1); // Lime
    public static Color NemCharacterColor = new Color(.192f, .765f, .945f, 1); // Cyan
    public static Color MoxCharacterColor = new Color(1f, .345f, .467f, 1); // Pink
    public static Color StrikerCharacterColor = new Color(.557f, .765f, .137f, 1); // Olive, #8ec323
    public static Color CrowCharacterColor = new Color(.204f, .482f, .608f, 1); // Teal */

    public static final String SHOULDER1 = makeCharacterPath("mainChar/shoulder.png");
    public static final String SHOULDER2 = makeCharacterPath("mainChar/shoulder2.png");
    public static final String CORPSE = makeCharacterPath("mainChar/corpse.png");
    private static final String ATTACK_S_ART = makeImagePath("512/_druid_attack.png");
    private static final String SKILL_S_ART = makeImagePath("512/_druid_skill.png");
    private static final String POWER_S_ART = makeImagePath("512/_druid_power.png");
    private static final String CARD_ENERGY_S = makeImagePath("512/energy.png");
    private static final String TEXT_ENERGY = makeImagePath("512/text_energy.png");
    private static final String ATTACK_L_ART = makeImagePath("1024/_druid_attack.png");
    private static final String SKILL_L_ART = makeImagePath("1024/_druid_skill.png");
    private static final String POWER_L_ART = makeImagePath("1024/_druid_power.png");
    private static final String CARD_ENERGY_L = makeImagePath("1024/energy.png");
    private static final String CHARSELECT_BUTTON = makeImagePath("charSelect/charButton.png");
    private static final String CHARSELECT_PORTRAIT = makeImagePath("charSelect/charBG.png");

    public static final String SHOULDER1_NEM = makeCharacterPath("mainChar/shoulder.png");
    public static final String SHOULDER2_NEM = makeCharacterPath("mainChar/shoulder2.png");
    public static final String CORPSE_NEM = makeCharacterPath("mainChar/corpse.png");
    private static final String ATTACK_S_ART_NEM = makeImagePath("512/nem_attack.png");
    private static final String SKILL_S_ART_NEM = makeImagePath("512/nem_skill.png");
    private static final String POWER_S_ART_NEM = makeImagePath("512/nem_power.png");
    private static final String ATTACK_L_ART_NEM = makeImagePath("1024/attack.png");
    private static final String SKILL_L_ART_NEM = makeImagePath("1024/nem_skill.png");
    private static final String POWER_L_ART_NEM = makeImagePath("1024/nem_power.png");
    private static final String CHARSELECT_BUTTON_NEM = makeImagePath("charSelect/nemCharButton.png");
    private static final String CHARSELECT_PORTRAIT_NEM = makeImagePath("charSelect/nemCharBG.png");

    public static final String SHOULDER1_SJ = makeCharacterPath("mainChar/shoulder.png");
    public static final String SHOULDER2_SJ = makeCharacterPath("mainChar/shoulder2.png");
    public static final String CORPSE_SJ = makeCharacterPath("mainChar/corpse.png");
    private static final String ATTACK_S_ART_SJ = makeImagePath("512/striker_attack.png");
    private static final String SKILL_S_ART_SJ = makeImagePath("512/striker_skill.png");
    private static final String POWER_S_ART_SJ = makeImagePath("512/striker_power.png");
    private static final String ATTACK_L_ART_SJ = makeImagePath("1024/striker_attack.png");
    private static final String SKILL_L_ART_SJ = makeImagePath("1024/striker_skill.png");
    private static final String POWER_L_ART_SJ = makeImagePath("1024/striker_power.png");
    private static final String CHARSELECT_BUTTON_SJ = makeImagePath("charSelect/adoraCharButton.png");
    private static final String CHARSELECT_PORTRAIT_SJ = makeImagePath("charSelect/adoraCharBG.png");

    public static final String SHOULDER1_HP = makeCharacterPath("mainChar/shoulder.png");
    public static final String SHOULDER2_HP = makeCharacterPath("mainChar/shoulder2.png");
    public static final String CORPSE_HP = makeCharacterPath("mainChar/corpse.png");
    private static final String ATTACK_S_ART_HP = makeImagePath("512/striker_attack.png");
    private static final String SKILL_S_ART_HP = makeImagePath("512/striker_skill.png");
    private static final String POWER_S_ART_HP = makeImagePath("512/striker_power.png");
    private static final String ATTACK_L_ART_HP = makeImagePath("1024/striker_attack.png");
    private static final String SKILL_L_ART_HP = makeImagePath("1024/striker_skill.png");
    private static final String POWER_L_ART_HP = makeImagePath("1024/striker_power.png");
    private static final String CHARSELECT_BUTTON_HP = makeImagePath("charSelect/strikerCharButton.png");
    private static final String CHARSELECT_PORTRAIT_HP = makeImagePath("charSelect/strikerCharBG.png");

    private static final String ATTACK_S_ART_M = makeImagePath("512/monkey_attack.png");
    private static final String SKILL_S_ART_M = makeImagePath("512/monkey_skill.png");
    private static final String POWER_S_ART_M = makeImagePath("512/monkey_power.png");
    private static final String ATTACK_L_ART_M = makeImagePath("1024/monkey_attack.png");
    private static final String SKILL_L_ART_M = makeImagePath("1024/monkey_skill.png");
    private static final String POWER_L_ART_M = makeImagePath("1024/monkey_power.png");

    private static final String ATTACK_S_ART_B = makeImagePath("512/bloon_attack.png");
    private static final String SKILL_S_ART_B = makeImagePath("512/bloon_skill.png");
    private static final String POWER_S_ART_B = makeImagePath("512/bloon_power.png");
    private static final String ATTACK_L_ART_B = makeImagePath("1024/bloon_attack.png");
    private static final String SKILL_L_ART_B = makeImagePath("1024/bloon_skill.png");
    private static final String POWER_L_ART_B = makeImagePath("1024/bloon_power.png");

    private static final String ATTACK_S_ART_P = makeImagePath("512/power_attack.png");
    private static final String SKILL_S_ART_P = makeImagePath("512/power_skill.png");
    private static final String POWER_S_ART_P = makeImagePath("512/power_power.png");
    private static final String ATTACK_L_ART_P = makeImagePath("1024/power_attack.png");
    private static final String SKILL_L_ART_P = makeImagePath("1024/power_skill.png");
    private static final String POWER_L_ART_P = makeImagePath("1024/power_power.png");

    private static final String SKILL_S_ART_Mox = makeImagePath("512/mox.png");
    private static final String SKILL_L_ART_Mox = makeImagePath("1024/mox.png");

    public static Settings.GameLanguage[] SupportedLanguages = {
            Settings.GameLanguage.ENG,
    };

    private String getLangString() {
        for (Settings.GameLanguage lang : SupportedLanguages) {
            if (lang.equals(Settings.language)) {
                return Settings.language.name().toLowerCase();
            }
        }
        return "eng";
    }

    public ModFile() {
        BaseMod.subscribe(this);

        BaseMod.addColor(CharacterFile.Enums.DRUIDSURV_COLOR, characterColor, characterColor, characterColor,
                characterColor, characterColor, characterColor, characterColor,
                ATTACK_S_ART, SKILL_S_ART, POWER_S_ART, CARD_ENERGY_S,
                ATTACK_L_ART, SKILL_L_ART, POWER_L_ART, CARD_ENERGY_L, TEXT_ENERGY);

        BaseMod.addColor(CharacterFile.Enums.MONKEY_COLOR, characterColor, characterColor, characterColor,
                characterColor, characterColor, characterColor, characterColor,
                ATTACK_S_ART, SKILL_S_ART, POWER_S_ART, CARD_ENERGY_S,
                ATTACK_L_ART, SKILL_L_ART, POWER_L_ART, CARD_ENERGY_L, TEXT_ENERGY);

        BaseMod.addColor(CharacterFile.Enums.NEMDRUID_COLOR, NemCharacterColor, NemCharacterColor, NemCharacterColor,
                NemCharacterColor, NemCharacterColor, NemCharacterColor, NemCharacterColor,
                ATTACK_S_ART_NEM, SKILL_S_ART_NEM, POWER_S_ART_NEM, CARD_ENERGY_S,
                ATTACK_L_ART_NEM, SKILL_L_ART_NEM, POWER_L_ART_NEM, CARD_ENERGY_L, TEXT_ENERGY);

        BaseMod.addColor(CharacterFile.Enums.NEMDRUID_MOX_COLOR, MoxCharacterColor, MoxCharacterColor, MoxCharacterColor,
                MoxCharacterColor, MoxCharacterColor, MoxCharacterColor, MoxCharacterColor,
                SKILL_S_ART_Mox, SKILL_S_ART_Mox, SKILL_S_ART_Mox, CARD_ENERGY_S,
                SKILL_L_ART_Mox, SKILL_L_ART_Mox, SKILL_L_ART_Mox, CARD_ENERGY_L, TEXT_ENERGY);

        BaseMod.addColor(CharacterFile.Enums.STRIKER_COLOR, StrikerCharacterColor, StrikerCharacterColor, StrikerCharacterColor,
                StrikerCharacterColor, StrikerCharacterColor, StrikerCharacterColor, StrikerCharacterColor,
                ATTACK_S_ART_SJ, SKILL_S_ART_SJ, POWER_S_ART_SJ, CARD_ENERGY_S,
                ATTACK_L_ART_SJ, SKILL_L_ART_SJ, POWER_L_ART_SJ, CARD_ENERGY_L, TEXT_ENERGY);

        BaseMod.addColor(CharacterFile.Enums.ADORA_COLOR, AdoraCharacterColor, AdoraCharacterColor, AdoraCharacterColor,
                AdoraCharacterColor, AdoraCharacterColor, AdoraCharacterColor, AdoraCharacterColor,
                ATTACK_S_ART_HP, SKILL_S_ART_HP, POWER_S_ART_HP, CARD_ENERGY_S,
                ATTACK_L_ART_HP, SKILL_L_ART_HP, POWER_L_ART_HP, CARD_ENERGY_L, TEXT_ENERGY);
    }

    public static String makePath(String resourcePath) {
        return modID + "Resources/" + resourcePath;
    }

    public static String makeImagePath(String resourcePath) {
        return modID + "Resources/images/" + resourcePath;
    }

    public static String makeRelicPath(String resourcePath) {
        return modID + "Resources/images/relics/" + resourcePath;
    }

    public static String makePowerPath(String resourcePath) {
        return modID + "Resources/images/powers/" + resourcePath;
    }

    public static String makeCharacterPath(String resourcePath)
    {
        return modID + "Resources/images/char/" + resourcePath;
    }

    public static String makeCardPath(String resourcePath) {
        return modID + "Resources/images/cards/" + resourcePath;
    }

    public static void initialize() {
        ModFile thismod = new ModFile();
    }

    @Override
    public void receiveEditCharacters() {
        BaseMod.addCharacter(new CharacterFile(CharacterFile.characterStrings.NAMES[1], CharacterFile.Enums.DRUIDSURV),
                CHARSELECT_BUTTON, CHARSELECT_PORTRAIT, CharacterFile.Enums.DRUIDSURV);
        BaseMod.addCharacter(new NemCharacterFile(NemCharacterFile.characterStrings.NAMES[1], CharacterFile.Enums.NEMDRUID),
                CHARSELECT_BUTTON_NEM, CHARSELECT_PORTRAIT_NEM, CharacterFile.Enums.NEMDRUID);
        /*BaseMod.addCharacter(new StrikerCharacterFile(StrikerCharacterFile.characterStrings.NAMES[1], CharacterFile.Enums.STRIKER_COLOR),
                CHARSELECT_BUTTON, CHARSELECT_PORTRAIT, CharacterFile.Enums.STRIKER);*/
        BaseMod.addCharacter(new AdoraCharacterFile(AdoraCharacterFile.characterStrings.NAMES[1], CharacterFile.Enums.ADORA),
                CHARSELECT_BUTTON, CHARSELECT_PORTRAIT, CharacterFile.Enums.ADORA);

        new AutoAdd(modID)
                .packageFilter(AbstractEasyPotion.class)
                .any(AbstractEasyPotion.class, (info, potion) -> {
                    if (potion.pool == null)
                        BaseMod.addPotion(potion.getClass(), potion.liquidColor, potion.hybridColor, potion.spotsColor, potion.ID);
                    else
                        BaseMod.addPotion(potion.getClass(), potion.liquidColor, potion.hybridColor, potion.spotsColor, potion.ID, potion.pool);
                });
    }

    @Override
    public void receiveEditRelics() {
        new AutoAdd(modID)
                .packageFilter(AbstractEasyRelic.class)
                .any(AbstractEasyRelic.class, (info, relic) -> {
                    if (relic.color == null) {
                        BaseMod.addRelic(relic, RelicType.SHARED);
                    } else {
                        BaseMod.addRelicToCustomPool(relic, relic.color);
                    }
                    if (!info.seen) {
                        UnlockTracker.markRelicAsSeen(relic.relicId);
                    }
                });

        //BaseMod.addRelicToCustomPool(new DataDisk(), CharacterFile.Enums.DRUIDSURV_COLOR);
        //BaseMod.addRelicToCustomPool(new MagicFlower(), CharacterFile.Enums.DRUIDSURV_COLOR);
    }

    @Override
    public void receiveEditCards() {
        CustomIconHelper.addCustomIcon(BloontoniumIcon.get());
        CustomIconHelper.addCustomIcon(GreenMoxIcon.get());
        CustomIconHelper.addCustomIcon(RubyMoxIcon.get());
        CustomIconHelper.addCustomIcon(BlueMoxIcon.get());
        CustomIconHelper.addCustomIcon(ClrMoxIcon.get());
        new AutoAdd(modID)
                .packageFilter(AbstractEasyDynamicVariable.class)
                .any(DynamicVariable.class, (info, var) ->
                        BaseMod.addDynamicVariable(var));
        new AutoAdd(modID)
                .packageFilter(AbstractEasyCard.class)
                .setDefaultSeen(true)
                .cards();
    }

    @Override
    public void receiveEditStrings() {
        BaseMod.loadCustomStringsFile(CardStrings.class, modID + "Resources/localization/" + getLangString() + "/Cardstrings.json");
        BaseMod.loadCustomStringsFile(RelicStrings.class, modID + "Resources/localization/" + getLangString() + "/Relicstrings.json");
        BaseMod.loadCustomStringsFile(CharacterStrings.class, modID + "Resources/localization/" + getLangString() + "/Charstrings.json");
        BaseMod.loadCustomStringsFile(PowerStrings.class, modID + "Resources/localization/" + getLangString() + "/Powerstrings.json");
        BaseMod.loadCustomStringsFile(UIStrings.class, modID + "Resources/localization/" + getLangString() + "/UIstrings.json");
        BaseMod.loadCustomStringsFile(OrbStrings.class, modID + "Resources/localization/" + getLangString() + "/Orbstrings.json");
        BaseMod.loadCustomStringsFile(StanceStrings.class, modID + "Resources/localization/" + getLangString() + "/Stancestrings.json");
        BaseMod.loadCustomStringsFile(PotionStrings.class, modID + "Resources/localization/" + getLangString() + "/Potionstrings.json");
        BaseMod.loadCustomStringsFile(RunModStrings.class, modID + "Resources/localization/" + getLangString() + "/run_mods.json");
    }

    @Override
    public void receiveAddAudio() {
        for (ProAudio a : ProAudio.values())
            BaseMod.addAudio(makeID(a.name()), makePath("audio/" + a.name().toLowerCase() + ".ogg"));
    }

    @Override
    public void receiveEditKeywords() {
        Gson gson = new Gson();
        String json = Gdx.files.internal(modID + "Resources/localization/" + getLangString() + "/Keywordstrings.json").readString(String.valueOf(StandardCharsets.UTF_8));
        com.evacipated.cardcrawl.mod.stslib.Keyword[] keywords = gson.fromJson(json, com.evacipated.cardcrawl.mod.stslib.Keyword[].class);

        if (keywords != null) {
            for (Keyword keyword : keywords) {
                BaseMod.addKeyword(modID, keyword.PROPER_NAME, keyword.NAMES, keyword.DESCRIPTION);
            }
        }
    }

    @Override
    public void receiveCustomModeMods(List<CustomMod> l) {
        l.add(new CustomMod(Improvised.ID, "b", true));
        l.add(new CustomMod(Improvised2.ID, "b", true));
        l.add(new CustomMod(QuincyStarter.ID, "b", true));
        l.add(new CustomMod(ErraticDeck.ID, "b", true));
        l.add(new CustomMod(OrbDeck.ID, "b", true));
    }

    @Override
    public void receivePostDungeonInitialize() {
        DeckHandler deez = new DeckHandler();
        if (CardCrawlGame.trial != null && CardCrawlGame.trial.dailyModIDs().contains(Improvised.ID) || ModHelper.isModEnabled(Improvised.ID)) {
            deez.ImprovisedDeck();
        }

        if (CardCrawlGame.trial != null && CardCrawlGame.trial.dailyModIDs().contains(Improvised2.ID) || ModHelper.isModEnabled(Improvised2.ID)) {
            deez.Improvised2Deck();
        }

        if (CardCrawlGame.trial != null && CardCrawlGame.trial.dailyModIDs().contains(Improvised2.ID) || ModHelper.isModEnabled(Improvised2.ID)) {
            deez.Improvised2Deck();
        }

        if (CardCrawlGame.trial != null && CardCrawlGame.trial.dailyModIDs().contains(QuincyStarter.ID) || ModHelper.isModEnabled(QuincyStarter.ID)) {
            p().relics.add(new TodoItemNew());
            p().relics.add(new StormBlight());
            p().relics.add(new IceCream());
            p().relics.add(new RunicPyramid());
            deez.QuincyStarter();
        }

        if (CardCrawlGame.trial != null && CardCrawlGame.trial.dailyModIDs().contains(ErraticDeck.ID) || ModHelper.isModEnabled(ErraticDeck.ID)) {
            deez.ErraticDeck();
        }
        if (CardCrawlGame.trial != null && CardCrawlGame.trial.dailyModIDs().contains(OrbDeck.ID) || ModHelper.isModEnabled(OrbDeck.ID)) {
            deez.OrbDeck();
        }
    }

}
