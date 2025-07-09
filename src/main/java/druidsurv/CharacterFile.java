package druidsurv;

import basemod.abstracts.CustomEnergyOrb;
import basemod.abstracts.CustomPlayer;
import basemod.animations.SpriterAnimation;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.MathUtils;
import com.evacipated.cardcrawl.modthespire.lib.SpireEnum;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.CardLibrary;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.helpers.ScreenShake;
import com.megacrit.cardcrawl.localization.CharacterStrings;
import com.megacrit.cardcrawl.screens.CharSelectInfo;
import druidsurv.cards.starterDruid.*;
import druidsurv.relics.TodoItemNew;
import druidsurv.relics.decks.BasicDeck;

import java.util.ArrayList;

import static druidsurv.CharacterFile.Enums.DRUIDSURV_COLOR;
import static druidsurv.ModFile.*;

public class CharacterFile extends CustomPlayer {

    static final String ID = makeID("DruidSurv");
    static final CharacterStrings characterStrings = CardCrawlGame.languagePack.getCharacterString(ID);
    static final String[] NAMES = characterStrings.NAMES;
    static final String[] TEXT = characterStrings.TEXT;


    public CharacterFile(String name, PlayerClass setClass) {
        super(name, setClass, new CustomEnergyOrb(orbTextures, makeCharacterPath("mainChar/orb/vfx.png"), null), new SpriterAnimation(
                makeCharacterPath("mainChar/static.scml")));
        initializeClass(null,
                SHOULDER1,
                SHOULDER2,
                CORPSE,
                getLoadout(), 50.0F, -10.0F, 261, 290, new EnergyManager(3));


        dialogX = (drawX + 0.0F * Settings.scale);
        dialogY = (drawY + 240.0F * Settings.scale);
    }

    @Override
    public CharSelectInfo getLoadout() {
        return new CharSelectInfo(NAMES[0], TEXT[0],
                72, 72, 2, 0, 5, this, getStartingRelics(),
                getStartingDeck(), false);
    }

    @Override
    public ArrayList<String> getStartingDeck() {
        ArrayList<String> retVal = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            retVal.add(Strike.ID);
        }
        for (int i = 0; i < 2; i++) {
            retVal.add(HuntressMonkey.ID);
        }
        for (int i = 0; i < 1; i++) {
            retVal.add(HeartOfThunder.ID);
        }
        for (int i = 0; i < 1; i++) {
            retVal.add(Harden.ID);
        }
        for (int i = 0; i < 3; i++) {
            retVal.add(Defend.ID);
        }
        for (int i = 0; i < 2; i++) {
            retVal.add(OliveBloon.ID);
        }
        return retVal;
    }

    public ArrayList<String> getStartingRelics() {
        ArrayList<String> retVal = new ArrayList<>();
        retVal.add(BasicDeck.ID);
        retVal.add(TodoItemNew.ID);
        return retVal;
    }

    @Override
    public void doCharSelectScreenSelectEffect() {
        CardCrawlGame.sound.playA("UNLOCK_PING", MathUtils.random(-0.2F, 0.2F));
        CardCrawlGame.screenShake.shake(ScreenShake.ShakeIntensity.LOW, ScreenShake.ShakeDur.SHORT,
                false);
    }

    private static final String[] orbTextures = {
            makeCharacterPath("mainChar/orb/CoinIcon1.png"),
            makeCharacterPath("mainChar/orb/void.png"),
            makeCharacterPath("mainChar/orb/CoinDepletedIconSprite1.png")
    };

    @Override
    public String getCustomModeCharacterButtonSoundKey() {
        return "UNLOCK_PING";
    }

    @Override
    public int getAscensionMaxHPLoss() {
        return 11;
    }

    @Override
    public AbstractCard.CardColor getCardColor() {
        return DRUIDSURV_COLOR;
    }

    @Override
    public Color getCardTrailColor() {
        return characterColor.cpy();
    }

    @Override
    public BitmapFont getEnergyNumFont() {
        return FontHelper.energyNumFontRed;
    }

    @Override
    public String getLocalizedCharacterName() {
        return NAMES[0];
    }

    @Override
    public AbstractCard getStartCardForEvent() {
        //System.out.println("YOU NEED TO SET getStartCardForEvent() in your " + getClass().getSimpleName() + " file!");
        return new HeartOfThunder();
    }

    @Override
    public String getTitle(AbstractPlayer.PlayerClass playerClass) {
        return NAMES[1];
    }

    @Override
    public AbstractPlayer newInstance() {
        return new CharacterFile(name, chosenClass);
    }

    @Override
    public Color getCardRenderColor() {
        return characterColor.cpy();
    }

    @Override
    public Color getSlashAttackColor() {
        return characterColor.cpy();
    }

    @Override
    public AbstractGameAction.AttackEffect[] getSpireHeartSlashEffect() {
        return new AbstractGameAction.AttackEffect[]{
                AbstractGameAction.AttackEffect.LIGHTNING,
                AbstractGameAction.AttackEffect.SLASH_HEAVY,
                AbstractGameAction.AttackEffect.LIGHTNING};
    }

    @Override
    public String getSpireHeartText() {
        return TEXT[1];
    }

    @Override
    public String getVampireText() {
        return TEXT[2];
    }

    public static class Enums {
        @SpireEnum
        public static PlayerClass DRUIDSURV;
        @SpireEnum
        public static PlayerClass NEMDRUID;
        @SpireEnum
        public static PlayerClass STRIKER;
        @SpireEnum
        public static PlayerClass ADORA;
        @SpireEnum(name = "DRUIDSURV_COLOR")
        public static AbstractCard.CardColor DRUIDSURV_COLOR;
        @SpireEnum(name = "MONKEY_COLOR")
        public static AbstractCard.CardColor MONKEY_COLOR;
        @SpireEnum(name = "NEMDRUID_COLOR")
        public static AbstractCard.CardColor NEMDRUID_COLOR;
        @SpireEnum(name = "MOXES")
        public static AbstractCard.CardColor NEMDRUID_MOX_COLOR;
        @SpireEnum(name = "THE STRIKER")
        public static AbstractCard.CardColor STRIKER_COLOR;
        @SpireEnum(name = "THE HIGH PRIESTESS")
        public static AbstractCard.CardColor ADORA_COLOR;
        @SuppressWarnings("unused")
        @SpireEnum(name = "DRUIDSURV_COLOR")
        public static CardLibrary.LibraryType LIBRARY_COLOR;
        @SuppressWarnings("unused")
        @SpireEnum(name = "MONKEY_COLOR")
        public static CardLibrary.LibraryType LIBRARY_COLOR_M;
        @SuppressWarnings("unused")
        @SpireEnum(name = "NEMDRUID_COLOR")
        public static CardLibrary.LibraryType LIBRARY_COLOR_NEM;
        @SuppressWarnings("unused")
        @SpireEnum(name = "MOXES")
        public static CardLibrary.LibraryType LIBRARY_MOX_COLOR;
        @SuppressWarnings("unused")
        @SpireEnum(name = "THE STRIKER")
        public static CardLibrary.LibraryType LIBRARY_COLOR_STRIKER;
        @SuppressWarnings("unused")
        @SpireEnum(name = "THE HIGH PRIESTESS")
        public static CardLibrary.LibraryType LIBRARY_COLOR_ADORA;
    }
}
