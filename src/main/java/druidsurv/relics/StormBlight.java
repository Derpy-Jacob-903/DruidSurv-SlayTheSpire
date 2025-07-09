package druidsurv.relics;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.unique.GamblingChipAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;
import com.megacrit.cardcrawl.powers.watcher.DevaPower;
import com.megacrit.cardcrawl.powers.watcher.EnergyDownPower;
import com.megacrit.cardcrawl.vfx.combat.FastingEffect;
import com.sun.corba.se.impl.presentation.rmi.StubFactoryFactoryStaticImpl;
import druidsurv.CharacterFile;
import druidsurv.cards.cardvars.CardTags;
import druidsurv.powers.ThornPower;
import druidsurv.util.modifedclasses.Mulligan;

import static druidsurv.ModFile.makeID;

public class StormBlight extends AbstractEasyRelic {
    public static final String ID = makeID("WornDeck");
    private boolean activated;

    public StormBlight() {
        super(ID, RelicTier.STARTER, LandingSound.FLAT);
    }

    public void atBattleStartPreDraw() {
        this.activated = false;
    }

    public void atBattleStart() {

        //addToBot((AbstractGameAction)new RelicAboveCreatureAction((AbstractCreature)AbstractDungeon.player, this));
        AbstractPlayer p = AbstractDungeon.player;
        addToBot((AbstractGameAction)new DrawCardAction(p, 3));
        addToBot((AbstractGameAction) new ApplyPowerAction(p, p, (AbstractPower) new EnergyDownPower(p, 3), 3, true, AbstractGameAction.AttackEffect.NONE));
        addToBot((AbstractGameAction) new ApplyPowerAction(p, p, (AbstractPower) new DevaPower(p), 1, true, AbstractGameAction.AttackEffect.NONE));

    }

    public void atTurnStart() {

    }

    public void onEquip() {
        --AbstractDungeon.player.masterHandSize;
        --AbstractDungeon.player.masterHandSize;
        --AbstractDungeon.player.masterHandSize;
        --AbstractDungeon.player.masterHandSize;
    }

    public void onUnequip() {
        ++AbstractDungeon.player.masterHandSize;
        ++AbstractDungeon.player.masterHandSize;
        ++AbstractDungeon.player.masterHandSize;
        ++AbstractDungeon.player.masterHandSize;
    }

    public void atTurnStartPostDraw() {
        if (!this.activated)
        {
            this.activated = true;
            //flash();
            addToBot((AbstractGameAction)new Mulligan((AbstractCreature) AbstractDungeon.player));
        }
    }
}
