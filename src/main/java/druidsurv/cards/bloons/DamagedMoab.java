package druidsurv.cards.bloons;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.powers.bloons.BasicBloonPower;
import druidsurv.relics.CueBall;
import druidsurv.actions.ReduceBloonHealthAction;

import static druidsurv.ModFile.makeID;

public class DamagedMoab extends AbstractEasyCard {
    public final static String ID = makeID("DamagedMOAB");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public DamagedMoab() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.SELF_AND_ENEMY, "DamagedMoab_CardArt");
        baseDamage = 100;
        baseBlock = 5;
        baseMagicNumber = magicNumber = 1;
        tags.add(druidsurv.cards.cardvars.CardTags.BLOON);
        tags.add(druidsurv.cards.cardvars.CardTags.LARGE);
        this.exhaust = true;
        this.setCardBack(cardSubType.BLOON);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if(AbstractDungeon.player.hasRelic(CueBall.ID)){ damage *= 0.75; addToBot((AbstractGameAction)new GainEnergyAction(this.magicNumber));};
        BasicBloonPower power = new BasicBloonPower(m, 4, damage, "MOAB");
        addToBot((AbstractGameAction)new ApplyPowerAction(m, p, (AbstractPower)power, 1, true, AbstractGameAction.AttackEffect.NONE));
        addToBot((AbstractGameAction)new ReduceBloonHealthAction(m, p, power, 30));
        bloonBlck();
    }

    @Override
    public void upp()
    {
        upgradeDamage(7);
        upgradeBlock(3);
    }
}