package druidsurv.relics;

import basemod.AutoAdd;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.actions.unique.GamblingChipAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;
import com.megacrit.cardcrawl.powers.EnergizedPower;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
import druidsurv.CharacterFile;
import druidsurv.cards.cardvars.CardTags;

import static druidsurv.ModFile.makeID;

@AutoAdd.Ignore
public class TodoItem extends AbstractEasyRelic {
    public static final String ID = makeID("TodoItem");
    private boolean activated;

    public TodoItem() {
        super(ID, RelicTier.STARTER, LandingSound.FLAT, CharacterFile.Enums.DRUIDSURV_COLOR);
    }

    public void atBattleStartPreDraw() {
        this.activated = false;
    }

    public void atBattleStart() {
        //addToBot((AbstractGameAction)new RelicAboveCreatureAction((AbstractCreature)AbstractDungeon.player, this));
        addToBot((AbstractGameAction)new DrawCardAction((AbstractCreature)AbstractDungeon.player, 2));
        }

    public void onEquip() {
        --AbstractDungeon.player.masterHandSize;
        --AbstractDungeon.player.masterHandSize;
    }

    public void onUnequip() {
        ++AbstractDungeon.player.masterHandSize;
        ++AbstractDungeon.player.masterHandSize;
    }

    public void onPlayerEndTurn() {
        //AbstractPlayer p = AbstractDungeon.player;
        //int maxIterations = Math.min(p.energy.energyMaster, EnergyPanel.getCurrentEnergy()); // Limit the iterations
        //for (int i = 0; i < maxIterations; i++) {
            //addToBot((AbstractGameAction)new ApplyPowerAction(p, p, (AbstractPower)new EnergizedPower(p, 1), 1, true, AbstractGameAction.AttackEffect.NONE));
        //}
    }

    public void updateDescription()
    {
        if (DESCRIPTIONS != null && DESCRIPTIONS.length > 1)
        { this.description = DESCRIPTIONS[0] + AbstractDungeon.player.energy.energyMaster + DESCRIPTIONS[1]; }
        else { this.description = "Description not available."; }
    }

    public void onPlayCard(AbstractCard c, AbstractMonster m) {
        if (c.color == this.color && c.tags.contains(CardTags.MONKEY) || c.rarity == AbstractCard.CardRarity.BASIC || c.type == AbstractCard.CardType.STATUS)
        {
            AbstractPlayer p = AbstractDungeon.player;
            addToBot((AbstractGameAction)new ApplyPowerAction(p, p, (AbstractPower)new DrawCardNextTurnPower(p, 1), 1, true, AbstractGameAction.AttackEffect.NONE));
        }
    }

    public void atTurnStartPostDraw() {
        if (!this.activated)
        {
        this.activated = true;
            //flash();
            //addToBot((AbstractGameAction)new RelicAboveCreatureAction((AbstractCreature) AbstractDungeon.player, this));
            //addToBot((AbstractGameAction)new GamblingChipAction((AbstractCreature)AbstractDungeon.player, true));
        }
    }
}
