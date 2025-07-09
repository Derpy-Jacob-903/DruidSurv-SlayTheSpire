package druidsurv.cards.bloons;

import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.PersistFields;
import com.evacipated.cardcrawl.mod.stslib.variables.ExhaustiveVariable;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.powers.bloons.BasicBloonPower;
import druidsurv.relics.CueBall;

import static druidsurv.ModFile.makeID;

public class Moab extends AbstractEasyCard {
    public final static String ID = makeID("MOAB");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public Moab() {
        super(ID, 2, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY, "MOAB_CardArt");
        baseDamage = 100;
        baseBlock = 3;
        baseMagicNumber = magicNumber = 1;
        tags.add(druidsurv.cards.cardvars.CardTags.BLOON);
        tags.add(druidsurv.cards.cardvars.CardTags.LARGE);
        PersistFields.setBaseValue(this, 2);
        ExhaustiveVariable.setBaseValue(this, 2);
        this.exhaust = true;
        this.setCardBack(cardSubType.BLOON);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if(AbstractDungeon.player.hasRelic(CueBall.ID)){ damage *= 0.75; addToBot((AbstractGameAction)new GainEnergyAction(this.magicNumber));};
        addToBot((AbstractGameAction)new ApplyPowerAction(m, p, new BasicBloonPower(m, 4, damage, "MOAB"), 1, true, AbstractGameAction.AttackEffect.NONE));
        bloonBlck();
    }

    @Override
    public void upp()
    {
        upgradeDamage(25);
        upgradeBlock(3);
    }
}