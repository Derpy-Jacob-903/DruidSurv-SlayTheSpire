package druidsurv.util;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.blue.*;
import com.megacrit.cardcrawl.cards.green.*;
import com.megacrit.cardcrawl.cards.purple.*;
import com.megacrit.cardcrawl.cards.red.Bash;
import com.megacrit.cardcrawl.cards.red.Defend_Red;
import com.megacrit.cardcrawl.cards.red.PommelStrike;
import com.megacrit.cardcrawl.cards.red.Strike_Red;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import druidsurv.CharacterFile;
import druidsurv.cards.bloons.*;
import druidsurv.cards.cardvars.CardTags;
import druidsurv.cards.colorless.DiscardX;
import druidsurv.cards.colorless.HeartOfThunderColorless;
import druidsurv.cards.monkeys.*;
import druidsurv.cards.bloons.DarkBloon;
import druidsurv.cards.monkeys.adora.BloontoniumMiner;
import druidsurv.cards.powers.SpikeStorm;
import druidsurv.cards.powers.SupplyDrop;

import java.util.ArrayList;

import static druidsurv.util.Wiz.returnTrulyRandomPrediCardInCombat;

public class DeckHandler {
    public void ImprovisedDeck()
    {
        for (int i = 0; i < 13; i++) {
            AbstractCard eligibleCardsList = returnTrulyRandomPrediCardInCombat(this::isSpades, true);
            AbstractDungeon.player.masterDeck.addToTop(eligibleCardsList.makeCopy());
        }
        for (int i = 0; i < 13; i++) {
            AbstractCard eligibleCardsList = returnTrulyRandomPrediCardInCombat(this::isHearts, true);
            AbstractDungeon.player.masterDeck.addToTop(eligibleCardsList.makeCopy());
        }
        for (int i = 0; i < 13; i++) {
            AbstractCard eligibleCardsList = returnTrulyRandomPrediCardInCombat(this::isClubs, true);
            AbstractDungeon.player.masterDeck.addToTop(eligibleCardsList.makeCopy());
        }
        for (int i = 0; i < 13; i++) {
            AbstractCard eligibleCardsList = returnTrulyRandomPrediCardInCombat(this::isDiamonds, true);
            AbstractDungeon.player.masterDeck.addToTop(eligibleCardsList.makeCopy());
        }
    }

    public boolean isBasic(AbstractCard c) {
        return  c.rarity == AbstractCard.CardRarity.BASIC;
    }
    public boolean isStrike(AbstractCard c) {
        return  c.hasTag(AbstractCard.CardTags.STARTER_STRIKE);
    }
    public boolean isDefend(AbstractCard c) {
        return  c.hasTag(AbstractCard.CardTags.STARTER_DEFEND);
    }
    public boolean isNonStrikeDefendBasic(AbstractCard c) {
        return  c.rarity == AbstractCard.CardRarity.BASIC && !c.hasTag(AbstractCard.CardTags.STARTER_STRIKE) && !c.hasTag(AbstractCard.CardTags.STARTER_DEFEND);
    }
    public boolean isBetterStrike(AbstractCard c) {
        return  c.rarity == AbstractCard.CardRarity.COMMON && c.baseDamage > 5 && !c.exhaust && !c.isEthereal && !c.isInnate;
    }
    public boolean isBetterDefend(AbstractCard c) {
        return  c.rarity == AbstractCard.CardRarity.COMMON && c.baseBlock > 4 && !c.exhaust && !c.isEthereal && !c.isInnate;
    }

    public boolean isSpades(AbstractCard c) {
        return  c.hasTag(CardTags.BLOON) || c.color == AbstractCard.CardColor.BLUE
                || c.color.name().equals("SQUIRTLE_BLUE") || c.color.name().equals("TOTODILE_BLUE")
                || c.color.name().equals("FERROTHORN_COLOR") || c.color.name().equals("COLOR_FERROTHORN");
    }
    public boolean isHearts(AbstractCard c) {
        return c.hasTag(CardTags.MONKEY) || c.color == AbstractCard.CardColor.RED
                || c.color.name().equals("SQUIRTLE_BLUE") || c.color.name().equals("TOTODILE_BLUE") || c.color.name().equals("THE_VIXEN_ORANGE");
    }
    public boolean isClubs(AbstractCard c) {
        return c.color == AbstractCard.CardColor.GREEN  || (c.color == CharacterFile.Enums.DRUIDSURV_COLOR
                && !(c.hasTag(CardTags.BLOON) || c.hasTag(CardTags.MONKEY) || c.hasTag(CardTags.BCSPOWER)))
                || c.color.name().equals("SQUIRTLE_BLUE") || c.color.name().equals("TOTODILE_BLUE")
                || c.color.name().equals("FERROTHORN_COLOR") || c.color.name().equals("COLOR_FERROTHORN");
    }
    public boolean isDiamonds(AbstractCard c) {
        return c.hasTag(CardTags.BCSPOWER) || c.color == AbstractCard.CardColor.PURPLE
                || c.color.name().equals("SQUIRTLE_BLUE") || c.color.name().equals("TOTODILE_BLUE") || c.color.name().equals("THE_VIXEN_ORANGE");
    }

    public void Improvised2Deck()
    {
        ArrayList<String> retVal = new ArrayList<>();
        AbstractDungeon.player.masterDeck.addToTop(new Strike_Red());
        AbstractDungeon.player.masterDeck.addToTop(new Strike_Red());
        AbstractDungeon.player.masterDeck.addToTop(new Strike_Red());
        AbstractDungeon.player.masterDeck.addToTop(new Strike_Red());
        AbstractDungeon.player.masterDeck.addToTop(new Strike_Red());
        AbstractDungeon.player.masterDeck.addToTop(new Defend_Red());
        AbstractDungeon.player.masterDeck.addToTop(new Defend_Red());
        AbstractDungeon.player.masterDeck.addToTop(new Defend_Red());
        AbstractDungeon.player.masterDeck.addToTop(new Defend_Red());
        AbstractDungeon.player.masterDeck.addToTop(new Bash());
        AbstractDungeon.player.masterDeck.addToTop(new Bash());
        AbstractDungeon.player.masterDeck.addToTop(new Bash());
        AbstractDungeon.player.masterDeck.addToTop(new PommelStrike());

        AbstractDungeon.player.masterDeck.addToTop(new Strike_Green());
        AbstractDungeon.player.masterDeck.addToTop(new Strike_Green());
        AbstractDungeon.player.masterDeck.addToTop(new Strike_Green());
        AbstractDungeon.player.masterDeck.addToTop(new Strike_Green());
        AbstractDungeon.player.masterDeck.addToTop(new Defend_Green());
        AbstractDungeon.player.masterDeck.addToTop(new Defend_Green());
        AbstractDungeon.player.masterDeck.addToTop(new Defend_Green());
        AbstractDungeon.player.masterDeck.addToTop(new Defend_Green());
        AbstractDungeon.player.masterDeck.addToTop(new Survivor());
        AbstractDungeon.player.masterDeck.addToTop(new Survivor());
        AbstractDungeon.player.masterDeck.addToTop(new Neutralize());
        AbstractDungeon.player.masterDeck.addToTop(new Neutralize());
        AbstractDungeon.player.masterDeck.addToTop(new QuickSlash());

        AbstractDungeon.player.masterDeck.addToTop(new Strike_Blue());
        AbstractDungeon.player.masterDeck.addToTop(new Strike_Blue());
        AbstractDungeon.player.masterDeck.addToTop(new Strike_Blue());
        AbstractDungeon.player.masterDeck.addToTop(new Strike_Blue());
        AbstractDungeon.player.masterDeck.addToTop(new Defend_Blue());
        AbstractDungeon.player.masterDeck.addToTop(new Defend_Blue());
        AbstractDungeon.player.masterDeck.addToTop(new Defend_Blue());
        AbstractDungeon.player.masterDeck.addToTop(new Defend_Blue());
        AbstractDungeon.player.masterDeck.addToTop(new Zap());
        AbstractDungeon.player.masterDeck.addToTop(new Zap());
        AbstractDungeon.player.masterDeck.addToTop(new Dualcast());
        AbstractDungeon.player.masterDeck.addToTop(new Dualcast());
        AbstractDungeon.player.masterDeck.addToTop(new SweepingBeam());

        AbstractDungeon.player.masterDeck.addToTop(new Strike_Purple());
        AbstractDungeon.player.masterDeck.addToTop(new Strike_Purple());
        AbstractDungeon.player.masterDeck.addToTop(new Strike_Purple());
        AbstractDungeon.player.masterDeck.addToTop(new Strike_Purple());
        AbstractDungeon.player.masterDeck.addToTop(new Defend_Watcher());
        AbstractDungeon.player.masterDeck.addToTop(new Defend_Watcher());
        AbstractDungeon.player.masterDeck.addToTop(new Defend_Watcher());
        AbstractDungeon.player.masterDeck.addToTop(new Defend_Watcher());
        AbstractDungeon.player.masterDeck.addToTop(new Eruption());
        AbstractDungeon.player.masterDeck.addToTop(new Eruption());
        AbstractDungeon.player.masterDeck.addToTop(new Vigilance());
        AbstractDungeon.player.masterDeck.addToTop(new Vigilance());
        AbstractDungeon.player.masterDeck.addToTop(new CutThroughFate());

        AbstractDungeon.player.masterDeck.addToTop(new DiscardX());
    }

    public void QuincyStarter()
    {
        AbstractDungeon.player.masterDeck.clear();
        AbstractDungeon.player.masterDeck.addToTop(new RedBloon());
        AbstractDungeon.player.masterDeck.addToTop(new RedBloon());
        AbstractDungeon.player.masterDeck.addToTop(new RedBloon());
        AbstractDungeon.player.masterDeck.addToTop(new BlueBloon());
        AbstractDungeon.player.masterDeck.addToTop(new BlueBloon());
        AbstractDungeon.player.masterDeck.addToTop(new BlueBloon());
        AbstractDungeon.player.masterDeck.addToTop(new SpikeStorm());
        AbstractDungeon.player.masterDeck.addToTop(new SpikeStorm());
        AbstractDungeon.player.masterDeck.addToTop(new SpikeStorm());
        AbstractDungeon.player.masterDeck.addToTop(new GreenBloon());
        AbstractDungeon.player.masterDeck.addToTop(new GreenBloon());
        AbstractDungeon.player.masterDeck.addToTop(new GreenBloon());
        AbstractDungeon.player.masterDeck.addToTop(new Moab());
        AbstractDungeon.player.masterDeck.addToTop(new Moab());
        AbstractDungeon.player.masterDeck.addToTop(new Moab());
        AbstractDungeon.player.masterDeck.addToTop(new Bfb());
        AbstractDungeon.player.masterDeck.addToTop(new WhiteBloon());
        AbstractDungeon.player.masterDeck.addToTop(new WhiteBloon());
        AbstractDungeon.player.masterDeck.addToTop(new CeramicBloon());
        AbstractDungeon.player.masterDeck.addToTop(new DartMonkey());
        AbstractDungeon.player.masterDeck.addToTop(new DartMonkey());
        AbstractDungeon.player.masterDeck.addToTop(new DartMonkey());
        AbstractDungeon.player.masterDeck.addToTop(new TackShooter());
        AbstractDungeon.player.masterDeck.addToTop(new TackShooter());
        AbstractDungeon.player.masterDeck.addToTop(new TackShooter());
        AbstractDungeon.player.masterDeck.addToTop(new SniperMonkey());
        AbstractDungeon.player.masterDeck.addToTop(new SniperMonkey());
        AbstractDungeon.player.masterDeck.addToTop(new SniperMonkey());
        AbstractDungeon.player.masterDeck.addToTop(new SuperMonkey());
        AbstractDungeon.player.masterDeck.addToTop(new SupplyDrop());
        AbstractDungeon.player.masterDeck.addToTop(new SupplyDrop());
        AbstractDungeon.player.masterDeck.addToTop(new SupplyDrop());
        AbstractDungeon.player.masterDeck.addToTop(new TripleDart());
        AbstractDungeon.player.masterDeck.addToTop(new TripleDart());
        AbstractDungeon.player.masterDeck.addToTop(new TripleDart());
        AbstractDungeon.player.masterDeck.addToTop(new PinkBloon());
        AbstractDungeon.player.masterDeck.addToTop(new PinkBloon());
        AbstractDungeon.player.masterDeck.addToTop(new PinkBloon());
        AbstractDungeon.player.masterDeck.addToTop(new BlackBloon());
        AbstractDungeon.player.masterDeck.addToTop(new BlackBloon());
    }

    public void ErraticDeck()
    {
        /*ArrayList<AbstractCard> Strikes = new ArrayList<>();
        ArrayList<AbstractCard> Defend = new ArrayList<>();
        ArrayList<AbstractCard> Three = new ArrayList<>();
        Strikes.add(new Strike_Red());
        Strikes.add(new Strike_Blue());
        Strikes.add(new Strike_Purple());
        Strikes.add(new Strike_Green());
        Strikes.add(new PommelStrike());
        Strikes.add(new DaggerThrow());
        Strikes.add(new FlyingKnee());
        Strikes.add(new PoisonedStab());
        Strikes.add(new QuickSlash());
        Strikes.add(new FlyingKnee());
        Strikes.add(new Slice());
        Strikes.add(new SuckerPunch());
        Strikes.add(new BallLightning());
        Strikes.add(new ColdSnap());
        Strikes.add(new CompileDriver());
        Strikes.add(new Rebound());
        Strikes.add(new CrushJoints());
        Strikes.add(new CutThroughFate());
        Strikes.add(new EmptyFist());
        Strikes.add(new BallLightning());
        Strikes.add(new BallLightning());
        Strikes.add(new BallLightning());*/
        int size = AbstractDungeon.player.masterDeck.size();
        AbstractDungeon.player.masterDeck.clear();
        for (int i = 0; i < size; i++) {
            AbstractCard eligibleCardsList = returnTrulyRandomPrediCardInCombat(this::isBasic, true);
            AbstractDungeon.player.masterDeck.addToTop(eligibleCardsList.makeCopy());
        }
        for (int i = 0; i < size; i++) {
            AbstractCard eligibleCardsList = returnTrulyRandomPrediCardInCombat(this::isBasic, true);
            AbstractDungeon.player.masterDeck.addToTop(eligibleCardsList.makeCopy());
        }

    }

    public void OrbDeck()
    {
        int size = AbstractDungeon.player.masterDeck.size();
        AbstractDungeon.player.masterDeck.clear();

        AbstractDungeon.player.masterDeck.addToTop(new BallLightning());
        AbstractDungeon.player.masterDeck.addToTop(new ColdSnap());
        AbstractDungeon.player.masterDeck.addToTop(new Darkness());
        AbstractDungeon.player.masterDeck.addToTop(new BloontoniumMiner());
        AbstractDungeon.player.masterDeck.addToTop(new PurpleBloon());
        AbstractDungeon.player.masterDeck.addToTop(new CyanBloon());
        AbstractDungeon.player.masterDeck.addToTop(new DarkBloon());
        AbstractDungeon.player.masterDeck.addToTop(new SunBloon());
        AbstractDungeon.player.masterDeck.addToTop(new Zap());
        AbstractDungeon.player.masterDeck.addToTop(new Fusion());
        AbstractDungeon.player.masterDeck.addToTop(new DoomAndGloom());
        AbstractDungeon.player.masterDeck.addToTop(new HeartOfThunderColorless());
        AbstractDungeon.player.masterDeck.addToTop(new Dualcast());
        AbstractDungeon.player.masterDeck.addToTop(new Dualcast());
    }
}
